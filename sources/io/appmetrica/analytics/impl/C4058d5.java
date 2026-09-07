package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.d5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4058d5 implements InterfaceC4560x9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4556x5 f11509a;

    public C4058d5(B9 b9, S6 s6, Fg fg, C4108f5 c4108f5) {
        C4033c5 c4033c5 = new C4033c5(s6, fg);
        this.f11509a = new C4556x5(b9, c4033c5.a(), c4033c5.b(), c4108f5);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4560x9
    public final InterfaceC4535w9 a() {
        return this.f11509a;
    }

    public final C4556x5 b() {
        return this.f11509a;
    }
}
