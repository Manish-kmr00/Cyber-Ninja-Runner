package io.bidmachine.ads.networks.gam;

import android.text.TextUtils;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
class GAMParams extends UnifiedParams {
    final String adUnitId;
    final String price;
    final String score;

    GAMParams(UnifiedMediationParams unifiedMediationParams) {
        super(unifiedMediationParams);
        this.adUnitId = unifiedMediationParams.getStringOrNull("ad_unit_id");
        this.score = unifiedMediationParams.getStringOrNull("score");
        this.price = unifiedMediationParams.getStringOrNull("price");
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback unifiedAdCallback) {
        if (TextUtils.isEmpty(this.adUnitId)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound("ad_unit_id"));
            return false;
        }
        if (TextUtils.isEmpty(this.score)) {
            unifiedAdCallback.onAdLoadFailed(BMError.notFound("score"));
            return false;
        }
        if (!TextUtils.isEmpty(this.price)) {
            return true;
        }
        unifiedAdCallback.onAdLoadFailed(BMError.notFound("price"));
        return false;
    }
}
