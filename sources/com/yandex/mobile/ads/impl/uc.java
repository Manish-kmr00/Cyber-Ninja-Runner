package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f10375a;
    private final qc b;
    private final qc c;
    private final pe0 d;

    public final void a(final sc listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10375a.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.uc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                uc.a(this.f$0, listener);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ uc(Context context) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new b41(b41.d));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this(context, executorServiceNewSingleThreadExecutor, new re0(context), new rf0(context), qe0.a(context));
    }

    public uc(Context context, Executor executor, qc gmsAdvertisingInfoProvider, qc hmsAdvertisingInfoProvider, pe0 gmsAdvertisingIdStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(gmsAdvertisingInfoProvider, "gmsAdvertisingInfoProvider");
        Intrinsics.checkNotNullParameter(hmsAdvertisingInfoProvider, "hmsAdvertisingInfoProvider");
        Intrinsics.checkNotNullParameter(gmsAdvertisingIdStorage, "gmsAdvertisingIdStorage");
        this.f10375a = executor;
        this.b = gmsAdvertisingInfoProvider;
        this.c = hmsAdvertisingInfoProvider;
        this.d = gmsAdvertisingIdStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(uc this$0, sc listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        lc lcVarA = this$0.b.a();
        lc lcVarA2 = this$0.c.a();
        this$0.d.b(lcVarA);
        nc ncVar = new nc(lcVarA, lcVarA2, this$0.d.a(lcVarA));
        if (ncVar.a() == null && ncVar.c() == null) {
            listener.a();
        } else {
            listener.a(ncVar);
        }
    }
}
