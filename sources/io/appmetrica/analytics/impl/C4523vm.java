package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4523vm extends AbstractC4444si {
    public C4523vm(Context context, String str) {
        super(context, str, "array");
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4444si
    public final Object a(int i) {
        return this.f11766a.getResources().getStringArray(i);
    }

    public final String[] b(int i) {
        return this.f11766a.getResources().getStringArray(i);
    }
}
