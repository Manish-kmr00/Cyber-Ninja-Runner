package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.banner.MediatedBannerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ey0 implements ox0<MediatedBannerAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx0<MediatedBannerAdapter> f8842a;

    public ey0(vx0<MediatedBannerAdapter> mediatedAdProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        this.f8842a = mediatedAdProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ox0
    public final mx0<MediatedBannerAdapter> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f8842a.a(context, MediatedBannerAdapter.class);
    }
}
