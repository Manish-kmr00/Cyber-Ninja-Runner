package com.bytedance.sdk.openadsdk.multipro.KZx;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.JG.pA.JG;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.multipro.ZZv;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes9.dex */
public class pA implements com.bytedance.sdk.openadsdk.multipro.pA {
    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Uri pA(Uri uri, ContentValues contentValues) {
        return null;
    }

    private static JG ZZv() {
        try {
            if (aBv.pA() != null) {
                return com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean pA(String str) {
        if (aBv.pA() == null) {
            return false;
        }
        try {
            JG jgZZv = ZZv();
            if (jgZZv != null) {
                return "true".equals(jgZZv.pA(Uri.parse(ML() + "checkFrequency?rit=" + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Og() {
        if (aBv.pA() == null) {
            return false;
        }
        try {
            JG jgZZv = ZZv();
            if (jgZZv != null) {
                return "true".equals(jgZZv.pA(Uri.parse(ML() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String KZx() {
        if (aBv.pA() == null) {
            return null;
        }
        try {
            JG jgZZv = ZZv();
            if (jgZZv != null) {
                return jgZZv.pA(Uri.parse(ML() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String ML() {
        return ZZv.Og + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA(Uri uri) {
        new StringBuilder("get type uri: ").append(uri);
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.SD.pA.pA().pA(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.SD.pA.pA().Og() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.SD.pA.pA().KZx();
        }
        return null;
    }
}
