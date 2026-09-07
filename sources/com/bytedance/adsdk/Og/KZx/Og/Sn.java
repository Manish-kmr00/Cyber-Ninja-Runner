package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class Sn {
    private boolean KZx;
    private PointF Og;
    private final List<com.bytedance.adsdk.Og.KZx.pA> pA;

    public Sn(PointF pointF, boolean z, List<com.bytedance.adsdk.Og.KZx.pA> list) {
        this.Og = pointF;
        this.KZx = z;
        this.pA = new ArrayList(list);
    }

    public Sn() {
        this.pA = new ArrayList();
    }

    public void pA(float f, float f2) {
        if (this.Og == null) {
            this.Og = new PointF();
        }
        this.Og.set(f, f2);
    }

    public PointF pA() {
        return this.Og;
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    public boolean Og() {
        return this.KZx;
    }

    public List<com.bytedance.adsdk.Og.KZx.pA> KZx() {
        return this.pA;
    }

    public void pA(Sn sn, Sn sn2, float f) {
        if (this.Og == null) {
            this.Og = new PointF();
        }
        this.KZx = sn.Og() || sn2.Og();
        if (sn.KZx().size() != sn2.KZx().size()) {
            sn.KZx().size();
            sn2.KZx().size();
        }
        int iMin = Math.min(sn.KZx().size(), sn2.KZx().size());
        if (this.pA.size() < iMin) {
            for (int size = this.pA.size(); size < iMin; size++) {
                this.pA.add(new com.bytedance.adsdk.Og.KZx.pA());
            }
        } else if (this.pA.size() > iMin) {
            for (int size2 = this.pA.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.Og.KZx.pA> list = this.pA;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFPA = sn.pA();
        PointF pointFPA2 = sn2.pA();
        pA(com.bytedance.adsdk.Og.JG.ML.pA(pointFPA.x, pointFPA2.x, f), com.bytedance.adsdk.Og.JG.ML.pA(pointFPA.y, pointFPA2.y, f));
        for (int size3 = this.pA.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.Og.KZx.pA pAVar = sn.KZx().get(size3);
            com.bytedance.adsdk.Og.KZx.pA pAVar2 = sn2.KZx().get(size3);
            PointF pointFPA3 = pAVar.pA();
            PointF pointFOg = pAVar.Og();
            PointF pointFKZx = pAVar.KZx();
            PointF pointFPA4 = pAVar2.pA();
            PointF pointFOg2 = pAVar2.Og();
            PointF pointFKZx2 = pAVar2.KZx();
            this.pA.get(size3).pA(com.bytedance.adsdk.Og.JG.ML.pA(pointFPA3.x, pointFPA4.x, f), com.bytedance.adsdk.Og.JG.ML.pA(pointFPA3.y, pointFPA4.y, f));
            this.pA.get(size3).Og(com.bytedance.adsdk.Og.JG.ML.pA(pointFOg.x, pointFOg2.x, f), com.bytedance.adsdk.Og.JG.ML.pA(pointFOg.y, pointFOg2.y, f));
            this.pA.get(size3).KZx(com.bytedance.adsdk.Og.JG.ML.pA(pointFKZx.x, pointFKZx2.x, f), com.bytedance.adsdk.Og.JG.ML.pA(pointFKZx.y, pointFKZx2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.pA.size() + "closed=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
    }
}
