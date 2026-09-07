package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DX implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, Wx {
    private boolean BSW;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, PointF> JG;
    private final String KZx;
    private final com.bytedance.adsdk.Og.Bzk ML;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, PointF> SD;
    private final boolean ZZv;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> omh;
    private final Path pA = new Path();
    private final RectF Og = new RectF();
    private final Og Bzk = new Og();
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> SGo = null;

    public DX(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.BSW bsw) {
        this.KZx = bsw.pA();
        this.ZZv = bsw.ML();
        this.ML = bzk;
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA = bsw.ZZv().pA();
        this.JG = pAVarPA;
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA2 = bsw.KZx().pA();
        this.SD = pAVarPA2;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA3 = bsw.Og().pA();
        this.omh = pAVarPA3;
        pAVar.pA(pAVarPA);
        pAVar.pA(pAVarPA2);
        pAVar.pA(pAVarPA3);
        pAVarPA.pA(this);
        pAVarPA2.pA(this);
        pAVarPA3.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        Og();
    }

    private void Og() {
        this.BSW = false;
        this.ML.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < list.size(); i++) {
            KZx kZx = list.get(i);
            if (kZx instanceof TX) {
                TX tx = (TX) kZx;
                if (tx.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.SIMULTANEOUSLY) {
                    this.Bzk.pA(tx);
                    tx.pA(this);
                } else if (kZx instanceof aBv) {
                    this.SGo = ((aBv) kZx).Og();
                }
            } else if (kZx instanceof aBv) {
                this.SGo = ((aBv) kZx).Og();
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar;
        if (this.BSW) {
            return this.pA;
        }
        this.pA.reset();
        if (this.ZZv) {
            this.BSW = true;
            return this.pA;
        }
        PointF pointFSD = this.SD.SD();
        float f = pointFSD.x / 2.0f;
        float f2 = pointFSD.y / 2.0f;
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar2 = this.omh;
        float fBzk = pAVar2 == null ? 0.0f : ((com.bytedance.adsdk.Og.pA.Og.ZZv) pAVar2).Bzk();
        if (fBzk == 0.0f && (pAVar = this.SGo) != null) {
            fBzk = Math.min(pAVar.SD().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fBzk > fMin) {
            fBzk = fMin;
        }
        PointF pointFSD2 = this.JG.SD();
        this.pA.moveTo(pointFSD2.x + f, (pointFSD2.y - f2) + fBzk);
        this.pA.lineTo(pointFSD2.x + f, (pointFSD2.y + f2) - fBzk);
        if (fBzk > 0.0f) {
            float f3 = fBzk * 2.0f;
            this.Og.set((pointFSD2.x + f) - f3, (pointFSD2.y + f2) - f3, pointFSD2.x + f, pointFSD2.y + f2);
            this.pA.arcTo(this.Og, 0.0f, 90.0f, false);
        }
        this.pA.lineTo((pointFSD2.x - f) + fBzk, pointFSD2.y + f2);
        if (fBzk > 0.0f) {
            float f4 = fBzk * 2.0f;
            this.Og.set(pointFSD2.x - f, (pointFSD2.y + f2) - f4, (pointFSD2.x - f) + f4, pointFSD2.y + f2);
            this.pA.arcTo(this.Og, 90.0f, 90.0f, false);
        }
        this.pA.lineTo(pointFSD2.x - f, (pointFSD2.y - f2) + fBzk);
        if (fBzk > 0.0f) {
            float f5 = fBzk * 2.0f;
            this.Og.set(pointFSD2.x - f, pointFSD2.y - f2, (pointFSD2.x - f) + f5, (pointFSD2.y - f2) + f5);
            this.pA.arcTo(this.Og, 180.0f, 90.0f, false);
        }
        this.pA.lineTo((pointFSD2.x + f) - fBzk, pointFSD2.y - f2);
        if (fBzk > 0.0f) {
            float f6 = fBzk * 2.0f;
            this.Og.set((pointFSD2.x + f) - f6, pointFSD2.y - f2, pointFSD2.x + f, (pointFSD2.y - f2) + f6);
            this.pA.arcTo(this.Og, 270.0f, 90.0f, false);
        }
        this.pA.close();
        this.Bzk.pA(this.pA);
        this.BSW = true;
        return this.pA;
    }
}
