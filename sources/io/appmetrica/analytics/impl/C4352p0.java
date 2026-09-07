package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4352p0 implements InterfaceC3989ab {
    public static volatile C4352p0 e;
    public static volatile boolean f;
    public static volatile boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11709a;
    public final C4227k0 b;
    public final FutureTask c;
    public final Ia d;

    public C4352p0(Context context) {
        this.f11709a = context;
        C4227k0 c4227k0B = C4455t4.i().b();
        this.b = c4227k0B;
        this.d = c4227k0B.a(context, C4455t4.i().e());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.p0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.p();
            }
        });
    }

    public static C4352p0 a(Context context) {
        C4352p0 c4352p0 = e;
        if (c4352p0 == null) {
            synchronized (C4352p0.class) {
                c4352p0 = e;
                if (c4352p0 == null) {
                    c4352p0 = new C4352p0(context);
                    c4352p0.j();
                    C4455t4.i().c.a().execute(new RunnableC4327o0(c4352p0));
                    e = c4352p0;
                }
            }
        }
        return c4352p0;
    }

    public static void b(boolean z) {
        c().b(z);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        return f;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        C4352p0 c4352p0;
        c4352p0 = e;
        return (c4352p0 == null || !c4352p0.c.isDone() || c4352p0.f().i() == null) ? false : true;
    }

    public static synchronized void n() {
        e = null;
        f = false;
        g = false;
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        f = true;
    }

    public static void r() {
        g = true;
    }

    public static C4352p0 s() {
        return e;
    }

    public static void setDataSendingEnabled(boolean z) {
        c().setDataSendingEnabled(z);
    }

    public static void setUserProfileID(String str) {
        c().setUserProfileID(str);
    }

    public final void c(AppMetricaConfig appMetricaConfig) {
        this.d.a(appMetricaConfig, this);
    }

    public final void d(AppMetricaConfig appMetricaConfig) {
        f().a(appMetricaConfig);
        C4455t4.i().c.a().execute(new RunnableC4353p1(this.f11709a));
    }

    public final String e() {
        return f().e();
    }

    public final Ja f() {
        try {
            return (Ja) this.c.get();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Map<String, String> g() {
        return f().g();
    }

    public final AdvIdentifiersResult h() {
        return f().h();
    }

    public final C4364pc i() {
        return f().i();
    }

    public final void j() {
        C4206j4 c4206j4 = C4455t4.i().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.p0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.o();
            }
        };
        c4206j4.f11611a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + ThreadFactoryC4589yd.f11859a.incrementAndGet()).start();
    }

    public final void o() {
        C4455t4.i().q.a(this.f11709a);
        new C4306n4(this.f11709a).a(this.f11709a);
        C4455t4.i().a(this.f11709a).a();
        this.c.run();
    }

    public final Ja p() {
        Ja ja;
        C4227k0 c4227k0 = this.b;
        Context context = this.f11709a;
        Ia ia = this.d;
        synchronized (c4227k0) {
            if (c4227k0.d == null) {
                if (c4227k0.a(context)) {
                    c4227k0.d = new C4501v0();
                } else {
                    c4227k0.d = new C4451t0(context, ia);
                }
            }
            ja = c4227k0.d;
        }
        return ja;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C4455t4.i().c.a().execute(new RunnableC4353p1(this.f11709a));
    }

    public final Ya c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static Nc c() {
        if (m()) {
            return e.f();
        }
        return C4455t4.i().b;
    }

    public final C4088ea d() {
        return f().d();
    }

    public final C4505v4 b() {
        return this.d.a();
    }

    public static void a(Location location) {
        c().a(location);
    }

    public static void a(boolean z) {
        c().a(z);
    }

    public static void a(String str, String str2) {
        c().a(str, str2);
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        f().a(deferredDeeplinkParametersListener);
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        f().a(deferredDeeplinkListener);
    }

    public final void a(ReporterConfig reporterConfig) {
        f().a(reporterConfig);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        f().a(startupParamsCallback, list);
    }

    public static synchronized void a(C4352p0 c4352p0) {
        e = c4352p0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3989ab
    public final Za a() {
        return f().a();
    }
}
