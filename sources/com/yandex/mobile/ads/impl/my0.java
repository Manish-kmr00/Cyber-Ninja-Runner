package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class my0 extends dx0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my0(CustomizableMediaView mediaView, kx0 mediaViewRenderController) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(CustomizableMediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return dx0.a.g;
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    public final void b(View view, ax0 ax0Var) {
        CustomizableMediaView mediaView = (CustomizableMediaView) view;
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, ax0 ax0Var) {
        CustomizableMediaView mediaView = (CustomizableMediaView) view;
        ax0 mediaValue = ax0Var;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
    }
}
