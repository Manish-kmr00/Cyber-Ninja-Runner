package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public class SGo {
    public static void pA(String str) {
        pA("any_door_id", str);
    }

    public static String pA() {
        return Og("any_door_id", null);
    }

    private static void pA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA((String) null, str, str2);
        } catch (Throwable unused) {
        }
    }

    private static String Og(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
