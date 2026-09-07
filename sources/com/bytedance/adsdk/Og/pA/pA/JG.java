package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class JG implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, Wx {
    private final com.bytedance.adsdk.Og.KZx.Og.Og JG;
    private final com.bytedance.adsdk.Og.Bzk KZx;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, PointF> ML;
    private final String Og;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, PointF> ZZv;
    private boolean omh;
    private final Path pA = new Path();
    private final Og SD = new Og();

    public JG(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.Og og) {
        this.Og = og.pA();
        this.KZx = bzk;
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA = og.KZx().pA();
        this.ZZv = pAVarPA;
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA2 = og.Og().pA();
        this.ML = pAVarPA2;
        this.JG = og;
        pAVar.pA(pAVarPA);
        pAVar.pA(pAVarPA2);
        pAVarPA.pA(this);
        pAVarPA2.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        Og();
    }

    private void Og() {
        this.omh = false;
        this.KZx.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < list.size(); i++) {
            KZx kZx = list.get(i);
            if (kZx instanceof TX) {
                TX tx = (TX) kZx;
                if (tx.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.SIMULTANEOUSLY) {
                    this.SD.pA(tx);
                    tx.pA(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        if (this.omh) {
            return this.pA;
        }
        this.pA.reset();
        if (this.JG.ML()) {
            this.omh = true;
            return this.pA;
        }
        PointF pointFSD = this.ZZv.SD();
        float f = pointFSD.x / 2.0f;
        float f2 = pointFSD.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.pA.reset();
        if (this.JG.ZZv()) {
            float f5 = -f2;
            this.pA.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.pA.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.pA.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.pA.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.pA.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.pA.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.pA.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.pA.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.pA.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.pA.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFSD2 = this.ML.SD();
        this.pA.offset(pointFSD2.x, pointFSD2.y);
        this.pA.close();
        this.SD.pA(this.pA);
        this.omh = true;
        return this.pA;
    }
}
