package com.bytedance.sdk.openadsdk.multipro.ZZv;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.safedk.android.analytics.brandsafety.l;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
class Og {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> pA;

    public static SharedPreferences pA(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(pA(str), 0);
        } catch (Throwable th) {
            WV.pA("SPMultiHelperImpl", "getSharedPreferences error ", th.getMessage());
            return null;
        }
    }

    private static String pA(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object pA(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pA;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(pA(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void pA(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pA;
        if (softReference == null || softReference.get() == null) {
            pA = new SoftReference<>(new ConcurrentHashMap());
        }
        String strPA = pA(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = pA.get();
        if (concurrentHashMap.get(strPA) == null) {
            concurrentHashMap.put(strPA, new HashMap());
        }
        concurrentHashMap.get(strPA).put(str2, obj);
    }

    private static void Og(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pA;
        if (softReference == null || softReference.get() == null || (map = pA.get().get(pA(str))) == null) {
            return;
        }
        map.clear();
    }

    static synchronized <T> void pA(Context context, String str, String str2, T t) {
        String strPA = pA.pA(str, str2);
        if (Bzk.SD(strPA)) {
            com.bytedance.sdk.component.Og ogPA = com.bytedance.sdk.component.Og.pA(context, strPA);
            if (t.equals(pA(strPA, str2))) {
                return;
            }
            com.bytedance.sdk.component.Og.KZx kZxOg = ogPA.Og();
            pA(kZxOg, str2, (Object) t);
            kZxOg.apply();
            pA(strPA, str2, t);
            return;
        }
        SharedPreferences sharedPreferencesPA = pA(context, strPA);
        if (sharedPreferencesPA == null) {
            return;
        }
        if (t.equals(pA(strPA, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesPA.edit();
        pA(editorEdit, str2, t);
        editorEdit.apply();
        pA(strPA, str2, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void pA(SharedPreferences.Editor editor, String str, T t) {
        if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editor.putString(str, (String) t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void pA(com.bytedance.sdk.component.Og.KZx kZx, String str, T t) {
        if (t instanceof Integer) {
            kZx.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            kZx.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            kZx.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            kZx.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            kZx.putString(str, (String) t);
        }
    }

    static String pA(Context context, String str, String str2, String str3) {
        Object objPA = pA(str, str2);
        if (objPA != null) {
            return String.valueOf(objPA);
        }
        Object objOg = Og(context, str, str2, str3);
        pA(str, str2, objOg);
        return String.valueOf(objOg);
    }

    private static Object Og(Context context, String str, String str2, String str3) {
        String strPA = pA(str);
        if (!pA(context, strPA, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return pA.pA(context, strPA, str2, (String) null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(pA.pA(context, strPA, str2, false));
        }
        if (str3.equalsIgnoreCase(l.w)) {
            return Integer.valueOf(pA.pA(context, strPA, str2, 0));
        }
        if (str3.equalsIgnoreCase(Constants.LONG)) {
            return Long.valueOf(pA.pA(context, strPA, str2, 0L));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(pA.pA(context, strPA, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return pA.pA(context, strPA, str2, (String) null);
        }
        return null;
    }

    static boolean pA(Context context, String str, String str2) {
        String strPA = pA.pA(str, str2);
        if (Bzk.SD(strPA)) {
            return com.bytedance.sdk.component.Og.pA(context, strPA).pA(str2);
        }
        SharedPreferences sharedPreferencesPA = pA(context, strPA);
        return sharedPreferencesPA != null && sharedPreferencesPA.contains(str2);
    }

    public static void Og(Context context, String str, String str2) {
        try {
            String strPA = pA.pA(str, str2);
            if (Bzk.SD(strPA)) {
                com.bytedance.sdk.component.Og.pA(context, strPA).Og().remove(str2).apply();
                return;
            }
            SharedPreferences sharedPreferencesPA = pA(context, strPA);
            if (sharedPreferencesPA == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesPA.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pA;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = pA.get().get(pA(strPA));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    static void Og(Context context, String str) {
        if (Bzk.SD(str)) {
            com.bytedance.sdk.component.Og.pA(context, str).Og().clear().apply();
            Og(str);
            return;
        }
        SharedPreferences sharedPreferencesPA = pA(context, str);
        if (sharedPreferencesPA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesPA.edit();
        editorEdit.clear();
        editorEdit.apply();
        Og(str);
    }

    static Map<String, ?> KZx(Context context, String str) {
        SharedPreferences sharedPreferencesPA = pA(context, str);
        if (sharedPreferencesPA == null) {
            return null;
        }
        return sharedPreferencesPA.getAll();
    }
}
