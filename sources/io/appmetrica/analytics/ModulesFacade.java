package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.AbstractC4121fi;
import io.appmetrica.analytics.impl.C4141gd;
import io.appmetrica.analytics.impl.C4191id;
import io.appmetrica.analytics.impl.C4215jd;
import io.appmetrica.analytics.impl.C4240kd;
import io.appmetrica.analytics.impl.C4265ld;
import io.appmetrica.analytics.impl.C4290md;
import io.appmetrica.analytics.impl.C4315nd;
import io.appmetrica.analytics.impl.C4352p0;

/* JADX INFO: loaded from: classes8.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C4315nd f10918a = new C4315nd();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        C4315nd c4315nd = f10918a;
        C4141gd c4141gd = c4315nd.b;
        c4141gd.b.a(context);
        c4141gd.d.a(str);
        c4315nd.c.f11780a.a(context.getApplicationContext().getApplicationContext());
        return AbstractC4121fi.f11553a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        C4315nd c4315nd = f10918a;
        c4315nd.b.getClass();
        c4315nd.c.getClass();
        c4315nd.f11684a.getClass();
        synchronized (C4352p0.class) {
            z = C4352p0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        C4315nd c4315nd = f10918a;
        c4315nd.b.f11568a.a(null);
        c4315nd.c.getClass();
        c4315nd.d.execute(new C4215jd(c4315nd, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        C4315nd c4315nd = f10918a;
        c4315nd.b.getClass();
        c4315nd.c.getClass();
        c4315nd.d.execute(new C4240kd(c4315nd, i, str));
    }

    public static void sendEventsBuffer() {
        C4315nd c4315nd = f10918a;
        c4315nd.b.getClass();
        c4315nd.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C4315nd c4315nd = f10918a;
        c4315nd.b.getClass();
        c4315nd.c.getClass();
        c4315nd.d.execute(new C4265ld(c4315nd, z));
    }

    public static void setProxy(C4315nd c4315nd) {
        f10918a = c4315nd;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        C4315nd c4315nd = f10918a;
        c4315nd.b.c.a(str);
        c4315nd.c.getClass();
        c4315nd.d.execute(new C4290md(c4315nd, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        C4315nd c4315nd = f10918a;
        boolean zBooleanValue = bool.booleanValue();
        c4315nd.b.getClass();
        c4315nd.c.getClass();
        c4315nd.d.execute(new C4191id(c4315nd, adRevenue, zBooleanValue));
    }
}
