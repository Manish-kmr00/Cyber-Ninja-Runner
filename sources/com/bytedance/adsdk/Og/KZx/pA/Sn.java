package com.bytedance.adsdk.Og.KZx.pA;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
abstract class Sn<V, O> implements Wx<V, O> {
    final List<com.bytedance.adsdk.Og.SD.pA<V>> pA;

    Sn(List<com.bytedance.adsdk.Og.SD.pA<V>> list) {
        this.pA = list;
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public List<com.bytedance.adsdk.Og.SD.pA<V>> KZx() {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public boolean Og() {
        return this.pA.isEmpty() || (this.pA.size() == 1 && this.pA.get(0).ML());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.pA.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.pA.toArray()));
        }
        return sb.toString();
    }
}
