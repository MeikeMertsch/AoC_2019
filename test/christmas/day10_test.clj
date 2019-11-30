(ns christmas.day10-test
  (:require [christmas.day10 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day10real"))