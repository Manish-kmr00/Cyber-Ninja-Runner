package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes11.dex */
public class oX implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, ML, SGo, Wx {
    private final com.bytedance.adsdk.Og.pA.Og.oX Bzk;
    private final boolean JG;
    private final com.bytedance.adsdk.Og.Bzk KZx;
    private final String ML;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> SD;
    private ZZv SGo;
    private final com.bytedance.adsdk.Og.KZx.KZx.pA ZZv;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> omh;
    private final Matrix pA = new Matrix();
    private final Path Og = new Path();

    public oX(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.WV wv) {
        this.KZx = bzk;
        this.ZZv = pAVar;
        this.ML = wv.pA();
        this.JG = wv.ML();
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = wv.Og().pA();
        this.SD = pAVarPA;
        pAVar.pA(pAVarPA);
        pAVarPA.pA(this);
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA2 = wv.KZx().pA();
        this.omh = pAVarPA2;
        pAVar.pA(pAVarPA2);
        pAVarPA2.pA(this);
        com.bytedance.adsdk.Og.pA.Og.oX oXVarSGo = wv.ZZv().SGo();
        this.Bzk = oXVarSGo;
        oXVarSGo.pA(pAVar);
        oXVarSGo.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.SGo
    public void pA(ListIterator<KZx> listIterator) {
        if (this.SGo != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.SGo = new ZZv(this.KZx, this.ZZv, "Repeater", this.JG, arrayList, null);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        this.SGo.pA(list, list2);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        Path pathZZv = this.SGo.ZZv();
        this.Og.reset();
        float fFloatValue = this.SD.SD().floatValue();
        float fFloatValue2 = this.omh.SD().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.pA.set(this.Bzk.Og(i + fFloatValue2));
            this.Og.addPath(pathZZv, this.pA);
        }
        return this.Og;
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.SD.SD().floatValue();
        float fFloatValue2 = this.omh.SD().floatValue();
        float fFloatValue3 = this.Bzk.Og().SD().floatValue() / 100.0f;
        float fFloatValue4 = this.Bzk.KZx().SD().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.pA.set(matrix);
            float f = i2;
            this.pA.preConcat(this.Bzk.Og(f + fFloatValue2));
            this.SGo.pA(canvas, this.pA, (int) (i * com.bytedance.adsdk.Og.JG.ML.pA(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        this.SGo.pA(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.KZx.invalidateSelf();
    }
}
