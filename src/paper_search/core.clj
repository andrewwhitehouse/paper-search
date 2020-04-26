(ns paper-search.core
  (:require [clojure.data.json :as json]
            [paper-search.europmc :refer [search]]
            [clj-http.client :as http]
            [paper-search.html-parser.medrxiv :as medrxiv]
            [paper-search.to-markdown :as md]
            [clojure.string :as str]
            [clj-time.core :as ct]
            [clj-time.format :as ctf]
            [clojure.java.io :as io]))


(defn- process-page [url]
  (println "Processing" url "...")
  (-> (http/get url) :body medrxiv/parse))

(defn- medrxiv-search
  ([query opts]
   (let [results (search query opts)]
     (->> (filter #(= :medrxiv (:publisher %)) results)
          (map #(process-page (:url %))))))
  ([query] (medrxiv-search query {})))

(defn- markdown-result [query results]
  (str (md/header "Europe PMC Search Results")
       "**Query**: \"" query "\"\n\n"
       (str/join "\n" (map md/to-markdown results))))

(defn- date-suffix []
  (let [formatter (ctf/formatter "MMddHHmmss")]
    (ctf/unparse formatter (ct/now))))

(defn -main [& args]
  (if (< (count args) 1)
    (println "Specify search term as a quoted argument")
    (let [page-size (if (>= (count args) 2) (Integer/parseInt (second args)) 50)
          query (first args)
          output (markdown-result query (medrxiv-search query {:page-size page-size}))
          output-file-name (-> query str/lower-case (str/replace #" " "_") (str "_" (date-suffix) ".md"))
          out-file (io/file output-file-name)]
      (println "Writing" (.getAbsolutePath out-file))
      (with-open [writer (io/writer (io/file out-file))]
        (.write writer output)))))