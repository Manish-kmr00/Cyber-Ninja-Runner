package com.yandex.mobile.ads.impl;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b41 implements ThreadFactory {
    private static final String b = "YandexAds.UrlTracker";
    public static final String c = "YandexAds.BaseController";
    public static final String d = "YandexAds.AdvertisingId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8474a;

    public b41(String threadName) {
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        this.f8474a = threadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new Thread(runnable, this.f8474a);
    }
}
