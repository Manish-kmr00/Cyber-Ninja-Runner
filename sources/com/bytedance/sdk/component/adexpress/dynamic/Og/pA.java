package com.bytedance.sdk.component.adexpress.dynamic.Og;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    public static int pA(SD sd) {
        if (sd == null) {
            return 0;
        }
        String strVgu = sd.Vgu();
        String strWQf = sd.WQf();
        if (TextUtils.isEmpty(strWQf) || TextUtils.isEmpty(strVgu) || !strWQf.equals(Reporting.Key.CREATIVE)) {
            return 0;
        }
        if (strVgu.equals("shake")) {
            return 2;
        }
        if (strVgu.equals("twist")) {
            return 3;
        }
        return strVgu.equals("slide") ? 1 : 0;
    }
}
