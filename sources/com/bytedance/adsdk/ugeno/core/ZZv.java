package com.bytedance.adsdk.ugeno.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv {
    private static Map<String, Og> pA = new HashMap();

    public static void pA(List<Og> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Og og : list) {
            if (og != null) {
                pA.put(og.pA(), og);
            }
        }
    }

    public static Og pA(String str) {
        return pA.get(str);
    }
}
