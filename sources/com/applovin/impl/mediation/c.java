package com.applovin.impl.mediation;

import com.applovin.impl.g0;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.z2;

/* JADX INFO: loaded from: classes12.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f535a;
    private final o b;
    private final a c;
    private g0 d;

    public interface a {
        void a(z2 z2Var);
    }

    c(k kVar, a aVar) {
        this.f535a = kVar;
        this.b = kVar.O();
        this.c = aVar;
    }

    public void a(final z2 z2Var, long j) {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        }
        this.d = g0.a(j, this.f535a, new Runnable() { // from class: com.applovin.impl.mediation.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z2Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var) {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.c.a(z2Var);
    }

    public void a() {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        g0 g0Var = this.d;
        if (g0Var != null) {
            g0Var.a();
            this.d = null;
        }
    }
}
