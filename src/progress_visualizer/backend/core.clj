(ns progress-visualizer.backend.core
  (:require [clojure.core.async :refer [go <!!]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [progress-visualizer.backend.routes :refer [router]]))

(def handler
  (wrap-defaults router api-defaults))

(defn -main
  []
  (run-jetty handler {:port 3000}))
