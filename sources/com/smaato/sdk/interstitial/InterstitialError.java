package com.smaato.sdk.interstitial;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public enum InterstitialError {
    NO_AD_AVAILABLE("No ad is currently available matching the requested parameters. Please try again later."),
    INVALID_REQUEST("Invalid ad request (e.g. PublisherId or AdSpaceId is incorrect)."),
    NETWORK_ERROR("The ad request has not been completed due to a network connectivity issue."),
    CACHE_LIMIT_REACHED("Cache is full. Please use the one of previously loaded ADs."),
    INTERNAL_ERROR("An internal error happened (e.g. the ad server responded with an invalid response)."),
    CREATIVE_RESOURCE_EXPIRED("A creative resource's TTL expired."),
    AD_UNLOADED("RichMedia ad requested to be unloaded."),
    SDK_INITIALISATION_ERROR("Smaato SDK is not initialised"),
    AGE_RESTRICTED("Age restricted user.");

    private final String description;

    InterstitialError(String str) {
        this.description = (String) Objects.requireNonNull(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format("[%s]: %s", name(), this.description);
    }
}
