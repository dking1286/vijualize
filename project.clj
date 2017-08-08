(defproject vijualize "0.1.0-SNAPSHOT"
  :description "A little app to provide an ongoing view of a company's progress"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [org.clojure/core.async "0.3.443"]
                 [environ "1.1.0"]
                 [ring/ring-core "1.6.2"]
                 [ring/ring-jetty-adapter "1.6.2"]
                 [ring/ring-defaults "0.3.1"]
                 [compojure "1.6.0"]
                 [clj-http "3.6.1"]
                 [cljs-http "0.1.43"]
                 [cljsjs/c3 "0.4.14-0"]
                 [com.cemerick/piggieback "0.2.2"]]

  :plugins [[lein-ring "0.12.0"]
            [lein-figwheel "0.5.12"]
            [lein-environ "1.1.0"]]

  :profiles
  {:dev
   {:dependencies [[figwheel-sidecar "0.5.4-6"]
                   [org.clojure/tools.nrepl "0.2.10"]
                   [proto-repl "0.3.1"]]
    :repl-options
    {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :ring
  {:handler backend.core/handler
   :port 3000
   :auto-refresh? true
   :nrepl
   {:start? true
    :host "localhost"
    :port 3001}}

  :cljsbuild
  {:builds
   [{:id "dev"
     :figwheel true
     :source-paths ["src"]
     :compiler
     {:main "frontend.core"
      :asset-path "js"
      :output-to "resources/public/js/main.js"
      :output-dir "resources/public/js"
      :verbose true}}]}

  :figwheel
  {:server-port 3005
   :nrepl-port 3006
   :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
   :css-dirs ["resources/public/css"]})
