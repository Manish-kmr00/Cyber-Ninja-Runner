package com.bytedance.sdk.openadsdk.api.banner;

/* JADX INFO: loaded from: classes7.dex */
public final class PAGBannerSize {
    private final int Og;
    private final int pA;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(300, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i, int i2) {
        this.pA = i;
        this.Og = i2;
    }

    public int getWidth() {
        return this.pA;
    }

    public int getHeight() {
        return this.Og;
    }
}
