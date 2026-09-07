package com.iab.omid.library.vungle.adsession.media;

import com.yandex.mobile.ads.instream.InstreamAdBreakType;

/* JADX INFO: loaded from: classes10.dex */
public enum Position {
    PREROLL(InstreamAdBreakType.PREROLL),
    MIDROLL(InstreamAdBreakType.MIDROLL),
    POSTROLL(InstreamAdBreakType.POSTROLL),
    STANDALONE("standalone");

    private final String position;

    Position(String str) {
        this.position = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.position;
    }
}
