package com.bytedance.adsdk.Og.pA.pA;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class TX implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, KZx {
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> JG;
    private final List<com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA> KZx = new ArrayList();
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> ML;
    private final boolean Og;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> SD;
    private final com.bytedance.adsdk.Og.KZx.Og.yFO.pA ZZv;
    private final String pA;

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
    }

    public TX(com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.yFO yfo) {
        this.pA = yfo.pA();
        this.Og = yfo.JG();
        this.ZZv = yfo.Og();
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = yfo.ZZv().pA();
        this.ML = pAVarPA;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA2 = yfo.KZx().pA();
        this.JG = pAVarPA2;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA3 = yfo.ML().pA();
        this.SD = pAVarPA3;
        pAVar.pA(pAVarPA);
        pAVar.pA(pAVarPA2);
        pAVar.pA(pAVarPA3);
        pAVarPA.pA(this);
        pAVarPA2.pA(this);
        pAVarPA3.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        for (int i = 0; i < this.KZx.size(); i++) {
            this.KZx.get(i).pA();
        }
    }

    void pA(com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA interfaceC0167pA) {
        this.KZx.add(interfaceC0167pA);
    }

    com.bytedance.adsdk.Og.KZx.Og.yFO.pA Og() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.pA.Og.pA<?, Float> KZx() {
        return this.ML;
    }

    public com.bytedance.adsdk.Og.pA.Og.pA<?, Float> ZZv() {
        return this.JG;
    }

    public com.bytedance.adsdk.Og.pA.Og.pA<?, Float> ML() {
        return this.SD;
    }

    public boolean JG() {
        return this.Og;
    }
}
