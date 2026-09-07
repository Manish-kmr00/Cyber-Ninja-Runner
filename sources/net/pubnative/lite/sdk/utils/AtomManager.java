package net.pubnative.lite.sdk.utils;

import android.content.Context;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.prefs.HyBidPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class AtomManager {
    static Boolean mIsAtomConfigEnabled;

    public static void setAtomEnabled(Context context, Ad ad) {
        if (context == null || ad == null) {
            return;
        }
        Boolean boolIsAtomEnabled = ad.isAtomEnabled();
        if (boolIsAtomEnabled == null && (boolIsAtomEnabled = mIsAtomConfigEnabled) == null) {
            boolIsAtomEnabled = HyBid.isAtomEnabled();
        }
        new HyBidPreferences(context).setAtomEnabled(boolIsAtomEnabled);
    }

    public static Boolean isAtomEnabled(Context context) {
        return HyBid.isAtomEnabled();
    }

    public static void setAtomSDKConfig(Boolean bool) {
        mIsAtomConfigEnabled = bool;
    }
}
