(ns smallest-multiple)
(use 'clojure.test)

(defn is-divisible-by? [n d]
  (= (mod n d) 0))

(defn solution? [n top]
  (let [nums (range 1 top)] 
    (every? (partial is-divisible-by? n) nums)))

(defn solve [top]
  (loop [candidate (* top 2)]
    (if (not (solution? candidate top))
      (do 
        (println (+ candidate top))
        (recur (+ candidate top)))
      candidate)))
  

; (deftest base-case
;   (= (solve 10) 2520))

; (run-tests 'smallest-multiple)

(solve 20)