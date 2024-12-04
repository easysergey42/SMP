(ns smp-lab-1.task-3-test
  (:require [clojure.test :refer :all]
            [smp-lab-1.task-3 :refer :all]))

(deftest filter-test
  (testing "my-filter test"
    (is (= `(2 4) (my-filter even? [1 2 3 4 5])))))

(deftest map-test
  (testing "my-map test"
    (is (= `(2 3 4) (my-map inc `(1 2 3))))))