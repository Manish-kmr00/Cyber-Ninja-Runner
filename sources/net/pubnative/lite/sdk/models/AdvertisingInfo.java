package net.pubnative.lite.sdk.models;

/* JADX INFO: loaded from: classes11.dex */
public class AdvertisingInfo {
    private final String advertisingId;
    private final Boolean limitTrackingEnabled;

    public AdvertisingInfo(String str, Boolean bool) {
        this.advertisingId = str;
        this.limitTrackingEnabled = bool;
    }

    public String getAdvertisingId() {
        return this.advertisingId;
    }

    public Boolean isLimitTrackingEnabled() {
        return this.limitTrackingEnabled;
    }
}
