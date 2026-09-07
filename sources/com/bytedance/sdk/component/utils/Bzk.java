package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class Bzk {
    private static Context pA;

    public static void pA(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            pA = context.createConfigurationContext(Og(context, str, str2));
        } catch (Throwable th) {
            WV.Og(th.getMessage());
        }
        yFO.pA(pA);
    }

    private static Configuration Og(Context context, String str, String str2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str, str2));
        return configuration;
    }
}
