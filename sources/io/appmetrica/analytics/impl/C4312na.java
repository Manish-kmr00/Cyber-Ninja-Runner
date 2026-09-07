package io.appmetrica.analytics.impl;

import android.os.Bundle;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.na, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4312na extends R4 {
    public C4312na(O4 o4) {
        super(o4);
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final boolean a(C3984a6 c3984a6, L4 l4) {
        Bundle bundle = c3984a6.m;
        this.f11322a.a(bundle != null ? (C4089eb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null);
        return false;
    }
}
