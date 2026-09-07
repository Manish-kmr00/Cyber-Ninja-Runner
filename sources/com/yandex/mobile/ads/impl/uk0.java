package com.yandex.mobile.ads.impl;

import com.google.firebase.ktx.BuildConfig;

/* JADX INFO: loaded from: classes12.dex */
public enum uk0 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("definedByJavaScript"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1(BuildConfig.VERSION_NAME),
    /* JADX INFO: Fake field, exist only in values array */
    EF2(com.ironsource.b9.h.r),
    /* JADX INFO: Fake field, exist only in values array */
    EF3("beginToRender"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("onePixel"),
    c("viewable"),
    /* JADX INFO: Fake field, exist only in values array */
    EF69("audible"),
    /* JADX INFO: Fake field, exist only in values array */
    EF79("other");

    private final String b;

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }

    uk0(String str) {
        this.b = str;
    }
}
