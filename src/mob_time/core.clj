(ns mob-time.core
  (:require [cheshire.core :as json :refer [parse-string]]
            [clojure.core :as core :refer :all]
            [clojure.math.numeric-tower :refer :all]
            [clj-http.client :as http :refer [get]]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn getTimeLeftInMillis [url mob]
  (core/get
    (json/parse-string (:body (http/get (str url "/" mob "/status"))))
    "timeLeftInMillis"))

(defn timeLeftInMillis [json]
 (core/get (json/parse-string json) "timeLeftInMillis"))

(defn timeLeft [body]
  (let [time-left (timeLeftInMillis body)]
    (if (= time-left 60000)
      "1m"
      (str (ceil (/ time-left 1000)) "s")))) 
