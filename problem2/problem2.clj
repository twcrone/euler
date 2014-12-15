(def four-mil (* 4 1000000))

(defn fib [i j sum]
  (if (> j four-mil)
    (println sum)
    (fib j (+ i j) (if (even? j) (+ sum j) sum))))

(fib 1 2 0)
