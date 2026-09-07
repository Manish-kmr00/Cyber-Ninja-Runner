package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes8.dex */
public class KZx implements pA.InterfaceC0167pA {
    private final pA<Float, Float> JG;
    private final pA<Float, Float> KZx;
    private final pA<Float, Float> ML;
    private final pA<Integer, Integer> Og;
    private boolean SD = true;
    private final pA<Float, Float> ZZv;
    private final pA.InterfaceC0167pA pA;

    public KZx(pA.InterfaceC0167pA interfaceC0167pA, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.ML.SGo sGo) {
        this.pA = interfaceC0167pA;
        pA<Integer, Integer> pAVarPA = sGo.pA().pA();
        this.Og = pAVarPA;
        pAVarPA.pA(this);
        pAVar.pA(pAVarPA);
        pA<Float, Float> pAVarPA2 = sGo.Og().pA();
        this.KZx = pAVarPA2;
        pAVarPA2.pA(this);
        pAVar.pA(pAVarPA2);
        pA<Float, Float> pAVarPA3 = sGo.KZx().pA();
        this.ZZv = pAVarPA3;
        pAVarPA3.pA(this);
        pAVar.pA(pAVarPA3);
        pA<Float, Float> pAVarPA4 = sGo.ZZv().pA();
        this.ML = pAVarPA4;
        pAVarPA4.pA(this);
        pAVar.pA(pAVarPA4);
        pA<Float, Float> pAVarPA5 = sGo.ML().pA();
        this.JG = pAVarPA5;
        pAVarPA5.pA(this);
        pAVar.pA(pAVarPA5);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.SD = true;
        this.pA.pA();
    }

    public void pA(Paint paint) {
        if (this.SD) {
            this.SD = false;
            double dFloatValue = ((double) this.ZZv.SD().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.ML.SD().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.Og.SD().intValue();
            paint.setShadowLayer(this.JG.SD().floatValue(), fSin, fCos, Color.argb(Math.round(this.KZx.SD().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
