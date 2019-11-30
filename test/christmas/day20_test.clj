(ns christmas.day20-test
  (:require [christmas.day20 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day20real"))