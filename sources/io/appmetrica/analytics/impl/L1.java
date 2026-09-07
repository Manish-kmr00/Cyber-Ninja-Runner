package io.appmetrica.analytics.impl;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public final class L1 implements Oj {
    public static final K1 b = new K1();
    public static final int c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4252l0 f11234a;

    public L1(InterfaceC4252l0 interfaceC4252l0) {
        this.f11234a = interfaceC4252l0;
    }

    @Override // io.appmetrica.analytics.impl.Oj
    public final void reportData(int i, Bundle bundle) {
        ((I1) this.f11234a).a(bundle);
    }
}
