package io.bidmachine.ads.networks.adaptiverendering;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;

/* JADX INFO: loaded from: classes9.dex */
public class AdaptiveRenderingConfig extends NetworkConfig {
    static final String NATIVE_FEATURES_KEY = "features";

    public AdaptiveRenderingConfig() {
        super(AdaptiveRenderingAdapter.KEY, null);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new AdaptiveRenderingAdapter();
    }
}
