package com.bytedance.sdk.openadsdk.ZZv.pA;

/* JADX INFO: loaded from: classes13.dex */
class SD implements com.bytedance.sdk.component.JG.pA.ML.KZx {
    private final com.bytedance.sdk.component.SD.Og.Og pA;

    public SD() {
        com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
        this.pA = ogKZx;
        ogKZx.pA(7);
        ogKZx.pA("track_url");
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML.KZx
    public void pA(String str) {
        this.pA.Og(str);
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML.KZx
    public void pA(String str, String str2) {
        this.pA.Og(str, str2);
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML.KZx
    public com.bytedance.sdk.component.JG.pA.ML.ZZv pA() {
        return new Bzk(this.pA.pA());
    }
}
