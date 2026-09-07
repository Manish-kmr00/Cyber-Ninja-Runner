package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.yandex.div2.PhoneMasks;

/* JADX INFO: loaded from: classes4.dex */
public class Og {
    private static String pA;

    public static String pA() {
        return "open_news";
    }

    public static String Og() {
        return "1371";
    }

    public static String KZx() {
        return BuildConfig.VERSION_NAME;
    }

    public static String ZZv() {
        return gbA.SD();
    }

    public static String ML() {
        return com.bytedance.sdk.openadsdk.core.Bzk.Og().JG();
    }

    public static String JG() {
        return com.bytedance.sdk.component.utils.DX.SD(com.bytedance.sdk.openadsdk.core.aBv.pA());
    }

    public static String pA(Context context) {
        return com.bytedance.sdk.openadsdk.core.WV.pA(context);
    }

    public static String SD() {
        try {
            if (!TextUtils.isEmpty(pA)) {
                return pA;
            }
            String strPA = com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_app_sha1", 259200000L);
            pA = strPA;
            if (pA(strPA)) {
                return pA;
            }
            String strPA2 = com.bytedance.sdk.component.utils.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA());
            pA = strPA2;
            if (pA(strPA2)) {
                String upperCase = pA.toUpperCase();
                pA = upperCase;
                com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_app_sha1", upperCase);
                return pA;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    private static boolean pA(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(":")) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!PhoneMasks.EXTRA_NUMBERS.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
