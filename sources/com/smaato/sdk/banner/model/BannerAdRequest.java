package com.smaato.sdk.banner.model;

import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;

/* JADX INFO: loaded from: classes13.dex */
public class BannerAdRequest extends SomaAdRequest {
    private final BannerAdSize bannerAdSize;

    public BannerAdRequest(AdRequest adRequest, BannerAdSize bannerAdSize) {
        super(adRequest);
        this.bannerAdSize = bannerAdSize;
    }

    public BannerAdSize getBannerAdSize() {
        return this.bannerAdSize;
    }
}
