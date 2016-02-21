(ns sicp-clojure.ch1.1-16
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn fast-expt-iter [a b n]
  (cond
    (zero? n) a
    (even? n) (fast-expt-iter a (* b b) (/ n 2))
    :else     (fast-expt-iter (* a b) b (dec n))))

(defn fast-expt [b n]
  (fast-expt-iter 1 b n))

(deftest t
  (is 2     (fast-expt 2 1))
  (is 4     (fast-expt 2 2))
  (is 8     (fast-expt 2 3))
  (is 1024  (fast-expt 2 10))
  (is 2048  (fast-expt 2 11))
  (is 59049 (fast-expt 3 10)))

;;(run-tests)
