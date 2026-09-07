package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y2 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7447a;
    public final /* synthetic */ com.ogury.ad.interstitial.ui.a b;

    public y2(r rVar, com.ogury.ad.interstitial.ui.a aVar) {
        this.f7447a = rVar;
        this.b = aVar;
    }

    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        r rVar = this.f7447a;
        if (rVar != null) {
            rVar.a(adController, adLayout);
        }
        this.b.f7478a.finish();
    }
}
