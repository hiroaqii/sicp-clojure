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
