(ns smallest-multiple)
(use 'clojure.test)

; Project Euler
;
; Smallest Multiple
;
; Problem 5
;
; 2520 is the smallest number that can be divided by each of the numbers from 1
; to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all of the 
; numbers from 1 to 20?
;
; Solution by twcrone

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
  

(deftest base-case
  (= (solve 10) 2520))

(run-tests 'smallest-multiple)

(println "------------------------------")
(println "Solving for 20...")
(println "Solution for 20 is " (solve 20))