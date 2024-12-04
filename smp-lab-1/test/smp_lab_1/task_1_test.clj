(ns smp-lab-1.task-1-test
  (:require [clojure.test :refer :all]
            [smp-lab-1.task-1 :refer :all]))

(deftest simple-test
  (testing "Casual example with n = 0"
    (is (= `("") (extend-words-by-n-chars `("") `(\a \b \c) 0) ))))

(deftest basic-test
  (testing "Test from the task example"
    (is (=
          `("aba" "abc" "aca" "acb" "bab" "bac" "bca" "bcb" "cab" "cac" "cba" "cbc")
          (sort (extend-words-by-n-chars `("") `(\a \b \c) 3))))))