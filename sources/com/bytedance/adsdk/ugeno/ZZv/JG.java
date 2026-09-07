package com.bytedance.adsdk.ugeno.ZZv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class JG {
    private static Map<String, KZx> pA = new HashMap();

    public static void pA(List<KZx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (KZx kZx : list) {
            if (kZx != null) {
                pA.put(kZx.pA(), kZx);
            }
        }
    }

    public static KZx pA(String str) {
        return pA.get(str);
    }
}
