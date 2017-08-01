(require '[figwheel-sidecar.repl :as r]
         '[figwheel-sidecar.repl-api :as ra])

(ra/start-figwheel!
  {:figwheel-options {:server-port 3000
                      :nrepl-port 7002
                      :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
                      :css-dirs ["resources/public/css"]}
   :build-ids ["dev"]
   :all-builds
   [{:id "dev"
     :figwheel true
     :source-paths ["src"]
     :compiler {:main 'medcircle-progress-visualizer.core
                :foreign-libs [{:file "node_modules/d3/build/d3.min.js"
                                :provides ["d3"]}]
                :asset-path "js"
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js"
                :verbose true}}]})

(ra/cljs-repl)
