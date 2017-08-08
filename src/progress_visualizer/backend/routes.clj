(ns progress-visualizer.backend.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defn get-analytics
  [req]
  {:status 200
   :headers {"content-type" "application/json"}
   :body (slurp "resources/public/json/analytics.json")})

(defroutes router
  (GET "/analytics" [] get-analytics)
  (route/not-found "Not found"))
