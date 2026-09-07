package io.bidmachine.ads.networks.nast;

import android.text.TextUtils;
import io.bidmachine.ContextProvider;
import io.bidmachine.ImageDataImpl;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.nativead.NativeNetworkAdapter;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedNativeAd;
import io.bidmachine.unified.UnifiedNativeAdCallback;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;

/* JADX INFO: loaded from: classes9.dex */
class NastNative extends UnifiedNativeAd {
    NastNative() {
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedNativeAdCallback unifiedNativeAdCallback, UnifiedNativeAdRequestParams unifiedNativeAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        NastParams nastParams = new NastParams(unifiedMediationParams);
        if (nastParams.isValid(unifiedNativeAdRequestParams, unifiedNativeAdCallback)) {
            unifiedNativeAdCallback.setVisibilitySource(VisibilitySource.BidMachine);
            NativeNetworkAdapter privacySheetData = new NastAdapter().setTitle(nastParams.title).setDescription(nastParams.description).setCallToAction(nastParams.callToAction).setIcon(new ImageDataImpl(nastParams.iconUrl)).setMainImage(new ImageDataImpl(nastParams.imageUrl)).setVideoUrl(nastParams.videoUrl).setVideoAdm(nastParams.videoAdm).setClickUrl(nastParams.clickUrl).setNetworkControlLoadingAssets(false).setAdLabelData(nastParams.adLabelData).setPrivacySheetData(nastParams.privacySheetData);
            if (nastParams.rating != null) {
                privacySheetData.setRating(nastParams.rating.floatValue());
            }
            unifiedNativeAdCallback.onAdLoaded(privacySheetData);
        }
    }

    private static final class NastAdapter extends NativeNetworkAdapter {
        private NastAdapter() {
        }

        @Override // io.bidmachine.nativead.NativeNetworkAdapter, io.bidmachine.nativead.NativePublicData
        public boolean hasVideo() {
            return (TextUtils.isEmpty(getVideoAdm()) && TextUtils.isEmpty(getVideoUrl())) ? false : true;
        }
    }
}
