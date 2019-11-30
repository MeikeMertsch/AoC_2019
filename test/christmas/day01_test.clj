(ns christmas.day01-test
  (:require [christmas.day01 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day03real"))