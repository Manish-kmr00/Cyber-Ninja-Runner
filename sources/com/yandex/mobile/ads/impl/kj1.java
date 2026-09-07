package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreakType;

/* JADX INFO: loaded from: classes13.dex */
public enum kj1 {
    c(InstreamAdBreakType.PREROLL),
    d(InstreamAdBreakType.MIDROLL),
    e(InstreamAdBreakType.POSTROLL),
    f("standalone");

    private final String b;

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }

    kj1(String str) {
        this.b = str;
    }
}
