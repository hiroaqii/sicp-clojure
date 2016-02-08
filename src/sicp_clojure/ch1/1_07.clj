(ns sicp-clojure.ch1.1-07)

(defn average [x y]
  (/ (+ x y) 2))

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (println guess) ;; 変化を確認
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (recur (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

;; 許容誤差の値0.001よりも小さい値なので正しい値が返ってこない
(sqrt 0.0001)
;; 0.03230844833048122 (正しい値は0.01)

;; 許容誤差の値0.001よりも小さくならないので無限ループが起こる
(sqrt 10000000000000)



;; 新しい推定値との差分で判断するよう修正
(defn good-enough2? [guess x]
  (let [new-guess (improve guess x)]
    (< (abs (- new-guess guess)) 0.001)))

(defn sqrt-iter2 [guess x]
  (if (good-enough2? guess x)
    guess
    (recur (improve guess x) x)))

(defn sqrt2 [x]
  (sqrt-iter2 1.0 x))

(sqrt2 0.0001)
;; 0.010120218365353947

(sqrt2 10000000000000)
;; 3162277.6601683795
