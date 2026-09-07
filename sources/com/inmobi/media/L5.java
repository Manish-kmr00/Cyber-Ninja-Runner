package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class L5 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M5 f3123a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L5(M5 m5) {
        super(1);
        this.f3123a = m5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f3141a;
        if (i != 1 && i != 2) {
            switch (i) {
                case 150:
                case 151:
                case 152:
                    Map map = it.c;
                    if (map != null && map.containsKey("data")) {
                        Object obj2 = it.c.get("data");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.incident.IncidentEvent");
                        this.f3123a.b((C3353e5) obj2);
                    }
                    break;
            }
        } else {
            M5 m5 = this.f3123a;
            M3 m3 = m5.b;
            if (m3 != null) {
                ScheduledExecutorService scheduledExecutorService = m3.h;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                m3.h = null;
                m3.e.set(false);
                m3.f.set(true);
                m3.g.clear();
                m3.i = null;
            }
            C3517pb.f().a(m5.d);
        }
        return Unit.INSTANCE;
    }
}
