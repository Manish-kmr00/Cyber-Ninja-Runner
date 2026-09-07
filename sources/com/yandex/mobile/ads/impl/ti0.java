package com.yandex.mobile.ads.impl;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes13.dex */
public final class ti0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f10305a = new AtomicLong();

    @JvmStatic
    public static final long a() {
        return f10305a.getAndIncrement();
    }
}
