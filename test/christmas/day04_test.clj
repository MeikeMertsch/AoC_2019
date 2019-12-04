(ns christmas.day04-test
 (:require [christmas.day04 :as chr]
 		 	[expectations :refer :all]
 		 	[clojure.string :as str]))

(comment
(def start 347312)
(def end 805915)

(expect 594 (chr/passwords start end)) ; 596 546
(expect 364 (chr/passwords2 start end)) ; 596 546

(expect nil (chr/has-double (chr/to-array 123789)))
(expect true (chr/has-double (chr/to-array 223450)))
(expect true (chr/has-double (chr/to-array 111111)))

(expect true (chr/is-increasing (chr/to-array 123789)))
(expect false (chr/is-increasing (chr/to-array 223450)))
(expect true (chr/is-increasing (chr/to-array 111111)))
(expect true (chr/is-increasing (chr/to-array 111123)))
(expect true (chr/is-increasing (chr/to-array 135679)))


(expect "" (partition-by identity [1 1 1 1 1 1]))
(expect "" (partition-by identity [6 7 7 9 9 9]))
)