package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
final class ll2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ml2 b;
    final /* synthetic */ String c = "Cannot load bidder token. Token generation failed";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ll2(ml2 ml2Var) {
        super(0);
        this.b = ml2Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.b.f9653a.onBidderTokenFailedToLoad(this.c);
        return Unit.INSTANCE;
    }
}
