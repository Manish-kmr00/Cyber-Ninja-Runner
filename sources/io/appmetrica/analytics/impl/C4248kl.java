package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.kl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4248kl extends B5 {
    public C4248kl(Cl cl, Hl hl, Bl bl) {
        super(cl, hl, bl);
    }

    @Override // io.appmetrica.analytics.impl.B5
    public final synchronized void a(Bl bl) {
        a(new W5(c(), C4486ua.E.u(), C4486ua.E.r(), ((Bl) b()).mergeFrom(bl)));
        e();
    }
}
