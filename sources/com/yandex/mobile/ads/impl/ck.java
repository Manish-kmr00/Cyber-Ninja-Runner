package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ck implements hv1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bk<Object> f8618a;
    final /* synthetic */ i82 b;

    ck(bk<Object> bkVar, i82 i82Var) {
        this.f8618a = bkVar;
        this.b = i82Var;
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f8618a.b(error);
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(jc advertisingConfiguration, l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        this.f8618a.f().a(advertisingConfiguration);
        this.f8618a.f().a(environmentConfiguration);
        this.f8618a.b(this.b);
    }
}
