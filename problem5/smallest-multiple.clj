(ns smallest-multiple)
(use 'clojure.test)

(def nums '(1 2 3 4 5 6 7 8 9 10))

(defn is-divisible-by? [d]
  (= (mod 2520 d) 0))

(defn solve [] (every? is-divisible-by? nums))

(deftest base-case
  (is (solve)))

(run-tests 'smallest-multiple)