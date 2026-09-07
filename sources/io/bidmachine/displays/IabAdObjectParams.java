package io.bidmachine.displays;

import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedMediationParams;

/* JADX INFO: loaded from: classes5.dex */
class IabAdObjectParams extends AdObjectParams {
    IabAdObjectParams(Ad ad) {
        super(ad);
        getData().put("creativeId", ad.getId());
    }

    @Override // io.bidmachine.models.AdObjectParams
    public boolean isValid() {
        Object obj = getData().get(UnifiedMediationParams.KEY_CREATIVE_ADM);
        return (obj instanceof CharSequence) && !TextUtils.isEmpty((CharSequence) obj);
    }

    void setCreativeAdm(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getData().put(UnifiedMediationParams.KEY_CREATIVE_ADM, str);
    }
}
