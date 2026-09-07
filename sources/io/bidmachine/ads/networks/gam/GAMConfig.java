package io.bidmachine.ads.networks.gam;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GAMConfig extends NetworkConfig {
    static final String KEY_AD_UNIT_ID = "ad_unit_id";
    static final String KEY_EXPIRATION_TIME_SEC = "expiration_time";
    static final String KEY_OVERRIDE_CALLBACKS = "override_callbacks";
    static final String KEY_PRICE = "price";
    static final String KEY_REQUEST_AGENT = "request_agent";
    static final String KEY_SCORE = "score";
    static final String KEY_SUPPORTED_VERSIONS_RANGE = "supported_versions_range";
    static final String KEY_WATERFALL_CONFIGURATIONS = "waterfall_configurations";

    public GAMConfig(Map<String, String> map) {
        super(BuildConfig.ADAPTER_NAME, map);
    }

    public GAMConfig(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new GAMAdapter();
    }
}
