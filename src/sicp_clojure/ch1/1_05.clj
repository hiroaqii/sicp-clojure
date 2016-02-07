(ns sicp-clojure.ch1.1-05
  (:require [clojure.test :refer [deftest is run-tests]]))


;;正規順序の評価　：完全に展開し、簡約する
;;作用的順序の評価：引数を評価し、作用させる
;;
;;作用的順序の評価が行われるので、(test_ 0 (p))を実行すると
;;無限ループに陥りStackOverflowErrorで終了する
;;(もし正規順序の評価であれば0を返す）

(defn p [] (p))

(defn test_ [x y]
  (if (= x 0)
    0
    y))

;;(test_ 0 (p))
;;StackOverflowError
