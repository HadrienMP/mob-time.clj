(ns mob-time.core
  (:require [clojure.core :as core :refer :all]
            [clj-http.client :as http]
            [clojure.java.shell :as shell]
            [mob-time.timeLeft :refer :all]))

(defn call [url mob]
   (:body (http/get (str url "/" mob "/status"))))

(defn nextCommand [body previous]
  (let [command (timeLeft body)]
    (if (= command (:last previous))
           {:command nil :last command}
           {:command command :last command})))

(defn clear []
  (->> (shell/sh "/bin/sh" "-c" "clear <  /dev/null") :out println))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (future (loop [previous {}]
            (let [current (nextCommand (call "https://mob-time-server.herokuapp.com" "fwg") previous)]
              (if (:command current)
                (dosync (clear) (println (:command current))))
              (Thread/sleep 2000) 
              (recur current)))))
