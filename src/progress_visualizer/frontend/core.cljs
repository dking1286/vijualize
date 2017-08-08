(ns progress-visualizer.frontend.core
  (:require [lib.c3 :as c3]))

(enable-console-print!)

(c3/generate {"bindto" "#app"
              "data" {"columns" [['data1', 30, 200, 100, 400, 150, 250]
                                 ['data2', 50, 20, 10, 40, 15, 25]]}})
