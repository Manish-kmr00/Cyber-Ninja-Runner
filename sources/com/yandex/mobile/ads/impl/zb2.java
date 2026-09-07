package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
final class zb2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ dc2 b;
    final /* synthetic */ z92 c;
    final /* synthetic */ aa2 d;
    final /* synthetic */ wp1<r92> e;
    final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zb2(dc2 dc2Var, z92 z92Var, co0 co0Var, ca2 ca2Var, Object obj) {
        super(0);
        this.b = dc2Var;
        this.c = z92Var;
        this.d = co0Var;
        this.e = ca2Var;
        this.f = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        s92 s92VarA = this.b.d.a(this.b.g, this.c, this.d, this.e);
        this.b.b.a(f5.v, this.c);
        this.b.c.a(this.b.g, this.b.f8681a, this.c, this.d, this.f, s92VarA);
        return Unit.INSTANCE;
    }
}
