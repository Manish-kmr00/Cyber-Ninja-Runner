package com.bytedance.sdk.openadsdk.pA.Og;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv implements PAGNativeAdData {
    private final pA pA;

    public ZZv(pA pAVar) {
        this.pA = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGImageItem getIcon() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.KZx();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getTitle() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.ZZv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getDescription() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.ML();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getButtonText() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.JG();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGMediaView getMediaView() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.SD();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdLogoView() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.SGo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGNativeAdData.PAGNativeMediaType getMediaType() {
        if (yFO.ML(this.pA.pA)) {
            return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo;
        }
        return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdChoicesView() {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.BSW();
        }
        return null;
    }
}
