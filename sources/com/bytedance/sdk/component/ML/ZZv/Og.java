package com.bytedance.sdk.component.ML.ZZv;

/* JADX INFO: loaded from: classes10.dex */
public class Og implements Bzk {
    private com.bytedance.sdk.component.ML.JG Og;
    private byte[] pA;

    public Og(byte[] bArr, com.bytedance.sdk.component.ML.JG jg) {
        this.pA = bArr;
        this.Og = jg;
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        Bzk omhVar;
        int iWV = kZx.WV();
        kZx.pA(this.pA.length);
        if (iWV != 2) {
            if (iWV == 3) {
                byte[] bArr = this.pA;
                omhVar = new Wx(bArr, this.Og, com.bytedance.sdk.component.ML.KZx.KZx.pA.Og(bArr));
            } else {
                boolean zOg = com.bytedance.sdk.component.ML.KZx.KZx.pA.Og(this.pA);
                if (!zOg && com.bytedance.sdk.component.ML.KZx.KZx.pA.pA(this.pA)) {
                    omhVar = new ML(this.pA, this.Og);
                } else {
                    omhVar = new Wx(this.pA, this.Og, zOg);
                }
            }
        } else if (com.bytedance.sdk.component.ML.KZx.KZx.pA.pA(this.pA)) {
            omhVar = new ML(this.pA, this.Og);
        } else if (this.Og == null) {
            omhVar = new BSW();
        } else {
            omhVar = new omh(1001, "not image format", null);
        }
        kZx.pA(omhVar);
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "image_type";
    }
}
