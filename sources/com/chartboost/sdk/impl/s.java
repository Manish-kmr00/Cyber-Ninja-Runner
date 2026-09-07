package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes12.dex */
public enum s {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    public final String b;

    s(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
