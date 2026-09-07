package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class qy0 implements MediatedNativeAdViewProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f10056a;
    private final m71 b;

    public qy0(View nativeAdView, m71 nativeAdWeakViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(nativeAdWeakViewProvider, "nativeAdWeakViewProvider");
        this.f10056a = nativeAdView;
        this.b = nativeAdWeakViewProvider;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final View getNativeAdView() {
        return this.f10056a;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getAgeView() {
        View viewA = this.b.a("age");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getBodyView() {
        View viewA = this.b.a("body");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getCallToActionView() {
        View viewA = this.b.a("call_to_action");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getDomainView() {
        View viewA = this.b.a("domain");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final ImageView getFeedbackView() {
        View viewA = this.b.a("feedback");
        if (viewA instanceof ImageView) {
            return (ImageView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final ImageView getIconView() {
        View viewA = this.b.a("icon");
        if (viewA instanceof ImageView) {
            return (ImageView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final FrameLayout getMediaView() {
        View viewA = this.b.a("media");
        if (viewA instanceof CustomizableMediaView) {
            return (CustomizableMediaView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getPriceView() {
        View viewA = this.b.a("price");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final View getRatingView() {
        return this.b.a("rating");
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getReviewCountView() {
        View viewA = this.b.a("review_count");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getSponsoredView() {
        View viewA = this.b.a("sponsored");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getTitleView() {
        View viewA = this.b.a("title");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdViewProvider
    public final TextView getWarningView() {
        View viewA = this.b.a("warning");
        if (viewA instanceof TextView) {
            return (TextView) viewA;
        }
        return null;
    }
}
