(ns paper-search.to-markdown)

(defn header [text]
  (str "# " text "\n\n"))

(defn to-markdown [{:keys [html-url abstract-url title abstract author-email
                            journal-title publication-date rights author
                            id language doi description publisher pdf-link]}]

  (str "## " title "\n\n"
       "### Abstract\n\n" abstract "\n\n"
       "### Authors\n\n" author "\n\n"
       "**Author Email** " author-email "\n\n"
       "[PDF Link](" pdf-link ")\n\n"
       "**Publication Date** " publication-date "\n\n"
       "**Publisher** " publisher "\n\n"
       "**Rights** " rights "\n\n"
       "**DOI** " doi "\n\n"
       "**Journal Title** " journal-title "\n\n"
       "[HTML Link](" html-url ")\n\n"
       "\n"))
