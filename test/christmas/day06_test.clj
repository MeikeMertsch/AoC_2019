(ns christmas.day06-test
  (:require [christmas.day06 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day06real"))
(def t-file "COM)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L")

(def t2-file "COM)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L
K)YOU
I)SAN")

(def t-input (chr/parse t-file))
(def t-input2 (chr/parse t2-file))

;(expect "" (chr/parse file))
;(expect "" t-input)

(expect ["B"] (chr/find-orbiter2 t-input2 ["YOU"]))

(expect 42 (chr/game t-file))
;(expect 147807 (chr/game file "COM"))

(expect 42 (chr/game2 t2-file "YOU"))
(expect 42 (chr/game2 file "YOU"))
