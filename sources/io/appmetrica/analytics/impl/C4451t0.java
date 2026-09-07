package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4451t0 implements Ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11771a;
    public final Ia b;
    public final Ke c;
    public final C4398ql d;
    public final Yf e;
    public final C4367pf f;
    public final C4021bi g;
    public final C4320ni h;
    public final L7 i;
    public final Ak j;
    public volatile C4364pc k;
    public final C4103f0 l;
    public boolean m;

    public C4451t0(Context context, Ia ia) {
        this.f11771a = context;
        this.b = ia;
        Ke keB = C4455t4.i().b(context);
        this.c = keB;
        C4439sd.a();
        C4455t4 c4455t4I = C4455t4.i();
        c4455t4I.k().a(new C4032c4(context));
        C4367pf c4367pfA = AbstractC4476u0.a(context, AbstractC4476u0.a(ia.b(), this));
        this.f = c4367pfA;
        L7 l7G = c4455t4I.g();
        this.i = l7G;
        C4320ni c4320niA = AbstractC4476u0.a(c4367pfA, context, ia.getDefaultExecutor());
        this.h = c4320niA;
        l7G.a(c4320niA);
        C4398ql c4398qlA = AbstractC4476u0.a(context, c4320niA, keB, ia.b());
        this.d = c4398qlA;
        c4320niA.a(c4398qlA);
        this.e = AbstractC4476u0.a(c4320niA, keB, ia.b());
        this.g = AbstractC4476u0.a(context, c4367pfA, c4320niA, ia.b(), c4398qlA);
        this.j = c4455t4I.m();
        this.l = new C4103f0(keB);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Ya c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C4088ea d() {
        return this.d.e();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final String e() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final C4364pc i() {
        return this.k;
    }

    public final Pa j() {
        C4364pc c4364pc = this.k;
        Intrinsics.checkNotNull(c4364pc);
        return c4364pc.f11720a;
    }

    public final C4021bi k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean zA = a(orCreateMainPublicLogger, appMetricaConfig, new C4401r0(this, appMetricaConfig, orCreateMainPublicLogger));
        if (zA || this.m) {
            z = false;
        } else {
            a(appMetricaConfig, orCreateMainPublicLogger);
            z = true;
        }
        if (zA || z) {
            this.c.a(appMetricaConfig);
        } else {
            orCreateMainPublicLogger.warning("AppMetrica SDK already has been activated", new Object[0]);
        }
        if (zA) {
            ImportantLogger.INSTANCE.info(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA, "Activate AppMetrica with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        if (z) {
            ImportantLogger.INSTANCE.info(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA, "Upgrade AppMetrica anonymous mode to normal with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        this.m = true;
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void b(boolean z) {
        j().b(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        C4103f0 c4103f0 = this.l;
        AppMetricaConfig appMetricaConfigF = c4103f0.f11540a.f();
        if (appMetricaConfigF == null) {
            C4302n0 c4302n0 = c4103f0.b;
            c4302n0.getClass();
            AppMetricaConfig.Builder builderNewConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c4302n0.f11677a.c() && Intrinsics.areEqual(c4302n0.b.f11616a, Boolean.TRUE)) {
                builderNewConfigBuilder.handleFirstActivationAsUpdate(true);
            }
            Boolean bool = appMetricaLibraryAdapterConfig.advIdentifiersTracking;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            builderNewConfigBuilder.withAdvIdentifiersTracking(bool.booleanValue());
            appMetricaConfigF = builderNewConfigBuilder.build();
        }
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, appMetricaConfigF, new C4426s0(this, appMetricaConfigF, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA, "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.H6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, AbstractC4288mb.c(this.f.f11723a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, Cc cc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            C4314nc c4314ncA = cc.a();
            G7 g7 = new G7(c4314ncA);
            C4364pc c4364pc = new C4364pc(c4314ncA, g7);
            this.b.c().a(g7);
            this.k = c4364pc;
            C4606z5 c4606z5 = this.j.b;
            synchronized (c4606z5) {
                c4606z5.f11870a = c4314ncA;
                Iterator it = c4606z5.b.iterator();
                while (it.hasNext()) {
                    ((Sd) it.next()).consume(c4314ncA);
                }
                c4606z5.b.clear();
            }
            return true;
        }
        cc.a();
        return false;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        Boolean bool = appMetricaConfig.logs;
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            publicLogger.setEnabled(true);
            PublicLogger.INSTANCE.getAnonymousInstance().setEnabled(true);
        } else {
            publicLogger.setEnabled(false);
            PublicLogger.INSTANCE.getAnonymousInstance().setEnabled(false);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.crashReporting, bool2)).booleanValue()) {
            this.b.d().a(this.f11771a, appMetricaConfig, this);
            this.b.d().b();
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            Ak ak = this.j;
            synchronized (ak) {
                if (ak.g) {
                    ak.f11062a.b(ak.c, EnumC4276m.RESUMED);
                    ak.f11062a.b(ak.d, EnumC4276m.PAUSED);
                    ak.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        C4398ql c4398ql = this.d;
        c4398ql.e = publicLogger;
        c4398ql.b(appMetricaConfig.customHosts);
        C4398ql c4398ql2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        c4398ql2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        this.h.a(appMetricaConfig.locationTracking, appMetricaConfig.dataSendingEnabled, appMetricaConfig.advIdentifiersTracking);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Nc
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC3989ab
    public final Za a() {
        return this.g;
    }
}
