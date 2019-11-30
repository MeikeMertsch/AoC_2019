(ns christmas.day13-test
  (:require [christmas.day13 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day13real"))