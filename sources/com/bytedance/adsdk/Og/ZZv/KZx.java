package com.bytedance.adsdk.Og.ZZv;

/* JADX INFO: loaded from: classes13.dex */
public enum KZx {
    JSON(".json"),
    ZIP(".zip");

    public final String KZx;

    KZx(String str) {
        this.KZx = str;
    }

    public String pA() {
        return ".temp" + this.KZx;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.KZx;
    }
}
