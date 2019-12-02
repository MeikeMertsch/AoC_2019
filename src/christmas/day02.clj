(ns christmas.day02
	(:require [christmas.tools :as tools])
	(:require [clojure.string :as str]))

(defn parse[file]
    (->> (re-seq #"\d+" file)
         (map tools/parse-int)))

(defn do-thing [{:keys [program position] :as game} funct]
    (let [pos1 (get program (get program (inc position)))
          pos2 (get program (get program (+ 2 position)))
          result-pos (get program (+ 3 position))]
        (update-in game [:program result-pos] (constantly (funct pos1 pos2)))))
        
(defn do-end [game]
    (assoc game :continue false))
                    
(defn tick[{:keys [position program] :as game}]
    (let [instruction (get program position)]
        (-> (case instruction
                1 (do-thing game +)
                2 (do-thing game *)
                99 (do-end game))
            (assoc :position (+ 4 position))
        )))

(defn traverse[program]
    (->> {:program program :position 0 :continue true}
         (iterate tick)
         (take-while :continue)
         last
         :program
         first))

(defn program[file [noun verb]]
    (-> (update file 1 (constantly noun))
        (update 2 (constantly verb))
        traverse))

(defn program1202[file]
    (->> (parse file)
         (apply vector)
         (#(program % [12 2]))))

(defn combine[number]
    (map #(vector number %) (range 100)))

(defn pairs[]
    (apply concat (map combine (range 100))))         

(defn thingy[instructions [noun verb :as pair]]
    (vector (program instructions pair) noun verb))
    
(defn program2[file]
    (let [instructions (apply vector (parse file))]
        (->> (map #(thingy instructions %) (pairs))
             (filter #(= 19690720 (first %)))
             first
             rest
             (apply str))))


                 
                 