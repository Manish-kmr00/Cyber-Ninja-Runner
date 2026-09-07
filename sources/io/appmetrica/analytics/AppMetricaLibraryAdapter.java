package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.C4526w0;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public class AppMetricaLibraryAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C4526w0 f10912a = new C4526w0();

    public static void activate(Context context) {
        f10912a.a(context, AppMetricaLibraryAdapterConfig.newConfigBuilder().build());
    }

    public static void reportEvent(String str, String str2, String str3) {
        C4526w0 c4526w0 = f10912a;
        Gb gb = c4526w0.b;
        if (!gb.c.a((Void) null).f11273a || !gb.d.a(str).f11273a || !gb.e.a(str2).f11273a || !gb.f.a(str3).f11273a) {
            PublicLogger.INSTANCE.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
            return;
        }
        c4526w0.c.getClass();
        c4526w0.d.getClass();
        ModuleEvent.Builder builderWithName = ModuleEvent.newBuilder(4).withName("appmetrica_system_event_42");
        Pair[] pairArr = new Pair[3];
        if (str == null) {
            str = "null";
        }
        pairArr[0] = TuplesKt.to("sender", str);
        if (str2 == null) {
            str2 = "null";
        }
        pairArr[1] = TuplesKt.to("event", str2);
        if (str3 == null) {
            str3 = "null";
        }
        pairArr[2] = TuplesKt.to("payload", str3);
        ModulesFacade.reportEvent(builderWithName.withAttributes(MapsKt.mapOf(pairArr)).build());
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        C4526w0 c4526w0 = f10912a;
        if (c4526w0.b.c.a((Void) null).f11273a) {
            c4526w0.c.getClass();
            ModulesFacade.setAdvIdentifiersTracking(z);
        }
    }

    public static void setProxy(C4526w0 c4526w0) {
        f10912a = c4526w0;
    }

    public static void activate(Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f10912a.a(context, appMetricaLibraryAdapterConfig);
    }
}
