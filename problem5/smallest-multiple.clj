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
        (recur (+ candidate top)))
      candidate)))
  

; (deftest base-case
;   (= (solve 10) 2520))

; (run-tests 'smallest-multiple)
(println "Solution for 10 is " (solve 10))

(println "Solution for 20 is " (solve 20))