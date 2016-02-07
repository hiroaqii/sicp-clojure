(ns sicp-clojure.ch1.1-06)

(defn new-if [predicate then-clause else-clause]
  (cond predicate
        then-clause
        :else else-clause))

(new-if (= 2 3) 0 5)
;; 5
(new-if (= 1 1) 0 5)
;; 0

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x) x)))


;; new-if関数は特殊形式ではなく普通の関数。
;; つまり適用順序評価なので、(good-enough? guess x) の結果に関係なく
;; (sqrt-iter (improve guess x) x) は評価される。
;; よって無限ループになる。
(sqrt-ite 1.0 9)
;; StackOverflowError
