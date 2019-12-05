(ns christmas.day05-test
  (:require [christmas.day05 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(comment
(def file (slurp "resources/day05real"))


;(expect "" (chr/parse file))

;(expect {:optcode 2 :mode3 0 :mode2 1 :mode1 0} (chr/decrypt-instr 1002))

;(expect 8332629 (chr/program1205 file 1))
(expect "" (chr/program1205 file 5)) ; 2260930 too low

;(expect "" (map-indexed vector (chr/parse file)))

(expect nil (chr/program1205 "1002,4,3,4,33" 1))
(expect nil (chr/program1205 "1101,100,-1,4,0" 1))
(expect 1 (chr/program1205 "3,0,4,0,99" 1))
)