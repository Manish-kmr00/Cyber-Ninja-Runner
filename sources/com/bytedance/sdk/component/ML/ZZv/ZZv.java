package com.bytedance.sdk.component.ML.ZZv;

/* JADX INFO: loaded from: classes14.dex */
public class ZZv extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        com.bytedance.sdk.component.ML.Og ogVZF = kZx.vZF();
        if (ogVZF != null) {
            if (ogVZF.KZx()) {
                kZx.pA(new SGo());
                return;
            } else if (ogVZF.ZZv()) {
                kZx.pA(new JG());
                return;
            }
        }
        kZx.pA(new BSW());
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "cache_policy";
    }
}
