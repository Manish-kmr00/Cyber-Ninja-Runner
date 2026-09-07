package net.pubnative.lite.sdk.vpaid;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerInfo {
    private final String mMessage;
    private boolean mNoAdsFound;

    public PlayerInfo(String str) {
        this.mMessage = TextUtils.isEmpty(str) ? "Unknown error" : str;
    }

    public void setNoAdsFound() {
        this.mNoAdsFound = true;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isNoAdsFound() {
        return this.mNoAdsFound;
    }

    public String toString() {
        return "PlayerInfo{message='" + this.mMessage + "'}";
    }
}
