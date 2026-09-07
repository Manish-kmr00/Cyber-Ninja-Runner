package io.bidmachine.ads.networks.nast;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;

/* JADX INFO: loaded from: classes8.dex */
public class NastConfig extends NetworkConfig {
    public NastConfig() {
        super(NastAdapter.KEY, null);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new NastAdapter();
    }
}
