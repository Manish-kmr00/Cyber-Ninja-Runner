package com.ogury.ad.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f7295a = Executors.newFixedThreadPool(Math.max(4, Runtime.getRuntime().availableProcessors()));

    @Override // com.ogury.ad.internal.h8
    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f7295a.execute(runnable);
    }
}
