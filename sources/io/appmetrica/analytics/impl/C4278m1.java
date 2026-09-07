package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.internal.js.AppMetricaInitializerJsInterface;
import io.appmetrica.analytics.internal.js.AppMetricaJsInterface;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4278m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4377q0 f11662a;
    public final Cdo b;
    public final C4146gi c;
    public final L7 d;
    public final Jk e;
    public final K2 f;
    public final Fm g;
    public final Ak h;

    public C4278m1(C4377q0 c4377q0, K2 k2, Jk jk, Cdo cdo, Fm fm, C4146gi c4146gi, L7 l7, Ak ak) {
        this.f11662a = c4377q0;
        this.b = cdo;
        this.c = c4146gi;
        this.d = l7;
        this.f = k2;
        this.g = fm;
        this.e = jk;
        this.h = ak;
    }

    public static IHandlerExecutor c() {
        return C4455t4.i().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        K2 k2 = this.f;
        k2.f.a(context);
        k2.b.a(appMetricaConfig);
        Fm fm = this.g;
        Context applicationContext = context.getApplicationContext();
        fm.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            fm.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        fm.f11147a.getClass();
        C4352p0 c4352p0A = C4352p0.a(applicationContext);
        c4352p0A.d.a(appMetricaConfig, c4352p0A);
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.m1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(context, appMetricaConfig);
            }
        });
        this.f11662a.getClass();
        synchronized (C4352p0.class) {
            C4352p0.f = true;
        }
    }

    public final String b() {
        this.f11662a.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        if (c4352p0 == null) {
            return null;
        }
        return c4352p0.f().e();
    }

    public final C4364pc d() {
        this.f11662a.getClass();
        return C4352p0.e.f().i();
    }

    public final void e() {
        d().f11720a.a(this.h.a());
    }

    public final void f() {
        this.f.f11218a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new O0(this));
    }

    public final void c(Activity activity) {
        this.f.f11218a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Z0(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C4377q0 c4377q0 = this.f11662a;
        Context applicationContext = context.getApplicationContext();
        c4377q0.getClass();
        C4352p0 c4352p0A = C4352p0.a(applicationContext);
        c4352p0A.f().a(this.d.b(appMetricaConfig));
        Context context2 = c4352p0A.f11709a;
        ((G9) C4455t4.i().c.a()).execute(new RunnableC4353p1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new M0(this, str));
    }

    public final void d(String str) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.j.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new H0(this, str));
    }

    public C4278m1() {
        this(C4455t4.i().c(), new Cdo());
    }

    public final void c(String str, String str2) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.s.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4154h1(this, str, str2));
    }

    public C4278m1(C4377q0 c4377q0, Cdo cdo) {
        this(c4377q0, new K2(c4377q0), new Jk(c4377q0), cdo, new Fm(c4377q0, cdo), C4146gi.a(), C4455t4.i().g(), C4455t4.i().m());
    }

    public final void d(String str, String str2) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        if (k2.o.a(str).f11273a) {
            this.g.getClass();
            IHandlerExecutor iHandlerExecutorC = c();
            ((G9) iHandlerExecutorC).b.post(new W0(this, str, str2));
        }
    }

    public final void b(String str) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.s.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4129g1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new J0(this, z));
    }

    public final void b(Activity activity) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.c.a(activity);
        this.g.getClass();
        Intent intentA = Fm.a(activity);
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new E0(this, intentA));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f11273a && this.f.n.a(str).f11273a) {
            this.g.getClass();
            IHandlerExecutor iHandlerExecutorC = c();
            ((G9) iHandlerExecutorC).b.post(new X0(this, str));
        }
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new L0(this, z));
    }

    public final void a(Activity activity) {
        this.f.f11218a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4104f1(this, activity));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new U0(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.m1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f11218a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.m1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C4278m1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4179i1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f11662a.getClass();
        C4352p0.a(context);
    }

    public final void a(String str, Throwable th) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new R1();
            th.fillInStackTrace();
        }
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4203j1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.u.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4228k1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.v.a(th);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4253l1(this, th));
    }

    public final void a(String str) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.i.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new F0(this, str));
    }

    public final void a(Intent intent) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new G0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new I0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new K0(this, z));
    }

    public final void a(UserProfile userProfile) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new N0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new P0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Q0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new R0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new S0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new T0(this, deferredDeeplinkListener));
    }

    public final Ya a(Context context, String str) {
        K2 k2 = this.f;
        k2.f.a(context);
        k2.k.a(str);
        Fm fm = this.g;
        fm.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        K2 k2 = this.f;
        k2.f.a(context);
        k2.h.a(reporterConfig);
        Fm fm = this.g;
        fm.e.a(context.getApplicationContext());
        C4146gi c4146gi = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((Yh) c4146gi.f11571a.get(reporterConfig.apiKey)) == null) {
            synchronized (c4146gi.f11571a) {
                if (((Yh) c4146gi.f11571a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor iHandlerExecutorA = C4455t4.i().c.a();
                    c4146gi.b.getClass();
                    if (C4352p0.e == null) {
                        ((G9) iHandlerExecutorA).b.post(new RunnableC4096ei(c4146gi, applicationContext));
                    }
                    Yh yh = new Yh(applicationContext.getApplicationContext(), str, new C4377q0());
                    c4146gi.f11571a.put(str, yh);
                    yh.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.m.a(webView);
        Cdo cdo = this.g.b;
        cdo.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA);
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                ao aoVar = new ao();
                synchronized (cdo) {
                    PublicLogger publicLogger = cdo.b;
                    if (publicLogger == null) {
                        cdo.f11523a.add(aoVar);
                    } else {
                        aoVar.consume(publicLogger);
                    }
                }
            } else {
                cdo.a(new bo());
            }
        } catch (Throwable th) {
            cdo.a(new co(th));
        }
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new V0(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        Fm fm = this.g;
        Context applicationContext = context.getApplicationContext();
        fm.e.a(applicationContext);
        fm.f.a(applicationContext);
        return C4455t4.i().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new Y0(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC3979a1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        K2 k2 = this.f;
        k2.f.a(context);
        k2.p.a(startupParamsCallback);
        Fm fm = this.g;
        fm.e.a(context.getApplicationContext());
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4004b1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4029c1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        K2 k2 = this.f;
        k2.f11218a.a(null);
        k2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4054d1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor moduleAdRevenueProcessorA = C4455t4.i().k().a();
        if (moduleAdRevenueProcessorA != null) {
            moduleAdRevenueProcessorA.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor iHandlerExecutorC = c();
        ((G9) iHandlerExecutorC).b.post(new RunnableC4079e1(this, listFromMap));
    }

    public static Pa a(C4278m1 c4278m1) {
        return c4278m1.d().f11720a;
    }
}
