(ns christmas.day12-test
  (:require [christmas.day12 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day12real"))