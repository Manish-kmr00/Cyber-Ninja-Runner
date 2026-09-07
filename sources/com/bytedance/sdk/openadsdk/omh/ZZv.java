package com.bytedance.sdk.openadsdk.omh;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.rB;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ZZv extends pA {
    public static KZx pA;

    public static String pA(com.bytedance.sdk.component.SD.Og.KZx kZx, String str) {
        KZx kZxPA;
        Map map;
        if (!rB.KZx() || (kZxPA = Og.pA("net")) == null || (map = (Map) kZxPA.pA(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                kZx.Og(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
