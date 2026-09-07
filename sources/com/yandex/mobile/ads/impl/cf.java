package com.yandex.mobile.ads.impl;

import com.facebook.internal.AnalyticsEvents;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<mf, String> f8595a = MapsKt.mapOf(TuplesKt.to(mf.c, "Network error"), TuplesKt.to(mf.d, "Invalid response"), TuplesKt.to(mf.b, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN));

    public static String a(mf mfVar) {
        String str = f8595a.get(mfVar);
        return str == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str;
    }
}
