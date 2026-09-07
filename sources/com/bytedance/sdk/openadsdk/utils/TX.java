package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.json.b9;

/* JADX INFO: loaded from: classes6.dex */
public class TX {
    private static boolean pA;

    public static void pA() {
        pA = true;
    }

    public static void Og() {
        pA = false;
    }

    public static void pA(String str, String str2, Object... objArr) {
        pA(KZx(str, str2), objArr);
    }

    public static void pA(String str, String str2) {
        if (pA && str2 != null) {
            Log.d(pA(str), str2);
        }
    }

    public static void pA(String str, Object... objArr) {
        if (pA && objArr != null) {
            Log.d(pA(str), pA(objArr));
        }
    }

    public static void Og(String str, String str2, Object... objArr) {
        Og(KZx(str, str2), objArr);
    }

    public static void Og(String str, String str2) {
        if (pA && str2 != null) {
            Log.e(pA(str), str2);
        }
    }

    public static void Og(String str, Object... objArr) {
        if (pA && objArr != null) {
            Log.e(pA(str), pA(objArr));
        }
    }

    private static String pA(String str) {
        return TextUtils.isEmpty("PangleSDK-6508") ? str : pA("[PangleSDK-6508]-[" + str + b9.i.e);
    }

    private static String KZx(String str, String str2) {
        return TextUtils.isEmpty("PangleSDK-6508") ? str : pA(str2 + "]-[" + str);
    }

    private static String pA(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
