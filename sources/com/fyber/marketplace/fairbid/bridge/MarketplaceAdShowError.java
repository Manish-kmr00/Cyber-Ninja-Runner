package com.fyber.marketplace.fairbid.bridge;

/* JADX INFO: loaded from: classes13.dex */
public enum MarketplaceAdShowError {
    GENERIC_SHOW_ERROR("Generic Error"),
    EXPIRED_AD_ERROR("Expired Ad Error");

    private final String message;

    MarketplaceAdShowError(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }
}
