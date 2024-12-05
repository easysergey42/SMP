(ns smp-lab-2.task-1
  (:require [smp-lab-2.core :refer :all]))

(time ((integrate my-f 0.05) 0 50))

(time ((memoized-integrate my-f 0.05) 0 50))

(time ((inf-integral my-f 0.05) 50.0))