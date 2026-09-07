package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public final class ua implements va {
    static final /* synthetic */ KProperty<Object>[] b = {ta.a(ua.class, "adViewReference", "getAdViewReference()Lcom/monetization/ads/banner/InternalAdView;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn1 f10370a;

    public ua(jp0 adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.f10370a = ao1.a(adView);
    }

    @Override // com.yandex.mobile.ads.impl.va
    public final boolean a() {
        jp0 jp0Var = (jp0) this.f10370a.getValue(this, b[0]);
        return jp0Var != null && oh2.b(jp0Var) >= 1;
    }

    @Override // com.yandex.mobile.ads.impl.va
    public final boolean b() {
        jp0 jp0Var = (jp0) this.f10370a.getValue(this, b[0]);
        return (jp0Var == null || oh2.d(jp0Var)) ? false : true;
    }
}
