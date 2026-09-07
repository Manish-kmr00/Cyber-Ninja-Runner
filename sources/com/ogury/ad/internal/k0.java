package com.ogury.ad.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k0 extends FunctionReferenceImpl implements Function0<Unit> {
    public k0(Object obj) {
        super(0, obj, n0.class, "onAdLoaded", "onAdLoaded()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        n0 n0Var = (n0) this.receiver;
        x xVar = n0Var.i;
        if (xVar != null) {
            xVar.b();
        }
        g0 g0Var = n0Var.j;
        if (g0Var != null) {
            g0Var.b();
        }
        if (n0Var.h == null) {
            n0Var.e.e();
        }
        x xVar2 = n0Var.h;
        if (xVar2 != null) {
            xVar2.a(new m0(n0Var));
        }
        return Unit.INSTANCE;
    }
}
