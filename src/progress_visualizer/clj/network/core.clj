(ns progress-visualizer.clj.network.core
  (:require  [clojure.core.async :refer [chan go >!]]
             [clj-http.client :as client]))

(defn get
  [url]
  (let [output (chan)]
    (go (>! output (client/get url)))
    output))
