package com.smaato.sdk.interstitial;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class InterstitialRequestError {
    private final String adSpaceId;
    private final InterstitialError interstitialError;
    private final String publisherId;

    public InterstitialRequestError(InterstitialError interstitialError, String str, String str2) {
        this.interstitialError = (InterstitialError) Objects.requireNonNull(interstitialError);
        this.publisherId = str;
        this.adSpaceId = str2;
    }

    public String getPublisherId() {
        return this.publisherId;
    }

    public String getAdSpaceId() {
        return this.adSpaceId;
    }

    public InterstitialError getInterstitialError() {
        return this.interstitialError;
    }
}
