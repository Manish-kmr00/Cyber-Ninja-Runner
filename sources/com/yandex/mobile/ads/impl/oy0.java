package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oy0 implements ox0<MediatedNativeAdapter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vx0<MediatedNativeAdapter> f9873a;

    public oy0(vx0<MediatedNativeAdapter> mediatedAdProvider) {
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        this.f9873a = mediatedAdProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ox0
    public final mx0<MediatedNativeAdapter> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f9873a.a(context, MediatedNativeAdapter.class);
    }
}
