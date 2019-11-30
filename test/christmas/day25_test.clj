(ns christmas.day25-test
  (:require [christmas.day25 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day25real"))