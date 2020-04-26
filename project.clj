(defproject paper-search "0.1.0-SNAPSHOT"
  :description "Demo paper extraction for EUvsVirus Hackathon"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.10.1"]
                 [com.cemerick/url "0.1.1"]
                 [org.clojure/data.xml "0.0.8"]
                 [org.clojure/data.json "1.0.0"]
                 [org.apache.pdfbox/pdfbox "2.0.19"]]
  :repl-options {:init-ns paper-search.europemc}
  :main paper-search.europemc)
