package com.iab.omid.library.pubmatic.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2840a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2840a;
    }

    public void a(Context context) {
        this.f2840a = context != null ? context.getApplicationContext() : null;
    }
}
