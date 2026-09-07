package io.bidmachine;

import android.content.Context;
import io.bidmachine.AdListener;
import io.bidmachine.AdRequest;
import io.bidmachine.IAd;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.AdObject;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BidMachineAd<SelfType extends IAd, AdRequestType extends AdRequest<AdRequestType, ?, UnifiedAdRequestParamsType>, AdObjectType extends AdObject<AdObjectParamsType, UnifiedAdRequestParamsType, ?>, AdObjectParamsType extends AdObjectParams, UnifiedAdRequestParamsType extends UnifiedAdRequestParams, AdListenerType extends AdListener<SelfType>> implements IAd<SelfType, AdRequestType> {
    AdRequestType adRequest;
    private final AdsType adsType;
    private final ContextProvider contextProvider;
    private AdListenerType listener;
    private final Tag tag = new Tag("BidMachineAd");
    private State currentState = State.Idle;
    private final AdRequest.AdRequestListener<AdRequestType> adRequestListener = (AdRequest.AdRequestListener<AdRequestType>) new AdRequest.AdRequestListener<AdRequestType>() { // from class: io.bidmachine.BidMachineAd.2
        @Override // io.bidmachine.AdRequest.AdRequestListener
        public void onRequestSuccess(AdRequestType adrequesttype, AuctionResult auctionResult) {
            if (adrequesttype == BidMachineAd.this.adRequest) {
                BidMachineAd.this.processRequestSuccess(adrequesttype);
            }
        }

        @Override // io.bidmachine.AdRequest.AdRequestListener
        public void onRequestFailed(AdRequestType adrequesttype, BMError bMError) {
            if (adrequesttype == BidMachineAd.this.adRequest) {
                BidMachineAd.this.processRequestFail(bMError);
            }
        }

        @Override // io.bidmachine.AdRequest.AdRequestListener
        public void onRequestExpired(AdRequestType adrequesttype) {
            if (adrequesttype == BidMachineAd.this.adRequest) {
                BidMachineAd.this.adProcessCallback.processExpired();
            }
        }
    };
    private final AdRequest.InternalAdRequestListener<AdRequestType> internalAdRequestListener = (AdRequest.InternalAdRequestListener<AdRequestType>) new AdRequest.InternalAdRequestListener<AdRequestType>() { // from class: io.bidmachine.BidMachineAd.3
        @Override // io.bidmachine.AdRequest.InternalAdRequestListener
        public void onRequestDestroyed(AdRequestType adrequesttype) {
            if (adrequesttype == BidMachineAd.this.adRequest) {
                BidMachineAd.this.destroy();
            }
        }
    };
    final AdProcessCallback adProcessCallback = new AnonymousClass4();
    final BidMachineTrackingObject trackingObject = new BidMachineTrackingObject() { // from class: io.bidmachine.BidMachineAd.1
        @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
        public List<String> getTrackingUrls(TrackEventType trackEventType) {
            AdResponse adResponse = BidMachineAd.this.getAdResponse();
            if (adResponse != null) {
                return adResponse.getTrackUrls(trackEventType);
            }
            return null;
        }

        @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
        public AdExtension.EventConfiguration getEventConfiguration() {
            AdResponse adResponse = BidMachineAd.this.getAdResponse();
            if (adResponse != null) {
                return adResponse.getEventConfiguration();
            }
            return super.getEventConfiguration();
        }
    };
    protected final AtomicBoolean isFinishTracked = new AtomicBoolean(false);
    protected final AtomicBoolean isCloseTracked = new AtomicBoolean(false);

    enum State {
        Idle,
        Requesting,
        Loading,
        Success,
        Failed,
        Destroyed,
        Expired
    }

    protected abstract AdObjectType createAdObject(ContextProvider contextProvider, AdRequestType adrequesttype, NetworkAdapter networkAdapter, AdObjectParams adObjectParams, AdProcessCallback adProcessCallback);

    public BidMachineAd(Context context, AdsType adsType) {
        this.contextProvider = new SimpleContextProvider(context);
        this.adsType = adsType;
    }

    Context getContext() {
        return this.contextProvider.getApplicationContext();
    }

    AdsType getAdsType() {
        return this.adsType;
    }

    ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    @Override // io.bidmachine.IAd
    public AuctionResult getAuctionResult() {
        AdRequestType adrequesttype = this.adRequest;
        if (adrequesttype != null) {
            return adrequesttype.getAuctionResult();
        }
        return null;
    }

    protected final AdResponse getAdResponse() {
        AdRequestType adrequesttype = this.adRequest;
        if (adrequesttype != null) {
            return adrequesttype.getAdResponse();
        }
        return null;
    }

    protected final AdObjectType getLoadedAdObject() {
        AdResponse adResponse = getAdResponse();
        if (adResponse == null) {
            return null;
        }
        try {
            return (AdObjectType) adResponse.getAdObject();
        } catch (Throwable unused) {
            return null;
        }
    }

    public SelfType setListener(AdListenerType adlistenertype) {
        this.listener = adlistenertype;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyAdRequest() {
        AdRequestType adrequesttype = this.adRequest;
        this.adRequest = null;
        if (adrequesttype != null) {
            detachRequest(adrequesttype);
            adrequesttype.destroy();
        }
    }

    @Override // io.bidmachine.IAd
    public SelfType load(AdRequestType adrequesttype) {
        log("load requested");
        this.trackingObject.eventStart(TrackEventType.Load);
        if (!BidMachineImpl.get().isInitialized()) {
            processRequestFail(BMError.internal("BidMachine not initialized"));
            return this;
        }
        if (this.currentState != State.Idle) {
            log("request process abort because it's already processing");
            return this;
        }
        if (adrequesttype == null) {
            processRequestFail(BMError.notFound("AdRequest"));
            return this;
        }
        detachRequest(this.adRequest);
        this.adRequest = adrequesttype;
        attachRequest(adrequesttype);
        processRequest(adrequesttype);
        return this;
    }

    @Override // io.bidmachine.IAd
    public void destroy() {
        this.adProcessCallback.processDestroy();
        this.trackingObject.clear();
    }

    @Override // io.bidmachine.IAd
    public boolean isLoading() {
        return this.currentState == State.Requesting || this.currentState == State.Loading;
    }

    @Override // io.bidmachine.IAd
    public boolean isLoaded() {
        return getLoadedAdObject() != null && this.currentState == State.Success;
    }

    @Override // io.bidmachine.IAd
    public boolean canShow() {
        return isLoaded() && isCanShowAd() && isNetworkAvailableDuringShow();
    }

    @Override // io.bidmachine.IAd
    public boolean isDestroyed() {
        return this.currentState == State.Destroyed;
    }

    @Override // io.bidmachine.IAd
    public boolean isExpired() {
        return this.currentState == State.Expired;
    }

    protected AdObjectType prepareShow(boolean z) {
        processPrepareShow();
        if (!isNetworkAvailableDuringShow()) {
            processShowFail(BMError.NoConnection);
            return null;
        }
        if (isDestroyed()) {
            processShowFail(BMError.Destroyed);
            return null;
        }
        if (isExpired()) {
            processShowFail(BMError.Expired);
            return null;
        }
        if (!isLoaded()) {
            processShowFail(BMError.internal("Ad not loaded"));
            return null;
        }
        if (z && !isCanShowAd()) {
            processShowFail(BMError.ResponseDuplicated);
            return null;
        }
        return (AdObjectType) getLoadedAdObject();
    }

    private boolean isNetworkAvailableDuringShow() {
        return BidMachineSettings.isShowWithoutInternet() || Utils.isNetworkAvailable(getContext());
    }

    boolean isCanShowAd() {
        AdResponse adResponse = getAdResponse();
        return (adResponse == null || adResponse.wasShown()) ? false : true;
    }

    private void processRequest(AdRequestType adrequesttype) {
        log("process request start");
        if (getAuctionResult() != null) {
            processRequestSuccess(adrequesttype);
        } else {
            this.currentState = State.Requesting;
            adrequesttype.request(getContext());
        }
    }

    void processRequestSuccess(AdRequestType adrequesttype) {
        if (this.currentState.ordinal() > State.Loading.ordinal()) {
            return;
        }
        this.currentState = State.Loading;
        AdResponse adResponse = adrequesttype.getAdResponse();
        if (adResponse == null) {
            processRequestFail(BMError.incorrectContent("AdResponse is null"));
        } else {
            log("start loading");
            adResponse.loadAdObject(this.contextProvider, adrequesttype, this, this.adProcessCallback);
        }
    }

    private void attachRequest(AdRequestType adrequesttype) {
        if (adrequesttype != null) {
            adrequesttype.addListener(this.adRequestListener);
            adrequesttype.addInternalListener(this.internalAdRequestListener);
        }
    }

    private void detachRequest(AdRequestType adrequesttype) {
        if (adrequesttype != null) {
            adrequesttype.removeListener(this.adRequestListener);
            adrequesttype.removeInternalListener(this.internalAdRequestListener);
        }
    }

    void processRequestFail(BMError bMError) {
        if (this.currentState.ordinal() > State.Loading.ordinal()) {
            return;
        }
        trackEvent(TrackEventType.Load, bMError);
        this.adProcessCallback.processLoadFail(bMError);
    }

    void processPrepareShow() {
        trackEvent(TrackEventType.ImpressionOpportunity, null);
    }

    void processShowFail(BMError bMError) {
        trackEvent(TrackEventType.Show, bMError);
        this.adProcessCallback.processShowFail(bMError);
    }

    private void trackEvent(TrackEventType trackEventType, BMError bMError) {
        this.trackingObject.eventFinish(trackEventType, getAdsType(), getAdResponse(), bMError);
    }

    /* JADX INFO: renamed from: io.bidmachine.BidMachineAd$4, reason: invalid class name */
    class AnonymousClass4 extends SimpleAdProcessCallback {
        private AdCridThreadHandler adCridThreadHandler;

        AnonymousClass4() {
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processLoadSuccess() {
            if (BidMachineAd.this.currentState.ordinal() > State.Loading.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processLoadSuccess");
            BidMachineAd.this.currentState = State.Success;
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BidMachineAd.this.listener != null) {
                        BidMachineAd.this.log("notify AdLoaded");
                        BidMachineAd.this.listener.onAdLoaded(BidMachineAd.this);
                    }
                }
            });
            Utils.ifNotNull(BidMachineAd.this.getAdResponse(), new Executable() { // from class: io.bidmachine.BidMachineAd$4$$ExternalSyntheticLambda4
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    this.f$0.m7354lambda$processLoadSuccess$0$iobidmachineBidMachineAd$4((AdResponse) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processLoadSuccess$0$io-bidmachine-BidMachineAd$4, reason: not valid java name */
        /* synthetic */ void m7354lambda$processLoadSuccess$0$iobidmachineBidMachineAd$4(AdResponse adResponse) {
            Utils.ifNotNull(this.adCridThreadHandler, new BidMachineAd$4$$ExternalSyntheticLambda0());
            if (adResponse.isCridMonitoringEnabled) {
                this.adCridThreadHandler = new AdCridThreadHandler(adResponse.getAuctionResult().getCreativeId());
            }
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processLoadFail(final BMError bMError) {
            BidMachineAd.this.log("processLoadFail - " + bMError);
            BidMachineAd.this.currentState = State.Failed;
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd$4$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m7353lambda$processLoadFail$1$iobidmachineBidMachineAd$4(bMError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processLoadFail$1$io-bidmachine-BidMachineAd$4, reason: not valid java name */
        /* synthetic */ void m7353lambda$processLoadFail$1$iobidmachineBidMachineAd$4(BMError bMError) {
            if (BidMachineAd.this.listener != null) {
                BidMachineAd.this.log("notify AdLoadFailed");
                BidMachineAd.this.listener.onAdLoadFailed(BidMachineAd.this, bMError);
            }
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processFillAd() {
            if (BidMachineAd.this.currentState.ordinal() > State.Success.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processFillAd");
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processShowFail(final BMError bMError) {
            BidMachineAd.this.log("processShowFail - " + bMError);
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m7355lambda$processShowFail$2$iobidmachineBidMachineAd$4(bMError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processShowFail$2$io-bidmachine-BidMachineAd$4, reason: not valid java name */
        /* synthetic */ void m7355lambda$processShowFail$2$iobidmachineBidMachineAd$4(BMError bMError) {
            if (BidMachineAd.this.listener != null) {
                BidMachineAd.this.log("notify AdShowFailed");
                BidMachineAd.this.listener.onAdShowFailed(BidMachineAd.this, bMError);
            }
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processShown() {
            if (BidMachineAd.this.currentState.ordinal() > State.Success.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processShown");
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd.4.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BidMachineAd.this.listener != null) {
                        BidMachineAd.this.log("notify AdImpression");
                        BidMachineAd.this.listener.onAdImpression(BidMachineAd.this);
                    }
                }
            });
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processVisibilityTrackerImpression() {
            if (BidMachineAd.this.currentState.ordinal() > State.Success.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processImpression");
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processClicked() {
            if (BidMachineAd.this.currentState.ordinal() > State.Success.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processClicked");
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd.4.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BidMachineAd.this.listener != null) {
                        BidMachineAd.this.log("notify AdClicked");
                        BidMachineAd.this.listener.onAdClicked(BidMachineAd.this);
                    }
                }
            });
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processFinished() {
            if (BidMachineAd.this.currentState.ordinal() <= State.Success.ordinal() && BidMachineAd.this.isFinishTracked.compareAndSet(false, true)) {
                BidMachineAd.this.log("processFinished");
                Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd.4.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BidMachineAd.this.listener instanceof AdRewardedListener) {
                            BidMachineAd.this.log("notify AdRewarded");
                            ((AdRewardedListener) BidMachineAd.this.listener).onAdRewarded(BidMachineAd.this);
                        }
                    }
                });
            }
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processClosed() {
            if (BidMachineAd.this.currentState.ordinal() <= State.Success.ordinal() && BidMachineAd.this.isCloseTracked.compareAndSet(false, true)) {
                BidMachineAd.this.log("processClosed (" + BidMachineAd.this.isFinishTracked.get() + ")");
                Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd$4$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m7352lambda$processClosed$3$iobidmachineBidMachineAd$4();
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$processClosed$3$io-bidmachine-BidMachineAd$4, reason: not valid java name */
        /* synthetic */ void m7352lambda$processClosed$3$iobidmachineBidMachineAd$4() {
            if (BidMachineAd.this.listener instanceof AdFullScreenListener) {
                BidMachineAd.this.log("notify AdClosed");
                AdFullScreenListener adFullScreenListener = (AdFullScreenListener) BidMachineAd.this.listener;
                BidMachineAd bidMachineAd = BidMachineAd.this;
                adFullScreenListener.onAdClosed(bidMachineAd, bidMachineAd.isFinishTracked.get());
            }
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processExpired() {
            if (BidMachineAd.this.currentState.ordinal() > State.Success.ordinal()) {
                return;
            }
            BidMachineAd.this.log("processExpired");
            BidMachineAd.this.currentState = State.Expired;
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineAd.4.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BidMachineAd.this.listener != null) {
                        BidMachineAd.this.log("notify AdExpired");
                        BidMachineAd.this.listener.onAdExpired(BidMachineAd.this);
                    }
                }
            });
            Utils.ifNotNull(this.adCridThreadHandler, new BidMachineAd$4$$ExternalSyntheticLambda0());
            this.adCridThreadHandler = null;
        }

        @Override // io.bidmachine.SimpleAdProcessCallback, io.bidmachine.AdProcessCallback
        public void processDestroy() {
            BidMachineAd.this.log("destroy requested");
            BidMachineAd.this.currentState = State.Destroyed;
            AdResponse adResponse = BidMachineAd.this.getAdResponse();
            if (adResponse != null) {
                adResponse.removeCallback(this);
            }
            BidMachineAd.this.destroyAdRequest();
            Utils.ifNotNull(this.adCridThreadHandler, new BidMachineAd$4$$ExternalSyntheticLambda0());
            this.adCridThreadHandler = null;
        }
    }

    public String toString() {
        return this.tag + ", state - " + this.currentState + ", auctionResult - " + getAuctionResult();
    }

    protected final void log(final String str) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineAd$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7351lambda$log$0$iobidmachineBidMachineAd(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$log$0$io-bidmachine-BidMachineAd, reason: not valid java name */
    /* synthetic */ String m7351lambda$log$0$iobidmachineBidMachineAd(String str) {
        StringBuilder sb = new StringBuilder(this.adsType.name());
        AuctionResult auctionResult = getAuctionResult();
        if (auctionResult != null) {
            sb.append(" (");
            sb.append(auctionResult.getNetworkKey());
            sb.append(")");
        }
        return String.format("%s - %s", sb, str);
    }
}
