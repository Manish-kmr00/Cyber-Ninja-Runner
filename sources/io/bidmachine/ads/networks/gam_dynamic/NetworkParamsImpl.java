package io.bidmachine.ads.networks.gam_dynamic;

/* JADX INFO: loaded from: classes8.dex */
public abstract class NetworkParamsImpl implements NetworkParams {
    private final String networkKey;
    private final String networkName;

    public NetworkParamsImpl(String str, String str2) {
        this.networkKey = str;
        this.networkName = str2;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.NetworkParams
    public String getNetworkKey() {
        return this.networkKey;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.NetworkParams
    public String getNetworkName() {
        return this.networkName;
    }
}
