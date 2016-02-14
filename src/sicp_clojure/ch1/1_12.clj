(ns sicp-clojure.ch1.1-12
  (:require [clojure.test :refer [deftest is run-tests]]))


;;h:高さ,idx:左から何個目か
(defn pascals-triangle [h idx]
  (cond
    (neg? (- h idx)) -1 ;; invalid args
    (or (= 1 h) (= 1 idx) (= h idx)) 1
    :else (+ (pascals-triangle (dec h) (dec idx))
             (pascals-triangle (dec h) idx))))

(deftest t
  (is (= 1 (pascals-triangle 1 1)))
  (is (= 2 (pascals-triangle 3 2)))
  (is (= 3 (pascals-triangle 4 3)))
  (is (= 4 (pascals-triangle 5 2)))
  (is (= 6 (pascals-triangle 5 3)))
  (is (= -1 (pascals-triangle 5 6))))

;(run-tests)
