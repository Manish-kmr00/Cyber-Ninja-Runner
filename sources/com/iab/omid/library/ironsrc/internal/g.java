package com.iab.omid.library.ironsrc.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2701a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2701a;
    }

    public void a(Context context) {
        this.f2701a = context != null ? context.getApplicationContext() : null;
    }
}
