(ns christmas.day23-test
  (:require [christmas.day23 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day23real"))