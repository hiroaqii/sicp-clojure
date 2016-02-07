(ns sicp-clojure.ch1.chapter1)

;;;1.1.2 命名と環境

(def pi 3.14159)
(def radius 10)
(* pi (* radius radius))
;;314.159

(def circumference (* 2 pi radius))
circumference
;;62.8318

;;;1.1.3 組み合わせの評価
;; なし

;;;1.1.4 複合手続き
(defn square [x]
  (* x x))

(square 21)
;;441
(square (+ 2 5))
;;49
(square (square 3))
;;81

(defn sum-of-squares [x y]
  (+ (square x) (square y)))

(sum-of-squares 3 4)
;;25

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

(f 5)
;;136

;;;1.1.5 手続き適用の置換モデル
;;なし

;;;1.1.6 条件式と述語
(defn abs [x]
  (cond
    (> x 0) x
    (= x 0) 0
    (< x 0) (- x)))

(defn abs [x]
  (cond
    (< x 0) (- x)
    :else x))

(defn abs [x]
  (if (< x 0) (- x) x))


;;;1.1.7 ニュートン法による平方根

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (recur (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt 9)
;;3.00009155413138
(sqrt (+ 100 37))
;;11.704699917758145
(sqrt (+ (sqrt 2) (sqrt 3)))
;;1.7739279023207892
(square (sqrt 1000))
;;1000.000369924366
