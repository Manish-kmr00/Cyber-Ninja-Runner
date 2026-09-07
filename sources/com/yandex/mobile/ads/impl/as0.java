package com.yandex.mobile.ads.impl;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class as0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f8437a = new AtomicLong();

    public static long a() {
        return f8437a.getAndIncrement();
    }
}
