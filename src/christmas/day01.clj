(ns christmas.day01
	(:require [christmas.tools :as tools])
	(:require [clojure.string :as str]))

(defn parse-file[file]
	(->> (str/split-lines file)
		 (map tools/parse-int)
		 ))

(defn energy-module[value]
	(-> (/ value 3)
		Math/floor
		(- 2)))

(defn total-fuel[values]
	(->> (map energy-module values)
		 (apply +)
		 int))

(defn total-per-module [value]
	(->> (iterate energy-module  value)
		 (take-while pos?)
		 rest
		 (apply +)))

(defn total-all[values]
	(->> (map total-per-module values)
		 (apply +)
		 int))