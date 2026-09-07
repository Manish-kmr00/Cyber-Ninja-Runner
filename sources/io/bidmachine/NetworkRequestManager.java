package io.bidmachine;

import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.utils.BMError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
class NetworkRequestManager {
    private static volatile NetworkRequestManager instance;
    private final Object lock = new Object();
    final Map<String, NetworkRequest<?, Response, BMError>> networkRequestMap = new HashMap();

    NetworkRequestManager() {
    }

    public static NetworkRequestManager get() {
        NetworkRequestManager networkRequestManager = instance;
        if (networkRequestManager == null) {
            synchronized (NetworkRequestManager.class) {
                networkRequestManager = instance;
                if (networkRequestManager == null) {
                    networkRequestManager = new NetworkRequestManager();
                    instance = networkRequestManager;
                }
            }
        }
        return networkRequestManager;
    }

    public boolean contains(String str) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.networkRequestMap.containsKey(str);
        }
        return zContainsKey;
    }

    public void add(String str, NetworkRequest<?, Response, BMError> networkRequest) {
        synchronized (this.lock) {
            this.networkRequestMap.put(str, networkRequest);
        }
    }

    public NetworkRequest<?, Response, BMError> remove(String str) {
        NetworkRequest<?, Response, BMError> networkRequestRemove;
        synchronized (this.lock) {
            networkRequestRemove = this.networkRequestMap.remove(str);
        }
        return networkRequestRemove;
    }
}
