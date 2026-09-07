package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC4127g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11558a;
    public final C4496uk b;
    public final C4596yk c;
    public final C4471tk d;
    public final Ya e;
    public final SystemTimeProvider f;

    public AbstractC4127g(C4282m5 c4282m5, C4496uk c4496uk, C4596yk c4596yk, C4471tk c4471tk, Ya ya, SystemTimeProvider systemTimeProvider) {
        this.f11558a = c4282m5;
        this.b = c4496uk;
        this.c = c4596yk;
        this.d = c4471tk;
        this.e = ya;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ C4173hk a(Object obj) {
        return a((C4197ik) obj);
    }

    public final C4173hk b() {
        if (this.c.h()) {
            return new C4173hk(this.f11558a, this.c, a(), this.f);
        }
        return null;
    }

    public final C4173hk a(C4197ik c4197ik) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C4282m5 c4282m5 = this.f11558a;
        C4596yk c4596yk = this.c;
        long jA = this.b.a();
        C4596yk c4596yk2 = this.c;
        c4596yk2.a(C4596yk.f, Long.valueOf(jA));
        c4596yk2.a(C4596yk.d, Long.valueOf(c4197ik.f11606a));
        c4596yk2.a(C4596yk.h, Long.valueOf(c4197ik.f11606a));
        c4596yk2.a(C4596yk.g, 0L);
        c4596yk2.a(C4596yk.i, Boolean.TRUE);
        c4596yk2.b();
        this.f11558a.e.a(jA, this.d.f11785a, TimeUnit.MILLISECONDS.toSeconds(c4197ik.b));
        return new C4173hk(c4282m5, c4596yk, a(), new SystemTimeProvider());
    }

    public final C4247kk a() {
        C4222jk c4222jk = new C4222jk(this.d);
        c4222jk.g = this.c.i();
        c4222jk.f = this.c.c.a(C4596yk.g);
        c4222jk.d = this.c.c.a(C4596yk.h);
        c4222jk.c = this.c.c.a(C4596yk.f);
        c4222jk.h = this.c.c.a(C4596yk.d);
        c4222jk.f11621a = this.c.c.a(C4596yk.e);
        return new C4247kk(c4222jk);
    }
}
