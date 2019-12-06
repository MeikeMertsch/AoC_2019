(ns christmas.day05
  (:require [clojure.string :as str]
            [christmas.tools :as tools]))

(defn parse [file]
  (->> (re-seq #"-?\d+" file)
       (map tools/parse-int)
       vec))

(defn get-value [program position mode]
  (case mode
    0 (get program (get program position))
    1 (get program position)))


(defn do-thing [{:keys [program position] :as game} {:keys [mode1 mode2 mode3]} funct]
  (let [pos1 (get-value program (inc position) mode1)
        pos2 (get-value program (+ 2 position) mode2)
        posr (get-value program (+ 3 position) 1)]
    (-> (update-in game [:program posr] (constantly (funct pos1 pos2)))
        (update :position (partial + 4)))))

(defn do-end [game]
  (assoc game :continue false))

(defn decrypt-instr [instruction]
  (let [mode3 (quot instruction 10000)
        after3 (- instruction (* mode3 10000))
        mode2 (quot after3 1000)
        after2 (- after3 (* mode2 1000))
        mode1 (quot after2 100)]
    {:mode3 mode3 :mode2 mode2 :mode1 mode1 :optcode (- after2 (* mode1 100))}))

(defn input [{:keys [position input program] :as game} {:keys [mode1]}]
  (-> (update-in game [:program (get program (inc position))] (constantly input))
      (update :position (partial + 2))))

(defn output [{:keys [program position] :as game} {:keys [mode1]}]
  (-> (update game :output #(assoc % position (get-value program (inc position) mode1)))
      (update :position (partial + 2))))

(defn jump [{:keys [program position] :as game} {:keys [mode1 mode2]} funct]
  (if (funct (get-value program (inc position) mode1))
    (assoc game :position (get-value program (+ 2 position) mode2))
    (update game :position (partial + 3))))

(defn compare_ [{:keys [program position] :as game} {:keys [mode1 mode2 mode3]} funct]
  (let [nr1 (get-value program (inc position) mode1) 
        nr2 (get-value program (+ 2 position) mode2)
        nr3 (get program (+ 3 position))]
  (-> (if (funct nr1 nr2) 1 0)
      (#(update-in game [:program nr3] (constantly %)))
      (update :position (partial + 4)))))

(defn tick [{:keys [position program] :as game}]
  (let [instruction (decrypt-instr (get program position))]
    (doall (println "instructions: " instruction " original: " (get program position)))
    (-> (case (:optcode instruction)
          1 (do-thing game instruction +)
          2 (do-thing game instruction *)
          3 (input game instruction)
          4 (output game instruction)
          5 (jump game instruction (partial not= 0))
          6 (jump game instruction zero?)
          7 (compare_ game instruction <)
          8 (compare_ game instruction =)
          99 (do-end game)))))

(defn traverse [input program]
  (->> {:program program :position 0 :continue true :output {} :input input}
       (iterate tick)
       (take-while :continue)
       last
       :output
       (sort-by first)
       last
       last))

(defn program1205 [file input]
  (->> (parse file)
       (traverse input)))
