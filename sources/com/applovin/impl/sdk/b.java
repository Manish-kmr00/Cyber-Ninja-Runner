package com.applovin.impl.sdk;

import com.applovin.impl.d7;
import com.applovin.impl.s1;
import com.applovin.impl.v4;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f640a;
    private final WeakReference b;
    private final WeakReference c;
    private d7 d;

    private b(s1 s1Var, a.InterfaceC0139a interfaceC0139a, k kVar) {
        this.b = new WeakReference(s1Var);
        this.c = new WeakReference(interfaceC0139a);
        this.f640a = kVar;
    }

    public static b a(s1 s1Var, a.InterfaceC0139a interfaceC0139a, k kVar) {
        b bVar = new b(s1Var, interfaceC0139a, kVar);
        bVar.a(s1Var.getTimeToLiveMillis());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f640a.f().a(this);
    }

    public s1 b() {
        return (s1) this.b.get();
    }

    public void d() {
        a();
        s1 s1VarB = b();
        if (s1VarB == null) {
            return;
        }
        s1VarB.setExpired();
        a.InterfaceC0139a interfaceC0139a = (a.InterfaceC0139a) this.c.get();
        if (interfaceC0139a == null) {
            return;
        }
        interfaceC0139a.onAdExpired(s1VarB);
    }

    public void a(long j) {
        a();
        if (((Boolean) this.f640a.a(v4.a1)).booleanValue() || !this.f640a.n0().isApplicationPaused()) {
            this.d = d7.a(j, this.f640a, new Runnable() { // from class: com.applovin.impl.sdk.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
        }
    }

    public void a() {
        d7 d7Var = this.d;
        if (d7Var != null) {
            d7Var.a();
            this.d = null;
        }
    }
}
