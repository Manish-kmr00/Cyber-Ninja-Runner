package com.bytedance.sdk.openadsdk.core.WV.pA;

/* JADX INFO: loaded from: classes12.dex */
public enum pA {
    XML_PARSING_ERROR(100),
    SCHEMA_VALIDATION_ERROR(101),
    WRAPPER_TIMEOUT(301),
    NO_ADS_VAST_RESPONSE(303),
    GENERAL_LINEAR_AD_ERROR(400),
    GENERAL_COMPANION_AD_ERROR(600),
    UNDEFINED_ERROR(900);

    private final int omh;

    pA(int i) {
        this.omh = i;
    }

    public String pA() {
        return String.valueOf(this.omh);
    }
}
