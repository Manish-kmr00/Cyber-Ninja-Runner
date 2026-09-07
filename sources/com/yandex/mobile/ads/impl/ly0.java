package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ly0 implements ox0<MediatedInterstitialAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx0<MediatedInterstitialAdapter> f9577a;

    public ly0(vx0<MediatedInterstitialAdapter> mediatedAdProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        this.f9577a = mediatedAdProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ox0
    public final mx0<MediatedInterstitialAdapter> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f9577a.a(context, MediatedInterstitialAdapter.class);
    }
}
