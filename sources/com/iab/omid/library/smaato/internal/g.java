package com.iab.omid.library.smaato.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2914a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2914a;
    }

    public void a(Context context) {
        this.f2914a = context != null ? context.getApplicationContext() : null;
    }
}
