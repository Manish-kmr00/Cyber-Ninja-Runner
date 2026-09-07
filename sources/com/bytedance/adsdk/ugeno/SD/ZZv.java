package com.bytedance.adsdk.ugeno.SD;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes4.dex */
public final class ZZv {
    private static Context KZx;
    private static Resources Og;
    private static String pA;

    public static void pA(String str) {
        pA = str;
    }

    private static String pA(Context context) {
        if (pA == null) {
            pA = context.getPackageName();
        }
        return pA;
    }

    private static int pA(Context context, String str, String str2) {
        if (Og == null) {
            Og = context.getResources();
        }
        return Og.getIdentifier(str, str2, pA(context));
    }

    public static int pA(Context context, String str) {
        return pA(context, str, "drawable");
    }
}
