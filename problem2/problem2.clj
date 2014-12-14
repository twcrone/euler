(def four-mil (* 4 1000000))

(defn even [n] (= (mod n 2) 0))

(defn add-even [n] (if (even n) n 0))

(defn fib [i j sum]
  (if (even j)
    (println j))
  (if (> j four-mil)
    (println "DONE -> " sum)
    (fib j (+ i j) (+ sum (add-even j)))))

(fib 1 2 0)
