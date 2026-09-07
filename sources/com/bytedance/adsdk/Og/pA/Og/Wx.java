package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Path;
import com.bytedance.adsdk.Og.pA.pA.yFO;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Wx extends pA<com.bytedance.adsdk.Og.KZx.Og.Sn, Path> {
    private List<yFO> JG;
    private final Path ML;
    private final com.bytedance.adsdk.Og.KZx.Og.Sn ZZv;

    public Wx(List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.Sn>> list) {
        super(list);
        this.ZZv = new com.bytedance.adsdk.Og.KZx.Og.Sn();
        this.ML = new Path();
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public Path pA(com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.Sn> pAVar, float f) {
        this.ZZv.pA(pAVar.pA, pAVar.Og, f);
        com.bytedance.adsdk.Og.KZx.Og.Sn snPA = this.ZZv;
        List<yFO> list = this.JG;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                snPA = this.JG.get(size).pA(snPA);
            }
        }
        com.bytedance.adsdk.Og.JG.ML.pA(snPA, this.ML);
        return this.ML;
    }

    public void pA(List<yFO> list) {
        this.JG = list;
    }
}
