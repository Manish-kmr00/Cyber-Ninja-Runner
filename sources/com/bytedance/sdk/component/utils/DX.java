package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.x8;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;

/* JADX INFO: loaded from: classes4.dex */
public class DX {
    public static boolean pA(Context context) {
        return KZx(context) != 0;
    }

    public static int Og(Context context) {
        int iKZx = KZx(context);
        if (iKZx == 1) {
            return 0;
        }
        if (iKZx == 4) {
            return 1;
        }
        if (iKZx == 5) {
            return 4;
        }
        if (iKZx != 6) {
            return iKZx;
        }
        return 6;
    }

    public static int KZx(Context context) {
        return BF.pA(context, 60000L);
    }

    public static boolean ZZv(Context context) {
        return KZx(context) == 4;
    }

    public static boolean ML(Context context) {
        return KZx(context) == 5;
    }

    public static boolean JG(Context context) {
        return KZx(context) == 6;
    }

    public static String SD(Context context) {
        int iKZx = KZx(context);
        if (iKZx == 2) {
            return "2g";
        }
        if (iKZx == 3) {
            return x8.f4583a;
        }
        if (iKZx == 4) {
            return x8.b;
        }
        if (iKZx == 5) {
            return "4g";
        }
        if (iKZx == 6) {
            return "5g";
        }
        return DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY;
    }

    public static boolean pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(d.v) || str.startsWith("https://");
    }

    public static boolean omh(Context context) {
        if (context == null) {
            return false;
        }
        int iKZx = KZx(context);
        return iKZx == 2 || iKZx == 3 || iKZx == 4 || iKZx == 5 || iKZx == 6;
    }
}
