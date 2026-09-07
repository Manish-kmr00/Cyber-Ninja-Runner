package net.pubnative.lite.sdk.utils;

import android.content.Context;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.prefs.HyBidPreferences;

/* JADX INFO: loaded from: classes12.dex */
public class AdTopicsAPIManager {
    public static void setTopicsAPIEnabled(Context context, Ad ad) {
        if (context == null || ad == null) {
            return;
        }
        Boolean boolIsTopicsAPIEnabled = ad.isTopicsAPIEnabled();
        boolean zBooleanValue = HyBid.isTopicsApiEnabled().booleanValue();
        if (boolIsTopicsAPIEnabled == null || boolIsTopicsAPIEnabled.booleanValue() == zBooleanValue) {
            return;
        }
        new HyBidPreferences(context).setTopicsAPIEnabled(boolIsTopicsAPIEnabled);
        HyBid.setTopicsApiEnabled(boolIsTopicsAPIEnabled);
    }

    public static Boolean isTopicsAPIEnabled(Context context) {
        if (context == null) {
            return null;
        }
        return new HyBidPreferences(context).isTopicsAPIEnabled();
    }
}
