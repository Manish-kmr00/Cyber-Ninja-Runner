package com.smaato.sdk.core.ad;

/* JADX INFO: loaded from: classes13.dex */
public enum GeoType {
    GPS("1"),
    IP_ADDRESS("2"),
    USER_PROVIDED("3");

    private final String type;

    GeoType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
