package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class dy0 implements ox0<MediatedAppOpenAdAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx0<MediatedAppOpenAdAdapter> f8743a;

    public dy0(vx0<MediatedAppOpenAdAdapter> mediatedAdProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        this.f8743a = mediatedAdProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ox0
    public final mx0<MediatedAppOpenAdAdapter> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f8743a.a(context, MediatedAppOpenAdAdapter.class);
    }
}
