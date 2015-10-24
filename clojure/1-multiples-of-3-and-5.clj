(defn sum-factors-of-5-or-3 [max]
  (loop [sum 0 x max]
    (if (pos? x)
      (recur (if (or (= (mod x 3) 0) (= (mod x 5) 0)) (+ sum x) sum) (dec x))
      sum)))

(println (sum-factors-of-5-or-3 999) "Should be" 233168)
