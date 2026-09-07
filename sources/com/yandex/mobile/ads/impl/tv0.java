package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tv0<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f10334a;
    private final w41 b;

    public tv0(ot nativeAdAssets, w41 nativeAdContainerViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdContainerViewProvider, "nativeAdContainerViewProvider");
        this.f10334a = nativeAdAssets;
        this.b = nativeAdContainerViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        ExtendedViewContainer extendedViewContainer = (ExtendedViewContainer) container.findViewById(R.id.media_container);
        if (extendedViewContainer != null && this.f10334a.h() == null && this.f10334a.i() == null) {
            extendedViewContainer.setVisibility(8);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
