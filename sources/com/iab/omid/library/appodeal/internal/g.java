package com.iab.omid.library.appodeal.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2524a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2524a;
    }

    public void a(Context context) {
        this.f2524a = context != null ? context.getApplicationContext() : null;
    }
}
