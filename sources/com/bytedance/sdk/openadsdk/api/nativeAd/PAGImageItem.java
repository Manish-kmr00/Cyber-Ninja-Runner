package com.bytedance.sdk.openadsdk.api.nativeAd;

/* JADX INFO: loaded from: classes11.dex */
public class PAGImageItem {
    private final String KZx;
    private final int Og;
    private float ZZv;
    private final int pA;

    public PAGImageItem(int i, int i2, String str, float f) {
        this.pA = i;
        this.Og = i2;
        this.KZx = str;
        this.ZZv = f;
    }

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }

    public int getHeight() {
        return this.pA;
    }

    public int getWidth() {
        return this.Og;
    }

    public String getImageUrl() {
        return this.KZx;
    }

    public float getDuration() {
        return this.ZZv;
    }
}
