package io.bidmachine;

import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
public class NetworkAdUnit {
    private final AdsFormat adsFormat;
    private final String id = UUID.randomUUID().toString();
    private final Map<String, String> mediationConfig;
    private final NetworkAdapter networkAdapter;

    public NetworkAdUnit(NetworkAdapter networkAdapter, AdsFormat adsFormat, Map<String, String> map) {
        this.networkAdapter = networkAdapter;
        this.adsFormat = adsFormat;
        this.mediationConfig = map;
    }

    public String getId() {
        return this.id;
    }

    public NetworkAdapter getNetworkAdapter() {
        return this.networkAdapter;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public Map<String, String> getMediationConfig() {
        return this.mediationConfig;
    }

    public String getNetworkKey() {
        return this.networkAdapter.getKey();
    }

    public String getMediationParameter(String str) {
        return this.mediationConfig.get(str);
    }

    void onWinAuction() throws Throwable {
        getNetworkAdapter().onWinAuction(this);
    }

    void onLossAuction() throws Throwable {
        getNetworkAdapter().onLossAuction(this);
    }

    void clearAuction() throws Throwable {
        getNetworkAdapter().clearAuction(this);
    }
}
