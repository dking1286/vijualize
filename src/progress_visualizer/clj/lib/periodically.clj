(in-ns 'progress-visualizer.clj.lib.core)
(require '[clojure.core.async :as async :refer [chan go timeout <! >!]])

(defn set-interval
  [interval f]
  (let [output (chan)]
    (go (while true (do (<! (timeout interval)) (>! output (f)))))
    output))

(defmacro with-period
  [period & body]
  `(set-interval ~period (fn [] ~@body)))
