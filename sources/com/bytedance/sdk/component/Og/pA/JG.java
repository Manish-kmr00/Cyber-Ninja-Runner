package com.bytedance.sdk.component.Og.pA;

/* JADX INFO: loaded from: classes5.dex */
public final class JG {
    private final String[] pA;

    public JG(String[] strArr) {
        this.pA = strArr;
    }

    public int pA() {
        return this.pA.length / 2;
    }

    public String pA(int i) {
        return this.pA[i * 2];
    }

    public String Og(int i) {
        return this.pA[(i * 2) + 1];
    }
}
