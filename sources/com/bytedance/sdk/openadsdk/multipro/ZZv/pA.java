package com.bytedance.sdk.openadsdk.multipro.ZZv;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.JG;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public class pA {
    public static HashSet<String> pA = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.multipro.ZZv.pA.1
        {
            add("app_id");
            add("global_coppa");
            add("tt_gdpr");
            add("global_ccpa");
            add("keywords");
            add("extra_data");
            add("sdk_app_sha1");
            add(CommonUrlParts.UUID);
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    public static boolean pA() {
        if (aBv.pA() != null) {
            return true;
        }
        WV.Og("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static JG Og() {
        try {
            if (pA()) {
                return com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Context KZx() {
        return aBv.pA();
    }

    private static String ZZv() {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.Og + "/t_sp/";
    }

    private static String Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=".concat(String.valueOf(str));
    }

    public static synchronized void pA(String str, String str2, Boolean bool) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.pA(KZx(), str, str2, bool);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    Uri uri = Uri.parse(ZZv() + "boolean/" + str2 + Og(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    jgOg.pA(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void pA(String str, String str2, String str3) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.pA(KZx(), str, str2, str3);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    Uri uri = Uri.parse(ZZv() + "string/" + str2 + Og(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    jgOg.pA(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void pA(String str, String str2, Integer num) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.pA(KZx(), str, str2, num);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    Uri uri = Uri.parse(ZZv() + "int/" + str2 + Og(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    jgOg.pA(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void pA(String str, String str2, Long l) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.pA(KZx(), str, str2, l);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    Uri uri = Uri.parse(ZZv() + "long/" + str2 + Og(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    jgOg.pA(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void pA(String str, String str2, Float f) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.pA(KZx(), str, str2, f);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    Uri uri = Uri.parse(ZZv() + "float/" + str2 + Og(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", f);
                    jgOg.pA(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String Og(String str, String str2, String str3) {
        String strPA;
        if (!pA()) {
            return str3;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                return pA(KZx(), str, str2, str3);
            }
            JG jgOg = Og();
            return (jgOg == null || (strPA = jgOg.pA(Uri.parse(new StringBuilder().append(ZZv()).append("string/").append(str2).append(Og(str)).toString()))) == null || strPA.equals("null")) ? str3 : strPA;
        } catch (Throwable unused) {
        }
    }

    protected static String pA(Context context, String str, String str2, String str3) {
        String strPA = pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2, str3);
        }
        SharedPreferences sharedPreferencesPA = Og.pA(context, strPA);
        return sharedPreferencesPA == null ? str3 : sharedPreferencesPA.getString(str2, str3);
    }

    public static String pA(String str, String str2) {
        return pA.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static int pA(String str, String str2, int i) {
        String strPA;
        if (!pA()) {
            return i;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                return pA(KZx(), str, str2, i);
            }
            JG jgOg = Og();
            if (jgOg != null && (strPA = jgOg.pA(Uri.parse(ZZv() + "int/" + str2 + Og(str)))) != null && !strPA.equals("null")) {
                return Integer.parseInt(strPA);
            }
            return i;
        } catch (Throwable unused) {
        }
    }

    protected static int pA(Context context, String str, String str2, int i) {
        String strPA = pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2, i);
        }
        SharedPreferences sharedPreferencesPA = Og.pA(context, strPA);
        return sharedPreferencesPA == null ? i : sharedPreferencesPA.getInt(str2, i);
    }

    protected static float pA(Context context, String str, String str2, float f) {
        String strPA = pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2, f);
        }
        SharedPreferences sharedPreferencesPA = Og.pA(context, strPA);
        return sharedPreferencesPA == null ? f : sharedPreferencesPA.getFloat(str2, f);
    }

    public static boolean pA(String str, String str2, boolean z) {
        String strPA;
        if (!pA()) {
            return z;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                return pA(KZx(), str, str2, z);
            }
            JG jgOg = Og();
            if (jgOg != null && (strPA = jgOg.pA(Uri.parse(ZZv() + "boolean/" + str2 + Og(str)))) != null && !strPA.equals("null")) {
                return Boolean.parseBoolean(strPA);
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    protected static boolean pA(Context context, String str, String str2, boolean z) {
        String strPA = pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2, z);
        }
        SharedPreferences sharedPreferencesPA = Og.pA(context, strPA);
        return sharedPreferencesPA == null ? z : sharedPreferencesPA.getBoolean(str2, z);
    }

    public static long pA(String str, String str2, long j) {
        String strPA;
        if (!pA()) {
            return j;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                return pA(KZx(), str, str2, j);
            }
            JG jgOg = Og();
            if (jgOg != null && (strPA = jgOg.pA(Uri.parse(ZZv() + "long/" + str2 + Og(str)))) != null && !strPA.equals("null")) {
                return Long.parseLong(strPA);
            }
            return j;
        } catch (Throwable unused) {
        }
    }

    protected static long pA(Context context, String str, String str2, long j) {
        String strPA = pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2, j);
        }
        SharedPreferences sharedPreferencesPA = Og.pA(context, strPA);
        return sharedPreferencesPA == null ? j : sharedPreferencesPA.getLong(str2, j);
    }

    public static void Og(String str, String str2) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.Og(KZx(), str, str2);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    jgOg.pA(Uri.parse(ZZv() + "long/" + str2 + Og(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void pA(String str) {
        if (pA()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    Og.Og(KZx(), str);
                    return;
                }
                JG jgOg = Og();
                if (jgOg != null) {
                    jgOg.pA(Uri.parse(ZZv() + "clean" + Og(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
