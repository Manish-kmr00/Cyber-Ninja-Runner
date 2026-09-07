package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.q3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4380q3 extends AbstractC4444si {
    public C4380q3(Context context, String str) {
        super(context, str, "bool");
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4444si
    public final Object a(int i) {
        return Boolean.valueOf(this.f11766a.getResources().getBoolean(i));
    }

    public final Boolean b(int i) {
        return Boolean.valueOf(this.f11766a.getResources().getBoolean(i));
    }
}
