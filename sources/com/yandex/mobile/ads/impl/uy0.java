package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.mediation.nativeads.MediatedNativeAd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uy0 implements zb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zb1 f10433a;
    private final MediatedNativeAd b;
    private final ty0 c;
    private final l7 d;
    private boolean e;

    public uy0(zb1 nativeAdViewRenderer, MediatedNativeAd mediatedNativeAd, ty0 mediatedNativeRenderingTracker, l7 adQualityVerifierController) {
        Intrinsics.checkNotNullParameter(nativeAdViewRenderer, "nativeAdViewRenderer");
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        Intrinsics.checkNotNullParameter(mediatedNativeRenderingTracker, "mediatedNativeRenderingTracker");
        Intrinsics.checkNotNullParameter(adQualityVerifierController, "adQualityVerifierController");
        this.f10433a = nativeAdViewRenderer;
        this.b = mediatedNativeAd;
        this.c = mediatedNativeRenderingTracker;
        this.d = adQualityVerifierController;
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        this.f10433a.a(nativeAdViewAdapter);
        m71 m71VarG = nativeAdViewAdapter.g();
        View viewE = nativeAdViewAdapter.e();
        if (viewE != null) {
            this.b.unbindNativeAd(new qy0(viewE, m71VarG));
        }
        this.d.d();
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter, zo clickListenerConfigurator) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurator, "clickListenerConfigurator");
        this.f10433a.a(nativeAdViewAdapter, clickListenerConfigurator);
        m71 m71VarG = nativeAdViewAdapter.g();
        View viewE = nativeAdViewAdapter.e();
        if (viewE != null) {
            this.b.bindNativeAd(new qy0(viewE, m71VarG));
        }
        this.d.c();
        if (nativeAdViewAdapter.e() == null || this.e) {
            return;
        }
        this.e = true;
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a() {
        this.f10433a.a();
    }
}
