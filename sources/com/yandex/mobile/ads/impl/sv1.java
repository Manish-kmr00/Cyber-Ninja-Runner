package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class sv1 extends dx0 {
    private final og2<ImageView, uj0> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv1(CustomizableMediaView mediaView, ck0 imageViewAdapter, kx0 mediaViewRenderController, og2<ImageView, uj0> imageViewWrapper) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(imageViewAdapter, "imageViewAdapter");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(imageViewWrapper, "imageViewWrapper");
        this.d = imageViewWrapper;
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return dx0.a.f;
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
        this.d.a(asset, viewConfigurator, a(ax0Var2 != null ? ax0Var2.a() : null));
    }

    private static uj0 a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (uj0) list.get(0);
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
        uj0 uj0VarA = a(mediaValue.a());
        if (uj0VarA != null) {
            return this.d.a(uj0VarA);
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        super.b(mediaView, mediaValue);
        uj0 uj0VarA = a(mediaValue.a());
        if (uj0VarA == null) {
            return;
        }
        this.d.b(uj0VarA);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        uj0 uj0VarA = a(mediaValue.a());
        if (uj0VarA == null) {
            return;
        }
        this.d.b(uj0VarA);
    }
}
