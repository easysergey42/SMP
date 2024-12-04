(ns smp-lab-1.task-2)

(defn extend-word
  "Возвращает список слов, получившихся при удлинении слова word на 1 символ из chars без сдвоенных символов"
  [word, chars, acc]                                        ;acc изначально пустой список и накапливает в себе слова производные от word
  (if (empty? chars)
    acc
    ( if (= (first chars) (last word))
      (recur word (rest chars) acc)
      (recur word (rest chars) (cons (str word (first chars)) acc)))
    ))

(defn extend-all-words
  "Возвращает список слов, получившийся в результате удлинения всех слов из words на 1 символ символами из chars"
  [words, chars, acc]                                       ;acc накапливает все возможные слова производимые от words символами из chars
  (if (empty? words)
    acc
    (recur (rest words) chars (concat (extend-word (first words) chars ()) acc))))

(defn extend-words-by-n-chars
  "Возвращает список слов, полученный из words путем удлинения на n символов из chars"
  [words, chars, n]
  (if (= n 0)
    words
    (recur (extend-all-words words chars ()) chars (dec n)))
  )

;(extend-word "a" `(\a \b \c) ())
;(extend-all-words `("a" "b" "c") `(\a \b \c) ())
;(println (extend-words-by-n-chars `("") `(\a \b \c) 3))