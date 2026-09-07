package com.iab.omid.library.pubnativenet.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes11.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2877a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2877a;
    }

    public void a(Context context) {
        this.f2877a = context != null ? context.getApplicationContext() : null;
    }
}
