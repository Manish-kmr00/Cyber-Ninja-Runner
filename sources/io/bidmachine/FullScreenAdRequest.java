package io.bidmachine;

import io.bidmachine.FullScreenAdRequest;
import io.bidmachine.displays.PlacementBuilder;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;

/* JADX INFO: loaded from: classes.dex */
public abstract class FullScreenAdRequest<SelfType extends FullScreenAdRequest<SelfType>> extends AdRequest<SelfType, FullScreenAdRequestParameters, UnifiedFullscreenAdRequestParams> {
    protected FullScreenAdRequest(FullScreenAdRequestParameters fullScreenAdRequestParameters) {
        super(fullScreenAdRequestParameters);
    }

    public AdContentType getAdContentType() {
        return getAdRequestParameters().getAdContentType();
    }

    @Override // io.bidmachine.AdRequest
    boolean isPlacementBuilderMatch(PlacementBuilder placementBuilder) {
        return super.isPlacementBuilderMatch(placementBuilder) && getAdRequestParameters().isContentTypeMatch(placementBuilder.getAdContentType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.AdRequest
    public UnifiedFullscreenAdRequestParams createUnifiedAdRequestParams(FullScreenAdRequestParameters fullScreenAdRequestParameters, TargetingParams targetingParams, DataRestrictions dataRestrictions) {
        return new FullscreenUnifiedAdRequestParams(fullScreenAdRequestParameters, targetingParams, dataRestrictions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class FullScreenRequestBuilder<SelfType extends FullScreenRequestBuilder<SelfType, ReturnType>, ReturnType extends FullScreenAdRequest<ReturnType>> extends AdRequest.AdRequestBuilderImpl<SelfType, ReturnType, FullScreenAdRequestParameters> {
        protected AdContentType adContentType = AdContentType.All;

        protected FullScreenRequestBuilder() {
        }

        protected SelfType setAdContentType(AdContentType adContentType) {
            this.adContentType = adContentType;
            return this;
        }
    }

    private static class FullscreenUnifiedAdRequestParams extends UnifiedAdRequestParamsImpl<FullScreenAdRequestParameters> implements UnifiedFullscreenAdRequestParams {
        @Override // io.bidmachine.UnifiedAdRequestParamsImpl, io.bidmachine.unified.UnifiedAdRequestParams, io.bidmachine.unified.UnifiedFullscreenAdRequestParams
        public /* bridge */ /* synthetic */ FullScreenAdRequestParameters getAdRequestParameters() {
            return (FullScreenAdRequestParameters) super.getAdRequestParameters();
        }

        private FullscreenUnifiedAdRequestParams(FullScreenAdRequestParameters fullScreenAdRequestParameters, TargetingParams targetingParams, DataRestrictions dataRestrictions) {
            super(fullScreenAdRequestParameters, targetingParams, dataRestrictions);
        }
    }
}
