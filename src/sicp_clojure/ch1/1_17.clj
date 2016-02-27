(ns sicp-clojure.ch1.1-17
   (:require [clojure.test :refer [deftest is run-tests]]))

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn multi [a b]
  (cond
    (zero? b) 0
    (even? b) (multi (double a) (halve b))
    :else (+ (multi (double a) (halve (dec b))) a)))

(deftest t
  (is 0   (multi 3 0))
  (is 3   (multi 3 1))
  (is 6   (multi 3 2))
  (is 30  (multi 3 10))
  (is 333 (multi 3 111)))

;; (run-tests)
