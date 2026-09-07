package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4178i0 {
    public static final long j = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11591a;
    public final ICommonExecutor b;
    public CountDownLatch e;
    public final M1 g;
    public IAppMetricaService d = null;
    public final Object f = new Object();
    public final RunnableC4128g0 h = new RunnableC4128g0(this);
    public final ServiceConnectionC4153h0 i = new ServiceConnectionC4153h0(this);
    public boolean c = false;

    public C4178i0(Context context, ICommonExecutor iCommonExecutor, M1 m1) {
        this.f11591a = context.getApplicationContext();
        this.b = iCommonExecutor;
        this.g = m1;
    }

    public final synchronized boolean a() {
        return this.d != null;
    }

    public final void b() {
        synchronized (this.f) {
            this.b.remove(this.h);
        }
    }

    public final void c() {
        ICommonExecutor iCommonExecutor = this.b;
        synchronized (this.f) {
            iCommonExecutor.remove(this.h);
            if (!this.c) {
                iCommonExecutor.executeDelayed(this.h, j);
            }
        }
    }

    public final void a(Long l) {
        try {
            synchronized (this) {
                CountDownLatch countDownLatch = this.e;
                if (countDownLatch == null) {
                    return;
                }
                countDownLatch.await(l.longValue(), TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException unused) {
        }
    }
}
