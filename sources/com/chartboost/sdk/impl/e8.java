package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes2.dex */
public enum e8 {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");

    public final String b;

    e8(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
