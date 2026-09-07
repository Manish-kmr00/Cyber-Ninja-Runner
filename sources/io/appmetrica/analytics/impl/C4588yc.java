package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4588yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11858a;
    public final C4320ni b;
    public final Ad c;
    public final T9 d;
    public final C4568xh e;
    public final C4180i2 f;
    public final C4264lc g;
    public final r h;
    public final C4590ye i;
    public final C4350on j;
    public final C4467tg k;
    public final C6 l;
    public final X m;

    public C4588yc(Context context, C4367pf c4367pf, C4320ni c4320ni, C4398ql c4398ql) {
        this.f11858a = context;
        this.b = c4320ni;
        this.c = new Ad(c4367pf);
        T9 t9 = new T9(context);
        this.d = t9;
        this.e = new C4568xh(c4367pf, new CounterConfiguration(CounterConfigurationReporterType.MAIN));
        this.f = new C4180i2();
        this.g = C4455t4.i().l();
        this.h = new r();
        this.i = new C4590ye(t9);
        this.j = new C4350on();
        this.k = new C4467tg();
        this.l = new C6();
        this.m = new X();
    }

    public final X a() {
        return this.m;
    }

    public final Context b() {
        return this.f11858a;
    }

    public final C6 c() {
        return this.l;
    }

    public final T9 d() {
        return this.d;
    }

    public final C4590ye e() {
        return this.i;
    }

    public final C4264lc f() {
        return this.g;
    }

    public final C4467tg g() {
        return this.k;
    }

    public final C4568xh h() {
        return this.e;
    }

    public final C4320ni i() {
        return this.b;
    }

    public final C4350on j() {
        return this.j;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.e.b.applyFromConfig(appMetricaConfig);
        C4568xh c4568xh = this.e;
        String str = appMetricaConfig.userProfileID;
        synchronized (c4568xh) {
            c4568xh.f = str;
        }
        C4568xh c4568xh2 = this.e;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        c4568xh2.d = new C4217jf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
