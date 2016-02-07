(ns sicp-clojure.ch1.1-03
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn hoge [x y z]
  (let [lst (take-last 2 (sort [x y z]))
        square (fn [n] (* n n))]
    (+ (-> lst first square) (-> lst last square))))

(deftest f
  (is (= 13 (hoge 1 2 3)))
  (is (= 13 (hoge 3 2 1)))
  (is (= 50 (hoge 5 5 5)))
  (is (= 5  (hoge -1 -2 -3))))

;(run-tests)
