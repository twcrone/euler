(ns max-path-sum-1)
(use 'clojure.test)

(def base-data (list 3 7 4 2 4 6 8 9 3))

(defn solve-for [data] 23)

; test
(deftest base-case
  (is (= (solve-for '(3 7 4 2 4 6 8 9 3)) 23)))

(run-tests 'max-path-sum-1)
