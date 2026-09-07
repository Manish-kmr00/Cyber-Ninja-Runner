package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.x8;

/* JADX INFO: loaded from: classes3.dex */
public class BF {
    public static String pA(Context context) {
        int iPA = com.bytedance.sdk.component.utils.BF.pA(context, 0L);
        if (iPA == 2) {
            return "2g";
        }
        if (iPA == 3) {
            return x8.f4583a;
        }
        if (iPA == 4) {
            return x8.b;
        }
        if (iPA == 5) {
            return "4g";
        }
        if (iPA == 6) {
            return "5g";
        }
        return DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY;
    }
}
