package com.smaato.sdk.banner.ad;

/* JADX INFO: loaded from: classes2.dex */
public enum AutoReloadInterval {
    DISABLED(0),
    DEFAULT(60),
    VERY_SHORT(10),
    SHORT(30),
    NORMAL(60),
    LONG(120),
    VERY_LONG(240);

    private final int seconds;

    AutoReloadInterval(int i) {
        this.seconds = i;
    }

    public int getSeconds() {
        return this.seconds;
    }
}
