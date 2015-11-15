(ns max-path-sum-1)
(use 'clojure.test)
(require '[clojure.string :as str])

(defn reduce-row [values]
  (loop [src values
        dest []]
    (if (= (count src) 1)
      dest
      (recur (rest src) (conj dest (max (first src) (second src)))))))

(defn add-rows
  [a b]
  (if (empty? a)
    b
    (if (empty? b)
      a
      (map + a b))))

(defn solve-for
  [data]
  (loop [src (vec (reverse data))
         sol []]
    (if (= (count src) 1)
      (+ (first sol) (first (first src)))
      (recur (rest src) (reduce-row (add-rows (first src) sol))))))

(defn parse-int [s]
  (Integer. (re-find #"[0-9]*" s)))

(defn load-data []
  (with-open [rdr (clojure.java.io/reader "/Users/toddcrone/work/twcrone/active/euler/clojure/67-test-data")]
    (map #(map parse-int (str/split % #" ")) (vec (line-seq rdr)))))

(solve-for (load-data))

; test
(deftest base-case
  (is (= (solve-for [[3] [7 4] [2 4 6] [8 5 9 3]]) 23)))

(deftest reduce-row-test
  (is (= (reduce-row [8 5 9 3]) [8 9 9])))

(deftest add-rows-test
  (is (= (add-rows [1 2 3] [1 3 1]) [2 5 4])))

(run-tests 'max-path-sum-1)
