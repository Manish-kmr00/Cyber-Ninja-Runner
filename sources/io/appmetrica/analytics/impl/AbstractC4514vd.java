package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4514vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static D9 f11815a;

    public static final synchronized D9 a(Context context) {
        D9 d9;
        d9 = f11815a;
        if (d9 == null) {
            d9 = new D9(context, "uuid.dat");
            f11815a = d9;
        }
        return d9;
    }
}
