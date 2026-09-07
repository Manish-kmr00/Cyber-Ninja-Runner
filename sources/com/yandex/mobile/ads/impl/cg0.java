package com.yandex.mobile.ads.impl;

import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cg0 implements Callable<bg0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8601a;
    private final eg0 b;

    public cg0(String checkHost, zs defaultHostAccessChecker, eg0 hostAccessCheckerProvider) {
        Intrinsics.checkNotNullParameter(checkHost, "checkHost");
        Intrinsics.checkNotNullParameter(defaultHostAccessChecker, "defaultHostAccessChecker");
        Intrinsics.checkNotNullParameter(hostAccessCheckerProvider, "hostAccessCheckerProvider");
        this.f8601a = checkHost;
        this.b = hostAccessCheckerProvider;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final bg0 call() {
        boolean zA = this.b.a().a(this.f8601a);
        String str = "Host " + this.f8601a + " reachability is " + zA;
        op0.a(new Object[0]);
        return new bg0(zA);
    }
}
