package com.yandex.mobile.ads.impl;

import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ps1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f9948a = new LinkedHashSet();

    public final synchronized void a(os1 route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.f9948a.remove(route);
    }

    public final synchronized void b(os1 failedRoute) {
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        this.f9948a.add(failedRoute);
    }

    public final synchronized boolean c(os1 route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f9948a.contains(route);
    }
}
