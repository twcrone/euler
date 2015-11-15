(ns max-path-sum-1)
(use 'clojure.test)

(def base-data (list 3 7 4 2 4 6 8 9 3))

(defn reduce-row [values]
  (loop [src values
        dest []]
    (if (= (count src) 1)
      dest
      (recur (rest src) (conj dest (max (first src) (second src)))))))

(defn add-rows
  [a b]
  (map + a b))

(reduce-row [8 5 9 3])

(add-rows [1 2 3] [1 3 1])


(defn solve-for [data] 23)

; test
(deftest base-case
  (is (= (solve-for [3 7 4 2 4 6 8 9 3]) 23)))

(deftest reduce-row-test
  (is (= (reduce-row [8 5 9 3]) [8 9 9])))

(deftest add-rows-test
  (is (= (add-rows [1 2 3] [1 3 1]) [2 5 4])))

(run-tests 'max-path-sum-1)
