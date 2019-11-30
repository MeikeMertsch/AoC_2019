(ns christmas.day04-test
 (:require [christmas.day04 :as chr]
 		 	[expectations :refer :all]
 		 	[clojure.string :as str]))

(def file (slurp "resources/day04real"))