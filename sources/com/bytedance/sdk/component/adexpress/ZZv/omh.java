package com.bytedance.sdk.component.adexpress.ZZv;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.yFO;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class omh {
    private static boolean pA;

    public static int pA(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float pA(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og();
        }
        return (f * ZZv(context)) + 0.5f;
    }

    public static int Og(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og();
        }
        float fZZv = ZZv(context);
        if (fZZv <= 0.0f) {
            fZZv = 1.0f;
        }
        return (int) ((f / fZZv) + 0.5f);
    }

    public static float KZx(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og();
        }
        return f * ZZv(context);
    }

    private static float ZZv(Context context) {
        try {
            if (pA) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int pA(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int Og(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String KZx(Context context) {
        String language;
        try {
            Locale locale = yFO.Og(context).getConfiguration().getLocales().get(0);
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return pA(language);
    }

    private static String pA(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
