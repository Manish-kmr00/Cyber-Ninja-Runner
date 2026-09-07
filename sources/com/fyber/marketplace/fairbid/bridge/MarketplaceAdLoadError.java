package com.fyber.marketplace.fairbid.bridge;

/* JADX INFO: loaded from: classes13.dex */
public enum MarketplaceAdLoadError {
    RESPONSE_VALIDATION_FAILED("Response validation failed"),
    FAILED_TO_PARSE_AD_CONTENT("Failed to parse ad content"),
    FAILED_TO_LOAD_AD("Failed to load the ad "),
    FMP_NOT_READY_TO_LOAD_ADS("FMP Configuration not available or invalid. Ads cannot be loaded"),
    UNSUPPORTED_AD_TYPE("FMP does not know how to load the received creative type");

    private String errorMessage;

    MarketplaceAdLoadError(String str) {
        this.errorMessage = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
