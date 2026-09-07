package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gw0<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w41 f9039a;
    private final uu0 b;

    public gw0(ot nativeAdAssets, w41 nativeAdContainerViewProvider, uu0 mediaAspectRatioProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdContainerViewProvider, "nativeAdContainerViewProvider");
        Intrinsics.checkNotNullParameter(mediaAspectRatioProvider, "mediaAspectRatioProvider");
        this.f9039a = nativeAdContainerViewProvider;
        this.b = mediaAspectRatioProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V view) {
        Intrinsics.checkNotNullParameter(view, "container");
        this.f9039a.getClass();
        Intrinsics.checkNotNullParameter(view, "container");
        ExtendedViewContainer extendedViewContainer = (ExtendedViewContainer) view.findViewById(R.id.media_container);
        Float fA = this.b.a();
        if (extendedViewContainer == null || fA == null) {
            return;
        }
        hm1 hm1Var = new hm1(Math.min(Math.max(fA.floatValue(), 1.0f), 1.7777778f), new ou0.a());
        Intrinsics.checkNotNullParameter(view, "view");
        Context applicationContext = view.getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        extendedViewContainer.setMeasureSpecProvider(new cr(hm1Var, new lu0(view, 0.5f, applicationContext)));
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
