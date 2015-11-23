(defproject clubot "0.1.0-SNAPSHOT"
  :description "An robot."
  :url "http://github.com/threeve/clubot"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.clojure/core.async "0.2.374"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]
            [lein-npm "0.6.1"]]

  :npm {:dependencies [[source-map-support "0.3.2"]
                       [ws "0.8.0"]]}
  
  :source-paths ["src"]

  :clean-targets ^{:protect false} ["build" "target"]

  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [figwheel-sidecar "0.5.0-1"]]
                   :source-paths ["src"] }
             :repl {:dependencies [[org.clojure/tools.nrepl "0.2.12"]]
                    :plugins [[cider/cider-nrepl "0.10.0-SNAPSHOT"]
                              [refactor-nrepl "2.0.0-SNAPSHOT"]] }}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "clubot.core/on-js-reload"}
                :compiler {:main clubot.core
                           :optimizations :none
                           :output-dir "build"
                           :output-to "build/clubot.js"
                           :source-map true
                           :source-map-timestamp true
                           :target :nodejs}}

               {:id "min"
                :source-paths ["src"]
                :compiler {:main clubot.core
                           :output-dir "build"
                           :output-to "build/clubot.js"
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {})
