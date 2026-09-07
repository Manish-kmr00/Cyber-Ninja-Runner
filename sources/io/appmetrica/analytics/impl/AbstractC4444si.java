package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.si, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4444si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f11766a;
    public final String b;
    public final String c;

    public AbstractC4444si(Context context, String str, String str2) {
        this.f11766a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object a() {
        int identifier = this.f11766a.getResources().getIdentifier(this.b, this.c, this.f11766a.getPackageName());
        if (identifier == 0) {
            return null;
        }
        try {
            return a(identifier);
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract Object a(int i);
}
