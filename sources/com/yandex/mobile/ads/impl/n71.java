package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g71 f9705a;

    public n71(g71 viewProvider) {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        this.f9705a = viewProvider;
    }

    public final m71 a() {
        return new m71(new m71.a(this.f9705a.d(), this.f9705a.a()).a(this.f9705a.b()).a(this.f9705a.c()).a(this.f9705a.f()), 0);
    }
}
