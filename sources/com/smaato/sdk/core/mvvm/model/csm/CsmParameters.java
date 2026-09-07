package com.smaato.sdk.core.mvvm.model.csm;

import com.smaato.sdk.core.api.ImpressionCountingType;

/* JADX INFO: loaded from: classes2.dex */
public class CsmParameters {
    public final String bundleId;
    public final ImpressionCountingType impressionCountingType;
    public final String sci;
    public final String sessionId;
    public final Long ttlMs;

    public CsmParameters(String str, String str2, ImpressionCountingType impressionCountingType, Long l, String str3) {
        this.sessionId = str;
        this.sci = str2;
        this.impressionCountingType = impressionCountingType;
        this.ttlMs = l;
        this.bundleId = str3;
    }
}
