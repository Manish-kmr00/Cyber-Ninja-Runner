package com.amazon.device.ads;

/* JADX INFO: loaded from: classes7.dex */
public enum DTBAdNetwork {
    GOOGLE_AD_MANAGER(NetworkType.ADSERVER),
    ADMOB(NetworkType.MEDIATION),
    AD_GENERATION(NetworkType.ADSERVER),
    IRON_SOURCE(NetworkType.MEDIATION),
    MAX(NetworkType.MEDIATION),
    NIMBUS(NetworkType.ADSERVER),
    OTHER(NetworkType.OTHER);

    NetworkType networkType;

    DTBAdNetwork(NetworkType networkType) {
        this.networkType = networkType;
    }

    protected boolean isMediation() {
        return this.networkType.equals(NetworkType.MEDIATION);
    }
}
