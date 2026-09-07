package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
final /* synthetic */ class cc2 extends FunctionReferenceImpl implements Function1<kb2, Unit> {
    cc2(pm0 pm0Var) {
        super(1, pm0Var, wp1.class, "onFailure", "onFailure(Lcom/monetization/ads/video/VideoAdError;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(kb2 kb2Var) {
        kb2 p0 = kb2Var;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((wp1) this.receiver).a(p0);
        return Unit.INSTANCE;
    }
}
