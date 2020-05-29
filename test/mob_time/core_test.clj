(ns mob-time.core-test
  (:require [clojure.test :refer :all]
            [mob-time.core :refer :all]))

(deftest timeLeft-test
  (testing "Dangerous"
    (is (= 0
           (timeLeftInMillis "https://mob-time-server.herokuapp.com" "fwg"))))
  (testing "is 0s when out of time ?"
    (is (= "0s"
           (timeLeft "{\"lengthInMinutes\":4,\"timeLeftInMillis\":0,\"pomodoro\":{\"ratio\":0.6497}}"))))
  (testing "is 10s"
           (is (= "10s"
                  (timeLeft "{\"lengthInMinutes\":4,\"timeLeftInMillis\":10000,\"pomodoro\":{\"ratio\":0.6497}}"))))
  (testing "is 1s for 500ms"
           (is (= "1s"
                  (timeLeft "{\"lengthInMinutes\":4,\"timeLeftInMillis\":500,\"pomodoro\":{\"ratio\":0.6497}}"))))
  )
; https://mob-time-server.herokuapp.com/fwg/status
; {"lengthInMinutes":4,"timeLeftInMillis":90200,"pomodoro":{lein te"ratio":0.6497}