(ns mob-time.core-test
  (:require [clojure.test :refer :all]
            [mob-time.core :refer :all]
            [cheshire.core :as json :refer :all]
            [clj-http.client :refer :all]))

(def timeLeftInMillis [url]
  (json/parse-string
    (:body (clj-http.client/get (str mob-url "/fwg/status"))))
  )
(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 (timeLeftInMillis "https://mob-time-server.herokuapp.com")))))
; https://mob-time-server.herokuapp.com/fwg/status
; {"lengthInMinutes":4,"timeLeftInMillis":90200,"pomodoro":{"ratio":0.6497}
