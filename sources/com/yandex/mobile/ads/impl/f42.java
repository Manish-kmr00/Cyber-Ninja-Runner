package com.yandex.mobile.ads.impl;

import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f42 implements Runnable {
    final /* synthetic */ e42 b;

    f42(e42 e42Var) {
        this.b = e42Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a42 a42VarB;
        long jA;
        while (true) {
            e42 e42Var = this.b;
            synchronized (e42Var) {
                a42VarB = e42Var.b();
            }
            if (a42VarB == null) {
                return;
            }
            d42 d42VarD = a42VarB.d();
            Intrinsics.checkNotNull(d42VarD);
            e42 e42Var2 = this.b;
            e42 e42Var3 = e42.h;
            boolean zIsLoggable = e42.b.a().isLoggable(Level.FINE);
            if (zIsLoggable) {
                jA = d42VarD.h().d().a();
                b42.b(a42VarB, d42VarD, "starting");
            } else {
                jA = -1;
            }
            try {
                e42Var2.b(a42VarB);
                try {
                    Unit unit = Unit.INSTANCE;
                    if (zIsLoggable) {
                        b42.b(a42VarB, d42VarD, "finished run in " + b42.a(d42VarD.h().d().a() - jA));
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        b42.b(a42VarB, d42VarD, "failed a run in " + b42.a(d42VarD.h().d().a() - jA));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                e42Var2.d().execute(this);
                throw th2;
            }
        }
    }
}
