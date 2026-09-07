package com.yandex.mobile.ads.impl;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8706a = new AtomicBoolean(false);

    public final boolean a() {
        return this.f8706a.get();
    }

    public final void b() {
        this.f8706a.set(true);
    }
}
