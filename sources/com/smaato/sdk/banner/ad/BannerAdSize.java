package com.smaato.sdk.banner.ad;

import com.smaato.sdk.core.ad.AdDimension;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public enum BannerAdSize {
    XX_LARGE_320x50(AdDimension.XX_LARGE),
    MEDIUM_RECTANGLE_300x250(AdDimension.MEDIUM_RECTANGLE),
    LEADERBOARD_728x90(AdDimension.LEADERBOARD),
    SKYSCRAPER_120x600(AdDimension.SKYSCRAPER);

    public final AdDimension adDimension;

    BannerAdSize(AdDimension adDimension) {
        this.adDimension = (AdDimension) Objects.requireNonNull(adDimension);
    }
}
