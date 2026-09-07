package com.fyber.inneractive.sdk.response;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    RETURNED_ADTYPE_HTML(4),
    RETURNED_ADTYPE_MRAID(6),
    RETURNED_ADTYPE_VAST(8),
    RETURNED_ADTYPE_HTML5_VIDEO(9),
    RETURNED_ADTYPE_NATIVE(10),
    RETURNED_ADTYPE_PMN(11),
    RETURNED_ADTYPE_MOBILE_ADS(15);

    private int value;

    a(int i) {
        this.value = i;
    }

    public static a a(int i) {
        for (a aVar : values()) {
            if (aVar.value == i) {
                return aVar;
            }
        }
        return null;
    }
}
