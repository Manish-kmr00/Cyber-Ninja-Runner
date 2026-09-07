package io.bidmachine;

import android.app.Activity;
import android.content.Context;
import io.bidmachine.AdRequest;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.models.AdObject;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedAd;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdObjectImpl<AdRequestType extends AdRequest<AdRequestType, ?, UnifiedAdRequestParamsType>, AdObjectParamsType extends AdObjectParams, UnifiedAdType extends UnifiedAd<UnifiedAdCallbackType, UnifiedAdRequestParamsType>, UnifiedAdCallbackType extends UnifiedAdCallback, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> implements AdObject<AdObjectParamsType, UnifiedAdRequestParamsType, UnifiedAdCallbackType> {
    private final AdObjectParamsType adObjectParams;
    private final AdRequestType adRequest;
    private final ContextProvider contextProvider;
    private final AdProcessCallback processCallback;
    private final UnifiedAdType unifiedAd;
    private final UnifiedAdCallbackType unifiedAdCallback;

    @Override // io.bidmachine.models.AdObject
    public void hide() {
    }

    public AdObjectImpl(ContextProvider contextProvider, AdProcessCallback adProcessCallback, AdRequestType adrequesttype, AdObjectParamsType adobjectparamstype, UnifiedAdType unifiedadtype) {
        this.contextProvider = contextProvider;
        this.processCallback = adProcessCallback;
        this.adRequest = adrequesttype;
        this.adObjectParams = adobjectparamstype;
        this.unifiedAd = unifiedadtype;
        this.unifiedAdCallback = createUnifiedCallback(adProcessCallback);
    }

    public Context getApplicationContext() {
        return this.contextProvider.getApplicationContext();
    }

    public Activity getActivity() {
        return this.contextProvider.getActivity();
    }

    public AdRequestType getAdRequest() {
        return this.adRequest;
    }

    @Override // io.bidmachine.models.AdObject
    public AdObjectParamsType getParams() {
        return this.adObjectParams;
    }

    public UnifiedAdType getUnifiedAd() {
        return this.unifiedAd;
    }

    public UnifiedAdCallbackType getUnifiedAdCallback() {
        return this.unifiedAdCallback;
    }

    public AdProcessCallback getProcessCallback() {
        return this.processCallback;
    }

    @Override // io.bidmachine.models.AdObject
    public void load(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype, NetworkAdUnit networkAdUnit) throws Throwable {
        this.unifiedAd.load(contextProvider, this.unifiedAdCallback, unifiedadrequestparamstype, this.adObjectParams.getMediationParams(), networkAdUnit);
    }

    @Override // io.bidmachine.models.AdObject
    public void onShown() {
        getUnifiedAd().onShown();
    }

    @Override // io.bidmachine.models.AdObject
    public void onShowFailed() {
        getUnifiedAd().onShowFailed();
    }

    @Override // io.bidmachine.models.AdObject
    public void onImpression() {
        getUnifiedAd().onImpression();
    }

    @Override // io.bidmachine.models.AdObject
    public void onClicked() {
        getUnifiedAd().onClicked();
    }

    @Override // io.bidmachine.models.AdObject
    public void onFinished() {
        UnifiedAd unifiedAd = getUnifiedAd();
        if (unifiedAd instanceof UnifiedFullscreenAd) {
            ((UnifiedFullscreenAd) unifiedAd).onFinished();
        }
    }

    @Override // io.bidmachine.models.AdObject
    public void onClosed(boolean z) {
        UnifiedAd unifiedAd = getUnifiedAd();
        if (unifiedAd instanceof UnifiedFullscreenAd) {
            ((UnifiedFullscreenAd) unifiedAd).onClosed(z);
        }
    }

    @Override // io.bidmachine.models.AdObject
    public void onExpired() {
        getUnifiedAd().onExpired();
    }

    @Override // io.bidmachine.models.AdObject
    public void onDestroy() {
        getUnifiedAd().onDestroy();
    }

    @Override // io.bidmachine.models.AdObject
    public Map<String, Object> getCustomParams() {
        return getUnifiedAd().getCustomParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static class BaseUnifiedAdCallback implements UnifiedAdCallback {
        protected final AdProcessCallback processCallback;

        public BaseUnifiedAdCallback(AdProcessCallback adProcessCallback) {
            this.processCallback = adProcessCallback;
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void onAdLoadFailed(BMError bMError) {
            this.processCallback.processLoadFail(bMError);
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void onAdClicked() {
            this.processCallback.processClicked();
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void onAdShown() {
            this.processCallback.processShown();
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void onAdShowFailed(BMError bMError) {
            this.processCallback.processShowFail(bMError);
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void onAdExpired() {
            this.processCallback.processExpired();
        }

        @Override // io.bidmachine.unified.UnifiedAdCallback
        public void setVisibilitySource(VisibilitySource visibilitySource) {
            this.processCallback.setVisibilitySource(visibilitySource);
        }
    }
}
