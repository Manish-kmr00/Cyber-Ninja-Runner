package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class h11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h11 f9051a = new h11();
    private static boolean b;

    public final synchronized boolean a() {
        return b;
    }

    public final synchronized void b() {
        b = true;
    }

    private h11() {
    }
}
