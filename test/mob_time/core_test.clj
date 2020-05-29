(ns mob-time.core-test
  (:require [clojure.test :refer :all]
            [mob-time.core :refer :all]
            [cheshire.core :as json :refer :all]
            [clj-http.client :as http-client :refer :all]))

(defn timeLeftInMillis [url]
  (clojure.core/get
    (json/parse-string (:body (http-client/get (str url "/fwg/status"))))
    "timeLeftInMillis"))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 (timeLeftInMillis "https://mob-time-server.herokuapp.com")))))
; https://mob-time-server.herokuapp.com/fwg/status
; {"lengthInMinutes":4,"timeLeftInMillis":90200,"pomodoro":{lein te"ratio":0.6497}
