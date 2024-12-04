(ns smp-lab-1.task-3 )

(defn my-filter [pred coll]
  (seq (reduce #(if (pred %2) (conj %1 %2) %1) [] coll)))

(defn my-map [f coll]
  (seq (reduce #(conj %1 (f %2)) [] coll)))                 ;это не lazy-seq функции! из-за reduce...