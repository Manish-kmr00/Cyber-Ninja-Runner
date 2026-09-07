package com.bytedance.adsdk.ugeno.ZZv.Og;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class Og extends pA {
    private List<com.bytedance.adsdk.ugeno.ZZv.pA.ZZv> omh;

    public Og(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
        super(kZx, str, pAVar);
        this.omh = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.Og.pA
    public void pA() {
        com.bytedance.adsdk.ugeno.ZZv.pA.KZx kZxPA;
        if (this.JG == null || this.JG.size() <= 0) {
            return;
        }
        String str = this.JG.get("name");
        com.bytedance.adsdk.ugeno.ZZv.pA.pA pAVarVgu = this.KZx.Vgu();
        if (pAVarVgu == null || (kZxPA = pAVarVgu.pA(str)) == null) {
            return;
        }
        kZxPA.pA(str);
    }
}
