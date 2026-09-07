package io.appmetrica.analytics.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Y4 implements InterfaceC4085e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11430a;
    public final String b;

    public Y4(C4108f5 c4108f5) {
        this.f11430a = String.format("component_%s.db", Arrays.copyOf(new Object[]{c4108f5.d() ? com.ironsource.b9.h.Z : c4108f5.b()}, 1));
        this.b = "db_metrica_" + c4108f5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4085e7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4085e7
    public final String b() {
        return this.f11430a;
    }
}
