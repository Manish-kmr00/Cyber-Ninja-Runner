package com.yandex.mobile.ads.impl;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uv1 extends dx0 {
    private final og2<ViewPager2, List<uj0>> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv1(CustomizableMediaView mediaView, o31 multiBannerViewAdapter, kx0 mediaViewRenderController, og2<ViewPager2, List<uj0>> multiBannerViewWrapper) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(multiBannerViewAdapter, "multiBannerViewAdapter");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(multiBannerViewWrapper, "multiBannerViewWrapper");
        this.d = multiBannerViewWrapper;
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return dx0.a.e;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(View view) {
        CustomizableMediaView mediaView = (CustomizableMediaView) view;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        this.d.a();
        super.a(mediaView);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(ig asset, qg2 viewConfigurator, ax0 ax0Var) {
        ax0 ax0Var2 = ax0Var;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        this.d.a(asset, viewConfigurator, ax0Var2 != null ? ax0Var2.a() : null);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(CustomizableMediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        this.d.a();
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, ax0 ax0Var) {
        CustomizableMediaView mediaView = (CustomizableMediaView) view;
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        List<uj0> listA = mediaValue.a();
        if (listA == null || !(!listA.isEmpty())) {
            return false;
        }
        return this.d.a(listA);
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        super.b(mediaView, mediaValue);
        List<uj0> listA = mediaValue.a();
        if (listA == null || !(!listA.isEmpty())) {
            return;
        }
        this.d.b(listA);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        List<uj0> listA = mediaValue.a();
        if (listA == null || !(!listA.isEmpty())) {
            return;
        }
        this.d.b(listA);
    }
}
