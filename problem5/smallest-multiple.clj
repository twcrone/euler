(ns smallest-multiple)
(use 'clojure.test)

(def nums '(1 2 3 4 5 6 7 8 9 10))

(defn is-divisible-by? [n d]
  (= (mod n d) 0))

(defn solve [] (every? (partial is-divisible-by? 100) nums))

(deftest base-case
  (is (solve)))

(run-tests 'smallest-multiple)