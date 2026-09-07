package com.amazon.aps.ads.model;

/* JADX INFO: loaded from: classes14.dex */
public enum ApsAdNetwork {
    GOOGLE_AD_MANAGER(ApsAdNetworkType.ADSERVER),
    ADMOB(ApsAdNetworkType.MEDIATION),
    AD_GENERATION(ApsAdNetworkType.ADSERVER),
    UNITY_LEVELPLAY(ApsAdNetworkType.MEDIATION),
    MAX(ApsAdNetworkType.MEDIATION),
    NIMBUS(ApsAdNetworkType.ADSERVER),
    OTHER(ApsAdNetworkType.OTHER),
    CUSTOM_MEDIATION(ApsAdNetworkType.MEDIATION);

    ApsAdNetworkType networkType;

    ApsAdNetwork(ApsAdNetworkType apsAdNetworkType) {
        this.networkType = apsAdNetworkType;
    }

    protected boolean isMediation() {
        return this.networkType.equals(ApsAdNetworkType.MEDIATION);
    }
}
