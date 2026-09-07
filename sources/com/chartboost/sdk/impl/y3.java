package com.chartboost.sdk.impl;

import com.amazon.device.ads.DTBMetricsConfiguration;

/* JADX INFO: loaded from: classes13.dex */
public enum y3 {
    CTV("ctv"),
    MOBILE(DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY),
    OTHER("other");

    public final String b;

    y3(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
