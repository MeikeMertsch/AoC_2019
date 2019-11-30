(ns christmas.day08-test
  (:require [christmas.day08 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day08real"))