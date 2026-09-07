package com.inmobi.media;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3318bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rb f3278a;
    public final C3429jb b;
    public final C3332cc c;

    public C3318bc(Rb telemetryConfigMetaData, List samplingEvents) {
        Intrinsics.checkNotNullParameter(telemetryConfigMetaData, "telemetryConfigMetaData");
        Intrinsics.checkNotNullParameter(samplingEvents, "samplingEvents");
        this.f3278a = telemetryConfigMetaData;
        double dRandom = Math.random();
        this.b = new C3429jb(telemetryConfigMetaData, dRandom, samplingEvents);
        this.c = new C3332cc(telemetryConfigMetaData, dRandom);
    }

    public final int a(Sb telemetryEventType, String eventType) {
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        int iOrdinal = telemetryEventType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            C3332cc c3332cc = this.c;
            c3332cc.getClass();
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            if (c3332cc.b < c3332cc.f3286a.g) {
                Ob ob = Ob.f3160a;
                return 2;
            }
            return 0;
        }
        C3429jb c3429jb = this.b;
        c3429jb.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (!c3429jb.c.contains(eventType)) {
            return 1;
        }
        if (c3429jb.b < c3429jb.f3349a.g) {
            Ob ob2 = Ob.f3160a;
            return 2;
        }
        return 0;
    }
}
