package com.yandex.mobile.ads.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001*R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\r\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0013\u0010!\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u0013\u0010#\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\nR\u0013\u0010%\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0013\u0010'\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0013\u0010)\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "getNativeAdView", "()Landroid/view/View;", "nativeAdView", "Landroid/widget/TextView;", "getAgeView", "()Landroid/widget/TextView;", "ageView", "getBodyView", "bodyView", "getCallToActionView", "callToActionView", "getDomainView", "domainView", "Landroid/widget/ImageView;", "getFaviconView", "()Landroid/widget/ImageView;", "faviconView", "getFeedbackView", "feedbackView", "getIconView", "iconView", "Lcom/yandex/mobile/ads/nativeads/MediaView;", "getMediaView", "()Lcom/yandex/mobile/ads/nativeads/MediaView;", "mediaView", "getPriceView", "priceView", "getRatingView", "ratingView", "getReviewCountView", "reviewCountView", "getSponsoredView", "sponsoredView", "getTitleView", "titleView", "getWarningView", "warningView", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class NativeAdViewBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View nativeAdView;
    private final Map<String, View> b;

    public /* synthetic */ NativeAdViewBinder(View view, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, map);
    }

    public final TextView getAgeView() {
        View view = this.b.get("age");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getBodyView() {
        View view = this.b.get("body");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getCallToActionView() {
        View view = this.b.get("call_to_action");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getDomainView() {
        View view = this.b.get("domain");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final ImageView getFaviconView() {
        View view = this.b.get("favicon");
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        return null;
    }

    public final ImageView getFeedbackView() {
        View view = this.b.get("feedback");
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        return null;
    }

    public final ImageView getIconView() {
        View view = this.b.get("icon");
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        return null;
    }

    public final MediaView getMediaView() {
        View view = this.b.get("media");
        if (view instanceof MediaView) {
            return (MediaView) view;
        }
        return null;
    }

    public final View getNativeAdView() {
        return this.nativeAdView;
    }

    public final TextView getPriceView() {
        View view = this.b.get("price");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final View getRatingView() {
        return this.b.get("rating");
    }

    public final TextView getReviewCountView() {
        View view = this.b.get("review_count");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getSponsoredView() {
        View view = this.b.get("sponsored");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getTitleView() {
        View view = this.b.get("title");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    public final TextView getWarningView() {
        View view = this.b.get("warning");
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NativeAdViewBinder(View view, Map<String, ? extends View> map) {
        this.nativeAdView = view;
        this.b = map;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010+\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020.¢\u0006\u0004\b,\u0010/J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\bJ%\u0010!\u001a\u00020\u0000\"\f\b\u0000\u0010\u001f*\u00020\u001d*\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010\bJ\u0017\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010\bJ\u0017\u0010(\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010\bJ\u0017\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b*\u0010\b¨\u00060"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder$Builder;", "", "Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder;", "build", "()Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder;", "Landroid/widget/TextView;", "ageView", "setAgeView", "(Landroid/widget/TextView;)Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder$Builder;", "bodyView", "setBodyView", "callToActionView", "setCallToActionView", "domainView", "setDomainView", "Landroid/widget/ImageView;", "faviconView", "setFaviconView", "(Landroid/widget/ImageView;)Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder$Builder;", "feedbackView", "setFeedbackView", "iconView", "setIconView", "Lcom/yandex/mobile/ads/nativeads/MediaView;", "mediaView", "setMediaView", "(Lcom/yandex/mobile/ads/nativeads/MediaView;)Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder$Builder;", "priceView", "setPriceView", "Landroid/view/View;", "Lcom/yandex/mobile/ads/nativeads/Rating;", "T", "ratingView", "setRatingView", "(Landroid/view/View;)Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder$Builder;", "reviewCountView", "setReviewCountView", "sponsoredView", "setSponsoredView", "titleView", "setTitleView", "warningView", "setWarningView", "nativeAdView", "<init>", "(Landroid/view/View;)V", "Lcom/yandex/mobile/ads/nativeads/NativeAdView;", "(Lcom/yandex/mobile/ads/nativeads/NativeAdView;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f10885a;
        private final LinkedHashMap b;

        @Deprecated(message = "Use constructor with passing [NativeAdView] type")
        public Builder(View nativeAdView) {
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
            this.f10885a = nativeAdView;
            this.b = new LinkedHashMap();
        }

        public final NativeAdViewBinder build() {
            return new NativeAdViewBinder(this.f10885a, this.b, null);
        }

        public final Builder setAgeView(TextView ageView) {
            this.b.put("age", ageView);
            return this;
        }

        public final Builder setBodyView(TextView bodyView) {
            this.b.put("body", bodyView);
            return this;
        }

        public final Builder setCallToActionView(TextView callToActionView) {
            this.b.put("call_to_action", callToActionView);
            return this;
        }

        public final Builder setDomainView(TextView domainView) {
            this.b.put("domain", domainView);
            return this;
        }

        public final Builder setFaviconView(ImageView faviconView) {
            this.b.put("favicon", faviconView);
            return this;
        }

        public final Builder setFeedbackView(ImageView feedbackView) {
            this.b.put("feedback", feedbackView);
            return this;
        }

        public final Builder setIconView(ImageView iconView) {
            this.b.put("icon", iconView);
            return this;
        }

        public final Builder setMediaView(MediaView mediaView) {
            this.b.put("media", mediaView);
            return this;
        }

        public final Builder setPriceView(TextView priceView) {
            this.b.put("price", priceView);
            return this;
        }

        public final <T extends View & Rating> Builder setRatingView(T ratingView) {
            this.b.put("rating", ratingView);
            return this;
        }

        public final Builder setReviewCountView(TextView reviewCountView) {
            this.b.put("review_count", reviewCountView);
            return this;
        }

        public final Builder setSponsoredView(TextView sponsoredView) {
            this.b.put("sponsored", sponsoredView);
            return this;
        }

        public final Builder setTitleView(TextView titleView) {
            this.b.put("title", titleView);
            return this;
        }

        public final Builder setWarningView(TextView warningView) {
            this.b.put("warning", warningView);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(NativeAdView nativeAdView) {
            this((View) nativeAdView);
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        }
    }
}
