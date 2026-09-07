package com.yandex.mobile.ads.nativeads;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u000fH&J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAd;", "", "adAssets", "Lcom/yandex/mobile/ads/nativeads/NativeAdAssets;", "getAdAssets", "()Lcom/yandex/mobile/ads/nativeads/NativeAdAssets;", Ad.AD_TYPE, "Lcom/yandex/mobile/ads/nativeads/NativeAdType;", "getAdType", "()Lcom/yandex/mobile/ads/nativeads/NativeAdType;", "info", "", "getInfo", "()Ljava/lang/String;", "addImageLoadingListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yandex/mobile/ads/nativeads/NativeAdImageLoadingListener;", "bindNativeAd", "viewBinder", "Lcom/yandex/mobile/ads/nativeads/NativeAdViewBinder;", "loadImages", "removeImageLoadingListener", "setNativeAdEventListener", "eventListener", "Lcom/yandex/mobile/ads/nativeads/NativeAdEventListener;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeAd {
    void addImageLoadingListener(NativeAdImageLoadingListener listener);

    void bindNativeAd(NativeAdViewBinder viewBinder) throws NativeAdException;

    NativeAdAssets getAdAssets();

    NativeAdType getAdType();

    String getInfo();

    void loadImages();

    void removeImageLoadingListener(NativeAdImageLoadingListener listener);

    void setNativeAdEventListener(NativeAdEventListener eventListener);
}
