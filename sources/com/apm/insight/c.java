package com.apm.insight;

import com.apm.insight.l.g;

/* JADX INFO: compiled from: Ensure.java */
/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.apm.insight.b.a f187a = new com.apm.insight.b.a();

    public static com.apm.insight.b.a a() {
        return f187a;
    }

    public static void a(Throwable th, String str) {
        if (!e.i().isEnsureEnable() || g.a(th)) {
            return;
        }
        com.apm.insight.f.b.a(th, str, "core_exception_monitor");
    }
}
