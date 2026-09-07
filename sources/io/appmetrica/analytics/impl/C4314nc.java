package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4314nc extends T2 implements Pa {
    public static final Long r = Long.valueOf(TimeUnit.SECONDS.toMillis(1));
    public final C4026bn o;
    public final C4588yc p;
    public final C4339oc q;

    public C4314nc(C4588yc c4588yc) {
        super(c4588yc.b(), c4588yc.i(), c4588yc.h(), c4588yc.d(), c4588yc.f(), c4588yc.j(), c4588yc.g(), c4588yc.c(), c4588yc.a(), c4588yc.e());
        this.o = new C4026bn(new Rd("Referral url"));
        this.p = c4588yc;
        this.q = new C4339oc(this);
        l();
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        HashMap map = new HashMap();
        map.put("type", "open");
        map.put("link", str);
        map.put("auto", Boolean.valueOf(z));
        String strB = AbstractC4288mb.b(map);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(strB, "", 8208, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void b(String str) {
        this.o.a(str);
        C4320ni c4320ni = this.h;
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        HashMap map = new HashMap();
        map.put("type", "referral");
        map.put("link", str);
        map.put("auto", Boolean.FALSE);
        String strB = AbstractC4288mb.b(map);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(strB, "", 8208, 0, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void c() {
        C4339oc c4339oc = this.q;
        synchronized (c4339oc) {
            c4339oc.b.a(c4339oc.f11701a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final List<String> f() {
        return this.b.f11474a.b();
    }

    @Override // io.appmetrica.analytics.impl.T2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.T2
    public final void k() {
        super.k();
        C4455t4.i().k().b();
    }

    public final void l() {
        C4320ni c4320ni = this.h;
        c4320ni.c.a(this.b.f11474a);
        C4180i2 c4180i2 = this.p.f;
        C4289mc c4289mc = new C4289mc(this);
        long jLongValue = r.longValue();
        synchronized (c4180i2) {
            c4180i2.a(c4289mc, jLongValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(EnumC4326o enumC4326o) {
        if (enumC4326o == EnumC4326o.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
        } else {
            this.c.warning("Could not enable activity auto tracking. " + enumC4326o.f11691a, new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void b(Activity activity) {
        if (this.p.h.a(activity, EnumC4376q.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C4180i2 c4180i2 = this.p.f;
            synchronized (c4180i2) {
                c4180i2.getClass();
                for (C4155h2 c4155h2 : c4180i2.f11593a) {
                    if (!c4155h2.d) {
                        c4155h2.d = true;
                        c4155h2.b.executeDelayed(c4155h2.e, c4155h2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(Activity activity) {
        if (this.p.h.a(activity, EnumC4376q.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C4180i2 c4180i2 = this.p.f;
            synchronized (c4180i2) {
                c4180i2.getClass();
                for (C4155h2 c4155h2 : c4180i2.f11593a) {
                    if (c4155h2.d) {
                        c4155h2.d = false;
                        c4155h2.b.remove(c4155h2.e);
                        C4314nc c4314nc = c4155h2.f11577a.f11670a;
                        c4314nc.h.c.b(c4314nc.b.f11474a);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Nc
    public final void b(boolean z) {
        this.c.info("Set advIdentifiersTracking to %s", Boolean.valueOf(z));
        this.b.b.setAdvIdentifiersTracking(z);
    }

    public final void a(AppMetricaConfig appMetricaConfig, boolean z) {
        if (z) {
            clearAppEnvironment();
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        boolean zBooleanValue = ((Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.c.info("native crash reporting enabled: %b", Boolean.valueOf(zBooleanValue));
        if (zBooleanValue) {
            Ad ad = this.p.c;
            Context context = this.f11358a;
            ad.d = new C4601z0(this.b.b.getApiKey(), ad.f11058a.f11723a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, ad.f11058a.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), ad.f11058a.f11723a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            C4601z0 c4601z0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = ad.b;
                A0 a0 = ad.c;
                C4601z0 c4601z1 = ad.d;
                if (c4601z1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nativeCrashMetadata");
                } else {
                    c4601z0 = c4601z1;
                }
                a0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, A0.a(c4601z0)));
            }
        }
        C4339oc c4339oc = this.q;
        synchronized (c4339oc) {
            Integer num = appMetricaConfig.anrMonitoringTimeout;
            c4339oc.f11701a = num != null ? num.intValue() : 5;
            Boolean bool = appMetricaConfig.anrMonitoring;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                c4339oc.b.a(c4339oc.f11701a);
            } else {
                c4339oc.b.b();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Nc
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Nc
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(Cdo cdo) {
        PublicLogger publicLogger = this.c;
        synchronized (cdo) {
            cdo.b = publicLogger;
        }
        Iterator it = cdo.f11523a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        cdo.f11523a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(AnrListener anrListener) {
        this.q.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        C4320ni c4320ni = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(bytes, "", 42, publicLogger);
        C4568xh c4568xh = this.b;
        c4320ni.getClass();
        c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Nc
    public final void a(String str, String str2) {
        super.a(str, str2);
        Ad ad = this.p.c;
        String strD = this.b.d();
        C4601z0 c4601z0 = ad.d;
        if (c4601z0 != null) {
            C4601z0 c4601z1 = new C4601z0(c4601z0.f11867a, c4601z0.b, c4601z0.c, c4601z0.d, c4601z0.e, strD);
            ad.d = c4601z1;
            NativeCrashClientModule nativeCrashClientModule = ad.b;
            ad.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(A0.a(c4601z1));
        }
    }
}
