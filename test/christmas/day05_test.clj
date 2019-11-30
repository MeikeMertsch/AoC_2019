(ns christmas.day05-test
  (:require [christmas.day05 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day05real"))