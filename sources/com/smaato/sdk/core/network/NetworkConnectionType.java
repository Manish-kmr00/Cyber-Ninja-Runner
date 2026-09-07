package com.smaato.sdk.core.network;

import com.json.x8;

/* JADX INFO: loaded from: classes3.dex */
public enum NetworkConnectionType {
    CARRIER_2G("2g"),
    CARRIER_3G(x8.f4583a),
    CARRIER_4G("4g"),
    CARRIER_UNKNOWN("carrier"),
    WIFI(x8.b),
    ETHERNET(x8.e),
    OTHER("other");

    private final String type;

    NetworkConnectionType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
