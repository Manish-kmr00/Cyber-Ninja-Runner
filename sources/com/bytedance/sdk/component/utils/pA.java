package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class pA {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.pA$pA, reason: collision with other inner class name */
    static class C0209pA {
        static final Random pA = pA.KZx();
    }

    public static JSONObject pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return pA(jSONObject.toString());
    }

    public static JSONObject pA(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strOg = Og(str);
                if (!TextUtils.isEmpty(strOg)) {
                    jSONObject.put("message", strOg);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static String Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strPA = pA();
        String strPA2 = pA(strPA, 32);
        String strOg = Og();
        String strPA3 = (strPA2 == null || strOg == null) ? null : com.bytedance.sdk.component.ZZv.pA.pA(str, strOg, strPA2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strPA).append(strOg).append(strPA3);
        return sb.toString();
    }

    public static String KZx(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strPA = pA(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strPA == null) ? str : com.bytedance.sdk.component.ZZv.pA.Og(str.substring(49), strSubstring, strPA);
    }

    public static String pA() {
        String strPA = pA(16);
        if (strPA == null || strPA.length() != 32) {
            return null;
        }
        return strPA;
    }

    public static String pA(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String Og() {
        String strPA = pA(8);
        if (strPA == null || strPA.length() != 16) {
            return null;
        }
        return strPA;
    }

    public static String pA(int i) {
        try {
            byte[] bArr = new byte[i];
            C0209pA.pA.nextBytes(bArr);
            return ML.pA(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random KZx() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
