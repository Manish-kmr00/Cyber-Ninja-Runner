package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tu0<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w41 f10333a;
    private final uu0 b;

    public tu0(ot nativeAdAssets, w41 nativeAdContainerViewProvider, uu0 mediaAspectRatioProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdContainerViewProvider, "nativeAdContainerViewProvider");
        Intrinsics.checkNotNullParameter(mediaAspectRatioProvider, "mediaAspectRatioProvider");
        this.f10333a = nativeAdContainerViewProvider;
        this.b = mediaAspectRatioProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f10333a.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        ExtendedViewContainer extendedViewContainer = (ExtendedViewContainer) container.findViewById(R.id.media_container);
        Float fA = this.b.a();
        if (extendedViewContainer == null || fA == null) {
            return;
        }
        extendedViewContainer.setMeasureSpecProvider(new hm1(fA.floatValue(), new ou0.a()));
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
