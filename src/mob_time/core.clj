(ns mob-time.core
  (:require [cheshire.core :refer [parse-string]]
            [clojure.core :as core :refer :all]
            [clojure.math.numeric-tower :refer :all]
            [clj-http.client :as http]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn getTimeLeftInMillis [url mob]
  (get
    (parse-string (:body (http/get (str url "/" mob "/status"))))
    "timeLeftInMillis"))

(defn timeLeftInMillis [json]
 (get (parse-string json) "timeLeftInMillis"))

(defn timeLeft [body]
  (let [seconds (/ (timeLeftInMillis body) 1000)]
    (if (>= seconds 60)
     (str (int (/ seconds 60)) "m")
     (str (ceil seconds) "s"))))
