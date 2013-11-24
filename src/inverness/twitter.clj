(ns inverness.twitter
  (:require [clj-http.client :as http])
  (:use [clojure.tools.logging :only (info error)]
  	  [twitter.oauth]
   		[twitter.callbacks]
   		[twitter.callbacks.handlers]
  		[twitter.api.search])
  (:import (twitter.callbacks.protocols SyncSingleCallback)))

(def ^:dynamic *app-consumer-key* "m2X5IZKKHqrO87oLKxng")
(def ^:dynamic *app-consumer-secret* "YIr5MvbJ3etbYblKMa6BZHaBUtnAQCEe4XFdcvzns")
(def ^:dynamic *user-access-token* "2203909303-FURy9b3GbmtAaluLVaDxo74PbYW4us9BcXQzpbl")
(def ^:dynamic *user-access-token-secret* "mJEhbsqzQ3onzurQFmiVyBmpcWUNEyjouvbJdkS9D1gy8")


(def my-creds (make-oauth-creds *app-consumer-key*
                                *app-consumer-secret*
                                *user-access-token*
                                *user-access-token-secret*))

(defn get-tweets-by-location
  [location]
  (info "logging twitter search by location: " location)
  (search :oauth-creds my-creds 
                  :params {:geocode "37.781157,-122.398720,100mi"})
  )


(defn get-tweets-by-term
  [term]
  (info "logging twitter search by term: " term)
  (search :oauth-creds my-creds 
                  :params {:q term})
  )
