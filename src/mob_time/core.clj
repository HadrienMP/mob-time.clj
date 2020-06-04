(ns mob-time.core
  (:require [cheshire.core :refer [parse-string]]
            [clojure.core :as core :refer :all]
            [clojure.math.numeric-tower :refer :all]
            [clj-http.client :as http]
            [clojure.java.shell :as shell]))

(defn call [url mob]
   (:body (http/get (str url "/" mob "/status"))))

(defn timeLeftInMillis [json]
 (get (parse-string json) "timeLeftInMillis"))

(defn timeLeft [body]
  (let [seconds (/ (timeLeftInMillis body) 1000)]
    (if (>= seconds 60)
     (str (int (/ seconds 60)) "m")
     (str (ceil seconds) "s"))))
(defn clear []
  (->> (shell/sh "/bin/sh" "-c" "clear <  /dev/null") :out println))
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (future (loop []
            (clear)
            (println (timeLeft (call "https://mob-time-server.herokuapp.com" "fwg")))
            (Thread/sleep 2000) 
            (recur))))
