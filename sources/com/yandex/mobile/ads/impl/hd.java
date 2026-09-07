package com.yandex.mobile.ads.impl;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class hd implements le {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f9083a;

    public hd(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f9083a = executor;
    }

    @Override // com.yandex.mobile.ads.impl.le
    public final void a(final je report) {
        Intrinsics.checkNotNullParameter(report, "report");
        this.f9083a.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.hd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                hd.a(this.f$0, report);
            }
        });
    }

    private static void b(je jeVar) {
        String str = "reportLibraryAdapterEvent(), eventName = " + jeVar.a() + ", reportData = " + jeVar.b();
        op0.a(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hd this$0, je report) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(report, "$report");
        this$0.getClass();
        b(report);
        fd.f8884a.getClass();
        fd.a(report);
    }
}
