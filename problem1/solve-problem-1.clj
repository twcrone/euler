(defn get-value-div-by-5-or-3 [num] 
  (if (or (= (mod num 3) 0) (= (mod num 5) 0)) 
    num 
    0))

(defn sum-factors-of-5-or-3 [sum x] 
  (if (pos? x) 
    (recur (+ sum (get-value-div-by-5-or-3 x)) (dec x)) 
    sum))

(println (sum-factors-of-5-or-3 0 999) "Should be" 233168)
