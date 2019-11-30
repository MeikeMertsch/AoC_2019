(ns christmas.day06-test
  (:require [christmas.day06 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day06real"))