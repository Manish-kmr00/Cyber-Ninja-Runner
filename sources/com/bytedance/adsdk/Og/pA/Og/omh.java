package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class omh {
    private final List<com.bytedance.adsdk.Og.KZx.Og.omh> KZx;
    private final List<pA<Integer, Integer>> Og;
    private final List<pA<com.bytedance.adsdk.Og.KZx.Og.Sn, Path>> pA;

    public omh(List<com.bytedance.adsdk.Og.KZx.Og.omh> list) {
        this.KZx = list;
        this.pA = new ArrayList(list.size());
        this.Og = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.pA.add(list.get(i).Og().pA());
            this.Og.add(list.get(i).KZx().pA());
        }
    }

    public List<com.bytedance.adsdk.Og.KZx.Og.omh> pA() {
        return this.KZx;
    }

    public List<pA<com.bytedance.adsdk.Og.KZx.Og.Sn, Path>> Og() {
        return this.pA;
    }

    public List<pA<Integer, Integer>> KZx() {
        return this.Og;
    }
}
