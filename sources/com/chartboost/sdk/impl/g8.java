package com.chartboost.sdk.impl;

import com.adjust.sdk.Constants;

/* JADX INFO: loaded from: classes5.dex */
public enum g8 {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(Constants.NORMAL),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");

    public final String b;

    g8(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
