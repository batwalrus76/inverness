(defproject inverness "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://inverness.herokuapp.com"
  :license {:name "FIXME: choose"
            :url "http://example.com/FIXME"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [ring/ring-devel "1.1.0"]
                 [ring-basic-authentication "1.0.1"]
                 [environ "0.2.1"]                 
                 [cheshire "4.0.0"]
                 [clj-http "0.6.5"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [org.clojure/tools.logging "0.2.6"]
                 [twitter-api "0.7.4"]]
  :min-lein-version "2.0.0"  
  :plugins [[environ/environ.lein "0.2.1"]
                [lein-ring "0.8.3"]
                [lein-swank "1.4.5"]]
  :hooks [environ.leiningen.hooks]
  :main inverness.web
  :ring {:handler inverness.web/app}
  :profiles {:production {:env {:production true}}})