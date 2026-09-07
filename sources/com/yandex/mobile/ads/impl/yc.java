package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yc<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f10723a;
    private final j51 b;

    public yc(ot nativeAdAssets, j51 nativeAdDividerViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdDividerViewProvider, "nativeAdDividerViewProvider");
        this.f10723a = nativeAdAssets;
        this.b = nativeAdDividerViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewById = container.findViewById(R.id.age_divider);
        if (viewFindViewById == null || this.f10723a.a() != null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
