package io.bidmachine.ads.networks.nast;

import android.text.TextUtils;
import io.bidmachine.Function;
import io.bidmachine.LabelData;
import io.bidmachine.MediaAssetType;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.nativead.NativeAdRequestParameters;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public class NastParams extends UnifiedParams {
    final LabelData adLabelData;
    final String callToAction;
    final String clickUrl;
    final String description;
    final String iconUrl;
    final String imageUrl;
    final PrivacySheetData privacySheetData;
    final Float rating;
    final String title;
    final String videoAdm;
    final String videoUrl;

    NastParams(UnifiedMediationParams unifiedMediationParams) {
        super(unifiedMediationParams);
        this.title = unifiedMediationParams.getStringOrNull("title");
        this.description = unifiedMediationParams.getStringOrNull("description");
        this.callToAction = unifiedMediationParams.getStringOrNull("cta");
        this.rating = unifiedMediationParams.getFloatOrNull("rating");
        this.iconUrl = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_ICON_URL);
        this.imageUrl = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_IMAGE_URL);
        this.videoUrl = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_VIDEO_URL);
        this.videoAdm = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_VIDEO_ADM);
        this.clickUrl = unifiedMediationParams.getStringOrNull("clickUrl");
        this.adLabelData = (LabelData) unifiedMediationParams.getOrNullSafely(UnifiedMediationParams.KEY_AD_LABEL, new Function() { // from class: io.bidmachine.ads.networks.nast.NastParams$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Function
            public final Object apply(Object obj) {
                return NastParams.lambda$new$0(obj);
            }
        });
        this.privacySheetData = (PrivacySheetData) unifiedMediationParams.getOrNullSafely(UnifiedMediationParams.KEY_PRIVACY_SHEET, new Function() { // from class: io.bidmachine.ads.networks.nast.NastParams$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Function
            public final Object apply(Object obj) {
                return NastParams.lambda$new$1(obj);
            }
        });
    }

    static /* synthetic */ LabelData lambda$new$0(Object obj) {
        return (LabelData) obj;
    }

    static /* synthetic */ PrivacySheetData lambda$new$1(Object obj) {
        return (PrivacySheetData) obj;
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback unifiedAdCallback) {
        if (TextUtils.isEmpty(this.title)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound("title"));
            return false;
        }
        if (!TextUtils.isEmpty(this.callToAction)) {
            return true;
        }
        unifiedAdCallback.onAdLoadFailed(BMError.notFound("cta"));
        return false;
    }

    boolean isValid(UnifiedNativeAdRequestParams unifiedNativeAdRequestParams, UnifiedAdCallback unifiedAdCallback) {
        if (!isValid(unifiedAdCallback)) {
            return false;
        }
        NativeAdRequestParameters adRequestParameters = unifiedNativeAdRequestParams.getAdRequestParameters();
        if (adRequestParameters.isValidateAssets() && adRequestParameters.containsAssetType(MediaAssetType.Icon) && TextUtils.isEmpty(this.iconUrl)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound(UnifiedMediationParams.KEY_ICON_URL));
            return false;
        }
        if (adRequestParameters.isValidateAssets() && adRequestParameters.containsAssetType(MediaAssetType.Image) && TextUtils.isEmpty(this.imageUrl)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound(UnifiedMediationParams.KEY_IMAGE_URL));
            return false;
        }
        if (!adRequestParameters.isValidateAssets() || !adRequestParameters.containsAssetType(MediaAssetType.Video) || !TextUtils.isEmpty(this.videoAdm) || !TextUtils.isEmpty(this.videoUrl)) {
            return true;
        }
        unifiedAdCallback.onAdLoadFailed(BMError.notFound("videoAdm or videoUrl"));
        return false;
    }
}
