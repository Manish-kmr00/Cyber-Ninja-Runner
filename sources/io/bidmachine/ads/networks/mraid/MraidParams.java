package io.bidmachine.ads.networks.mraid;

import android.text.TextUtils;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.IabUtils;

/* JADX INFO: loaded from: classes5.dex */
class MraidParams extends UnifiedParams {
    final CacheControl cacheControl;
    final IabElementStyle closeableViewStyle;
    final IabElementStyle countDownStyle;
    final String creativeAdm;
    final int height;
    final boolean omsdkEnabled;
    final float placeholderTimeoutSec;
    final int progressDuration;
    final IabElementStyle progressStyle;
    final boolean r1;
    final boolean r2;
    final int skipOffset;
    final String storeUrl;
    final boolean useNativeClose;
    final int width;

    MraidParams(UnifiedMediationParams unifiedMediationParams) {
        super(unifiedMediationParams);
        this.creativeAdm = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_CREATIVE_ADM);
        this.width = unifiedMediationParams.getInteger("width");
        this.height = unifiedMediationParams.getInteger("height");
        this.cacheControl = IabUtils.toCacheControl(unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_CACHE_CONTROL));
        this.placeholderTimeoutSec = unifiedMediationParams.getFloat(UnifiedMediationParams.KEY_PLACEHOLDER_TIMEOUT_SEC);
        this.skipOffset = unifiedMediationParams.getInteger(UnifiedMediationParams.KEY_SKIP_OFFSET);
        this.useNativeClose = unifiedMediationParams.getBoolean(UnifiedMediationParams.KEY_USE_NATIVE_CLOSE);
        this.omsdkEnabled = unifiedMediationParams.getBoolean(UnifiedMediationParams.KEY_OM_SDK_ENABLED, true);
        this.r1 = unifiedMediationParams.getBoolean(UnifiedMediationParams.KEY_R1);
        this.r2 = unifiedMediationParams.getBoolean(UnifiedMediationParams.KEY_R2);
        this.storeUrl = unifiedMediationParams.getStringOrNull(UnifiedMediationParams.KEY_STORE_URL);
        this.progressDuration = unifiedMediationParams.getInteger(UnifiedMediationParams.KEY_PROGRESS_DURATION);
        Object objectOrNull = unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_CLOSE_BUTTON_CONTROL_ASSET);
        this.closeableViewStyle = objectOrNull instanceof AdExtension.ControlAsset ? IabUtils.transform((AdExtension.ControlAsset) objectOrNull) : null;
        Object objectOrNull2 = unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_COUNTDOWN_CONTROL_ASSET);
        this.countDownStyle = objectOrNull2 instanceof AdExtension.ControlAsset ? IabUtils.transform((AdExtension.ControlAsset) objectOrNull2) : null;
        Object objectOrNull3 = unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_PROGRESS_CONTROL_ASSET);
        this.progressStyle = objectOrNull3 instanceof AdExtension.ControlAsset ? IabUtils.transform((AdExtension.ControlAsset) objectOrNull3) : null;
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback unifiedAdCallback) {
        if (TextUtils.isEmpty(this.creativeAdm)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound(UnifiedMediationParams.KEY_CREATIVE_ADM));
            return false;
        }
        if (this.width == 0) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound("width"));
            return false;
        }
        if (this.height != 0) {
            return true;
        }
        unifiedAdCallback.onAdLoadFailed(BMError.notFound("height"));
        return false;
    }
}
