package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC4614zd implements Bn, InterfaceC4279m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11875a;
    public final int b;
    public final Pn c;
    public final U2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public AbstractC4614zd(int i, String str, Pn pn, U2 u2) {
        this.b = i;
        this.f11875a = str;
        this.c = pn;
        this.d = u2;
    }

    public final Cn a() {
        Cn cn = new Cn();
        cn.b = this.b;
        cn.f11094a = this.f11875a.getBytes();
        cn.d = new En();
        cn.c = new Dn();
        return cn;
    }

    @Override // io.appmetrica.analytics.impl.Bn
    public abstract /* synthetic */ void a(An an);

    public final U2 b() {
        return this.d;
    }

    public final String c() {
        return this.f11875a;
    }

    public final Pn d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        Nn nnA = this.c.a(this.f11875a);
        if (nnA.f11273a) {
            return true;
        }
        this.e.warning("Attribute " + this.f11875a + " of type " + ((String) AbstractC4275ln.f11659a.get(this.b)) + " is skipped because " + nnA.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
