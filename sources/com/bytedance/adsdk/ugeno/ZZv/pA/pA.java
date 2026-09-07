package com.bytedance.adsdk.ugeno.ZZv.pA;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    private volatile Map<String, KZx> pA = new HashMap();

    public KZx pA(String str) {
        if (this.pA.containsKey(str) && this.pA.get(str) != null) {
            return this.pA.get(str);
        }
        Og og = new Og();
        this.pA.put(str, og);
        return og;
    }

    public void pA(String str, KZx kZx) {
        if (!this.pA.containsKey(str) || this.pA.get(str) == null) {
            this.pA.put(str, kZx);
        }
    }
}
