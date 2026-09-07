package com.bytedance.sdk.component.ML.ZZv;

/* JADX INFO: loaded from: classes9.dex */
public class WV extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        byte[] bArrPA = kZx.yFO().Og(kZx.vZF()).pA(kZx.SGo());
        if (bArrPA == null) {
            kZx.pA(new JG());
        } else {
            kZx.pA(new Og(bArrPA, null));
        }
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "raw_cache";
    }
}
