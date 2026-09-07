package com.bytedance.sdk.component.ML.KZx.pA.Og;

import com.bytedance.sdk.component.ML.yFO;

/* JADX INFO: loaded from: classes8.dex */
public class KZx implements yFO {
    private com.bytedance.sdk.component.ML.KZx.pA.KZx<String, byte[]> KZx;
    private int Og;
    private int pA;

    public KZx(int i, int i2) {
        this.Og = i;
        this.pA = i2;
        this.KZx = new com.bytedance.sdk.component.ML.KZx.pA.KZx<String, byte[]>(i) { // from class: com.bytedance.sdk.component.ML.KZx.pA.Og.KZx.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ML.KZx.pA.KZx
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public int Og(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean pA(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.KZx.pA(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public byte[] pA(String str) {
        return this.KZx.pA(str);
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean Og(String str) {
        return this.KZx.pA(str) != null;
    }
}
