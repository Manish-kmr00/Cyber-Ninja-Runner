package com.chartboost.sdk.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001d\u0010\u0005\u001a\u00020\u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "(Ljava/lang/Exception;)Ljava/lang/String;", "errorMessage", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class p4 {
    public static final String a(Exception exc) {
        String message;
        return (exc == null || (message = exc.getMessage()) == null) ? "Unknown error" : message;
    }
}
