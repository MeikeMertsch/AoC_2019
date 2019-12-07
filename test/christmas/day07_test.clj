(ns christmas.day07-test
  (:require [christmas.day07 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(comment
(def file (slurp "resources/day07real"))
(def t-file "3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0")
(def t-file2 "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0")
(def t-file3 "3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5")
(def t-file4 "3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10")

;(expect 93 (chr/amplifier file [3 0]))

;(expect 43210 (chr/thruster t-file [4 3 2 1 0]))

;(expect 65210 (chr/signal t-file2))


;(expect 65210 (chr/signal file (range 5 10)))

(expect 139629729 (chr/signal t-file3 (range 5 10)))

(expect 139629729 (chr/thruster (chr/parse t-file3) [9 8 7 6 5]))
(expect 18216 (chr/thruster (chr/parse t-file4) [9 7 8 5 6]))

(expect 118936 (chr/signal file (range 5)))
(expect 139629729 (chr/signal t-file3 (range 5 10)))
(expect 57660948 (chr/signal file (range 5 10)))
)