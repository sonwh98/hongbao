(ns hongbao.core
  (:require
   [cider.nrepl :refer [cider-nrepl-handler]]
   [clojure.tools.cli :as tools-cli]
   [mount.core :as mount :refer [defstate]]
   [nrepl.server :as nrepl]
   [taoensso.timbre :as log])
  (:import hongbao.Main)
  )

(defstate ^{:on-reload :noop} nrepl-server
  :start  (when-not (or (= (type nrepl-server) mount.core.NotStartedState)
                        (.isRealized nrepl-server))
            (log/info "nrepl server starting...")
            (let [port (or (System/getenv "NREPL_PORT") 7777)
                  nrepl-server (nrepl/start-server :port port :handler cider-nrepl-handler)]
              (log/infof "nrepl server started on port %s" port)
              nrepl-server)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (let [params (tools-cli/cli args)]
    (mount/start-with-args (first params)))
  )

(comment
  hongbao.Main/foo
  )
