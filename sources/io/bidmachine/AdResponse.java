package io.bidmachine;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.models.AdObject;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.protobuf.AdCacheControl;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
class AdResponse implements ExpirationHandler.Listener {
    private static final long DEF_EXPIRATION_TIME_SEC = TimeUnit.MINUTES.toSeconds(29);
    private final Ad ad;
    private final AdCacheControl adCacheControl;
    final AdProcessCallbackComposite adCallbackComposite;
    private volatile AdObject adObject;
    private final AdRequestParameters adRequestParameters;
    private final AuctionResult auctionResult;
    private final String bidId;
    private final long createTimeMs;
    private final AdExtension.EventConfiguration eventConfiguration;
    private final ExpirationHandler expirationHandler;
    private final long expirationTimeMs;
    final boolean isCridMonitoringEnabled;
    ExpirationHandler loadExpirationHandler;
    private final NetworkAdUnitManager networkAdUnitManager;
    private final String responseId;
    private final Struct seatBidExt;
    private final Tag tag;
    final BidMachineTrackingObject trackingObject;
    private final NetworkAdUnit winnerNetworkAdUnit;
    final Map<TrackEventType, List<String>> trackUrlsMap = new EnumMap(TrackEventType.class);
    private final AtomicBoolean isExpired = new AtomicBoolean(false);
    final List<WeakReference<AdRequest<?, ?, ?>>> weakAdRequestList = new CopyOnWriteArrayList();
    private volatile AdResponseStatus status = AdResponseStatus.Idle;

    public AdResponse(AdRequestParameters adRequestParameters, NetworkAdUnitManager networkAdUnitManager, Response response, Response.Seatbid seatbid, Response.Seatbid.Bid bid, Ad ad, NetworkAdapter networkAdapter) {
        boolean z = false;
        AdProcessCallbackComposite adProcessCallbackComposite = new AdProcessCallbackComposite(this);
        this.adCallbackComposite = adProcessCallbackComposite;
        this.tag = new Tag("AdResponse");
        this.createTimeMs = System.currentTimeMillis();
        this.adRequestParameters = adRequestParameters;
        this.networkAdUnitManager = networkAdUnitManager;
        this.responseId = response.getId();
        this.seatBidExt = seatbid.getExt();
        this.bidId = bid.getId();
        this.ad = ad;
        AdExtension adExtensionFindFirstAdExtension = ProtoUtils.findFirstAdExtension(ad);
        AuctionResultImpl auctionResultImpl = new AuctionResultImpl(adRequestParameters.getAdsType(), seatbid, bid, ad, networkAdapter, adExtensionFindFirstAdExtension);
        this.auctionResult = auctionResultImpl;
        this.eventConfiguration = findEventConfiguration(adExtensionFindFirstAdExtension);
        this.adCacheControl = findAdCacheControl(adExtensionFindFirstAdExtension);
        long orDefault = Utils.getOrDefault(bid.getExp(), Response.Seatbid.Bid.getDefaultInstance().getExp(), DEF_EXPIRATION_TIME_SEC) * 1000;
        this.expirationTimeMs = orDefault;
        this.trackingObject = new BidMachineTrackingObject(auctionResultImpl.getId()) { // from class: io.bidmachine.AdResponse.1
            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public List<String> getTrackingUrls(TrackEventType trackEventType) {
                return AdResponse.this.getTrackUrls(trackEventType);
            }

            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public AdExtension.EventConfiguration getEventConfiguration() {
                return AdResponse.this.getEventConfiguration();
            }
        };
        this.winnerNetworkAdUnit = networkAdUnitManager.findOrAddWinnerNetworkAdUnit(networkAdapter, adRequestParameters.getAdsFormat(), auctionResultImpl.getNetworkParams());
        this.expirationHandler = new ExpirationHandler(orDefault, this);
        int creativeLoadingTimeout = adExtensionFindFirstAdExtension != null ? adExtensionFindFirstAdExtension.getCreativeLoadingTimeout() : 0;
        this.loadExpirationHandler = creativeLoadingTimeout > 0 ? new ExpirationHandler(creativeLoadingTimeout, new CreativeLoadingTimeoutListener(adProcessCallbackComposite)) : null;
        if (adExtensionFindFirstAdExtension != null && adExtensionFindFirstAdExtension.getCridMonitoringEnabled()) {
            z = true;
        }
        this.isCridMonitoringEnabled = z;
        extractTrackUrls(bid);
        subscribeExpireTracker();
    }

