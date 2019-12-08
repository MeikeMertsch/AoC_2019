(ns christmas.day08-test
  (:require [christmas.day08 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(comment
(def file (slurp "resources/day08real"))

(expect 1360 (chr/checksum file [25 6]))

(expect nil (chr/message file [25 6]))
)


;(        X       X X   X X   X X     X X       X X) 
;(  X X X X   X X   X   X X   X   X X   X   X X   X) 
;(      X X   X X   X   X X   X   X X   X   X X   X) 
;(  X X X X       X X   X X   X         X       X X) 
;(  X X X X   X X X X   X X   X   X X   X   X   X X) 
;(  X X X X   X X X X X     X X   X X   X   X X   X)

;XXXX XXX  X  X  XX  XXX
;X    X  X X  X X  X X  X
;XXX  X  X X  X X  X X  X
;X    XXX  X  X XXXX XXX
;X    X    X  X X  X X X
;X    X     XX  X  X X  X