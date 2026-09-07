package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3977a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11454a;

    public C3977a(Context context) {
        this.f11454a = context;
    }

    public final byte[] a() {
        try {
            return Wi.a(new StringBuilder(this.f11454a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public final byte[] b() {
        try {
            return Wi.a(this.f11454a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
