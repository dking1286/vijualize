(defproject medcircle-progress-visualizer "0.1.0-SNAPSHOT"
  :description "A little app to provide an ongoing view of medcircle's progress"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [org.clojure/core.async "0.3.443"]
                 [clj-http "3.6.1"]
                 [cljs-http "0.1.43"]
                 [environ "1.1.0"]
                 [analytij "0.3.3"]
                 [com.cemerick/piggieback "0.2.2"]] ;; WARNING: analytij might be out of date, may need to use Java API instead.

  :plugins [[lein-ring "0.12.0"]
            [lein-figwheel "0.5.12"]
            [lein-environ "1.1.0"]]

  :profiles
  {:dev {:dependencies [[figwheel-sidecar "0.5.4-6"]
                        [org.clojure/tools.nrepl "0.2.10"]
                        [proto-repl "0.3.1"]]
         :repl-options  {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :ring
  {:handler progress-visualizer.backend.core/handler
   :port 3000
   :auto-refresh? true
   :nrepl
   {:start? true
    :host "localhost"
    :port 3001}}

  :cljsbuild
  {:builds [{:id "dev"
             :figwheel true
             :source-paths ["src"]
             :compiler {:main "progress-visualizer.frontend.core"
                        :foreign-libs [{:file "node_modules/d3/build/d3.min.js"
                                        :provides ["d3"]}]
                        :asset-path "js"
                        :output-to "resources/public/js/main.js"
                        :output-dir "resources/public/js"
                        :verbose true}}]}
  :figwheel
  {:server-port 3005
   :nrepl-port 3006
   :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
   :css-dirs ["resources/public/css"]})
