package com.yandex.mobile.ads.impl;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
public final class p11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f9887a = new AtomicBoolean(false);

    @JvmStatic
    public static final void a() {
        if (f9887a.compareAndSet(false, true)) {
            dp0.b("Yandex Mobile Ads 7.12.1 initialized successfully", new Object[0]);
        }
    }
}
