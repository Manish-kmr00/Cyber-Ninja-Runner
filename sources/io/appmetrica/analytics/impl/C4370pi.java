package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4370pi extends R4 {
    public C4370pi(O4 o4) {
        super(o4);
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final boolean a(C3984a6 c3984a6, L4 l4) {
        Bundle bundle = c3984a6.m;
        this.f11322a.k.a(new N4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
