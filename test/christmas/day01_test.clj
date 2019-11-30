(ns christmas.day01-test
  (:require [christmas.day01 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))
(comment
(def file (slurp "resources/day01real"))

(expect 3 (chr/exercise01 "1122"))
(expect 4 (chr/exercise01 "1111"))
(expect 0 (chr/exercise01 "1234"))
(expect 9 (chr/exercise01 "91212129"))

(expect 1175 (chr/exercise01 file))

;-----------------------

(expect 6 (chr/exercise01b "1212"))
(expect 0 (chr/exercise01b "1221"))
(expect 4 (chr/exercise01b "123425"))
(expect 12 (chr/exercise01b "123123"))
(expect 4 (chr/exercise01b "12131415"))

(expect 1166 (chr/exercise01b file))
)