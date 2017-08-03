(ns progress-visualizer.backend.core
  (:require [clojure.core.async :refer [go <!!]]
            [network.core :refer [get]]))

(defn handler
  [req]
  (let [response (<!! (get "https://jsonplaceholder.typicode.com/posts/1"))]
    {:status (:status response)
     :body (str "This is the body: " (:body response))}))
