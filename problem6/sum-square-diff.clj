(ns sum-square-diff)

(defn square [n] (* n n))

(defn sum-squares [upper]
  (reduce + (map square (range (+ upper 1)))))

(defn square-sum [upper]
  (let [sum (reduce + (range (+ upper 1)))]
    (square sum)))

(defn diff-sums [upper]
  (- (square-sum upper) (sum-squares upper)))

(sum-squares 10)

(square-sum 10)

(diff-sums 10)

(diff-sums 100)
