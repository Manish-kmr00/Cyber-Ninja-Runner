package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4021bi implements Za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11481a;
    public final C4367pf b;
    public final C4320ni c;
    public final Handler d;
    public final C4398ql e;
    public final C4588yc f;
    public final LinkedHashMap g;
    public final C4026bn h;
    public final List i;
    public C4314nc j;

    public C4021bi(Context context, C4367pf c4367pf, C4320ni c4320ni, Handler handler, C4398ql c4398ql) {
        this.f11481a = context;
        this.b = c4367pf;
        this.c = c4320ni;
        this.d = handler;
        this.e = c4398ql;
        this.f = new C4588yc(context, c4367pf, c4320ni, c4398ql);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new C4026bn(new C4071di(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC3989ab
    public final Za a() {
        return this;
    }

    public final C4021bi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Za
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final synchronized C4314nc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        C4314nc c4314nc;
        c4314nc = this.j;
        if (c4314nc == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c4314nc = new C4314nc(this.f);
            c4314nc.i = new C4462tb(this.d, c4314nc);
            C4398ql c4398ql = this.e;
            C4568xh c4568xh = c4314nc.b;
            if (c4398ql != null) {
                c4568xh.b.setUuid(c4398ql.g());
            } else {
                c4568xh.getClass();
            }
            c4314nc.a(appMetricaConfig, z);
            c4314nc.k();
            this.c.f.c = new C3996ai(c4314nc);
            this.g.put(appMetricaConfig.apiKey, c4314nc);
            this.j = c4314nc;
        }
        return c4314nc;
    }

    @Override // io.appmetrica.analytics.impl.Za
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final synchronized C4314nc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        C4314nc c4314nc;
        c4314nc = this.j;
        if (c4314nc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c4314nc.a(appMetricaConfig, z);
            C4455t4.i().getClass();
            this.g.put(appMetricaConfig.apiKey, c4314nc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c4314nc = new C4314nc(this.f);
            c4314nc.i = new C4462tb(this.d, c4314nc);
            C4398ql c4398ql = this.e;
            C4568xh c4568xh = c4314nc.b;
            if (c4398ql != null) {
                c4568xh.b.setUuid(c4398ql.g());
            } else {
                c4568xh.getClass();
            }
            c4314nc.a(appMetricaConfig, z);
            c4314nc.k();
            this.c.f.c = new C3996ai(c4314nc);
            this.g.put(appMetricaConfig.apiKey, c4314nc);
            C4455t4.i().getClass();
            this.j = c4314nc;
        }
        return c4314nc;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA, "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized Ya b(ReporterConfig reporterConfig) {
        Ya ya;
        ya = (Ya) this.g.get(reporterConfig.apiKey);
        if (ya == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f11481a;
            Ec ec = new Ec(context, this.b, reporterConfig, this.c, new T9(context));
            ec.i = new C4462tb(this.d, ec);
            C4398ql c4398ql = this.e;
            C4568xh c4568xh = ec.b;
            if (c4398ql != null) {
                c4568xh.b.setUuid(c4398ql.g());
            } else {
                c4568xh.getClass();
            }
            ec.k();
            this.g.put(reporterConfig.apiKey, ec);
            ya = ec;
        }
        return ya;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized InterfaceC4014bb b(AppMetricaConfig appMetricaConfig) {
        T2 c4507v6;
        c4507v6 = this.j;
        if (c4507v6 == null) {
            Context context = this.f11481a;
            c4507v6 = new C4507v6(context, this.b, appMetricaConfig, this.c, new T9(context));
            c4507v6.i = new C4462tb(this.d, c4507v6);
            C4398ql c4398ql = this.e;
            C4568xh c4568xh = c4507v6.b;
            if (c4398ql != null) {
                c4568xh.b.setUuid(c4398ql.g());
            } else {
                c4568xh.getClass();
            }
            c4507v6.b(appMetricaConfig.errorEnvironment);
            c4507v6.k();
        }
        return c4507v6;
    }
}
