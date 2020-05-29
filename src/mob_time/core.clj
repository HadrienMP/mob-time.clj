(ns mob-time.core
  (:require [cheshire.core :as json :refer :all]
            [clojure.string :refer :all]
            [clj-http.client :as http-client :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn timeLeftInMillis [url mob]
  (clojure.core/get
    (json/parse-string (:body (http-client/get (str url "/" mob "/status"))))
    "timeLeftInMillis"))

(defn timeLeft [body]
  (str (/ (clojure.core/get (json/parse-string body) "timeLeftInMillis") 1000) "s"))
