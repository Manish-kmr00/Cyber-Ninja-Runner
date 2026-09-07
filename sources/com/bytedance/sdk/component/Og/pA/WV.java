package com.bytedance.sdk.component.Og.pA;

/* JADX INFO: loaded from: classes6.dex */
public enum WV {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String ML;

    WV(String str) {
        this.ML = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ML;
    }
}
