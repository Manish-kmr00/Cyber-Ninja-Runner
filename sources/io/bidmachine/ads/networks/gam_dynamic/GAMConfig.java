package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class GAMConfig extends NetworkConfig {
    static final String KEY_AD_UNIT_ID = "ad_unit_id";
    static final String KEY_CONTEXT = "context";
    static final String KEY_PRICE = "price";
    static final String KEY_SUPPORTED_VERSIONS_RANGE = "supported_versions_range";

    public GAMConfig(Map<String, String> map) {
        super(BuildConfig.ADAPTER_NAME, map);
    }

    public GAMConfig(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new GAMAdapter(getNetworkKey());
    }
}
