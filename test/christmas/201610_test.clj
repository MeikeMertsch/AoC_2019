(ns christmas.201610-test
    (:require [christmas.201610 :as chr]
                  [expectations :refer :all]
              [clojure.string :as str]))

(def t-file (slurp "resources/201610"))
(def file (slurp "resources/201610real"))
(def game (chr/parse-file t-file))




;(expect "" t-file )
;(expect "" (chr/parse-file t-file))
;(expect {:value 5 :bot 2} (first (chr/parse-file t-file)))

;(expect "" (chr/tick game))

(expect true (chr/bot-has-value {0 {:low [:output 2], :high [:output 0] :value 5}, 1 {:low [:output 1], :high [:bot 0]}, 2 {:low [:bot 1], :high [:bot 0]}}
    [5 0]))

(expect false (chr/bot-has-value {0 {:low [:output 2], :high [:output 0] :value 5}, 1 {:low [:output 1], :high [:bot 0]}, 2 {:low [:bot 1], :high [:bot 0]}}
    [5 1]))

;(expect "" (chr/tick (chr/tick (chr/tick (chr/tick (chr/tick (chr/tick game)))))))

(expect {:bots {}, :values {}, :outputs {2 1, 3 2, 5 0}} (chr/play t-file))
(expect {:bots {}, :values {}, :outputs {2 1, 3 2, 5 0}} (chr/play file))