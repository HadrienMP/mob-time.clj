(ns mob-time.core-test
  (:require [clojure.test :refer :all]
            [mob-time.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 (timeLeftInMillis "https://mob-time-server.herokuapp.com" "fwg")))))
; https://mob-time-server.herokuapp.com/fwg/status
; {"lengthInMinutes":4,"timeLeftInMillis":90200,"pomodoro":{lein te"ratio":0.6497}
