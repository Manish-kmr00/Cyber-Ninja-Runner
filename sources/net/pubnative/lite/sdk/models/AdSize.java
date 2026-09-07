package net.pubnative.lite.sdk.models;

import com.amazon.device.ads.DtbConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public enum AdSize {
    SIZE_320x50(320, 50, "s"),
    SIZE_300x250(300, 250, "m"),
    SIZE_300x50(300, 50, "s"),
    SIZE_320x480(320, DtbConstants.DEFAULT_PLAYER_HEIGHT, "l"),
    SIZE_1024x768(1024, 768, "l"),
    SIZE_768x1024(768, 1024, "l"),
    SIZE_728x90(728, 90, "s"),
    SIZE_160x600(160, 600, "m"),
    SIZE_250x250(250, 250, "m"),
    SIZE_300x600(300, 600, "l"),
    SIZE_320x100(320, 100, "s"),
    SIZE_480x320(DtbConstants.DEFAULT_PLAYER_HEIGHT, 320, "l"),
    SIZE_INTERSTITIAL(0, 0, "l");

    private final String adLayoutSize;
    private final int height;
    private final int width;

    AdSize(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.adLayoutSize = str;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getAdLayoutSize() {
        return this.adLayoutSize;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format(Locale.ENGLISH, "(%d x %d)", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }
}
