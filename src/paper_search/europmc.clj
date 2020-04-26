(ns paper-search.europmc
  (:require [clj-http.client :as http]
            [cemerick.url :refer [url-encode]]
            [clojure.data.xml :as xml]
            [clojure.string :as str])
  (:import (java.io StringReader)))

(defn- node->map [node]
  (let [tag (:tag node)
        content (:content node)]
    (if (and (= 1 (count content)) (string? (first content)))
      {tag (first content)}
      {tag (mapv node->map content)})))

(defn- merge-book-or-report-details [result]
  (if (:bookOrReportDetails result)
    (update result :bookOrReportDetails #(apply merge %))
    result))

(defn- result-list [search-result]
  (->> search-result
       :resultList
       (map
         (fn [result-item]
           (->> (result-item :result)
                (apply merge)
                merge-book-or-report-details)))))

(defn- res-url [result]
  (str "https://dx.doi.org/" (result :doi)))

(defn- res-title [result]
  (result :title))

(defn- res-authors [result]
  (result :authorString))

(defn- res-publisher [result]
  (let [publishers {"medRxiv" :medrxiv}
        pub-name (some-> result :bookOrReportDetails :publisher)]
    (when pub-name (get publishers pub-name))))

(defn- res-id [result]
  (result :id))

(defn- res-first-publication-date [result]
  (result :firstPublicationDate))

(defn- res-first-index-date [result]
  (result :firstIndexDate))

(defn- res-is-open-access? [result]
  (= "Y" (result :isOpenAccess)))

(defn- normalized [result]
  (zipmap
    [:url :title :authors :publisher :id :first-publication-date :first-index-date :open-access?]
    ((juxt res-url
           res-title
           res-authors
           res-publisher
           res-id
           res-first-publication-date
           res-first-index-date
           res-is-open-access?) result)))

(defn get-xml-search-result
  "Return body of search result as string"
  [query opts]
  (let [opts (merge {:open-access-only? false :page-size 50} opts)
        param-map {"pageSize" :page-size}
        encoded-query-param (url-encode (if (str query " OPEN_ACCESS:y") query))
        other-params (str/join "&" (map (fn [[qp op]] (str qp "=" (opts op))) param-map))
        url (str "https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=" encoded-query-param "&" other-params)
        response (http/get url)]
    (response :body)))

(defn parse-xml
  "Parse search response body to keywordized map"
  [body]
  (let [parsed-response (-> body (StringReader.) xml/parse node->map)]
    (->> parsed-response
         :responseWrapper
         (apply merge)
         result-list)))

(defn search [query opts]
  (->> (apply get-xml-search-result query opts)
       parse-xml
       (map normalized)))

(comment

  (search "Coronavirus mask")

  (get-xml-search-result "Coronavirus mask")

  )

