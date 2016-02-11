(ns sicp-clojure.ch1.chapter1)

;;-----------------------
;;; 1.1.2 命名と環境

(def pi 3.14159)
(def radius 10)
(* pi (* radius radius))
;;314.159

(def circumference (* 2 pi radius))
circumference
;;62.8318

;;-----------------------
;;; 1.1.3 組み合わせの評価
;; なし

;;-----------------------
;;; 1.1.4 複合手続き

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

;;-----------------------
;;; 1.1.5 手続き適用の置換モデル
;; なし

;;-----------------------
;;; 1.1.6 条件式と述語

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

;;-----------------------
;;; 1.1.7 ニュートン法による平方根

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

;;-----------------------
;;; 1.1.8 ブラックボックス抽象化としての手続き

(defn sqrt2 [x]
  (let [good-enough? (fn [guess] (< (abs (- (square guess) x)) 0.001))
        improve      (fn [guess] (average guess (/ x guess)))
        sqrt-iter    (fn [guess] (if (good-enough? guess)
                                  guess
                                  (recur (improve guess))))]
    (sqrt-iter 1.0)))

(sqrt2 2)
;; 1.4142156862745097
(sqrt2 3)
;; 1.7321428571428572
(sqrt2 4)
;; 2.0000000929222947

;; メモ
;;・レキシカルスコープ
;;  関数の定義時に決まるスコープ
;;・ダイナミックスコープ
;;　関数の評価時に決まるスコープ
