package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class lT {
    private static final Map<String, lT> pA = new HashMap();
    private SharedPreferences Og;

    public static lT pA(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        Map<String, lT> map = pA;
        lT lTVar = map.get(str);
        if (lTVar != null) {
            return lTVar;
        }
        lT lTVar2 = new lT(str, context);
        map.put(str, lTVar2);
        return lTVar2;
    }

    private lT(String str, Context context) {
        if (context != null) {
            this.Og = context.getSharedPreferences(str, 0);
        }
    }

    public String pA(String str, String str2) {
        try {
            return this.Og.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void pA(String str) {
        try {
            this.Og.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
