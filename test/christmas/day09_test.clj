(ns christmas.day09-test
  (:require [christmas.day09 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(comment
(def file (slurp "resources/day09real"))

(expect 3063082071 (chr/program1209 file 1))
(expect 81348 (chr/program1209 file 2))

;(expect 16 (count (str (first (chr/program1209 "1102,34915192,34915192,7,4,7,99,0" 1)))))
;(expect 1125899906842624N (first (chr/program1209 "104,1125899906842624,99" 1)))

;(expect [109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99] (chr/program1209 "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99" 1))


;(expect 3N (get {2N 3} 2 0))
)