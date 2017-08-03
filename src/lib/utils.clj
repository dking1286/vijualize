(in-ns 'lib.core)
(require '[clojure.core.async :refer [chan go <! go-loop]])

(def printer
  (let [input (chan)]
    (go-loop [] (do (println (<! input)) (recur)))
    input))
