(ns christmas.day07-test
  (:require [christmas.day07 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day07real"))