(ns mob-time.core-test
  (:require [clojure.test :refer :all]
            [mob-time.core :refer :all]
            [mob-time.timeLeft-test :refer [build-response]]))

(deftest nextCommand-test
  (testing "next command"
    (is (= {:command "2m" :last "2m"} (nextCommand (build-response "120000") {}))))
  (testing "keep last event"
    (is (= {:command nil :last "2m"}
           (->> {}
                (nextCommand (build-response "120001"))
                (nextCommand (build-response "120000"))))))
  (testing "keep last event three events"
    (is (= {:command nil :last "2m"}
           (->> {}
                (nextCommand (build-response "120002"))
                (nextCommand (build-response "120001"))
                (nextCommand (build-response "120000")))))))
