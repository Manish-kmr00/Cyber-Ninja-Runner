package com.pubmatic.sdk.common;

import com.amazon.device.ads.DtbConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes4.dex */
public class POBAdSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7548a;
    private int b;
    public static final POBAdSize BANNER_SIZE_320x50 = new POBAdSize(320, 50);
    public static final POBAdSize BANNER_SIZE_320x100 = new POBAdSize(320, 100);
    public static final POBAdSize BANNER_SIZE_300x250 = new POBAdSize(300, 250);
    public static final POBAdSize BANNER_SIZE_300x300 = new POBAdSize(300, 300);
    public static final POBAdSize BANNER_SIZE_250x250 = new POBAdSize(250, 250);
    public static final POBAdSize BANNER_SIZE_468x60 = new POBAdSize(468, 60);
    public static final POBAdSize BANNER_SIZE_728x90 = new POBAdSize(728, 90);
    public static final POBAdSize BANNER_SIZE_120x600 = new POBAdSize(120, 600);
    public static final POBAdSize INTERSTITIAL_320x480 = new POBAdSize(320, DtbConstants.DEFAULT_PLAYER_HEIGHT);
    public static final POBAdSize INTERSTITIAL_480x320 = new POBAdSize(DtbConstants.DEFAULT_PLAYER_HEIGHT, 320);
    public static final POBAdSize INTERSTITIAL_768x1024 = new POBAdSize(768, 1024);
    public static final POBAdSize INTERSTITIAL_1024x768 = new POBAdSize(1024, 768);

    public POBAdSize(int i, int i2) {
        this();
        this.f7548a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof POBAdSize)) {
            return false;
        }
        POBAdSize pOBAdSize = (POBAdSize) obj;
        return this.f7548a == pOBAdSize.f7548a && this.b == pOBAdSize.b;
    }

    public int getAdHeight() {
        return this.b;
    }

    public int getAdWidth() {
        return this.f7548a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isMREC() {
        return equals(BANNER_SIZE_300x250) || equals(BANNER_SIZE_300x300) || equals(BANNER_SIZE_250x250);
    }

    public String toString() {
        return this.f7548a + VastAttributes.HORIZONTAL_POSITION + this.b;
    }

    private POBAdSize() {
    }
}
