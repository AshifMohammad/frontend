(ns frontend.components.common
  (:require [cljs.core.async :as async :refer [>! <! alts! chan sliding-buffer put! close!]]))

;; XXX flashes
(defn flashes []
  "")

(def spinner
  [:svg {:viewBox "0 0 100 100"
         :spinner ""
         :dangerouslySetInnerHTML
         (clj->js
          {"__html" "<path fill=\"#fff\" d=\"M50 0c-23.297 0-42.873 15.936-48.424 37.5-.049.191-.083.389-.083.595 0 1.315 1.066 2.381 2.381 2.381h20.16c.96 0 1.783-.572 2.159-1.391l.041-.083c4.157-8.968 13.231-15.192 23.766-15.192 14.465 0 26.19 11.726 26.19 26.19 0 14.465-11.726 26.191-26.19 26.191-10.535 0-19.609-6.225-23.766-15.191l-.041-.084c-.376-.82-1.199-1.393-2.16-1.393h-20.159c-1.315 0-2.381 1.066-2.381 2.381 0 .207.035.406.083.596 5.551 21.564 25.127 37.5 48.424 37.5 27.614 0 50-22.385 50-50 0-27.614-22.386-50-50-50z\">
                         <animateTransform attributeName=\"transform\" begin=\"0ms\" dur=\"600ms\" fill=\"freeze\" type=\"rotate\" repeatDur=\"indefinite\" values=\"0 50 50;359 50 50\" keyTimes=\"0;1\" calcMode=\"spline\" keySplines=\"0.42 0 0.58 1\"></animateTransform>
                       </path>
                       <circle fill=\"#fff\" cx=\"50\" cy=\"50\" r=\"11.905\"></circle>"})}])

(defn contact-us-inner [controls-ch]
  [:a {:on-click #(put! controls-ch [:intercom-dialog-raised])}
   " contact us "])

(defn messages [messages]
  [:div.row-fluid
   (when (pos? (count messages))
     [:div#build-messages.offset1.span10
      (map (fn [message]
             [:div.alert.alert-info
              [:strong "Warning: "]
              [:span {:dangerouslySetInnerHTML #js {"__html" (:message message)}}]])
           messages)])])
