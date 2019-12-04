(ns christmas.day04
	(:require [clojure.string :as str]
              [christmas.tools :as tools]))

(defn to-array [number]
  (->> (str number)
       (map str)
       (map tools/parse-int)))

(defn has-double [number]
  (->> (partition 2 1 number)
       (some (partial apply =))))

(defn has-one-double [number]
  (->> (partition-by identity number)
       (some #(= 2 (count %)))))

(defn is-increasing [number]
  (apply <= number))

(defn passwords [start end]
  (->> (range start (inc end))
       (map to-array)
       (filter is-increasing)
       (filter has-double)
       count))

(defn passwords2 [start end]
  (->> (range start (inc end))
       (map to-array)
       (filter is-increasing)
       (filter has-one-double)
       count))

