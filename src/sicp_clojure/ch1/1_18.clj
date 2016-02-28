(ns sicp-clojure.ch1.1-18
  (:require [clojure.test :refer [deftest is run-tests]]))

(defn double [n]
  (+ n n))

(defn halve [n]
  (/ n 2))

(defn multi-itere [n a b]
  (cond
    (zero? b) n
    (even? b) (itere n (double a) (halve b))
    :else (recur (+ n a) a (dec b))))

(defn multi [a b]
  (multi-itere 0 a b))

(deftest t
  (is 0   (multi 3 0))
  (is 3   (multi 3 1))
  (is 6   (multi 3 2))
  (is 30  (multi 3 10))
  (is 333 (multi 3 111)))

;; (run-tests)
