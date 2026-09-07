package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3305b extends AbstractC3365f3 {
    public final long b;
    public final RunnableC3290a c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final Handler f;
    public ScheduledExecutorService g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3305b(long j, C3379g3 listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b = j;
        this.c = new RunnableC3290a(this);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new Handler(Looper.getMainLooper());
    }

    public static final StackTraceElement[] a(C3305b c3305b) {
        c3305b.getClass();
        return Looper.getMainLooper().getThread().getStackTrace();
    }

    public static final void b(C3305b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.d.getAndSet(true)) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this$0.g;
        if (scheduledExecutorService == null || scheduledExecutorService.scheduleAtFixedRate(this$0.c, 0L, this$0.b, TimeUnit.MILLISECONDS) == null) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new V4("ANRWatchDog"));
            this$0.g = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            if (scheduledExecutorServiceNewSingleThreadScheduledExecutor != null) {
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(this$0.c, 0L, this$0.b, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC3365f3
    public final void a() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3305b.b(this.f$0);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ec.f3062a.execute(runnable);
    }

    @Override // com.inmobi.media.AbstractC3365f3
    public final void b() {
        if (this.d.getAndSet(false)) {
            this.d.set(false);
            this.e.set(false);
            ScheduledExecutorService scheduledExecutorService = this.g;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.g = null;
        }
    }
}
