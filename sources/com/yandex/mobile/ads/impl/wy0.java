package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class wy0 implements ox0<MediatedRewardedAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx0<MediatedRewardedAdapter> f10604a;

    public wy0(vx0<MediatedRewardedAdapter> mediatedAdProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        this.f10604a = mediatedAdProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ox0
    public final mx0<MediatedRewardedAdapter> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f10604a.a(context, MediatedRewardedAdapter.class);
    }
}
