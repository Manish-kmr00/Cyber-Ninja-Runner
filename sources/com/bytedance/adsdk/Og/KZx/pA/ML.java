package com.bytedance.adsdk.Og.KZx.pA;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ML implements Wx<PointF, PointF> {
    private final List<com.bytedance.adsdk.Og.SD.pA<PointF>> pA;

    public ML(List<com.bytedance.adsdk.Og.SD.pA<PointF>> list) {
        this.pA = list;
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public List<com.bytedance.adsdk.Og.SD.pA<PointF>> KZx() {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public boolean Og() {
        return this.pA.size() == 1 && this.pA.get(0).ML();
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pA() {
        if (this.pA.get(0).ML()) {
            return new com.bytedance.adsdk.Og.pA.Og.BSW(this.pA);
        }
        return new com.bytedance.adsdk.Og.pA.Og.SGo(this.pA);
    }
}
