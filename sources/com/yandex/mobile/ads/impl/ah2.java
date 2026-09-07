package com.yandex.mobile.ads.impl;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes4.dex */
public class ah2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f8407a = ou.a();

    protected final CoroutineScope b() {
        return this.f8407a;
    }

    public final void a() {
        CoroutineScopeKt.cancel$default(this.f8407a, null, 1, null);
    }
}
