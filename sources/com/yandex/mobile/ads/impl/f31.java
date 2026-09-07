package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import com.monetization.ads.nativeads.view.pager.MultiBannerControlsContainer;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zs1<MultiBannerControlsContainer> f8863a = new zs1<>();

    public final MultiBannerControlsContainer a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        zs1<MultiBannerControlsContainer> zs1Var = this.f8863a;
        int i = R.layout.monetization_ads_internal_multibanner_controls;
        zs1Var.getClass();
        MultiBannerControlsContainer multiBannerControlsContainer = (MultiBannerControlsContainer) zs1.a(context, MultiBannerControlsContainer.class, i, null);
        if (multiBannerControlsContainer != null) {
            multiBannerControlsContainer.setLayoutParams(layoutParams);
        }
        return multiBannerControlsContainer;
    }
}
