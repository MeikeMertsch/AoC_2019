(ns christmas.day11-test
  (:require [christmas.day11 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day11real"))