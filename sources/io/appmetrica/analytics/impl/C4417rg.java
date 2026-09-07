package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.rg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4417rg implements T7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4307n5 f11751a;

    public C4417rg(InterfaceC4307n5 interfaceC4307n5) {
        this.f11751a = interfaceC4307n5;
    }

    @Override // io.appmetrica.analytics.impl.T7
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4393qg a(Context context, C4108f5 c4108f5, G4 g4) {
        return new C4393qg(context, c4108f5, g4, this.f11751a, new C4133g5(), C4223jl.a());
    }

    public final InterfaceC4307n5 a() {
        return this.f11751a;
    }
}
