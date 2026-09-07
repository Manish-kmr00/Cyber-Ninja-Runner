package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z2 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ogury.ad.interstitial.ui.a f7459a;

    public z2(com.ogury.ad.interstitial.ui.a aVar) {
        this.f7459a = aVar;
    }

    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        this.f7459a.f7478a.a(adController.v);
    }
}
