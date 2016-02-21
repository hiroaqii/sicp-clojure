(ns sicp-clojure.ch1.chapter1-2)

;;; 1.2.1 線形再帰と反復

;; メモ
;; ・線形再帰プロセス
;; ・線形反復プロセス

;; 線形再帰プロセスバージョン
(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(factorial 6)
;; 720


(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (recur (* counter product) (inc counter) max-count)))

;; 線形反復プロセスバージョン
(defn factorial2 [n]
  (fact-iter 1 1 n))

(factorial2 6)
;; 720

;;; 1.2.2 木の再帰

;; 再帰プロセス
(defn fib [n]
  (cond (zero? n) 0
        (= 1 n) 1
        :else (+ (fib (- n 1))
                 (fib (- n 2)))))
(fib 10)
;; 55


;; 反復プロセス
(defn fib-iter [a b cnt]
  (if (= cnt 0)
    b
    (recur (+ a b) b (- cnt 1))))

(defn fib2 [n]
  (fib-iter 1 0 n))

(fib2 10)
;; 55

;; Clojureぽい書き方
(defn fib3 [n]
  (let [col (->> [0 1]
                 (iterate (fn [[x y]] [y (+ x y)]))
                 (map first))]
    (nth col n)))

(fib3 10)
;; 55


;;両替パターンの計算

(defn first-denomination [kinds-of-coins]
  (condp = kinds-of-coins
    1 1
    2 5
    3 10
    4 25
    5 50))

(defn cc [amount kinds-of-coins]
  (cond
    (zero? amount) 1
    (or (< amount 0) (zero? kinds-of-coins)) 0
    :else (+ (cc amount (dec kinds-of-coins))
             (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))

(count-change 100)
;; 292

(comment
  ;;(count-change 10) の再帰プロセスの置換モデル
  (cc 10 5)
  (+ (cc 10 4)(cc -40 5))
  (+ (cc 10 3)(cc -15 4)(cc -40 5))
  (+ (cc 10 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ (cc 10 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ (cc 10 0)(cc 9 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 (cc 9 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 (cc 9 0)(cc 8 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 (cc 8 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 (cc 8 0)(cc 7 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 (cc 7 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 (cc 7 0)(cc 6 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 (cc 6 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 (cc 6 0) (cc 5 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 (cc 5 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 (cc 4 0) (cc 3 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 (cc 3 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 (cc 3 0)(cc 2 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5) )
  (+ 0 0 0 0 0 0 0 (cc 2 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 (cc 2 0)(cc 1 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 (cc 1 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 (cc 1 0)(cc 0 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 (cc 0 1)(cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 (cc 5 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 (cc 5 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 (cc 5 0)(cc 4 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 (cc 4 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 (cc 4 0)(cc 3 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 (cc 3 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 (cc 3 0)(cc 2 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 (cc 2 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 (cc 2 0)(cc 1 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 (cc 1 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 (cc 1 0)(cc 0 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 (cc 0 1)(cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 (cc 0 2)(cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 (cc 0 3)(cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 1 (cc -15 4)(cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 1 0 (cc -40 5))
  (+ 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 1 0 0)
  4
  )

;;; 1.2.4 指数計算

;; 線形再帰プロセス
(defn expt1 [b n]
  (if (zero? n)
    1
    (* b (expt1 b (dec n)))))

;; 線形反復プロセス
(defn expt-iter [b cnt product]
  (if (zero? cnt)
    product
    (expt-iter b (dec cnt) (* b product))))
(defn expt2 [b n]
  (expt-iter b n 1))

(defn fast-expt [b n]
  (cond
    (zero? n) 1
    (even? n) (int (Math/pow (fast-expt b (/ n 2)) 2))
    :else (* b (fast-expt b (dec n)))))

(comment
  ;;(fast-expt 2 10) の再帰プロセスの置換モデル
  (Math/pow (fast-expt 2 5) 2)
  (Math/pow (* 2 (fast-expt 2 4)) 2)
  (Math/pow (* 2 (Math/pow (fast-expt 2 2) 2)) 2)
  (Math/pow (* 2 (Math/pow (Math/pow (fast-expt 2 1) 2) 2)) 2)
  (Math/pow (* 2 (Math/pow (Math/pow (* 2 (fast-expt 2 0)) 2) 2)) 2)
  (Math/pow (* 2 (Math/pow (Math/pow (* 2 1) 2) 2))2)
  (Math/pow (* 2 (Math/pow (Math/pow 2 2)2))2)
  (Math/pow (* 2 (Math/pow 4 2)) 2)
  (Math/pow (* 2 16) 2)
  (Math/pow 32 2)
  1024
  )
