package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f10201a = CollectionsKt.listOf((Object[]) new String[]{StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url"});

    public static List a() {
        return f10201a;
    }
}
