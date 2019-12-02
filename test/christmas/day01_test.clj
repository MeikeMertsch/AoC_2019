(ns christmas.day01-test
    (:require [christmas.day01 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]
    )
)

(comment
(def file (slurp "resources/day01real"))
(def values (chr/parse-file file))

(expect "" (chr/parse-file file))

(expect 2.0 (chr/total-per-module 14))
(expect 966.0 (chr/total-per-module 1969))
(expect 50346.0 (chr/total-per-module 100756))

(expect 3352674 (chr/total-fuel values))
(expect 5026151 (chr/total-all values))
)
