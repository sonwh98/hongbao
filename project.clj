(defproject hongbao "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[com.algorand/algosdk "1.22.0"]
                 [org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.cli "1.0.214"]
                 [mount/mount "0.1.17"]
                 [nrepl/nrepl "1.0.0"]
                 [com.taoensso/timbre "6.0.4"]]
  :main ^:skip-aot hongbao.core
  :target-path "target/%s"
  :source-paths ["src/clj"] 
  :java-source-paths ["src/java"]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies [[luposlip/json-schema "0.4.0"]
                                  [org.clj-commons/hickory "0.7.3"]
                                  [pjstadig/humane-test-output "0.11.0"]]
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]
                   :plugins [[com.github.clj-kondo/lein-clj-kondo "0.2.4"]
                             [lein-ancient/lein-ancient "1.0.0-RC3"]
                             [lein-cljfmt/lein-cljfmt "0.9.0"]
                             [lein-shell/lein-shell "0.5.0"]
                             [cider/cider-nrepl "0.29.0"]]
                   :resource-paths ["test/resources"]
                   :test-paths ["test"]}})
