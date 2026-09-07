package com.fyber.inneractive.sdk.util;

import java.util.Locale;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public enum EnumC3243g {
    DISPLAY("DISPLAY"),
    VIDEO_CTA("VIDEO_CTA"),
    VIDEO_CLICK("VIDEO_CLICK"),
    VAST_ENDCARD("VAST_ENDCARD"),
    DEFAULT_ENDCARD("DEFAULT_ENDCARD"),
    VIDEO_APP_INFO("VIDEO_APP_INFO"),
    FMP_ENDCARD("FMP_ENDCARD"),
    STORE_PROMO_CTA("STORE_PROMO_CTA");

    private final String key;
    private String mVersion = "";
    private int mOrderShown = 0;

    EnumC3243g(String str) {
        this.key = str;
    }

    public final void a(String str) {
        this.mVersion = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        if ((this != FMP_ENDCARD || this.mOrderShown != 1) && this.mOrderShown != 2) {
            return this.key;
        }
        Locale locale = Locale.US;
        return this.key + "_" + this.mOrderShown;
    }

    public final String a() {
        return this.mVersion;
    }

    public final void a(int i) {
        this.mOrderShown = i;
    }
}
