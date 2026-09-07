package com.ogury.ad.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m4 f7354a = new m4();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final Handler c = new Handler(Looper.getMainLooper());
    public static final Runnable d = new Runnable() { // from class: com.ogury.ad.internal.m4$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            m4.a();
        }
    };
    public static final t7 e = t7.f7405a;
    public static final e9 f = new e9();

    public static final void a() {
        b();
    }

    public static void b() {
        u3 u3Var = u3.f7411a;
        ConcurrentHashMap concurrentHashMap = b;
        String str = "clean cache " + concurrentHashMap.size();
        u3Var.getClass();
        c();
        d();
        String str2 = "after cache " + concurrentHashMap.size();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    public static l4 c() {
        u5 u5Var;
        Long l;
        Iterator it = b.entrySet().iterator();
        while (it.hasNext()) {
            l4 l4Var = (l4) ((Map.Entry) it.next()).getValue();
            f.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis() - l4Var.d;
            a1 a1Var = l4Var.c.G;
            if (a1Var == null || (l = a1Var.f7256a) == null) {
                e.getClass();
                if (jCurrentTimeMillis > TimeUnit.SECONDS.toMillis(t7.b.d.d)) {
                    it.remove();
                    z3 z3Var = z3.f7460a;
                    z3.a(new h9("expired", l4Var.c));
                    u5Var = l4Var.f7343a.get();
                    if (u5Var != null) {
                        u5Var.b(l4Var.c);
                    }
                    return l4Var;
                }
            } else if (jCurrentTimeMillis > TimeUnit.SECONDS.toMillis(l.longValue())) {
                it.remove();
                z3 z3Var2 = z3.f7460a;
                z3.a(new h9("expired", l4Var.c));
                u5Var = l4Var.f7343a.get();
                if (u5Var != null) {
                    u5Var.b(l4Var.c);
                }
                return l4Var;
            }
        }
        return null;
    }

    public static void d() {
        Iterator it = b.entrySet().iterator();
        while (it.hasNext()) {
            if (((l4) ((Map.Entry) it.next()).getValue()).f7343a.get() == null) {
                it.remove();
            }
        }
        Handler handler = c;
        handler.removeCallbacksAndMessages(null);
        if (b.isEmpty()) {
            return;
        }
        handler.postDelayed(d, com.safedk.android.internal.d.N);
    }
}
