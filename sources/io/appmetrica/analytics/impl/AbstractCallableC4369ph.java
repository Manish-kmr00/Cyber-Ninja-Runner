package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ph, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractCallableC4369ph implements Callable {
    public static final C4344oh d = new C4344oh();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4178i0 f11724a;
    public final Ck b;
    public boolean c;

    public AbstractCallableC4369ph(C4178i0 c4178i0, Ck ck) {
        this.f11724a = c4178i0;
        this.b = ck;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C4178i0 b() {
        return this.f11724a;
    }

    public boolean c() {
        C4178i0 c4178i0 = this.f11724a;
        synchronized (c4178i0) {
            if (c4178i0.d == null) {
                c4178i0.e = new CountDownLatch(1);
                Intent intentA = AbstractC4073dk.a(c4178i0.f11591a);
                try {
                    c4178i0.g.b(c4178i0.f11591a);
                    c4178i0.f11591a.bindService(intentA, c4178i0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f11724a.a(5000L);
        return true;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }

    public final boolean d() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public void a() {
        IAppMetricaService iAppMetricaService;
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            int i = 0;
            do {
                C4178i0 c4178i0 = this.f11724a;
                synchronized (c4178i0) {
                    iAppMetricaService = c4178i0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        Ck ck = this.b;
                        if (ck == null || ((C3996ai) ck).a()) {
                            this.f11724a.c();
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                i++;
                if (!c()) {
                    return;
                }
                AtomicBoolean atomicBoolean = S1.e;
                if (S1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
