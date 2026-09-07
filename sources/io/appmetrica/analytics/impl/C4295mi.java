package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4295mi extends Jm {
    public final RunnableC4270li d;
    public final ICommonExecutor e;

    public C4295mi(C4282m5 c4282m5, InterfaceC4298ml interfaceC4298ml, ICommonExecutor iCommonExecutor) {
        super(c4282m5, interfaceC4298ml);
        this.d = new RunnableC4270li(this);
        this.e = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.Jm
    public final void a() {
        this.e.remove(this.d);
    }

    @Override // io.appmetrica.analytics.impl.Jm
    public final void e() {
        this.b.a();
        C4045ch c4045ch = (C4045ch) ((C4282m5) this.f11215a).k.a();
        if (c4045ch.k.a(c4045ch.j)) {
            String str = c4045ch.m;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                a(Nd.a((C4282m5) this.f11215a));
            } catch (Throwable unused) {
            }
        }
    }

    public final void f() {
        if (this.c.get()) {
            return;
        }
        this.e.remove(this.d);
        if (((C4045ch) ((C4282m5) this.f11215a).k.a()).g > 0) {
            this.e.executeDelayed(this.d, TimeUnit.SECONDS.toMillis(((C4045ch) ((C4282m5) this.f11215a).k.a()).g));
        }
    }
}
