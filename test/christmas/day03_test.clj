(ns christmas.day03-test
  (:require [christmas.day03 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))


(comment
(def file (slurp "resources/day03real"))
(def start (chr/parse-file file))
(def t-file "U7,R6,D4,L4\nR8,U5,L5,D3")
(def t-start (chr/parse-file t-file))


;(expect 1017 (chr/walk start))
;(expect 1017 (chr/walk2 start)) ; 12185 too high
(expect 1017 (chr/walk2 t-start)) ; 12185 too high

(expect [[0 0] [0 -1]] (chr/walk-entry [[1 1]] ["R" 5])) 
)
