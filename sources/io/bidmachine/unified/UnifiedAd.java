package io.bidmachine.unified;

import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public abstract class UnifiedAd<UnifiedAdCallbackType extends UnifiedAdCallback, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    public Map<String, Object> getCustomParams() {
        return null;
    }

    public abstract void load(ContextProvider contextProvider, UnifiedAdCallbackType unifiedadcallbacktype, UnifiedAdRequestParamsType unifiedadrequestparamstype, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable;

    public void onClicked() {
    }

    public void onDestroy() {
    }

    public void onExpired() {
    }

    public void onImpression() {
    }

    public void onShowFailed() {
    }

    public void onShown() {
    }
}
