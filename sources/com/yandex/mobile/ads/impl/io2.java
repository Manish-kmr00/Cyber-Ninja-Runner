package com.yandex.mobile.ads.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public final class io2 {
    private static io2 b = new io2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9251a;

    private io2() {
    }

    public static io2 a() {
        return b;
    }

    public final Context b() {
        return this.f9251a;
    }

    public final void a(Context context) {
        this.f9251a = context != null ? context.getApplicationContext() : null;
    }
}
