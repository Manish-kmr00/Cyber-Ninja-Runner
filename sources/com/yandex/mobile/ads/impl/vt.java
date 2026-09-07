package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class vt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p81 f10505a;

    public vt(p81 nativeForcePauseObserver) {
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        this.f10505a = nativeForcePauseObserver;
    }

    public final void a() {
        this.f10505a.b();
    }

    public final void b() {
        this.f10505a.a();
    }
}
