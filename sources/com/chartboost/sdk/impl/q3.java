package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes13.dex */
public enum q3 {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO("audio");

    public final String b;

    q3(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
