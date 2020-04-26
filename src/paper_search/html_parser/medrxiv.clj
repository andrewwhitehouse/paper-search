(ns paper-search.html-parser.medrxiv
  (:require [net.cgrand.enlive-html :refer :all]
            [clojure.string :as str]
            [clojure.java.io :as io])
  (:import (java.io StringReader)))

(defn- metadata [res]
  (->> (select res [:meta])
       (map :attrs)
       (reduce
         (fn [acc attr]
           (if (attr :name)
             (assoc acc (keyword (attr :name)) (attr :content))
             acc))
         {})))

(defn parse [content]
  (let [resource (html-resource (StringReader. content))
        meta (metadata resource)
        mappings {:html-url         :citation_full_html_url
                  :abstract-url     :citation_abstract_html_url
                  :title            :DC.Title
                  :abstract         :citation_abstract
                  :author-email     :citation_author_email
                  :journal-title    :citation_journal_title
                  :publication-date :citation_publication_date
                  :rights           :DC.Rights
                  :author           :citation_author
                  :id               :citation_id
                  :language         :DC.Language
                  :doi              :citation_doi
                  :description      :og-description
                  :publisher        :citation_publisher
                  :pdf-link         :citation_pdf_url}]
    (apply merge {} (map (fn [[k meta-k]] [k (meta meta-k)]) mappings))))