package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vv1 extends dx0 {
    private final og2<ub1, db2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv1(CustomizableMediaView mediaView, jg2 videoViewAdapter, kx0 mediaViewRenderController, og2<ub1, db2> videoViewWrapper) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(videoViewWrapper, "videoViewWrapper");
        this.d = videoViewWrapper;
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return dx0.a.d;
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
        this.d.a(asset, viewConfigurator, ax0Var2 != null ? ax0Var2.c() : null);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a() {
        this.d.b();
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
        db2 db2VarC = mediaValue.c();
        if (db2VarC != null) {
            return this.d.a(db2VarC);
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        super.b(mediaView, mediaValue);
        db2 db2VarC = mediaValue.c();
        if (db2VarC == null) {
            return;
        }
        this.d.b(db2VarC);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
    }
}
