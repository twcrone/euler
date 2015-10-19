(ns smallest-multiple)
(use 'clojure.test)

(def nums '(1 2 3 4 5 6 7 8 9 10))

(defn is-divisible-by? [n d]
  (= (mod n d) 0))

(defn solve [n] (every? (partial is-divisible-by? n) nums))

(deftest base-case
  (is (solve 2520)))

(run-tests 'smallest-multiple)