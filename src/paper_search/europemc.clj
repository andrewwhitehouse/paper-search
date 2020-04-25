(ns paper-search.europemc
  (:require [clj-http.client :as http]
            [cemerick.url :refer [url-encode]]
            [clojure.data.xml :as xml]
            [clojure.data.json :as json])
  (:import (java.io StringReader)))

(defn- node->map [node]
  (let [tag (:tag node)
        content (:content node)]
    (if (and (= 1 (count content)) (string? (first content)))
      {tag (first content)}
      {tag (mapv node->map content)})))

(defn- result-list [search-result]
  (->> search-result
       :resultList
       (map (fn [result-item] (apply merge (-> result-item :result))))))

(defn search [query]
  (let [url (str "https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=" (url-encode query))
        response (http/get url)
        parsed-response (-> response :body (StringReader.) xml/parse node->map)]
    (->> parsed-response
         :responseWrapper
         (apply merge)
         result-list)))


(defn -main [& args]
  (if (< (count args) 1)
    (println "Specify search term as a quoted argument")
    (json/write (search (first args))  *out*)))