package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes6.dex */
public final class wv1 extends dx0 {
    static final /* synthetic */ KProperty<Object>[] j = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(wv1.class, "weakMediaView", "getWeakMediaView()Lcom/monetization/ads/nativeads/CustomizableMediaView;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(wv1.class, "weakMediaValue", "getWeakMediaValue()Lcom/monetization/ads/network/model/MediaValue;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(wv1.class, "currentViewAdapter", "getCurrentViewAdapter()Lcom/monetization/ads/nativeads/assetadapter/viewadapter/MediaViewAdapter;", 0))};
    private final dx0 d;
    private final dx0 e;
    private final yy1 f;
    private final zn1 g;
    private final zn1 h;
    private final yv1 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wv1(CustomizableMediaView mediaView, vv1 videoViewAdapter, dx0 fallbackAdapter, kx0 mediaViewRenderController, yy1 fallbackSize) {
        super(mediaView, mediaViewRenderController);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(fallbackAdapter, "fallbackAdapter");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(fallbackSize, "fallbackSize");
        this.d = videoViewAdapter;
        this.e = fallbackAdapter;
        this.f = fallbackSize;
        this.g = ao1.a(null);
        this.h = ao1.a(null);
        Delegates delegates = Delegates.INSTANCE;
        this.i = new yv1(videoViewAdapter, this);
        mediaView.setOnSizeChangedListener$mobileads_externalRelease(new a(new WeakReference(this)));
    }

    public static final ax0 c(wv1 wv1Var) {
        return (ax0) wv1Var.h.getValue(wv1Var, j[1]);
    }

    public static final CustomizableMediaView d(wv1 wv1Var) {
        return (CustomizableMediaView) wv1Var.g.getValue(wv1Var, j[0]);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final dx0.a d() {
        return this.i.getValue(this, j[2]).d();
    }

    public static final void a(wv1 wv1Var, dx0 dx0Var) {
        wv1Var.i.setValue(wv1Var, j[2], dx0Var);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(View view) {
        CustomizableMediaView view2 = (CustomizableMediaView) view;
        Intrinsics.checkNotNullParameter(view2, "view");
        this.d.a(view2);
        this.e.a(view2);
    }

    private static final class a implements CustomizableMediaView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<wv1> f10596a;

        public a(WeakReference<wv1> weakSdkMediaViewVideoWithFallbackAdapter) {
            Intrinsics.checkNotNullParameter(weakSdkMediaViewVideoWithFallbackAdapter, "weakSdkMediaViewVideoWithFallbackAdapter");
            this.f10596a = weakSdkMediaViewVideoWithFallbackAdapter;
        }

        @Override // com.monetization.ads.nativeads.CustomizableMediaView.a
        public final void a(int i, int i2) {
            wv1 wv1Var = this.f10596a.get();
            if (wv1Var != null) {
                yy1 yy1Var = wv1Var.f;
                if (i < yy1Var.b() || i2 < yy1Var.a()) {
                    wv1.a(wv1Var, wv1Var.e);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(ig asset, qg2 viewConfigurator, ax0 ax0Var) {
        ax0 ax0Var2 = ax0Var;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        this.d.a(asset, viewConfigurator, ax0Var2);
        this.e.a(asset, viewConfigurator, ax0Var2);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a() {
        this.i.getValue(this, j[2]).a();
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(CustomizableMediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        this.d.a(mediaView);
        this.e.a(mediaView);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, ax0 ax0Var) {
        CustomizableMediaView view2 = (CustomizableMediaView) view;
        ax0 value = ax0Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.i.getValue(this, j[2]).a(view2, value);
    }

    @Override // com.yandex.mobile.ads.impl.dx0, com.yandex.mobile.ads.impl.ng2
    /* JADX INFO: renamed from: a */
    public final void b(CustomizableMediaView mediaView, ax0 value) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(value, "value");
        zn1 zn1Var = this.g;
        KProperty<?>[] kPropertyArr = j;
        zn1Var.setValue(this, kPropertyArr[0], mediaView);
        this.h.setValue(this, kPropertyArr[1], value);
        this.i.getValue(this, kPropertyArr[2]).b(mediaView, value);
    }

    @Override // com.yandex.mobile.ads.impl.dx0
    public final void a(ax0 mediaValue) {
        Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
        this.i.getValue(this, j[2]).a(mediaValue);
    }
}
