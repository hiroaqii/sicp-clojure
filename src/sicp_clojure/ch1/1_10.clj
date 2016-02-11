(ns sicp-clojure.ch1.1-10)

(defn A [x y]
  (cond
    (zero? y) 0
    (zero? x) (* 2 y)
    (= 1 y) 2
    :else (recur (dec x) (A x (dec y)))))

(comment
  (A 1 10); 1024
  (A 2 4) ; 65536
  (A 3 3) ; 65536
  )


(defn f [n] (A 0 n))
(comment
  (f 1) ;2
  (f 2) ;4
  (f 3) ;6
  ;; 数学的定義 2n
  )

(defn g [n] (A 1 n))
(comment
  (g 1) ;2
  (g 2) ;4
  (g 3) ;8
  (g 4) ;16
  ;; 数学的定義 2^n
  )

(defn h [n] (A 2 n))
(comment
  (h 1) ;2
  (h 2) ;4
  (h 3) ;16
  (h 4) ;65536
  ;; 数学的定義 2^(2^n)
  )
