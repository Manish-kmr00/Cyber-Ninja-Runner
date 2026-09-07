package com.bytedance.sdk.openadsdk.XT.pA.pA;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;

/* JADX INFO: loaded from: classes13.dex */
public class SD {
    public static JG pA(Context context, yFO yfo, String str) {
        if (KZx.pA()) {
            return new ML(context, yfo, str);
        }
        if (gbA.omh(context)) {
            return new ZZv(context, yfo, str);
        }
        return new pA(context, yfo, str);
    }
}
