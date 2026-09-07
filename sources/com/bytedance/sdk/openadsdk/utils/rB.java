package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.json.yk;

/* JADX INFO: loaded from: classes13.dex */
public class rB {
    private static String pA;

    public static boolean KZx() {
        return false;
    }

    public static boolean pA() {
        return com.bytedance.sdk.component.utils.WV.ZZv() && com.bytedance.sdk.openadsdk.core.Bzk.Og().aBv() && com.bytedance.sdk.openadsdk.core.Bzk.Og().XT();
    }

    public static String pA(String str) {
        try {
            if (!pA()) {
                return str;
            }
            String strYFO = com.bytedance.sdk.openadsdk.core.Bzk.Og().yFO();
            if (TextUtils.isEmpty(strYFO)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=".concat(String.valueOf(strYFO)));
            return Uri.parse(str).buildUpon().appendQueryParameter(Og(), strYFO).appendQueryParameter(yk.SESSION_HISTORY_KEY_AD_ID, "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String Og() {
        if (TextUtils.isEmpty(pA)) {
            pA = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return pA;
    }
}
