(ns mob-time.timeLeft-test
    (:require [clojure.test :refer :all])
    (:use [mob-time.timeLeft]))

(defn build-response [timeLeftInMillis]
      (str "{\"lengthInMinutes\":4,\"timeLeftInMillis\":" timeLeftInMillis ",\"pomodoro\":{\"ratio\":0.6497}}"))

(deftest timeLeft-test
         (testing "is 0s when out of time ?"
                  (is (= "0s" (timeLeft (build-response "0")))))
         (testing "is 10s"
                  (is (= "10s" (timeLeft (build-response "10000")))))
         (testing "is 1s for 500ms"
                  (is (= "1s" (timeLeft (build-response "500")))))
         (testing "is 1m for 60000ms"
                  (is (= "1m" (timeLeft (build-response "60000")))))
         (testing "is 1m for 70000ms"
                  (is (= "1m" (timeLeft (build-response "70000")))))
         (testing "is 2m for 120000ms"
                  (is (= "2m" (timeLeft (build-response "120000")))))
         (testing "is 2m for 130000ms"
                  (is (= "2m" (timeLeft (build-response "130000")))))
         (testing "is 2m for 130500ms"
                  (is (= "2m" (timeLeft (build-response "130500"))))))