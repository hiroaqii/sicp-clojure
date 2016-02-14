(ns sicp-clojure.ch1.1-15)

(defn cube [x]
  (* x x x))

;; (pirntln x) のコメントアウトをはずして
;; 何回呼ばれたか確認
(defn p [x]
  ;(println x)
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

(sine 12.15)
