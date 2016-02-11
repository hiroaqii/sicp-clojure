(ns sicp-clojure.ch1.1-09)

(defn plus1 [a b]
  (if (zero? a)
    b
    (inc (plus1 (dec a) b))))

(comment
  (plus1 4 5)
  (inc (plus1 3 5))
  (inc (inc (plus1 2 5)))
  (inc (inc (inc (plus1 1 5))))
  (inc (inc (inc (inc (plus 0 5)))))
  (inc (inc (inc (inc 5))))
  (inc (inc (inc 6)))
  (inc (inc 7))
  (inc 8)
  9
  ; 置換モデル -> 再帰プロセス
  )


(defn plus2 [a b]
  (if (zero? a)
    b
    (plus2 (dec a) (inc b))))

(comment
  (plus2 4 5)
  (plus2 3 6)
  (plus2 2 7)
  (plus2 1 8)
  (plus2 0 9)
  9
  ; 置換モデル -> 反復プロセス
  )
