(ns christmas.day24-test
  (:require [christmas.day24 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day24real"))