package com.bytedance.sdk.openadsdk.oX;

import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Sn;

/* JADX INFO: loaded from: classes7.dex */
class ML implements ZZv {
    private int KZx;
    private int ML;
    private ZZv Og;
    private int ZZv;
    long pA = System.currentTimeMillis();

    public ML(ZZv zZv, int i, int i2, int i3) {
        this.Og = zZv;
        this.KZx = i;
        this.ZZv = i2;
        this.ML = i3;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
        com.bytedance.sdk.openadsdk.oX.Og.pA pAVarGeneratorModel = this.Og.generatorModel();
        pAVarGeneratorModel.pA(BuildConfig.VERSION_NAME);
        pAVarGeneratorModel.pA(this.KZx);
        pAVarGeneratorModel.Og(this.ZZv);
        pAVarGeneratorModel.KZx(this.ML);
        pAVarGeneratorModel.Og(this.pA);
        pAVarGeneratorModel.JG(Bzk.Og().ML());
        pAVarGeneratorModel.ZZv(Sn.ZZv());
        return pAVarGeneratorModel;
    }
}
