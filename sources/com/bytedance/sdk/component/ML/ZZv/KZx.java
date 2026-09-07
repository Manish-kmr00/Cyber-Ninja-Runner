package com.bytedance.sdk.component.ML.ZZv;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class KZx extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        if (TextUtils.isEmpty(kZx.ML())) {
            com.bytedance.sdk.component.ML.WV wvML = kZx.yFO().ML();
            kZx.Og(wvML.pA(kZx));
            kZx.pA(wvML.Og(kZx));
        }
        kZx.pA(new SD());
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "generate_key";
    }
}
