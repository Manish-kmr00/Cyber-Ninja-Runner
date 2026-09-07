package com.inmobi.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class O3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3154a = LazyKt.lazy(N3.f3143a);

    public static final void a(S8 mRequest, M3 listener, L3 eventPayload, int i, String str, int i2, long j, C3545rc c3545rc, boolean z) {
        Intrinsics.checkNotNullParameter(mRequest, "$request");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(eventPayload, "$eventPayload");
        Intrinsics.checkNotNullParameter(mRequest, "mRequest");
        T8 t8B = mRequest.b();
        if (t8B.b()) {
            boolean z2 = W8.f3228a;
            P8 p8 = t8B.c;
            I3 i3 = p8 != null ? p8.f3168a : null;
            if (W8.f3228a && (i3 == I3.q || i3 == I3.p || i3 == I3.o || i3 == I3.n || i3 == I3.r)) {
                listener.a(eventPayload, false);
                return;
            } else {
                if (i <= 1) {
                    listener.a(eventPayload, true);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue("O3", "TAG");
                t8B.a();
                a(eventPayload, str, i2, i - 1, j, c3545rc, listener, z);
                return;
            }
        }
        listener.getClass();
        Intrinsics.checkNotNullParameter(eventPayload, "eventPayload");
        String TAG = listener.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        listener.f3132a.a(eventPayload.f3122a);
        listener.f3132a.a(System.currentTimeMillis());
        if (listener.c != null) {
            ArrayList eventIds = eventPayload.f3122a;
            Intrinsics.checkNotNullParameter(eventIds, "eventIds");
            Integer num = Tb.c;
            if (num != null && eventIds.contains(Integer.valueOf(num.intValue()))) {
                Tb.b = 0;
                K5 k5 = Tb.f3205a;
                if (k5 != null) {
                    k5.a("count", 0);
                }
                Tb.c = null;
            }
        }
        listener.e.set(false);
    }

    public static void a(final L3 l3, final String str, final int i, final int i2, final long j, final C3545rc c3545rc, final M3 m3, final boolean z) {
        long j2;
        HashMap mapHashMapOf;
        HashMap map;
        Intrinsics.checkNotNullExpressionValue("O3", "TAG");
        boolean z2 = W8.f3228a;
        if (W8.a(false) == null && C3517pb.m()) {
            final S8 s8 = new S8("POST", str, c3545rc, false, (L4) null, (String) null, 104);
            HashMap mapHashMapOf2 = MapsKt.hashMapOf(TuplesKt.to("payload", l3.b));
            if (mapHashMapOf2 != null && (map = s8.k) != null) {
                map.putAll(mapHashMapOf2);
            }
            int i3 = i - i2;
            if (i3 > 0 && (mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("X-im-retry-count", String.valueOf(i3)))) != null) {
                s8.i.putAll(mapHashMapOf);
            }
            s8.x = false;
            s8.t = false;
            s8.u = false;
            if (z) {
                long jPow = i2 != i ? ((long) Math.pow(2.0d, i3)) * j : 0L;
                j2 = jPow;
                Object value = f3154a.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                ((ScheduledExecutorService) value).schedule(new Runnable() { // from class: com.inmobi.media.O3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        O3.a(s8, m3, l3, i2, str, i, j, c3545rc, z);
                    }
                }, j2, TimeUnit.SECONDS);
                return;
            }
            if (i2 != i) {
                j2 = j;
            }
            Object value2 = f3154a.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
            ((ScheduledExecutorService) value2).schedule(new Runnable() { // from class: com.inmobi.media.O3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    O3.a(s8, m3, l3, i2, str, i, j, c3545rc, z);
                }
            }, j2, TimeUnit.SECONDS);
            return;
            j2 = jPow;
            Object value3 = f3154a.getValue();
            Intrinsics.checkNotNullExpressionValue(value3, "getValue(...)");
            ((ScheduledExecutorService) value3).schedule(new Runnable() { // from class: com.inmobi.media.O3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    O3.a(s8, m3, l3, i2, str, i, j, c3545rc, z);
                }
            }, j2, TimeUnit.SECONDS);
            return;
        }
        Intrinsics.checkNotNullExpressionValue("O3", "TAG");
        m3.a(l3, false);
    }
}
