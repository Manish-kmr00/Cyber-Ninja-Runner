package com.bytedance.sdk.component.Og.pA;

/* JADX INFO: loaded from: classes7.dex */
public class Sn {
    public pA JG;
    public Bzk KZx;
    public byte[] ML;
    public String ZZv;

    public enum pA {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public Sn() {
    }

    public String pA() {
        return this.ZZv;
    }

    public Sn(Bzk bzk, String str, pA pAVar) {
        this.KZx = bzk;
        this.ZZv = str;
        this.JG = pAVar;
    }

    public Sn(Bzk bzk, byte[] bArr, pA pAVar) {
        this.KZx = bzk;
        this.ML = bArr;
        this.JG = pAVar;
    }

    public static Sn pA(Bzk bzk, String str) {
        return new Sn(bzk, str, pA.STRING_TYPE);
    }

    public static Sn pA(Bzk bzk, byte[] bArr) {
        return new Sn(bzk, bArr, pA.BYTE_ARRAY_TYPE);
    }
}
