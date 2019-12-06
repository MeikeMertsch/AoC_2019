(ns christmas.day06
  (:require [clojure.string :as str]))


(defn parse [file]
  (->> (str/split-lines file)
       (map #(str/split % #"\)"))))

(defn find-orbiter [orbits middle]
  (->> (filter #((set middle) (first %)) orbits)
       (map last)))

(defn add-output [{:keys [orbits current output number] :as game} orbiter]
  (->> (assoc-in game [:output orbiter] number)))

(defn tick [{:keys [orbits current output number] :as game}]
  (let [orbiters (find-orbiter orbits current)]
       (-> (reduce add-output game orbiters)
           (assoc :current orbiters)
           (update :number inc))))

(defn game [input]
  (->> {:orbits (parse input) :current ["COM"] :output {} :number 1}
       (iterate tick)
       (drop-while #(not-empty (:current %)))
       first
       :output
       (map last)
       (apply +)))

(defn find-orbiter2 [orbits middle]
  (->> (filter #(or ((set middle) (first %))
                    ((set middle) (last %))) orbits)
       flatten
       (remove (set middle))))


(defn tick2 [{:keys [orbits current output number] :as game}]
  (let [orbiters (find-orbiter2 orbits current)]
    (-> (reduce add-output game orbiters)
        (assoc :current orbiters)
        (update :number inc))))


(defn game2 [input start]
  (->> {:orbits (parse input) :current [start] :output {} :number 1}
       (iterate tick2)
       (drop-while #(nil? ((:output %) "SAN")))
       first
       :output
       (#(% "SAN"))
       (+ -2)))

