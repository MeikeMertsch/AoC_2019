(ns christmas.day03
  (:require [clojure.string :as str]
            [clojure.set :as sets]
            [christmas.tools :as tools]))

(def directions {"R" [-1 0] "L" [1 0] "U" [0 1] "D" [0 -1]})

(defn parse-entry [entry]
  (->> (re-seq #"R|U|D|L|\d+" entry)
       (#(vector (first %) (tools/parse-int (last %))))))

(defn parse-line [line]
  (->> (str/split line #",")
       (map parse-entry)))
  
(defn parse-file [file]
  (->> (str/split-lines file)
       (map parse-line)))

(defn step [pos number]
  (->> (map * pos [number number])))

(defn walk-entry [prev-route [direction length]]
  (let [pos (last prev-route)
        dir (directions direction)]
    (->> (map (partial step dir) (range 1 (inc length)))
         (map (partial map + pos))
         (concat prev-route))))

(defn walk-line [route]
  (reduce walk-entry [[0 0]] route))


(defn add [x y]
  (+ (Math/abs x) (Math/abs y)))


(defn walk [routes]
  (->> (map walk-line routes)
       (map (partial into #{}))
       (apply sets/intersection)
       (map (partial apply add))
       sort
       rest
       first))

(defn distance-walked [route point]
  (->> (take-while (partial not= point) route)
       count))

(defn walk2 [routes]
  (let [[route1 route2 :as routes] (map walk-line routes)
        intersections (vec (apply sets/intersection (map (partial into #{}) routes)))] 
  (->> (map #(+ (distance-walked route1 %) 
                (distance-walked route2 %)) intersections)
       sort
       rest
       first)))