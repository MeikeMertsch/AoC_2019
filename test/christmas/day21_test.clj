(ns christmas.day21-test
  (:require [christmas.day21 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day21real"))