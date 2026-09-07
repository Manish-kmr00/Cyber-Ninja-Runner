package com.bytedance.sdk.openadsdk.multipro.ZZv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    private static boolean pA() {
        return aBv.pA() == null;
    }

    private static String Og(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void pA(String str, String str2, Boolean bool) {
        if (pA()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA.pA(Og(str), str2, bool);
        } else {
            pA(Og(str), str2, bool);
        }
    }

    public static void pA(String str, String str2, Long l) {
        if (pA()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA.pA(Og(str), str2, l);
        } else {
            pA(Og(str), str2, l);
        }
    }

    public static void pA(String str, String str2, String str3) {
        if (pA()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA.pA(Og(str), str2, str3);
        } else {
            pA(Og(str), str2, str3);
        }
    }

    public static void pA(String str, String str2, Integer num) {
        if (pA()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA.pA(Og(str), str2, num);
        } else {
            pA(Og(str), str2, num);
        }
    }

    public static int pA(String str, String str2, int i) {
        if (pA()) {
            return i;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return pA.pA(Og(str), str2, i);
        }
        return pA.pA(aBv.pA(), Og(str), str2, i);
    }

    public static boolean pA(String str, String str2, boolean z) {
        if (pA()) {
            return z;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return pA.pA(Og(str), str2, z);
        }
        return pA.pA(aBv.pA(), Og(str), str2, z);
    }

    public static long pA(String str, String str2, long j) {
        if (pA()) {
            return j;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return pA.pA(Og(str), str2, j);
        }
        return pA.pA(aBv.pA(), Og(str), str2, j);
    }

    public static String Og(String str, String str2, String str3) {
        if (pA()) {
            return str3;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return pA.Og(Og(str), str2, str3);
        }
        return pA.pA(aBv.pA(), Og(str), str2, str3);
    }

    public static void pA(String str, String str2) {
        if (pA()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                pA.Og(Og(str), str2);
            } else {
                Og.Og(aBv.pA(), Og(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(String str) {
        if (pA()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA.pA(Og(str));
        } else {
            Og.Og(aBv.pA(), Og(str));
        }
    }

    private static <T> void pA(String str, String str2, T t) {
        String strPA = pA.pA(str, str2);
        if (Bzk.SD(strPA)) {
            com.bytedance.sdk.component.Og.KZx kZxOg = com.bytedance.sdk.component.Og.pA(aBv.pA(), Og(strPA)).Og();
            Og.pA(kZxOg, str2, (Object) t);
            kZxOg.apply();
        } else {
            SharedPreferences sharedPreferencesPA = Og.pA(aBv.pA(), Og(strPA));
            if (sharedPreferencesPA == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesPA.edit();
            Og.pA(editorEdit, str2, t);
            editorEdit.apply();
        }
    }
}
