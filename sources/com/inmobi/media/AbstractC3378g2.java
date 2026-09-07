package com.inmobi.media;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3378g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C9 f3322a;

    static {
        int i = C9.f3042a;
        V4 threadFactory = new V4("ClickManagerExecutor", true);
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        C9 c9 = new C9(TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
        Intrinsics.checkNotNull(c9, "null cannot be cast to non-null type com.inmobi.commons.sdk.PriorityExecutor");
        f3322a = c9;
    }

    public static void a(Runnable runnable, B9 b9) {
        try {
            C9 c9 = f3322a;
            c9.getClass();
            Intrinsics.checkNotNull(b9);
            c9.execute(new C3434k2(runnable, b9));
        } catch (RejectedExecutionException unused) {
        }
    }
}
