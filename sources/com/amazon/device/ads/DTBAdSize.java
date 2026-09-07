package com.amazon.device.ads;

import com.json.b9;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DTBAdSize {
    public static final String AAX_INTERSTITIAL_AD_SIZE = "interstitial";
    private final AdType adType;
    private final int height;
    private JSONObject pubSettings;
    private final String slotUUID;
    private final int width;

    public DTBAdSize(int i, int i2, String str) {
        this(i, i2, AdType.DISPLAY, str, null);
        if (i == 9999 || i2 == 9999) {
            throw new IllegalArgumentException("Invalid size passed, Please use DTBInterstitialAdSize for interstitial ads.");
        }
    }

    protected DTBAdSize(int i, int i2, AdType adType, String str, JSONObject jSONObject) {
        if (i < 0 || i2 < 0 || DtbCommonUtils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Invalid parameter(s) passed to DTBAdSize constructor.");
        }
        this.width = i;
        this.height = i2;
        this.adType = adType;
        this.slotUUID = str;
        this.pubSettings = jSONObject;
    }

    protected DTBAdSize(int i, int i2, AdType adType, String str) {
        this(i, i2, adType, str, null);
        if (i < 0 || i2 < 0 || DtbCommonUtils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Invalid parameter(s) passed to DTBAdSize constructor.");
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isInterstitialAd() {
        return this.adType.equals(AdType.INTERSTITIAL);
    }

    public AdType getDTBAdType() {
        return this.adType;
    }

    public String getSlotUUID() {
        return this.slotUUID;
    }

    public JSONObject getPubSettings() {
        return this.pubSettings;
    }

    public void setPubSettings(JSONObject jSONObject) {
        this.pubSettings = jSONObject;
    }

    public int hashCode() {
        return ((this.height + 31) * 31) + this.width;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DTBAdSize dTBAdSize = (DTBAdSize) obj;
        return this.height == dTBAdSize.height && this.width == dTBAdSize.width;
    }

    public String toString() {
        return "DTBAdSize [" + this.width + VastAttributes.HORIZONTAL_POSITION + this.height + ", adType=" + this.adType + ", slotUUID=" + this.slotUUID + b9.i.e;
    }

    public static final class DTBInterstitialAdSize extends DTBAdSize {
        public DTBInterstitialAdSize(String str) {
            super(9999, 9999, AdType.INTERSTITIAL, str, null);
        }
    }

    public static final class DTBVideo extends DTBAdSize {
        public DTBVideo(int i, int i2, String str) {
            super(i, i2, AdType.VIDEO, str, null);
        }

        public DTBVideo(int i, int i2, String str, JSONObject jSONObject) {
            super(i, i2, AdType.VIDEO, str, jSONObject);
        }
    }
}
