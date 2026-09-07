package com.moloco.sdk.acm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {
    public static final a a(InitConfig initConfig) {
        Intrinsics.checkNotNullParameter(initConfig, "<this>");
        return new a(initConfig.getAppId(), initConfig.getPostAnalyticsUrl(), initConfig.getRequestPeriodSeconds(), initConfig.getClientOptions());
    }
}
