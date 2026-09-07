package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.n;

/* JADX INFO: compiled from: ANRThread.java */
/* JADX INFO: loaded from: classes10.dex */
public final class c {
    private static long b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f170a;
    private boolean c = false;
    private final Runnable d;

    c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (c.this.c) {
                    return;
                }
                c.this.f170a.d();
                long unused = c.b = SystemClock.uptimeMillis();
                if (com.apm.insight.runtime.j.a().b()) {
                    n.a().a(c.this.d, 500L);
                } else {
                    n.a().a(c.this.d, 500L);
                }
                com.apm.insight.runtime.b.a(c.b);
            }
        };
        this.d = runnable;
        this.f170a = bVar;
        n.a().a(runnable, 5000L);
    }

    public final void a() {
        if (this.c) {
            return;
        }
        n.a().a(this.d, 5000L);
    }

    public final void b() {
        this.c = true;
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - b <= 15000;
    }
}
