package com.digitalturbine.ignite.authenticator.events;

import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final b b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1233a;

    public static void a(d dVar, Exception exc) {
        a(dVar, com.digitalturbine.ignite.authenticator.utils.events.a.a(exc, null));
    }

    public static void a(d dVar, Object... objArr) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : dispatching event", "IgniteEventDispatcher");
        if (b.f1233a != null) {
            EnumC3143t enumC3143tA = EnumC3143t.a(dVar);
            if (enumC3143tA == null) {
                IAlog.f("%s : One DT Error: %s is missing in IAReportError map", "IgniteEventDispatcherWrapper", dVar);
            } else {
                new C3146w(enumC3143tA).a(objArr).a((String) null);
            }
        }
    }
}
