package com.bytedance.sdk.openadsdk.component.omh;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes12.dex */
public class Og extends com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA {
    public Og(Context context, ViewGroup viewGroup, yFO yfo) {
        super(context, viewGroup, yfo, null);
    }

    public void pA(DX.pA pAVar) {
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.SD, pAVar, (SD) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA
    public void XT() {
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh());
        pAVar.Og(JG());
        pAVar.ZZv(SD());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.ML(this.SD, pAVar);
    }
}
