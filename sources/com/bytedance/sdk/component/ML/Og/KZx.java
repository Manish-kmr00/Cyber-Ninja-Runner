package com.bytedance.sdk.component.ML.Og;

import com.bytedance.sdk.component.ML.Sn;

/* JADX INFO: loaded from: classes12.dex */
public class KZx implements com.bytedance.sdk.component.ML.ML {
    private boolean KZx;
    private boolean Og;
    private Sn ZZv;
    private String pA;

    public KZx(String str, boolean z, boolean z2, Sn sn) {
        this.pA = str;
        this.Og = z;
        this.KZx = z2;
        this.ZZv = sn;
    }

    @Override // com.bytedance.sdk.component.ML.ML
    public String pA() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.ML.ML
    public boolean Og() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.ML.ML
    public boolean KZx() {
        return this.KZx;
    }
}
