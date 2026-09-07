package com.inmobi.media;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class M3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K3 f3132a;
    public final InterfaceC3585u9 b;
    public final InterfaceC3458la c;
    public final String d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final LinkedList g;
    public ScheduledExecutorService h;
    public J3 i;

    public M3(K3 mEventDao, InterfaceC3585u9 mPayloadProvider, J3 eventConfig, InterfaceC3458la interfaceC3458la) {
        Intrinsics.checkNotNullParameter(mEventDao, "mEventDao");
        Intrinsics.checkNotNullParameter(mPayloadProvider, "mPayloadProvider");
        Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
        this.f3132a = mEventDao;
        this.b = mPayloadProvider;
        this.c = interfaceC3458la;
        this.d = "M3";
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new LinkedList();
        this.i = eventConfig;
    }

    public final void a(long j, final boolean z) {
        if (this.g.contains("default")) {
            return;
        }
        this.g.add("default");
        if (this.h == null) {
            String TAG = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            this.h = Executors.newSingleThreadScheduledExecutor(new V4(TAG));
        }
        Intrinsics.checkNotNullExpressionValue(this.d, "TAG");
        ScheduledExecutorService scheduledExecutorService = this.h;
        if (scheduledExecutorService != null) {
            final C3545rc c3545rc = null;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.M3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    M3.a(this.f$0, c3545rc, z);
                }
            };
            J3 j3 = this.i;
            K3 k3 = this.f3132a;
            k3.getClass();
            Context contextD = C3517pb.d();
            long j2 = -1;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "batch_processing_info");
                String key = k3.f3045a.concat("_last_batch_process");
                Intrinsics.checkNotNullParameter(key, "key");
                j2 = k5A.f3112a.getLong(key, -1L);
            }
            if (((int) j2) == -1) {
                this.f3132a.a(System.currentTimeMillis());
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            scheduledExecutorService.scheduleAtFixedRate(runnable, Math.max(0L, (timeUnit.toSeconds(j2) + (j3 != null ? j3.c : 0L)) - timeUnit.toSeconds(System.currentTimeMillis())), j, TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00de  */
    public static final void a(M3 listener, C3545rc c3545rc, boolean z) {
        int i;
        long j;
        boolean z2;
        boolean z3;
        L3 payload;
        Intrinsics.checkNotNullParameter(listener, "this$0");
        J3 j3 = listener.i;
        if (listener.f.get() || listener.e.get() || j3 == null) {
            return;
        }
        String TAG = listener.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        K3 k3 = listener.f3132a;
        long j2 = j3.b;
        k3.getClass();
        k3.a("ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (j2 * ((long) 1000)))});
        Intrinsics.checkNotNullExpressionValue("K3", "TAG");
        K3 k4 = listener.f3132a;
        k4.getClass();
        int iA = D1.a((D1) k4);
        int iP = C3435k3.f3355a.p();
        J3 j4 = listener.i;
        if (j4 == null) {
            i = 0;
        } else if (iP == 0 || iP != 1) {
            i = j4.g;
        } else {
            i = j4.e;
        }
        if (j4 == null) {
            j = 0;
        } else if (iP == 0 || iP != 1) {
            j = j4.j;
        } else {
            j = j4.i;
        }
        K3 k5 = listener.f3132a;
        long j5 = j3.d;
        ArrayList arrayListB = k5.b(1);
        if (arrayListB.isEmpty()) {
            z2 = false;
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = arrayListB.get(0);
            Intrinsics.checkNotNull(obj);
            if (timeUnit.toSeconds(jCurrentTimeMillis - ((E1) obj).b) > j5) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        K3 k6 = listener.f3132a;
        long j6 = j3.c;
        long j7 = j3.d;
        k6.getClass();
        Intrinsics.checkNotNullExpressionValue("K3", "TAG");
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long seconds = timeUnit2.toSeconds(System.currentTimeMillis()) + j6;
        ArrayList arrayListB2 = k6.b(1);
        if (arrayListB2.isEmpty()) {
            z3 = false;
        } else {
            Object obj2 = arrayListB2.get(0);
            Intrinsics.checkNotNull(obj2);
            if (seconds - timeUnit2.toSeconds(((E1) obj2).b) >= j7) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        if ((i <= iA || z2 || z3) && (payload = listener.b.a()) != null) {
            listener.e.set(true);
            Lazy lazy = O3.f3154a;
            String str = j3.k;
            int i2 = 1 + j3.f3104a;
            Intrinsics.checkNotNullParameter(payload, "payload");
            Intrinsics.checkNotNullParameter(listener, "listener");
            O3.a(payload, str, i2, i2, j, c3545rc, listener, z);
        }
    }

    public final void a(L3 eventPayload, boolean z) {
        Intrinsics.checkNotNullParameter(eventPayload, "eventPayload");
        String TAG = this.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        eventPayload.getClass();
        this.f3132a.a(System.currentTimeMillis());
        if (this.c != null) {
            ArrayList eventIds = eventPayload.f3122a;
            Intrinsics.checkNotNullParameter(eventIds, "eventIds");
            Integer num = Tb.c;
            if (num != null && eventIds.contains(Integer.valueOf(num.intValue()))) {
                Tb.c = null;
            }
        }
        this.e.set(false);
    }
}
