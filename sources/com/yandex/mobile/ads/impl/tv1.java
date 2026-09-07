package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tv1 extends dx0 {
    private final og2<s21, su0> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tv1(CustomizableMediaView mediaView, u21 mraidWebViewAdapter, kx0 mediaViewRenderController, og2<s21, su0> mraidWebViewWrapper) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mraidWebViewAdapter, "mraidWebViewAdapter");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(mraidWebViewWrapper, "mraidWebViewWrapper");
        this.d = mraidWebViewWrapper;
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return dx0.a.c;
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
        this.d.a(asset, viewConfigurator, ax0Var2 != null ? ax0Var2.b() : null);
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
        su0 su0VarB = mediaValue.b();
        if (su0VarB != null) {
            return this.d.a(su0VarB);
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        super.b(mediaView, mediaValue);
        su0 su0VarB = mediaValue.b();
        if (su0VarB == null) {
            return;
        }
        this.d.b(su0VarB);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
    }
}
