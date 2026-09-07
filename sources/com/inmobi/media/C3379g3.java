package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.CrashConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.g3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3379g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile CrashConfig f3323a;
    public final P6 b;
    public final List c;

    public C3379g3(Context context, CrashConfig crashConfig, P6 eventBus) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        this.f3323a = crashConfig;
        this.b = eventBus;
        List listSynchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
        this.c = listSynchronizedList;
        if (this.f3323a.getCrashConfig().getEnabled()) {
            listSynchronizedList.add(new Q2(Thread.getDefaultUncaughtExceptionHandler(), this));
        }
        if (this.f3323a.getAnr().getAppExitReason().getEnabled() && C3435k3.f3355a.z()) {
            listSynchronizedList.add(new M0(context, this, this.f3323a.getAnr().getAppExitReason().getIncidentWaitInterval(), this.f3323a.getAnr().getAppExitReason().getMaxNumberOfLines()));
        }
        if (this.f3323a.getAnr().getWatchdog().getEnabled()) {
            listSynchronizedList.add(new C3305b(this.f3323a.getAnr().getWatchdog().getInterval(), this));
        }
    }

    public final void a(C3353e5 incidentEvent) {
        int i;
        Intrinsics.checkNotNullParameter(incidentEvent, "incidentEvent");
        if ((incidentEvent instanceof N0) && this.f3323a.getAnr().getAppExitReason().getEnabled()) {
            i = 152;
        } else if ((incidentEvent instanceof R2) && this.f3323a.getCrashConfig().getEnabled()) {
            i = 150;
        } else if (!(incidentEvent instanceof gd) || !this.f3323a.getAnr().getWatchdog().getEnabled()) {
            return;
        } else {
            i = 151;
        }
        this.b.b(new N1(i, incidentEvent.f3054a, MapsKt.mapOf(TuplesKt.to("data", incidentEvent))));
    }
}
