package com.bytedance.sdk.component.ML.ZZv;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes11.dex */
public class ML extends pA {
    private com.bytedance.sdk.component.ML.JG Og;
    private byte[] pA;

    public ML(byte[] bArr, com.bytedance.sdk.component.ML.JG jg) {
        this.pA = bArr;
        this.Og = jg;
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        com.bytedance.sdk.component.ML.KZx.JG jgYFO = kZx.yFO();
        com.bytedance.sdk.component.ML.KZx.Og.pA pAVarPA = jgYFO.pA(kZx);
        try {
            kZx.TX();
            Bitmap bitmapPA = pAVarPA.pA(this.pA);
            if (bitmapPA != null) {
                kZx.pA(new Wx(bitmapPA, this.Og, false));
                jgYFO.pA(kZx.vZF()).pA(kZx.ML(), bitmapPA);
                return;
            }
            pA(1002, "decode failed bitmap null", null, kZx);
        } catch (Throwable th) {
            pA(1002, "decode failed:" + th.getMessage(), th, kZx);
        }
    }

    private void pA(int i, String str, Throwable th, com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        if (this.Og == null) {
            kZx.pA(new BSW());
        } else {
            kZx.pA(new omh(i, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "decode";
    }
}
