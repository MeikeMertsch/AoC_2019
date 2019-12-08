(ns christmas.day08
  (:require [clojure.string :as str]
            [christmas.tools :as tools]))

(defn parse-layers [file [width length]]
  (->> (map (comp tools/parse-int str) file)
       (partition (* width length))))

(defn checksum [file layer-size]
  (let [layers (parse-layers file layer-size)]
    (->> (map #(vector (count (filter (partial = 0) %))
                       (count (filter (partial = 1) %))
                       (count (filter (partial = 2) %))) layers)
         (sort-by first)
         first
         rest
         (apply *))))

(def colours {0 " ", 1 "X" nil "."})

(defn message [file [width _ :as layer-size]]
  (->> (parse-layers file layer-size)
       (apply map vector)
       (map (comp colours first #(drop-while #{2} %)))
       (partition width)
       (tools/draw)))