package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4345oi implements Oj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4178i0 f11703a;
    public final Lj b;
    public final ICommonExecutor c;

    public C4345oi(C4178i0 c4178i0, Lj lj) {
        this(c4178i0, lj, C4455t4.i().e().b());
    }

    public final void a(C4319nh c4319nh) {
        AbstractCallableC4369ph eg;
        ICommonExecutor iCommonExecutor = this.c;
        if (c4319nh.b) {
            Lj lj = this.b;
            eg = new C4308n6(lj.f11247a, lj.b, lj.c, c4319nh);
        } else {
            Lj lj2 = this.b;
            eg = new Eg(lj2.b, lj2.c, c4319nh);
        }
        iCommonExecutor.submit(eg);
    }

    public final void b(C4319nh c4319nh) {
        Lj lj = this.b;
        C4308n6 c4308n6 = new C4308n6(lj.f11247a, lj.b, lj.c, c4319nh);
        if (this.f11703a.a()) {
            try {
                this.c.submit(c4308n6).get(4L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c4308n6.c) {
            return;
        }
        try {
            c4308n6.a();
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Oj
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.c;
        Lj lj = this.b;
        iCommonExecutor.submit(new C4250kn(lj.b, lj.c, i, bundle));
    }

    public C4345oi(C4178i0 c4178i0, Lj lj, ICommonExecutor iCommonExecutor) {
        this.c = iCommonExecutor;
        this.b = lj;
        this.f11703a = c4178i0;
    }

    public final void b(C4367pf c4367pf) {
        ICommonExecutor iCommonExecutor = this.c;
        Lj lj = this.b;
        iCommonExecutor.submit(new C4494ui(lj.b, lj.c, c4367pf));
    }

    public final void a(C4367pf c4367pf) {
        ICommonExecutor iCommonExecutor = this.c;
        Lj lj = this.b;
        iCommonExecutor.submit(new C4192ie(lj.b, lj.c, c4367pf));
    }
}
