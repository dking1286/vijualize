(ns network.core
  (:require  [clojure.core.async :refer [chan go >!]]
             [clj-http.client :as client]))

(defn get
  [url]
  (let [output (chan)]
    (go (->> (client/get url)
             (>! output)))
    output))
