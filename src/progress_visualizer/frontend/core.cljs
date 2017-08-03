(ns progress-visualizer.frontend.core
  (:require [d3 :as d3]))

(enable-console-print!)

(def width 960)
(def height 500)

(-> (d3/select "body")
    (.append "div")
    (.text "Hello again!")
    (.style "color" "blue"))
