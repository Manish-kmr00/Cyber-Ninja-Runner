package com.yandex.mobile.ads.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public final class do2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8718a;

    final void a(Context context) {
        if (context != null) {
            if (this.f8718a) {
                return;
            }
            this.f8718a = true;
            to2.a().a(context);
            xn2.a().a(context);
            zn2.a(context);
            io2.a().a(context);
            return;
        }
        throw new IllegalArgumentException("Application Context cannot be null");
    }

    final boolean a() {
        return this.f8718a;
    }
}
