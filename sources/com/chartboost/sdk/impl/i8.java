package com.chartboost.sdk.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreakType;

/* JADX INFO: loaded from: classes5.dex */
public enum i8 {
    PREROLL(InstreamAdBreakType.PREROLL),
    MIDROLL(InstreamAdBreakType.MIDROLL),
    POSTROLL(InstreamAdBreakType.POSTROLL),
    STANDALONE("standalone");

    public final String b;

    i8(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
