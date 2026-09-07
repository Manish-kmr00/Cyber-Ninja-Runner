package io.bidmachine;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FullScreenAdRequestParameters extends AdRequestParameters {
    private final AdContentType adContentType;

    public FullScreenAdRequestParameters(AdsFormat adsFormat, AdContentType adContentType) {
        super(adsFormat);
        this.adContentType = adContentType;
    }

    public AdContentType getAdContentType() {
        return this.adContentType;
    }

    public boolean isContentTypeMatch(AdContentType adContentType) {
        return this.adContentType == AdContentType.All || this.adContentType == adContentType;
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return super.isParametersMatched(adRequestParameters) && (adRequestParameters instanceof FullScreenAdRequestParameters) && isParametersMatchedInternal((FullScreenAdRequestParameters) adRequestParameters);
    }

    private boolean isParametersMatchedInternal(FullScreenAdRequestParameters fullScreenAdRequestParameters) {
        return isContentTypeMatch(fullScreenAdRequestParameters.getAdContentType());
    }
}
