package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj0 f8575a;
    private final bp b;
    private final m71 c;
    private final Map<String, jg<?>> d;

    public c71(n71 nativeAdWeakViewHolder, o3 adConfiguration, pj0 imageProvider, mk0 impressionEventsObservable, bp onClickListenerFactory, o51 nativeAdFactoriesProvider, ug assetValueProvider, j91 nativeMediaContent, p81 nativeForcePauseObserver, o8 adResponse, bc1 nativeVisualBlock, a51 nativeAdControllers, kx0 mediaViewRenderController, m71 weakViewProvider, hj2 mediaControlsProvider, ex0 mediaViewAdapterCreator, Map assetAdapters) {
        Intrinsics.checkNotNullParameter(nativeAdWeakViewHolder, "nativeAdWeakViewHolder");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(onClickListenerFactory, "onClickListenerFactory");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(assetValueProvider, "assetValueProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(weakViewProvider, "weakViewProvider");
        Intrinsics.checkNotNullParameter(mediaControlsProvider, "mediaControlsProvider");
        Intrinsics.checkNotNullParameter(mediaViewAdapterCreator, "mediaViewAdapterCreator");
        Intrinsics.checkNotNullParameter(assetAdapters, "assetAdapters");
        this.f8575a = imageProvider;
        this.b = onClickListenerFactory;
        this.c = weakViewProvider;
        this.d = assetAdapters;
    }

    public final pj0 d() {
        return this.f8575a;
    }

    public final bp f() {
        return this.b;
    }

    public /* synthetic */ c71(n71 n71Var, o3 o3Var, pj0 pj0Var, mk0 mk0Var, bp bpVar, o51 o51Var, ug ugVar, j91 j91Var, p81 p81Var, o8 o8Var, bc1 bc1Var, a51 a51Var, kx0 kx0Var, rx1 rx1Var) {
        m71 m71VarA = n71Var.a();
        hj2 hj2Var = new hj2(m71VarA);
        ex0 ex0Var = new ex0(ugVar, o3Var, mk0Var, o51Var.c(), a51Var, kx0Var, hj2Var, rx1Var);
        this(n71Var, o3Var, pj0Var, mk0Var, bpVar, o51Var, ugVar, j91Var, p81Var, o8Var, bc1Var, a51Var, kx0Var, m71VarA, hj2Var, ex0Var, new lg(m71VarA, pj0Var, ex0Var, j91Var, p81Var, o8Var, bc1Var, o3Var.q().c()).a());
    }

    public final m71 g() {
        return this.c;
    }

    public final Map<String, jg<?>> c() {
        return this.d;
    }

    public final View e() {
        return this.c.d();
    }

    public final void b() {
        for (jg<?> jgVar : this.d.values()) {
            if (jgVar != null) {
                jgVar.destroy();
            }
        }
    }

    public final void a() {
        for (jg<?> jgVar : this.d.values()) {
            if (jgVar != null) {
                jgVar.a();
            }
        }
    }

    public final jg<?> a(ig<?> igVar) {
        if (igVar != null) {
            return this.d.get(igVar.b());
        }
        return null;
    }
}
