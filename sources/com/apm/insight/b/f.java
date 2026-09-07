package com.apm.insight.b;

import android.content.Context;

/* JADX INFO: compiled from: CrashANRHandler.java */
/* JADX INFO: loaded from: classes10.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f175a;
    private static g c;
    private final b b;

    public static f a(Context context) {
        if (f175a == null) {
            synchronized (f.class) {
                if (f175a == null) {
                    f175a = new f(context);
                }
            }
        }
        return f175a;
    }

    private f(Context context) {
        this.b = new b(context);
        g gVar = new g();
        c = gVar;
        gVar.a();
    }

    public final b a() {
        return this.b;
    }

    public static g b() {
        return c;
    }

    public final void c() {
        this.b.a();
    }

    public final void d() {
        this.b.b();
    }
}
