(defn is-prime [n] (not (some #(= (mod n %) 0) (range 2 (/ n 2)))))

(defn is-factor [n d] (= (mod n d) 0))

(defn prime-factors [n]
  (last (filter #(and (is-factor n %) (is-prime %)) (range 2 n))))

(println (prime-factors 13195))
