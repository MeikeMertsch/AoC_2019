(ns christmas.day09-test
  (:require [christmas.day09 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day09real"))