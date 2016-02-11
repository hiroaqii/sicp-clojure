(ns sicp-clojure.ch1.1-08)

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess) ) 3))

(defn good-enough? [guess x]
  (let [new-guess (improve guess x)]
    (< (abs (- new-guess guess)) 0.001)))

(defn cube-iter [guess x]
  (if (good-enough? guess x)
    guess
    (recur (improve guess x) x)))

(defn cube [x]
  (cube-iter 1.0 x))

(cube 8)
;; 2.000004911675504
(cube 27)
;; 3.0000005410641766
(cube 0.0001)
;; 0.04681032164902804
(cube 10000000000000)
;; 21544.346946265196
