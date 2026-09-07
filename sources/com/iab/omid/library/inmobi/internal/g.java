package com.iab.omid.library.inmobi.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2666a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2666a;
    }

    public void a(Context context) {
        this.f2666a = context != null ? context.getApplicationContext() : null;
    }
}
