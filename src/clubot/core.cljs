(ns clubot.core
  (:require [cljs.nodejs :as nodejs]))


(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(nodejs/enable-util-print!)

(def -main (fn [] nil))

(set! *main-cli-fn* -main)
