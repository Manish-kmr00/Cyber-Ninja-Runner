package com.smaato.sdk.interstitial.model;

import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialAdRequest extends SomaAdRequest {
    int displayHeightInDp;
    int displayWidthInDp;
    String fullscreenDimension;
    private final boolean isSplash;
    private final boolean richMediaIsRewarded;
    private final String videoType;

    public InterstitialAdRequest(AdRequest adRequest, String str, String str2, int i, int i2, boolean z, boolean z2) {
        super(adRequest);
        this.videoType = str;
        this.fullscreenDimension = str2;
        this.displayWidthInDp = i;
        this.displayHeightInDp = i2;
        this.isSplash = z;
        this.richMediaIsRewarded = z2;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public String getFullscreenDimension() {
        return this.fullscreenDimension;
    }

    public int getDisplayWidthInDp() {
        return this.displayWidthInDp;
    }

    public int getDisplayHeightInDp() {
        return this.displayHeightInDp;
    }

    public boolean getIsSplash() {
        return this.isSplash;
    }

    public boolean getRichMediaIsRewarded() {
        return this.richMediaIsRewarded;
    }
}
