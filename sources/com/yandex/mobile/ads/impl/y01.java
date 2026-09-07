package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class y01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f10691a;
    private final Executor b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        new Handler(Looper.getMainLooper()).post(r);
    }

    public /* synthetic */ y01() {
        Executor executor = new Executor() { // from class: com.yandex.mobile.ads.impl.y01$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                y01.a(runnable);
            }
        };
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(RangesKt.coerceIn(Runtime.getRuntime().availableProcessors() - 1, 2, 4));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        this(executor, executorServiceNewFixedThreadPool);
    }

    public y01(Executor mainThreadExecutor, Executor backgroundExecutor) {
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        this.f10691a = mainThreadExecutor;
        this.b = backgroundExecutor;
    }

    public final Executor b() {
        return this.f10691a;
    }

    public final Executor a() {
        return this.b;
    }
}
