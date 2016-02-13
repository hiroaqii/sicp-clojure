(ns sicp-clojure.ch1.1-11
  (:require [clojure.test :refer [deftest is run-tests]]))

;; 再帰プロセス
(defn f1 [n]
  (if (< n 3)
    n
    (+ (f1 (- n 1))
       (* 2 (f1 (- n 2)))
       (* 3 (f1 (- n 3))))))

;; 反復プロセス
(defn f2-iter [x y z cnt]
  (if (zero? cnt)
    x
    (recur y
           z
           (+ z (* 2 y) (* 3 x)) (dec cnt))))

(defn f2 [n]
  (f2-iter 0 1 2 n))

;; n=30だと再帰プロセスと反復プロセスで
;; 処理にかかる時間の違いが体感できる
(deftest t
  (is (= 1  (f1 1)))
  (is (= 1  (f2 1)))
  (is (= 2  (f1 2)))
  (is (= 2  (f2 2)))
  (is (= 4  (f1 3)))
  (is (= 4  (f2 3)))
  (is (= 11 (f1 4)))
  (is (= 11 (f2 4)))
  (is (= 25 (f1 5)))
  (is (= 25 (f2 5)))
  (is (= 1892 (f1 10)))
  (is (= 1892 (f2 10)))
  (is (= 10771211 (f1 20)))
  (is (= 10771211 (f2 20)))
  (is (= 61354575194 (f1 30)))
  (is (= 61354575194 (f2 30)))
  )

;(run-tests)
