package com.monetization.ads.mediation.nativeads;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005¨\u0006&"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdViewProvider;", "", "ageView", "Landroid/widget/TextView;", "getAgeView", "()Landroid/widget/TextView;", "bodyView", "getBodyView", "callToActionView", "getCallToActionView", "domainView", "getDomainView", "feedbackView", "Landroid/widget/ImageView;", "getFeedbackView", "()Landroid/widget/ImageView;", "iconView", "getIconView", "mediaView", "Landroid/widget/FrameLayout;", "getMediaView", "()Landroid/widget/FrameLayout;", "nativeAdView", "Landroid/view/View;", "getNativeAdView", "()Landroid/view/View;", "priceView", "getPriceView", "ratingView", "getRatingView", "reviewCountView", "getReviewCountView", "sponsoredView", "getSponsoredView", "titleView", "getTitleView", "warningView", "getWarningView", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedNativeAdViewProvider {
    TextView getAgeView();

    TextView getBodyView();

    TextView getCallToActionView();

    TextView getDomainView();

    ImageView getFeedbackView();

    ImageView getIconView();

    FrameLayout getMediaView();

    View getNativeAdView();

    TextView getPriceView();

    View getRatingView();

    TextView getReviewCountView();

    TextView getSponsoredView();

    TextView getTitleView();

    TextView getWarningView();
}
