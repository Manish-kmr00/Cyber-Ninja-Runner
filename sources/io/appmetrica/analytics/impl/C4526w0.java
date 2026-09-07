package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4526w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4377q0 f11822a;
    public final Gb b;
    public final Hb c;
    public final Jb d;
    public final IHandlerExecutor e;

    public C4526w0() {
        C4377q0 c4377q0C = C4455t4.i().c();
        this.f11822a = c4377q0C;
        this.b = new Gb(c4377q0C);
        this.c = new Hb(c4377q0C);
        this.d = new Jb();
        this.e = C4455t4.i().e().a();
    }

    public final void a(Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        Gb gb = this.b;
        if (!gb.f11160a.a(context).f11273a || !gb.b.a(appMetricaLibraryAdapterConfig).f11273a) {
            ImportantLogger.INSTANCE.info("[AppMetricaLibraryAdapterProxy]", "Activation failed due to context is null", new Object[0]);
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        Hb hb = this.c;
        hb.b.a(applicationContext);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        C4455t4.i().f.a();
        hb.f11175a.getClass();
        C4352p0 c4352p0A = C4352p0.a(applicationContext);
        c4352p0A.d.a(null, c4352p0A);
        this.e.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.w0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C4526w0.a(this.f$0, applicationContext, appMetricaLibraryAdapterConfig);
            }
        });
        this.f11822a.getClass();
        synchronized (C4352p0.class) {
            C4352p0.f = true;
        }
    }

    public static final void a(C4526w0 c4526w0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c4526w0.f11822a.getClass();
        C4352p0 c4352p0A = C4352p0.a(context);
        c4352p0A.f().a(appMetricaLibraryAdapterConfig);
        C4455t4.i().c.a().execute(new RunnableC4353p1(c4352p0A.f11709a));
    }
}
