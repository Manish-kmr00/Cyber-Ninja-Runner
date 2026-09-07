package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3994ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f11464a = new HashSet();
    public C4044cg b;
    public boolean c;
    public final Tn d;
    public final Context e;

    public C3994ag(Context context, Tn tn) {
        this.e = context;
        this.d = tn;
        this.b = tn.b();
        this.c = tn.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        Va vaA = C4243kg.a(context, C4486ua.E.d.a());
        InterfaceC4169hg interfaceC4169hg = (InterfaceC4169hg) new Rf(this, new C4243kg(vaA), new Ga(context), new C4268lg(context)).f.getValue();
        try {
            vaA.a(interfaceC4169hg);
        } catch (Throwable th) {
            interfaceC4169hg.a(th);
        }
    }

    public final synchronized void a(C4094eg c4094eg) {
        this.f11464a.add(c4094eg);
        if (this.c) {
            c4094eg.a(this.b);
        }
    }

    public final synchronized void a(C4044cg c4044cg) {
        Iterator it = this.f11464a.iterator();
        while (it.hasNext()) {
            ((C4094eg) it.next()).a(c4044cg);
        }
    }
}
