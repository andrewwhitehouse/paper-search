(ns paper-search.redirect
  (:require [clj-http.client :as http]
            [clj-http.cookies :as cks]))

(defn header-redirect [url]
  (let [cs (cks/cookie-store)
        response (http/get url {:cookie-store      cs
                                :redirect-strategy :none})]
    (condp = (response :status)
      302 (-> response :headers :Location)
      304 (-> response :headers :Location)
      nil)))

(defn -main [& args]
  (let [url "https://dx.doi.org/10.1016/j.arcmed.2020.04.001"]
    (println (header-redirect url))))