    public AdRequestParameters getAdRequestParameters() {
        return this.adRequestParameters;
    }

    public AdsType getAdsType() {
        return this.adRequestParameters.getAdsType();
    }

    public Ad getAd() {
        return this.ad;
    }

    public AuctionResult getAuctionResult() {
        return this.auctionResult;
    }

    public double getPrice() {
        return this.auctionResult.getPrice();
    }

    public CreativeFormat getCreativeFormat() {
        return this.auctionResult.getCreativeFormat();
    }

    public AdExtension.EventConfiguration getEventConfiguration() {
        return this.eventConfiguration;
    }

    public boolean canCache() {
        return this.adCacheControl == AdCacheControl.AD_CACHE_CONTROL_ENABLED;
    }

    public long calculateExpirationLeftMs() {
        return this.expirationTimeMs - (System.currentTimeMillis() - this.createTimeMs);
    }

    public NetworkAdUnit getWinnerNetworkAdUnit() {
        return this.winnerNetworkAdUnit;
    }

    public List<String> getTrackUrlListByEvent(TrackEventType trackEventType) {
        return this.trackUrlsMap.get(trackEventType);
    }

    public boolean isExpired() {
        return this.isExpired.get();
    }

    public synchronized AdResponseStatus getStatus() {
        return this.status;
    }

    public synchronized void setStatus(AdResponseStatus adResponseStatus) {
        this.status = adResponseStatus;
    }

    public AdObject getAdObject() {
        return this.adObject;
    }

    public List<String> getTrackUrls(TrackEventType trackEventType) {
        AdObject adObject = getAdObject();
        AdObjectParams params = adObject != null ? adObject.getParams() : null;
        if (params != null) {
            return params.getTrackUrls(trackEventType);
        }
        return null;
    }

