package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.json.b9;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv {
    public static String pA(String str) {
        if (!com.bytedance.sdk.component.utils.WV.ZZv() || TextUtils.isEmpty(str)) {
            return str;
        }
        com.bytedance.sdk.openadsdk.core.model.SD sd = new com.bytedance.sdk.openadsdk.core.model.SD(com.bytedance.sdk.openadsdk.core.Bzk.Og().Wx());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = sd.Og().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append(b9.i.c).append(sd.pA());
                } else {
                    sb.append("?").append(sd.pA());
                }
            }
        }
        return sb.toString();
    }
}
