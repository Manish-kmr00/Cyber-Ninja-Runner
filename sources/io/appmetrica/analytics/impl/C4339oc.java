package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.oc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4339oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11701a = 5;
    public final C4077e b;

    public C4339oc(InterfaceC3978a0 interfaceC3978a0) {
        this.b = new C4077e(new Ib(interfaceC3978a0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C4077e c4077e = this.b;
        c4077e.f11524a.add(new InterfaceC4027c() { // from class: io.appmetrica.analytics.impl.oc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC4027c
            public final void onAppNotResponding() {
                C4339oc.b(anrListener);
            }
        });
    }
}
