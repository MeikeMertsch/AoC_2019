(ns christmas.day03-test
  (:require [christmas.day03 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day03real"))