    public void attachAdRequest(AdRequest<?, ?, ?> adRequest) {
        if (adRequest == null) {
            return;
        }
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7342lambda$attachAdRequest$0$iobidmachineAdResponse();
            }
        });
        this.weakAdRequestList.add(new WeakReference<>(adRequest));
    }

    /* JADX INFO: renamed from: lambda$attachAdRequest$0$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7342lambda$attachAdRequest$0$iobidmachineAdResponse() {
        return String.format("attachRequest - %s", this);
    }

    public void detachAdRequest(AdRequest<?, ?, ?> adRequest) {
        if (adRequest == null) {
            return;
        }
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7344lambda$detachAdRequest$1$iobidmachineAdResponse();
            }
        });
        ArrayList arrayList = new ArrayList();
        for (WeakReference<AdRequest<?, ?, ?>> weakReference : this.weakAdRequestList) {
            AdRequest<?, ?, ?> adRequest2 = weakReference.get();
            if (adRequest2 == null || adRequest2 == adRequest) {
                arrayList.add(weakReference);
            }
        }
        this.weakAdRequestList.removeAll(arrayList);
        if (this.weakAdRequestList.isEmpty()) {
            release();
        }
    }

    /* JADX INFO: renamed from: lambda$detachAdRequest$1$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7344lambda$detachAdRequest$1$iobidmachineAdResponse() {
        return String.format("detachRequest - %s", this);
    }

    public synchronized void loadAdObject(ContextProvider contextProvider, AdRequest adRequest, BidMachineAd bidMachineAd, AdProcessCallback adProcessCallback) {
        onAdLoadStart(adRequest);
        this.adCallbackComposite.appendCallback(adProcessCallback);
        if (isAdLoaded()) {
            adProcessCallback.processLoadSuccess();
            return;
        }
        if (this.adCallbackComposite.isLoading.getAndSet(true)) {
            return;
        }
        this.trackingObject.eventStart(TrackEventType.Load);
        if (isExpired()) {
            this.adCallbackComposite.processLoadFail(BMError.ResponseExpired);
            return;
        }
        if (wasShown()) {
            this.adCallbackComposite.processLoadFail(BMError.ResponseDuplicated);
            return;
        }
        try {
            NetworkAdapter networkAdapterFindNetworkAdapter = adRequest.getAdsType().findNetworkAdapter(this.ad);
            if (networkAdapterFindNetworkAdapter == null) {
                this.adCallbackComposite.processLoadFail(BMError.incorrectContent("Failed to get adapter by response"));
                return;
            }
            AdObjectParams adObjectParamsCreateAdObjectParams = adRequest.getAdsType().createAdObjectParams(this.ad);
            if (adObjectParamsCreateAdObjectParams != null && adObjectParamsCreateAdObjectParams.isValid()) {
                AdObject adObjectCreateAdObject = bidMachineAd.createAdObject(contextProvider, adRequest, networkAdapterFindNetworkAdapter, adObjectParamsCreateAdObjectParams, this.adCallbackComposite);
                if (adObjectCreateAdObject == null) {
                    this.adCallbackComposite.processLoadFail(BMError.incorrectContent("Failed to create ad object by response"));
                    return;
                }
                this.adObject = adObjectCreateAdObject;
                startCreativeLoadingTimeout();
                adObjectCreateAdObject.load(contextProvider, adRequest.obtainUnifiedRequestParams(), this.winnerNetworkAdUnit);
                return;
            }
            this.adCallbackComposite.processLoadFail(BMError.incorrectContent("Failed to get parameters by response"));
        } catch (Throwable th) {
            Logger.w(th);
            this.adCallbackComposite.processLoadFail(BMError.throwable("Exception processing response", th));
        }
    }

    /* JADX INFO: renamed from: lambda$onAdLoadStart$2$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7346lambda$onAdLoadStart$2$iobidmachineAdResponse() {
        return String.format("onLoadStart - %s", this);
    }

    public void onAdLoadStart(AdRequest<?, ?, ?> adRequest) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7346lambda$onAdLoadStart$2$iobidmachineAdResponse();
            }
        });
        expireAdRequests(adRequest);
    }

    public boolean isAdLoaded() {
        return getAdObject() != null && this.adCallbackComposite.isLoaded.get();
    }

    public boolean wasShown() {
        return this.adCallbackComposite.isResultShownTracked.get();
    }

    public void removeCallback(AdProcessCallback adProcessCallback) {
        this.adCallbackComposite.removeCallback(adProcessCallback);
    }

    Value createBidCacheExtensionValue() {
        Struct.Builder builderPutFields = Struct.newBuilder().putFields("price", Value.newBuilder().setNumberValue(this.auctionResult.getPrice()).build()).putFields("exp", Value.newBuilder().setNumberValue(calculateExpirationLeftMs()).build()).putFields("request_id", Value.newBuilder().setStringValue(this.responseId).build()).putFields("bid_id", Value.newBuilder().setStringValue(this.bidId).build());
        if (this.seatBidExt.getFieldsCount() > 0) {
            builderPutFields.putFields("seat", Value.newBuilder().setStructValue(this.seatBidExt).build());
        }
        return Value.newBuilder().setStructValue(builderPutFields).build();
    }

    void destroy() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7343lambda$destroy$3$iobidmachineAdResponse();
            }
        });
        AdResponseManager.get().remove(this);
        clearCreativeLoadingTimeout();
        clearAdRequestList();
        unsubscribeExpireTracker();
        this.adCallbackComposite.destroy();
        this.trackUrlsMap.clear();
        this.networkAdUnitManager.notifyNetworkClearAuction();
        if (this.adCallbackComposite.isLoading()) {
            eventFinish(TrackEventType.Load, BMError.Destroyed);
        }
        if (this.adObject != null) {
            eventFinish(TrackEventType.Destroy);
        }
        this.trackingObject.clear();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.AdResponse.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdObject adObject = AdResponse.this.getAdObject();
                    if (adObject != null) {
                        adObject.onDestroy();
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
                AdResponse.this.adObject = null;
            }
        });
    }

    /* JADX INFO: renamed from: lambda$destroy$3$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7343lambda$destroy$3$iobidmachineAdResponse() {
        return String.format("destroy - %s", this);
    }

    void onShown() {
        unsubscribeExpireTracker();
        AdResponseManager.get().remove(this);
    }

    @Override // io.bidmachine.ExpirationHandler.Listener
    public void onExpired() {
        this.adCallbackComposite.processExpired();
    }

    /* JADX INFO: renamed from: lambda$notifyExpired$4$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7345lambda$notifyExpired$4$iobidmachineAdResponse() {
        return String.format("notifyExpired - %s", this);
    }

    void notifyExpired(boolean z) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7345lambda$notifyExpired$4$iobidmachineAdResponse();
            }
        });
        this.isExpired.set(true);
        unsubscribeExpireTracker();
        expireAdRequests(null);
        if (z) {
            destroy();
        }
    }

    void expireAdRequests(AdRequest<?, ?, ?> adRequest) {
        Iterator<WeakReference<AdRequest<?, ?, ?>>> it = this.weakAdRequestList.iterator();
        while (it.hasNext()) {
            AdRequest<?, ?, ?> adRequest2 = it.next().get();
            if (adRequest2 != null && adRequest2 != adRequest) {
                adRequest2.processExpired();
            }
        }
    }

    void clearAdRequestList() {
        Iterator<WeakReference<AdRequest<?, ?, ?>>> it = this.weakAdRequestList.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.weakAdRequestList.clear();
    }

    private boolean canBeUsedInFuture() {
        return (wasShown() || isExpired()) ? false : true;
    }

    /* JADX INFO: renamed from: lambda$release$5$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ String m7347lambda$release$5$iobidmachineAdResponse() {
        return String.format("release - %s", this);
    }

    void release() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7347lambda$release$5$iobidmachineAdResponse();
            }
        });
        AdResponseManager adResponseManager = AdResponseManager.get();
        if (canBeUsedInFuture() && adResponseManager.contains(this)) {
            clearAdRequestList();
            setStatus(AdResponseStatus.Idle);
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.AdResponse$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m7348lambda$release$6$iobidmachineAdResponse();
                }
            });
            return;
        }
        destroy();
    }

    /* JADX INFO: renamed from: lambda$release$6$io-bidmachine-AdResponse, reason: not valid java name */
    /* synthetic */ void m7348lambda$release$6$iobidmachineAdResponse() {
        try {
            AdObject adObject = getAdObject();
            if (adObject != null) {
                adObject.hide();
            }
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    AdExtension.EventConfiguration findEventConfiguration(AdExtension adExtension) {
        AdExtension.EventConfiguration eventConfiguration;
        if (adExtension == null || (eventConfiguration = adExtension.getEventConfiguration()) == AdExtension.EventConfiguration.getDefaultInstance()) {
            return null;
        }
        return eventConfiguration;
    }

    private AdCacheControl findAdCacheControl(AdExtension adExtension) {
        AdCacheControl adCacheControl;
        if (adExtension == null || (adCacheControl = adExtension.getAdCacheControl()) == AdCacheControl.UNRECOGNIZED) {
            return null;
        }
        return adCacheControl;
    }

    void startCreativeLoadingTimeout() {
        ExpirationHandler expirationHandler = this.loadExpirationHandler;
        if (expirationHandler != null) {
            expirationHandler.start();
        }
    }

    void clearCreativeLoadingTimeout() {
        ExpirationHandler expirationHandler = this.loadExpirationHandler;
        if (expirationHandler != null) {
            expirationHandler.stop();
        }
        this.loadExpirationHandler = null;
    }

    private void extractTrackUrls(Response.Seatbid.Bid bid) {
        ProtoUtils.addEvent(this.trackUrlsMap, TrackEventType.MediationWin, bid.getPurl());
        ProtoUtils.addEvent(this.trackUrlsMap, TrackEventType.MediationLoss, bid.getLurl());
    }

    private void subscribeExpireTracker() {
        this.expirationHandler.start();
    }

    void unsubscribeExpireTracker() {
        this.expirationHandler.stop();
    }

    void eventFinish(TrackEventType trackEventType) {
        eventFinish(trackEventType, null);
    }

    void eventFinish(TrackEventType trackEventType, BMError bMError) {
        this.trackingObject.eventFinish(trackEventType, getAdsType(), this, bMError);
    }

    public String toString() {
        return this.auctionResult.toString();
    }

    static class AdProcessCallbackComposite implements AdProcessCallback {
        private final WeakReference<AdResponse> weakAdResponse;
        private final Map<AdProcessCallback, Boolean> adProcessCallbackMap = new WeakHashMap();
        private final Object mutexCallback = new Object();
        final AtomicBoolean isLoaded = new AtomicBoolean(false);
        final AtomicBoolean isLoading = new AtomicBoolean(false);
        private final AtomicBoolean isLoadTracked = new AtomicBoolean(false);
        private final AtomicBoolean isShownTracked = new AtomicBoolean(false);
        private final AtomicBoolean isVisibilityTrackerStarted = new AtomicBoolean(false);
        private final AtomicBoolean isVisibilityTrackerShownTracked = new AtomicBoolean(false);
        private final AtomicBoolean isResultShownTracked = new AtomicBoolean(false);
        private final AtomicBoolean isImpressionTracked = new AtomicBoolean(false);
        private volatile boolean isFinished = false;
        private volatile VisibilitySource visibilitySource = VisibilitySource.Network;

        AdProcessCallbackComposite(AdResponse adResponse) {
            this.weakAdResponse = new WeakReference<>(adResponse);
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processLoadSuccess() {
            if (this.isLoadTracked.getAndSet(true)) {
                return;
            }
            this.isLoaded.set(true);
            this.isLoading.set(false);
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda3
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processLoadSuccess - %s", adResponse);
                    }
                });
                adResponse.clearCreativeLoadingTimeout();
                adResponse.eventFinish(TrackEventType.Load);
            }
            UserAgentManager.updateWebViewUserAgent();
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda4
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processLoadSuccess();
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processLoadFail(final BMError bMError) {
            if (this.isLoadTracked.getAndSet(true)) {
                return;
            }
            this.isLoaded.set(false);
            this.isLoading.set(false);
            AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda20
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processLoadFail - %s", bMError);
                    }
                });
                adResponse.clearCreativeLoadingTimeout();
                adResponse.eventFinish(TrackEventType.Load, bMError);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda21
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processLoadFail(bMError);
                }
            });
            processDestroy();
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processFillAd() {
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda16
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processFillAd - %s", adResponse);
                    }
                });
                if (adResponse.getAdsType().isFullscreen()) {
                    adResponse.onShown();
                }
                adResponse.eventFinish(TrackEventType.FillAd);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda17
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processFillAd();
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processShowFail(final BMError bMError) {
            AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda12
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processShowFail - %s", bMError);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onShowFailed();
                }
                adResponse.eventFinish(TrackEventType.Show, bMError);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda13
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processShowFail(bMError);
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processShown() {
            this.isShownTracked.set(true);
            if (canSendShownCallback()) {
                processResultShown();
            }
        }

        @Override // io.bidmachine.AdProcessCallback
        public boolean processVisibilityTrackerShown() {
            this.isVisibilityTrackerShownTracked.set(true);
            if (!canSendShownCallback()) {
                return false;
            }
            processResultShown();
            return true;
        }

        void processResultShown() {
            if (this.isResultShownTracked.compareAndSet(false, true)) {
                final AdResponse adResponse = getAdResponse();
                if (adResponse != null) {
                    Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda9
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return String.format("processShown - %s", adResponse);
                        }
                    });
                    adResponse.onShown();
                    AdObject adObject = adResponse.getAdObject();
                    if (adObject != null) {
                        adObject.onShown();
                    }
                    adResponse.eventFinish(TrackEventType.Show);
                }
                executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda10
                    @Override // io.bidmachine.Executable
                    public final void execute(Object obj) {
                        ((AdProcessCallback) obj).processShown();
                    }
                });
            }
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processVisibilityTrackerImpression() {
            if (this.isImpressionTracked.getAndSet(true)) {
                return;
            }
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processImpression - %s", adResponse);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onImpression();
                }
                adResponse.eventFinish(TrackEventType.Impression);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda11
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processVisibilityTrackerImpression();
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processClicked() {
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda7
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processClicked - %s", adResponse);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onClicked();
                }
                adResponse.eventFinish(TrackEventType.Click);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda8
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processClicked();
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processFinished() {
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda18
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processFinished - %s", adResponse);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onFinished();
                }
                this.isFinished = true;
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda19
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processFinished();
                }
            });
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processClosed() {
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda14
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return this.f$0.m7349x7695391b(adResponse);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onClosed(this.isFinished);
                }
                adResponse.eventFinish(TrackEventType.Close);
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda15
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processClosed();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processClosed$10$io-bidmachine-AdResponse$AdProcessCallbackComposite, reason: not valid java name */
        /* synthetic */ String m7349x7695391b(AdResponse adResponse) {
            return String.format("processClosed (%s) - %s", Boolean.valueOf(this.isFinished), adResponse);
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processExpired() {
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda5
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processExpired - %s", adResponse);
                    }
                });
                AdObject adObject = adResponse.getAdObject();
                if (adObject != null) {
                    adObject.onExpired();
                    adResponse.eventFinish(TrackEventType.Expired);
                }
            }
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda6
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processExpired();
                }
            });
            if (adResponse != null) {
                adResponse.notifyExpired(false);
            }
            processDestroy();
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processDestroy() {
            executeOnCallback(new Executable() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda1
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ((AdProcessCallback) obj).processDestroy();
                }
            });
            final AdResponse adResponse = getAdResponse();
            if (adResponse != null) {
                Logger.d(adResponse.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponse$AdProcessCallbackComposite$$ExternalSyntheticLambda2
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("processDestroy - %s", adResponse);
                    }
                });
                adResponse.destroy();
            }
        }

        @Override // io.bidmachine.AdProcessCallback
        public void processStartVisibilityTracker() {
            this.isVisibilityTrackerStarted.set(true);
        }

        @Override // io.bidmachine.AdProcessCallback
        public void setVisibilitySource(VisibilitySource visibilitySource) {
            this.visibilitySource = visibilitySource;
        }

        private AdResponse getAdResponse() {
            return this.weakAdResponse.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLoading() {
            return this.isLoading.get();
        }

        void appendCallback(AdProcessCallback adProcessCallback) {
            synchronized (this.mutexCallback) {
                this.adProcessCallbackMap.put(adProcessCallback, Boolean.TRUE);
            }
        }

        void removeCallback(AdProcessCallback adProcessCallback) {
            synchronized (this.mutexCallback) {
                this.adProcessCallbackMap.remove(adProcessCallback);
            }
        }

        void executeOnCallback(Executable<AdProcessCallback> executable) {
            synchronized (this.mutexCallback) {
                for (AdProcessCallback adProcessCallback : getAdProcessCallbackList()) {
                    if (adProcessCallback != null) {
                        executable.execute(adProcessCallback);
                    }
                }
            }
        }

        private List<AdProcessCallback> getAdProcessCallbackList() {
            return new ArrayList(this.adProcessCallbackMap.keySet());
        }

        void destroy() {
            this.weakAdResponse.clear();
            synchronized (this.mutexCallback) {
                this.adProcessCallbackMap.clear();
            }
        }

        Map<AdProcessCallback, Boolean> getAdProcessCallbackMap() {
            return this.adProcessCallbackMap;
        }

        private boolean canSendShownCallback() {
            int i = AnonymousClass3.$SwitchMap$io$bidmachine$core$VisibilitySource[this.visibilitySource.ordinal()];
            if (i == 1) {
                return isBidMachineShowTracked();
            }
            if (i == 2) {
                return isNetworkShowTracked();
            }
            if (i != 3) {
                return false;
            }
            return isBidMachineShowTracked() && isNetworkShowTracked();
        }

        private boolean isBidMachineShowTracked() {
            return !this.isVisibilityTrackerStarted.get() || this.isVisibilityTrackerShownTracked.get();
        }

        private boolean isNetworkShowTracked() {
            return this.isShownTracked.get();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.AdResponse$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$core$VisibilitySource;

        static {
            int[] iArr = new int[VisibilitySource.values().length];
            $SwitchMap$io$bidmachine$core$VisibilitySource = iArr;
            try {
                iArr[VisibilitySource.BidMachine.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$core$VisibilitySource[VisibilitySource.Network.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$core$VisibilitySource[VisibilitySource.All.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static class CreativeLoadingTimeoutListener implements ExpirationHandler.Listener {
        private final AdProcessCallback adProcessCallback;

        public CreativeLoadingTimeoutListener(AdProcessCallback adProcessCallback) {
            this.adProcessCallback = adProcessCallback;
        }

        @Override // io.bidmachine.ExpirationHandler.Listener
        public void onExpired() {
            this.adProcessCallback.processLoadFail(new BMError(BMError.TimeoutError, -1, "Creative loading timeout reached"));
        }
    }
}
