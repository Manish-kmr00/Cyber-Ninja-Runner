package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C4094eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ua f11534a;
    public final Zf b;
    public final Sa c;

    public C4094eg(Ua ua, Zf zf, Sa sa) {
        this.f11534a = ua;
        this.b = zf;
        this.c = sa;
    }

    public final void a(C4044cg c4044cg) {
        if (this.f11534a.a(c4044cg)) {
            this.b.a(c4044cg);
            this.c.a();
        }
    }

    public final Zf b() {
        return this.b;
    }

    public final Sa c() {
        return this.c;
    }

    public final Ua a() {
        return this.f11534a;
    }
}
