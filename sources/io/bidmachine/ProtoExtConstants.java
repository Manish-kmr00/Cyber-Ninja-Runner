package io.bidmachine;

/* JADX INFO: loaded from: classes3.dex */
public class ProtoExtConstants {
    public static final String AD_UNIT_ID = "bm_ad_unit_id";
    static final String NETWORK = "network";
    static final String NETWORKS_INFO = "networks_info";
    static final String NETWORK_ADAPTER_VERSION = "network_adapter_version";
    static final String NETWORK_VERSION = "network_version";

    public static final class Source {
        public static final String OMID_PN = "omidpn";
        public static final String OMID_PV = "omidpv";
    }

    static final class Placement {
        static final String BID_CACHE = "bid_cache";
        static final String BID_ID = "bid_id";
        static final String EXP = "exp";
        static final String PRICE = "price";
        static final String REQUEST_ID = "request_id";
        static final String SEAT = "seat";

        Placement() {
        }
    }

    static final class Context {
        Context() {
        }

        static final class App {
            static final String API_LEVEL = "apilevel";
            static final String FIRST_LAUNCH_TIME = "first_launch_time";
            static final String FRAMEWORK = "fmwname";
            static final String INSTALL_TIME = "install_time";
            static final String STORE_CATEGORY = "storecat";
            static final String STORE_SUB_CATEGORY = "storesubcat";

            App() {
            }

            static final class Release {
                static final String TYPE_DEBUG = "debug";
                static final String TYPE_RELEASE = "release";

                Release() {
                }
            }
        }

        static final class User {
            static final String SESSION_DURATION = "sessionduration";

            User() {
            }
        }
    }
}
