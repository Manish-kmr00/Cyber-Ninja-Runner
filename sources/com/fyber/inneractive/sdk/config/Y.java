package com.fyber.inneractive.sdk.config;

import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: classes13.dex */
public enum Y {
    NO_CLICK("0"),
    CTA_BUTTON("1"),
    COMPANION("2"),
    VIDEO("3"),
    APP_INFO(Protocol.VAST_1_0_WRAPPER),
    STORE_PROMO("5");

    String value;

    Y(String str) {
        this.value = str;
    }

    public final String a() {
        return this.value;
    }
}
