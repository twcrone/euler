(ns sum-square-diff)
(use 'clojure.test)

; Project Euler
;
; Sum square difference
;
; Problem 6
;
; The sum of the squares of the first ten natural numbers is,

; 1^2 + 2^2 + ... + 10^2 = 385
; The square of the sum of the first ten natural numbers is,

; (1 + 2 + ... + 10)^2 = 552 = 3025
; Hence the difference between the sum of the squares of the first ten natural
; numbers and the square of the sum is 3025 − 385 = 2640.

; Find the difference between the sum of the squares of the first one hundred
; natural numbers and the square of the sum.
;
; Solution by twcrone

(defn square [n] (* n n))

(defn sum-squares [upper]
  (reduce + (map square (range (+ upper 1)))))

(defn square-sum [upper]
  (let [sum (reduce + (range (+ upper 1)))]
    (square sum)))

(defn diff-sums [upper]
  (- (square-sum upper) (sum-squares upper)))


; tests

(deftest sum-squares-10
  (is (= (sum-squares 10) 385)))

(deftest square-sum-10
  (is (= (square-sum 10) 3025)))

(deftest diff-sums-10
  (is (= (diff-sums 10) 2640)))

(run-tests 'sum-square-diff)


; main

(println "------------------------------")
(println "Solving for 100...")
(println "Solution for 100 is " (diff-sums 100))
