(ns christmas.day22-test
  (:require [christmas.day22 :as chr]
  		  	[expectations :refer :all]
            [clojure.string :as str]))

(def file (slurp "resources/day22real"))