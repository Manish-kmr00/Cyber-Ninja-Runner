package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.TextUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class WV {
    private static String KZx;
    private static String Og;
    private static boolean ZZv;
    private static String pA;

    private static Context ZZv(Context context) {
        return context == null ? aBv.pA() : context;
    }

    public static String pA(Context context) {
        if (!TextUtils.isEmpty(pA)) {
            return pA;
        }
        JG(context);
        return pA;
    }

    public static String Og(Context context) {
        if (Og == null && !ZZv) {
            synchronized (WV.class) {
                if (!ZZv) {
                    ML(context);
                }
            }
        }
        return Og;
    }

    public static String KZx(Context context) {
        if (TextUtils.isEmpty(KZx) && !ZZv) {
            synchronized (WV.class) {
                if (!ZZv) {
                    ML(context);
                }
            }
        }
        return KZx;
    }

    public static void pA(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(pA)) {
                pA = str;
            }
            pA();
        }
        if (TextUtils.isEmpty(pA)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Bzk.KZx.Og(pA);
        BSW.pA(pA);
    }

    private static void ML(Context context) {
        Context contextZZv;
        if (ZZv || (contextZZv = ZZv(context)) == null) {
            return;
        }
        Og = String.valueOf(Build.TIME);
        KZx = KZx.pA(contextZZv).Og(CommonUrlParts.UUID, (String) null);
        ZZv = true;
    }

    private static void JG(Context context) {
        Context contextZZv = ZZv(context);
        if (contextZZv == null) {
            return;
        }
        String strOg = KZx.pA(contextZZv).Og("abcd", (String) null);
        if (TextUtils.isEmpty(strOg)) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
            int iOptInt = jSONObjectJsonObjectInit.optInt("cypher", -1);
            String strOptString = jSONObjectJsonObjectInit.optString("message");
            if (iOptInt == 3) {
                String strKZx = com.bytedance.sdk.component.utils.pA.KZx(strOptString);
                if (TextUtils.isEmpty(strKZx)) {
                    return;
                }
                pA = PangleNetworkBridge.jsonObjectInit(strKZx).optString("abcd");
                pA();
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA() {
        if (TextUtils.isEmpty(pA)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.xy.Og(new com.bytedance.sdk.component.omh.omh("update_did") { // from class: com.bytedance.sdk.openadsdk.core.WV.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", SystemClock.elapsedRealtime());
                    jSONObject.put("abcd", WV.pA);
                    KZx.pA(aBv.pA()).pA("abcd", com.bytedance.sdk.component.utils.pA.pA(jSONObject).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static String Og() {
        try {
            Locale locale = LocaleList.getDefault().get(0);
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String string = locale.toString();
            if (locale.toString().length() >= 5) {
                string = string.substring(0, 5);
            }
            if (Locale.SIMPLIFIED_CHINESE.toString().equals(string)) {
                return "zh";
            }
            return "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
