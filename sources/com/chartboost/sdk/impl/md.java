package com.chartboost.sdk.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public class md {
    public static md b = new md();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1080a;

    public static md b() {
        return b;
    }

    public Context a() {
        return this.f1080a;
    }

    public void a(Context context) {
        this.f1080a = context != null ? context.getApplicationContext() : null;
    }
}
