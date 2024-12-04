(ns smp-lab-2.core)


; f(x) = x^3 - 6x^2 + 7x +3
(defn my-f [x]
  (+ (+ (- (* (* x x) x) (* 6 (* x x))) (* 7 x)) 3))

(defn calc-trapezoid-area
  "площадь прямоугольной трапеции, аппроксимирующей функцию f на интервале [a;b]"
  [f a b]
  (* (* (+ (f a) (f b)) 0.5) (- b a)))

(defn integral [f a b d]
  (if (>= a b)
    0
    (+ (calc-trapezoid-area f a (+ a d)) (integral f (+ a d) b d))))

(integral my-f 0.0 2 0.1)