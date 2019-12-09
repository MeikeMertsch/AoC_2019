(ns christmas.day09
  (:require [clojure.string :as str]
            [christmas.tools :as tools]))

(defn parse [file]
  (->> (re-seq #"-?\d+" file)
       (map bigint)
       (zipmap (range))))

(defn get-value [program position mode relative]
  (case mode
    0 (get program (get program position) 0)
    1 (get program position 0)
    2 (get program (+ (get program position 0) relative))))

(defn do-thing [{:keys [program position relative] :as game} {:keys [mode1 mode2 mode3]} funct]
  (let [pos1 (get-value program (inc position) mode1 relative)
        pos2 (get-value program (+ 2 position) mode2 relative)
        posr (+ (get program (+ 3 position)) (if (= 2 mode3) relative 0))]
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

(defn input [{:keys [position input program relative] :as game} {:keys [mode1]}]
  (let [pos (case mode1
              0 (get program (inc position))
              2 (+ relative (get program (inc position))))]
    (-> (update-in game [:program pos] (constantly input))
        (update :position (partial + 2)))))

(defn output [{:keys [program position relative] :as game} {:keys [mode1]}]
  (let [value (case mode1
                0 (get program (get program (inc position)) 0)
                1 (get program (inc position) 0)
                2 (get program (+ relative (get program (inc position)))))]
    (-> (update game :output #(concat % [value]))
        (update :position (partial + 2)))))

(defn jump [{:keys [program position relative] :as game} {:keys [mode1 mode2]} funct]
  (if (funct (get-value program (inc position) mode1 relative))
    (assoc game :position (get-value program (+ 2 position) mode2 relative))
    (update game :position (partial + 3))))

(defn compare_ [{:keys [program position relative] :as game} {:keys [mode1 mode2 mode3]} funct]
  (let [nr1 (get-value program (inc position) mode1 relative)
        nr2 (get-value program (+ 2 position) mode2 relative)
        nr3 (+ (get program (+ 3 position)) (if (= 2 mode3) relative 0))]
    (-> (if (funct nr1 nr2) 1 0)
        (#(update-in game [:program nr3] (constantly %)))
        (update :position (partial + 4)))))

(defn move-relative [{:keys [program position relative] :as game} {:keys [mode1]}]
  (-> (get-value program (inc position) mode1 relative)
      (#(update game :relative (partial + %)))
      (update :position (partial + 2))))

(defn tick [{:keys [position program] :as game}]
  (let [instruction (decrypt-instr (get program position))]
    (-> (case (:optcode instruction)
          1 (do-thing game instruction +)
          2 (do-thing game instruction *)
          3 (input game instruction)
          4 (output game instruction)
          5 (jump game instruction (partial not= 0))
          6 (jump game instruction zero?)
          7 (compare_ game instruction <)
          8 (compare_ game instruction =)
          9 (move-relative game instruction)
          99 (do-end game)))))

(defn traverse [input program]
  (->> {:program program :position 0 :continue true :output [] :input (bigint input) :relative 0}
       (iterate tick)
       (take-while :continue)
       last
       :output
       first))

(defn program1209 [file input]
  (->> (parse file)
       (traverse input)))
