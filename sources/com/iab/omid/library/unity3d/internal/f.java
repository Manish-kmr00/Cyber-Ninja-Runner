package com.iab.omid.library.unity3d.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class f {
    private static f b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2950a;

    private f() {
    }

    public static f b() {
        return b;
    }

    public Context a() {
        return this.f2950a;
    }

    public void a(Context context) {
        this.f2950a = context != null ? context.getApplicationContext() : null;
    }
}
