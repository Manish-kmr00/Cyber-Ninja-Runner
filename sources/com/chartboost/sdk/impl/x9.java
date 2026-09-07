package com.chartboost.sdk.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0002\u001a\u00060\u0000j\u0002`\u0004*\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u0002\u0010\u0005*\f\b\u0000\u0010\u0006\"\u00020\u00002\u00020\u0000*\f\b\u0000\u0010\u0007\"\u00020\u00002\u00020\u0000¨\u0006\b"}, d2 = {"", "Lcom/chartboost/sdk/internal/utils/TimeStamp;", "a", "()J", "Lcom/chartboost/sdk/internal/utils/TimeStampSeconds;", "(J)J", "TimeStamp", "TimeStampSeconds", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class x9 {
    public static final long a(long j) {
        return j / ((long) 1000);
    }

    public static final long a() {
        return System.currentTimeMillis();
    }
}
