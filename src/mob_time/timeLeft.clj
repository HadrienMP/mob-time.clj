(ns mob-time.timeLeft
    (:require [cheshire.core :refer [parse-string]]
      [clojure.math.numeric-tower :refer :all]))

(defn timeLeftInMillis [json]
      (get (parse-string json) "timeLeftInMillis"))

(defn timeLeft [body]
      (let [seconds (/ (timeLeftInMillis body) 1000)]
           (if (>= seconds 60)
             (str (int (/ seconds 60)) "m")
             (str (ceil seconds) "s"))))