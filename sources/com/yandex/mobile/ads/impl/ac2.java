package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class ac2 extends FunctionReferenceImpl implements Function1<kb2, Unit> {
    ac2(ca2 ca2Var) {
        super(1, ca2Var, wp1.class, "onFailure", "onFailure(Lcom/monetization/ads/video/VideoAdError;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(kb2 kb2Var) {
        kb2 p0 = kb2Var;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((wp1) this.receiver).a(p0);
        return Unit.INSTANCE;
    }
}
