package com.iab.omid.library.amazon.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2452a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2452a;
    }

    public void a(Context context) {
        this.f2452a = context != null ? context.getApplicationContext() : null;
    }
}
