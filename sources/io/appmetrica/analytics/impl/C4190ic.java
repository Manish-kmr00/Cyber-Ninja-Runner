package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ic, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4190ic implements InterfaceC4560x9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4556x5 f11602a;

    public C4190ic(B9 b9, S6 s6, Fg fg, F4 f4, C4108f5 c4108f5, Le le) {
        C4165hc c4165hc = new C4165hc(s6, fg, this, f4, le);
        this.f11602a = new C4556x5(b9, c4165hc.a(), c4165hc.b(), c4108f5);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4560x9
    public final InterfaceC4535w9 a() {
        return this.f11602a;
    }

    public final C4556x5 b() {
        return this.f11602a;
    }
}
