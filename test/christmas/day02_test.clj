(ns christmas.day02-test
	(:require [christmas.day02 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

        (comment
(def file (slurp "resources/day02real"))

(def test1 "1,0,0,0,99")
(def test2 "2,3,0,3,99")
(def test3 "2,4,4,5,99,0")
(def test4 "1,1,1,4,99,5,6,0,99 becomes 30,1,1,4,2,5,6,0,99")

;(expect 6087827 (chr/program1202 file)) ;; 165 too low



(expect 6087827 (chr/program1202 file)) ;; 165 too low
(expect "5379" (chr/program2 file)) ;; 165 too low
        )