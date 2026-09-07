package com.bytedance.adsdk.Og.KZx.pA;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Bzk implements Wx<PointF, PointF> {
    private final Og Og;
    private final Og pA;

    public Bzk(Og og, Og og2) {
        this.pA = og;
        this.Og = og2;
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public List<com.bytedance.adsdk.Og.SD.pA<PointF>> KZx() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public boolean Og() {
        return this.pA.Og() && this.Og.Og();
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pA() {
        return new com.bytedance.adsdk.Og.pA.Og.Sn(this.pA.pA(), this.Og.pA());
    }
}
