(ns lib.c3
  (:require [cljsjs.c3 :as c3]))

(defn generate
  [opts]
  (js/c3.generate (clj->js opts)))
