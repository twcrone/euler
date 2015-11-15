(require '[clojure.string :as string])

(defn palindromic? [s] (= s (string/reverse s)))

