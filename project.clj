(defproject medcircle-progress-visualizer "0.1.0-SNAPSHOT"
  :description "A little app to provide an ongoing view of medcircle's progress"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [org.clojure/core.async "0.3.443"]
                 [cljs-http "0.1.43"]]

  :profiles
  {:dev {:dependencies [[figwheel-sidecar "0.5.4-6"]
                        [com.cemerick/piggieback "0.2.2"]
                        [org.clojure/tools.nrepl "0.2.10"]
                        [proto-repl "0.3.1"]]
         :repl-options  {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :aliases {"figwheel" ["run" "-m" "clojure.main" "script/figwheel.clj"]})
