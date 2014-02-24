(ns inverness.geocode
  (:require [clj-http.client :as client]
  			[clojure.data.json :as json])
  (:use [clojure.tools.logging :only (info error)])
  )

(defn get-geocode-by-address
	[address]
	(def geocode (client/get (str "http://maps.googleapis.com/maps/api/geocode/json?address=" address "&sensor=false")))
	(def body_str (get-in geocode [:body]))
	(def body (json/read-str body_str))
	(def results ((get-in body ["results"]) 0))
	(get-in results ["geometry" "location"])
	)