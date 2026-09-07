package com.yandex.mobile.ads.nativeads;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0005R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0005R\u0014\u0010#\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0014\u0010%\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0014\u0010'\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005¨\u0006)"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdAssets;", "", "age", "", "getAge", "()Ljava/lang/String;", "body", "getBody", "callToAction", "getCallToAction", "domain", "getDomain", "favicon", "Lcom/yandex/mobile/ads/nativeads/NativeAdImage;", "getFavicon", "()Lcom/yandex/mobile/ads/nativeads/NativeAdImage;", "icon", "getIcon", "image", "getImage", "isFeedbackAvailable", "", "()Z", "media", "Lcom/yandex/mobile/ads/nativeads/NativeAdMedia;", "getMedia", "()Lcom/yandex/mobile/ads/nativeads/NativeAdMedia;", "price", "getPrice", "rating", "", "getRating", "()Ljava/lang/Float;", "reviewCount", "getReviewCount", "sponsored", "getSponsored", "title", "getTitle", "warning", "getWarning", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeAdAssets {
    String getAge();

    String getBody();

    String getCallToAction();

    String getDomain();

    NativeAdImage getFavicon();

    NativeAdImage getIcon();

    NativeAdImage getImage();

    NativeAdMedia getMedia();

    String getPrice();

    Float getRating();

    String getReviewCount();

    String getSponsored();

    String getTitle();

    String getWarning();

    boolean isFeedbackAvailable();
}
