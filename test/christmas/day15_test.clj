(ns christmas.day15-test
  (:require [christmas.day15 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day15real"))