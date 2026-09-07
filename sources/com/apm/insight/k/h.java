package com.apm.insight.k;

import android.content.Context;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.q;

/* JADX INFO: compiled from: LaunchScanner.java */
/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f241a;

    private h(Context context) {
        this.f241a = context;
    }

    public static boolean a() {
        return b.a().c() || !com.apm.insight.l.a.c(com.apm.insight.e.g());
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.apm.insight.b.f.a(this.f241a).a().f();
        } catch (Throwable unused) {
        }
        try {
            if (com.apm.insight.l.a.c(this.f241a)) {
                b.a().a(com.apm.insight.l.k.b(this.f241a));
            } else {
                NativeImpl.j();
            }
            q.a().a(com.apm.insight.e.a().b(), com.apm.insight.entity.b.b());
            if (n.a().a() == null) {
            }
        } catch (Throwable th) {
            try {
                com.apm.insight.a.b(th);
            } finally {
                q.a().a(com.apm.insight.e.a().b(), com.apm.insight.entity.b.b());
                if (n.a().a() != null) {
                    com.apm.insight.j.d.a(n.a().a(), this.f241a).a();
                }
            }
        }
    }

    public static void a(Context context) {
        n.a().a(new h(context), 0L);
    }
}
