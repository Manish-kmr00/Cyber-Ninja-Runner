package com.bytedance.adsdk.pA.Og.ZZv;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public enum pA implements ML {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, pA> ZZv = new HashMap(128);

    static {
        for (pA pAVar : values()) {
            ZZv.put(pAVar.name().toLowerCase(), pAVar);
        }
    }

    public static pA pA(String str) {
        return ZZv.get(str.toLowerCase());
    }
}
