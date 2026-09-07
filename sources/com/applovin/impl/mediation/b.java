package com.applovin.impl.mediation;

import com.applovin.impl.q2;
import com.applovin.impl.sdk.k;
import com.applovin.impl.z2;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes12.dex */
public class b implements a.InterfaceC0134a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f534a;
    private final a b;
    private final c c;

    public b(k kVar) {
        this.f534a = kVar;
        this.b = new a(kVar);
        this.c = new c(kVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(z2 z2Var) {
        h hVarA;
        if (z2Var == null || (hVarA = z2Var.A()) == null || !z2Var.w().compareAndSet(false, true)) {
            return;
        }
        q2.e(hVarA.c(), z2Var);
    }

    public void a() {
        this.c.a();
        this.b.a();
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0134a
    public void b(final z2 z2Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(z2Var);
            }
        }, z2Var.g0());
    }

    public void e(z2 z2Var) {
        long jH0 = z2Var.h0();
        if (jH0 >= 0) {
            this.c.a(z2Var, jH0);
        }
        if (z2Var.r0() || z2Var.s0()) {
            this.b.a(z2Var, this);
        }
    }

    @Override // com.applovin.impl.mediation.c.a
    public void a(z2 z2Var) {
        c(z2Var);
    }
}
