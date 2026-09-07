package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes13.dex */
public interface OnFyberMarketplaceInitializedListener {

    public enum FyberInitStatus {
        SUCCESSFULLY,
        FAILED_NO_KITS_DETECTED,
        FAILED,
        INVALID_APP_ID
    }

    void onFyberMarketplaceInitialized(FyberInitStatus fyberInitStatus);
}
