package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes11.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2738a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2738a;
    }

    public void a(Context context) {
        this.f2738a = context != null ? context.getApplicationContext() : null;
    }
}
