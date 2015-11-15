(ns largest-prime-factor)
(use 'clojure.test)

; Project Euler
;
; Largest Prime Factor
;
; Problem 3
;
; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?
;
; Solution by twcrone

(defn is-prime [n] (not (some #(= (mod n %) 0) (range 2 (/ n 2)))))

(defn is-factor [n d] (= (mod n d) 0))

(defn prime-factors [n]
    (last (filter #(and (is-factor n %) (is-prime %)) (range 2 n))))

(println (prime-factors 13195))

(println (prime-factors 600851475143))
