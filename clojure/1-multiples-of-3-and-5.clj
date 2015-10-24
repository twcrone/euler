(ns multiples-of-3-and-5)
(use 'clojure.test)

; Project Euler
;
; Multiples of 3 and 5
;
; Problem 1
;
; If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.;
;
; Solution by twcrone

(defn sum-factors-of-5-or-3 [max]
  (loop [sum 0 x max]
    (if (pos? x)
      (recur (if (or (= (mod x 3) 0) (= (mod x 5) 0)) (+ sum x) sum) (dec x))
      sum)))

; test
(deftest base-case
  (is (= (sum-factors-of-5-or-3 10) 23)))

(run-tests 'multiples-of-3-and-5)

; main
(println (sum-factors-of-5-or-3 999))
