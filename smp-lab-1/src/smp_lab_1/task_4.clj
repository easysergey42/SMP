(ns smp-lab-1.task-4
  (:require [smp-lab-1.task-3 :refer :all]))

(defn extend-word
  "Возвращает список слов, получившихся при удлинении слова word на 1 символ из chars без сдвоенных символов"
  [word, chars]
  (my-map #(str word %) (my-filter #(not= (last word) %) chars)))

(defn extend-all-words
  "Возвращает список слов, получившийся в результате удлинения всех слов из words на 1 символ символами из chars"
  [words, chars]
  (reduce concat (my-map #(extend-word % chars) words)))

(defn extend-words-by-n-chars
  "Возвращает список слов, полученный из words путем удлинения на n символов из chars"
  [words, chars, n]
  (reduce (fn [words _] (extend-all-words words chars)) words (range n))
  )

;(extend-word "ac" '(\a \b \c))
;(extend-all-words '("a" "b" "c") '(\a \b \c))
(extend-words-by-n-chars `("xo") `(\a \b \c) 0)