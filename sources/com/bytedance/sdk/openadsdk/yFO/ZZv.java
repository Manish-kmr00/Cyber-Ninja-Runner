package com.bytedance.sdk.openadsdk.yFO;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.x8;

/* JADX INFO: loaded from: classes8.dex */
public enum ZZv {
    TYPE_2G("2g"),
    TYPE_3G(x8.f4583a),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI(x8.b),
    TYPE_MOBILE(DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY),
    TYPE_UNKNOWN("unknown");

    private String omh;

    ZZv(String str) {
        this.omh = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.omh;
    }
}
