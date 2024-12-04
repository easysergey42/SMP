(ns smp-lab-1.task-1)
(defn extend-word
  "Возвращает список слов, получившихся при удлинении слова word на 1 символ из chars без сдвоенных символов"
  [word, chars]
  (if (empty? chars)
    ()
    ( if (= (first chars) (last word))
      (extend-word word (rest chars))
      (cons (str word (first chars)) (extend-word word (rest chars))))
    ))

(defn extend-all-words
  "Возвращает список слов, получившийся в результате удлинения всех слов из words на 1 символ символами из chars"
  [words, chars]
  (if (empty? words)
    ()
    (concat (extend-word (first words) chars) (extend-all-words (rest words) chars))))

(defn extend-words-by-n-chars
  "Возвращает список слов, полученный из words путем удлинения на n символов из chars"
  [words, chars, n]
  (if (= n 0)
    words
    (extend-words-by-n-chars (extend-all-words words chars) chars (dec n)))
  )

;(println (extend-word "" `(\a \b \c)))
;(println (extend-all-words `("a") `(\a \b \c)))
;(println (extend-words-by-n-chars `("") `(\a \b \c) 3))