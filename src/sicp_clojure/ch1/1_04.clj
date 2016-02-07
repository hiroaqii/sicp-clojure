(ns sicp-clojure.ch1.1-04
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(deftest t
  (is (= 3 (a-plus-abs-b  1  2)))
  (is (= 1 (a-plus-abs-b  1  0)))
  (is (= 6 (a-plus-abs-b  3 -3)))
  (is (= 0 (a-plus-abs-b -3 -3))))

;(run-tests)
