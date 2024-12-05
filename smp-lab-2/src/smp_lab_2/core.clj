(ns smp-lab-2.core)
; f(x) = x^3 - 6x^2 + 7x +3
(defn my-f [x]
  (+ (+ (- (* (* x x) x) (* 6 (* x x))) (* 7 x)) 3))

(defn calc-trapezoid-area
  "площадь прямоугольной трапеции, аппроксимирующей функцию f на интервале [a;b]"
  [f a b]
  (* (* (+ (f a) (f b)) 0.5) (- b a)))

(defn integrate [function h]
  (fn integral [a b]
    (if (>= a b)
      0
      (+ (calc-trapezoid-area function a (+ a h)) (integral (+ a h) b)))))

(defn integral [f a b h]
  (if (>= a b)
    0
    (+ (calc-trapezoid-area f a (+ a h)) (integral f (+ a h) b h))))

(defn memoized-integrate [function h]
  (memoize (fn integral [a b]
             (if (>= a b)
               0
               (+ (calc-trapezoid-area function a (+ a h)) (integral (+ a h) b))))))

(defn inf-integral [f step]
  (let [seq (map first (iterate (fn [[step_sum index]]
                                  [(+ step_sum (calc-trapezoid-area f (* step (- index 1)) (* step index))) (inc index)]) [0 1]))]
    (fn [x]
      (let [i (int (/ x step))] (+
                                  (nth seq i)
                                  (calc-trapezoid-area f (* step i) x)))
      )
    )
  )

(integral my-f 0.0 2 0.1)
((integrate my-f 0.1) 0.0 2)