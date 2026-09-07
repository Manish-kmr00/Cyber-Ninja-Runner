package com.pubmatic.sdk.nativead;

import android.view.View;
import com.pubmatic.sdk.nativead.response.POBNativeAdDataResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdImageResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdTitleResponseAsset;
import com.pubmatic.sdk.nativead.views.POBNativeTemplateView;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface POBNativeAd {
    void destroy();

    POBNativeAdView getAdView();

    POBNativeAdDataResponseAsset getDataAssetForId(int i);

    POBNativeAdImageResponseAsset getImageAssetForId(int i);

    POBNativeAdTitleResponseAsset getTitleAssetForId(int i);

    void registerViewForInteraction(View view, List<View> list, POBNativeAdListener pOBNativeAdListener);

    void renderAd(POBNativeAdListener pOBNativeAdListener);

    void renderAd(POBNativeTemplateView pOBNativeTemplateView, POBNativeAdListener pOBNativeAdListener);
}
