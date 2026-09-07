package com.moloco.sdk.internal.services;

import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes9.dex */
public interface y {
    Boolean a();

    x b();

    String c();

    String d();

    @Deprecated(message = "Use invoke() instead", replaceWith = @ReplaceWith(expression = POBCrashAnalyticsConstants.DEVICE_INFO_KEY, imports = {}))
    x invoke();
}
