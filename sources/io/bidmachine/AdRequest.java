package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.openrtb.Openrtb;
import com.explorestack.protobuf.openrtb.Request;
import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.AdRequest;
import io.bidmachine.AdRequestParameters;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.core.Utils;
import io.bidmachine.displays.PlacementBuilder;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.RequestBuilder;
import io.bidmachine.models.RequestParams;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.RequestExtension;
import io.bidmachine.protobuf.ResponsePayload;
import io.bidmachine.tracking.EventData;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AdRequest<SelfType extends AdRequest, AdRequestParametersType extends AdRequestParameters, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    List<AdRequestListener<SelfType>> adRequestListeners;
    private final AdRequestParametersType adRequestParameters;
    AdResponse adResponse;
    private final AdResponseLoader adResponseLoader;
    final Queue<String> auctionUrlQueue;
    private final String id;
    List<InternalAdRequestListener<SelfType>> internalAdRequestListeners;
    private final AtomicBoolean isApiRequestCanceled;
    private final AtomicBoolean isApiRequestCompleted;
    private final AtomicBoolean isDestroyed;
    private final AtomicBoolean isLoading;
    private final AtomicBoolean isRequestExpired;
    private NetworkAdUnitManager networkAdUnitManager;
    private final Tag tag = new Tag("AdRequest");
    private final Runnable timeOutRunnable;
    private final BidMachineTrackingObject trackingObject;
    private UnifiedAdRequestParamsType unifiedAdRequestParams;

    public interface AdRequestListener<AdRequestType extends AdRequest> {
        void onRequestExpired(AdRequestType adrequesttype);

        void onRequestFailed(AdRequestType adrequesttype, BMError bMError);

        void onRequestSuccess(AdRequestType adrequesttype, AuctionResult auctionResult);
    }

    interface InternalAdRequestListener<AdRequestType extends AdRequest> {
        void onRequestDestroyed(AdRequestType adrequesttype);
    }

    protected abstract UnifiedAdRequestParamsType createUnifiedAdRequestParams(AdRequestParametersType adrequestparameterstype, TargetingParams targetingParams, DataRestrictions dataRestrictions);

    boolean isPlacementBuilderMatch(PlacementBuilder placementBuilder) {
        return true;
    }

    protected void onBeforeSetDisplayPlacementBuilder(Placement.DisplayPlacement.Builder builder) {
    }

    protected void onBeforeSetVideoPlacementBuilder(Placement.VideoPlacement.Builder builder) {
    }

    protected void onBuildPlacement(Placement.Builder builder) {
    }

    protected BMError verifyRequest() {
        return null;
    }

    protected AdRequest(AdRequestParametersType adrequestparameterstype) {
        String string = UUID.randomUUID().toString();
        this.id = string;
        this.isLoading = new AtomicBoolean(false);
        this.isApiRequestCanceled = new AtomicBoolean(false);
        this.isApiRequestCompleted = new AtomicBoolean(false);
        this.isRequestExpired = new AtomicBoolean(false);
        this.isDestroyed = new AtomicBoolean(false);
        this.timeOutRunnable = new Runnable() { // from class: io.bidmachine.AdRequest.1
            @Override // java.lang.Runnable
            public void run() {
                AdResponse adResponseReceive = AdResponseManager.get().receive(AdRequest.this.adRequestParameters);
                if (adResponseReceive != null) {
                    AdRequest.this.processApiRequestSuccess(adResponseReceive);
                } else {
                    AdRequest.this.processApiRequestFail(BMError.TimeoutError, false);
                    AdRequest.this.cancel();
                }
            }
        };
        this.trackingObject = new BidMachineTrackingObject(string) { // from class: io.bidmachine.AdRequest.2
            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public List<String> getTrackingUrls(TrackEventType trackEventType) {
                AdResponse adResponse = AdRequest.this.getAdResponse();
                if (adResponse != null) {
                    return adResponse.getTrackUrlListByEvent(trackEventType);
                }
                return super.getTrackingUrls(trackEventType);
            }

            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public AdExtension.EventConfiguration getEventConfiguration() {
                AdResponse adResponse = AdRequest.this.getAdResponse();
                if (adResponse != null) {
                    return adResponse.getEventConfiguration();
                }
                return super.getEventConfiguration();
            }
        };
        this.adRequestParameters = adrequestparameterstype;
        this.adResponseLoader = new AdResponseLoader(string);
        this.auctionUrlQueue = new LinkedList();
    }

    protected final AdsType getAdsType() {
        return this.adRequestParameters.getAdsType();
    }

    public AdRequestParametersType getAdRequestParameters() {
        return this.adRequestParameters;
    }

    AdResponse getAdResponse() {
        return this.adResponse;
    }

    Object build(Context context) {
        Map<String, Double> priceFloors;
        try {
            String sellerId = BidMachineImpl.get().getSellerId();
            if (TextUtils.isEmpty(sellerId)) {
                return BMError.notFound("SellerId");
            }
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            SessionManager sessionManager = SessionManager.get();
            AdvertisingDataManager.updateInfo(context);
            TargetingParams targetingParams = (TargetingParams) RequestParams.resolveParams(this.adRequestParameters.getTargetingParams(), bidMachineImpl.getTargetingParams());
            UserRestrictionParams userRestrictionParams = bidMachineImpl.getUserRestrictionParams();
            SessionAdParams sessionAdParams = (SessionAdParams) RequestParams.resolveParams(this.adRequestParameters.getSessionAdParams(), sessionManager.getSessionAdParams(getAdsType()).setSessionDuration(Integer.valueOf(sessionManager.getSessionDuration())));
            PriceFloorParams priceFloorParams = this.adRequestParameters.getPriceFloorParams();
            if (priceFloorParams != null && !priceFloorParams.getPriceFloors().isEmpty()) {
                priceFloors = priceFloorParams.getPriceFloors();
            } else {
                priceFloors = bidMachineImpl.getPriceFloorParams().getPriceFloors();
            }
            if (priceFloors.isEmpty()) {
                return BMError.notFound("PriceFloors");
            }
            Request.Builder builderNewBuilder = Request.newBuilder();
            Request.Item.Builder builderNewBuilder2 = Request.Item.newBuilder();
            builderNewBuilder2.setId(UUID.randomUUID().toString());
            builderNewBuilder2.setQty(1);
            for (Map.Entry<String, Double> entry : priceFloors.entrySet()) {
                Request.Item.Deal.Builder builderNewBuilder3 = Request.Item.Deal.newBuilder();
                builderNewBuilder3.setId(entry.getKey());
                builderNewBuilder3.setFlr(entry.getValue().doubleValue());
                builderNewBuilder3.setFlrcur("USD");
                builderNewBuilder2.addDeal(builderNewBuilder3);
            }
            builderNewBuilder.setContext(Any.pack(RequestDataRetriever.collectContext(context, bidMachineImpl, userRestrictionParams, targetingParams, sessionAdParams, null, getAdsType())));
            builderNewBuilder.setTest(bidMachineImpl.isTestMode());
            builderNewBuilder.addCur("USD");
            builderNewBuilder.setAt(2);
            builderNewBuilder.setTmax(10000);
            Placement.Builder builderNewBuilder4 = Placement.newBuilder();
            builderNewBuilder4.setSsai(0);
            builderNewBuilder4.setSdk(BidMachine.NAME);
            builderNewBuilder4.setSdkver("3.2.1");
            builderNewBuilder4.setSecure(!Utils.canUseCleartextTraffic());
            String placementId = this.adRequestParameters.getPlacementId();
            if (!TextUtils.isEmpty(placementId)) {
                builderNewBuilder4.setTagid(placementId);
            }
            for (Message.Builder builder : collectPlacementFormats(context, null)) {
                if (builder instanceof Placement.DisplayPlacement.Builder) {
                    Placement.DisplayPlacement.Builder builder2 = (Placement.DisplayPlacement.Builder) builder;
                    onBeforeSetDisplayPlacementBuilder(builder2);
                    builderNewBuilder4.setDisplay(builder2);
                } else if (builder instanceof Placement.VideoPlacement.Builder) {
                    Placement.VideoPlacement.Builder builder3 = (Placement.VideoPlacement.Builder) builder;
                    onBeforeSetVideoPlacementBuilder(builder3);
                    builderNewBuilder4.setVideo(builder3);
                } else {
                    throw new IllegalArgumentException("Unsupported display type: " + builder);
                }
            }
            Struct.Builder builderNewBuilder5 = Struct.newBuilder();
            OMSDKSettings.fillExtension(builderNewBuilder5);
            ListValue.Builder builderNewBuilder6 = ListValue.newBuilder();
            Iterator<AdResponse> it = AdResponseManager.get().peek(this.adRequestParameters).iterator();
            while (it.hasNext()) {
                builderNewBuilder6.addValues(it.next().createBidCacheExtensionValue());
            }
            if (builderNewBuilder6.getValuesCount() > 0) {
                builderNewBuilder5.putFields("bid_cache", Value.newBuilder().setListValue(builderNewBuilder6).build());
            }
            if (builderNewBuilder5.getFieldsCount() > 0) {
                builderNewBuilder4.setExt(builderNewBuilder5);
            }
            onBuildPlacement(builderNewBuilder4);
            builderNewBuilder2.setSpec(Any.pack(builderNewBuilder4.build()));
            builderNewBuilder.addItem(builderNewBuilder2.build());
            Struct.Builder builderNewBuilder7 = Struct.newBuilder();
            CustomParams customParams = this.adRequestParameters.getCustomParams();
            if (customParams != null) {
                Struct.Builder builderNewBuilder8 = Struct.newBuilder();
                customParams.fillStructBuilder(builderNewBuilder8);
                if (builderNewBuilder8.getFieldsCount() > 0) {
                    builderNewBuilder7.putFields("custom_params", Value.newBuilder().setStructValue(builderNewBuilder8).build());
                }
            }
            Struct privateStruct = ExtraParamsManager.get().getPrivateStruct(context);
            if (privateStruct != null) {
                builderNewBuilder7.putAllFields(privateStruct.getFieldsMap());
            }
            if (builderNewBuilder7.getFieldsCount() > 0) {
                builderNewBuilder.setExt(builderNewBuilder7.build());
            }
            RequestExtension.Builder builderNewBuilder9 = RequestExtension.newBuilder();
            builderNewBuilder9.setSellerId(sellerId);
            String ifv = bidMachineImpl.getIFV();
            if (!TextUtils.isEmpty(ifv)) {
                builderNewBuilder9.setIfv(ifv);
            }
            builderNewBuilder9.setBmIfv(bidMachineImpl.obtainBMIFV(context));
            builderNewBuilder9.setSessionId(sessionManager.getSessionId());
            builderNewBuilder.addExtProto(Any.pack(builderNewBuilder9.build()));
            return builderNewBuilder.build();
        } catch (Throwable th) {
            Logger.w(th);
            return BMError.throwable("Exception creating ad request", th);
        }
    }

    List<Message.Builder> collectPlacementFormats(Context context, List<String> list) throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        AdsType adsType = getAdsType();
        adsType.collectPlacements(new SimpleContextProvider(context), this, obtainUnifiedRequestParams(), collectNetworkConfig(context, adsType, list), arrayList, copyOnWriteArrayList, BidMachineImpl.get().getNetworksLoadingTimeOutSec());
        this.networkAdUnitManager = new NetworkAdUnitManager(copyOnWriteArrayList);
        return arrayList;
    }

    List<NetworkConfig> collectNetworkConfig(Context context, AdsType adsType, List<String> list) {
        HashMap map = new HashMap();
        List<NetworkConfig> networkConfigList = this.adRequestParameters.getNetworkConfigList();
        if (networkConfigList == null) {
            Utils.putAll(map, NetworkRegistry.copyOrNullInitializedNetworkConfigs(adsType));
        } else {
            map.putAll(NetworkRegistry.createInitNetworkConfigMap());
            for (final NetworkConfig networkConfig : networkConfigList) {
                final String strCheckAndPutNetwork = NetworkRegistry.checkAndPutNetwork(context, adsType, networkConfig, map);
                if (strCheckAndPutNetwork != null) {
                    logError(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda8
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return String.format("%s was removed from AdRequest: %s", networkConfig.getNetworkKey(), strCheckAndPutNetwork);
                        }
                    });
                }
            }
        }
        if (list != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (!list.contains((String) ((Map.Entry) it.next()).getKey())) {
                    it.remove();
                }
            }
        }
        Utils.putAll(map, NetworkRegistry.copyOrNullInitializedCoreNetworkConfigs(adsType));
        return new ArrayList(map.values());
    }

    public AuctionResult getAuctionResult() {
        AdResponse adResponse = this.adResponse;
        if (adResponse != null) {
            return adResponse.getAuctionResult();
        }
        return null;
    }

    public void request(Context context) {
        if (!BidMachineImpl.get().isInitialized()) {
            processRequestFail(BMError.internal("BidMachine not initialized"));
            return;
        }
        if (isDestroyed()) {
            processRequestFail(BMError.RequestDestroyed);
            return;
        }
        BMError bMErrorVerifyRequest = verifyRequest();
        if (bMErrorVerifyRequest != null) {
            processRequestFail(bMErrorVerifyRequest);
        } else {
            if (isLoading()) {
                return;
            }
            setLoading(true);
            AdRequestExecutor.get().execute(new AnonymousClass3(context.getApplicationContext()));
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.AdRequest$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$applicationContext;

        AnonymousClass3(Context context) {
            this.val$applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdRequest.this.cancel();
                AdRequest.this.unsubscribeTimeOut();
                if (AdRequest.this.adResponse != null) {
                    AdRequest.this.adResponse.detachAdRequest(AdRequest.this);
                    AdRequest.this.adResponse = null;
                }
                AdRequest.this.isApiRequestCanceled.set(false);
                AdRequest.this.isApiRequestCompleted.set(false);
                AdRequest.this.subscribeTimeOut();
                AdRequest.this.log(new LazyValue() { // from class: io.bidmachine.AdRequest$3$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return AdRequest.AnonymousClass3.lambda$run$0();
                    }
                });
                AdRequest.this.trackingObject.eventStart(TrackEventType.AuctionRequest);
                ResponsePayload bidPayload = AdRequest.this.adRequestParameters.getBidPayload();
                if (bidPayload == null) {
                    AdRequest.this.processRequestObject(this.val$applicationContext);
                } else {
                    AdRequest.this.processBidPayload(bidPayload);
                }
            } catch (Throwable th) {
                Logger.w(th);
                AdRequest.this.processRequestFail(BMError.throwable("Exception loading ad request", th));
            }
        }

        static /* synthetic */ String lambda$run$0() {
            return "Request start";
        }
    }

    protected void processBidPayload(ResponsePayload responsePayload) {
        if (responsePayload == ResponsePayload.getDefaultInstance()) {
            processRequestFail(BMError.incorrectContent("BidPayload has invalid content"));
            return;
        }
        if (!isBidPayloadValid(responsePayload)) {
            processRequestFail(BMError.incorrectContent("BidPayload does not match with AdRequest"));
            return;
        }
        Openrtb responseCache = responsePayload.getResponseCache();
        if (responseCache != null && responseCache != Openrtb.getDefaultInstance()) {
            ProtoTransformer.toAdResponse(this.adRequestParameters, obtainNetworkAdUnitManager(), responseCache.getResponse(), new ProtoTransformer.Listener<AdResponse>() { // from class: io.bidmachine.AdRequest.4
                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onSuccess(AdResponse adResponse) {
                    AdRequest.this.processApiRequestSuccess(adResponse);
                }

                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onFail(BMError bMError) {
                    AdRequest.this.processApiRequestFail(bMError);
                }
            });
            return;
        }
        String responseCacheUrl = responsePayload.getResponseCacheUrl();
        if (!TextUtils.isEmpty(responseCacheUrl) && Utils.isHttpUrl(responseCacheUrl)) {
            retrieveBody(responseCacheUrl);
        } else {
            processRequestFail(BMError.incorrectContent("BidPayload does not contain Response or URL"));
        }
    }

    boolean isBidPayloadValid(ResponsePayload responsePayload) {
        Placement requestItemSpec = responsePayload.getRequestItemSpec();
        try {
            return requestItemSpec == Placement.getDefaultInstance() || this.adRequestParameters.isPlacementObjectValid(requestItemSpec);
        } catch (Throwable th) {
            Logger.w(th);
            return false;
        }
    }

    void retrieveBody(String str) {
        processRequestBuilder(new ApiRequest.Builder().setMethod(NetworkRequest.Method.Get).setDataBinder(new ApiRequest.ApiResponseAuctionDataBinder()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRequestObject(Context context) {
        BMError bMErrorInternal;
        prepareUrls();
        Object objBuild = build(context);
        if (objBuild instanceof Request) {
            processRequestBuilder(new ApiRequest.Builder().setRequestData((Request) objBuild).setDataBinder(getAdsType().getBinder()), pollUrl());
            return;
        }
        if (objBuild instanceof BMError) {
            bMErrorInternal = (BMError) objBuild;
        } else {
            bMErrorInternal = BMError.internal("Failed to create ad request");
        }
        processRequestFail(bMErrorInternal);
    }

    void processRequestBuilder(final ApiRequest.Builder<Request, Response> builder, final String str) {
        if (canSendApiRequest()) {
            builder.url(str);
            this.adResponseLoader.load(this.adRequestParameters, obtainNetworkAdUnitManager(), builder, new AdResponseLoader.Listener() { // from class: io.bidmachine.AdRequest.5
                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onSuccess(AdResponse adResponse) {
                    AdRequest.this.setAuctionUrl(str);
                    AdRequest.this.processApiRequestSuccess(adResponse);
                }

                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onFail(BMError bMError) {
                    AdRequest.this.processApiRequestLoadedFail(builder, bMError);
                }

                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onCancel() {
                    AdRequest.this.processApiRequestCancel();
                }
            });
        }
    }

    private boolean canSendApiRequest() {
        return !isDestroyed();
    }

    private boolean canProcessApiRequestResult() {
        return (isCompleted() || isCanceled() || isDestroyed()) ? false : true;
    }

    void prepareUrls() {
        this.auctionUrlQueue.clear();
        this.auctionUrlQueue.addAll(UrlProvider.getAuctionUrlQueue());
    }

    String pollUrl() {
        if (this.auctionUrlQueue.isEmpty()) {
            this.auctionUrlQueue.addAll(UrlProvider.getAuctionUrlQueue());
        }
        return this.auctionUrlQueue.poll();
    }

    void setAuctionUrl(String str) {
        this.auctionUrlQueue.clear();
        this.auctionUrlQueue.add(str);
    }

    public void notifyMediationWin() {
        BMError bMError;
        if (isCompleted()) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return AdRequest.lambda$notifyMediationWin$1();
                }
            });
            if (isDestroyed()) {
                bMError = BMError.RequestDestroyed;
            } else {
                bMError = isExpired() ? BMError.RequestExpired : null;
            }
            this.trackingObject.eventFinish(TrackEventType.MediationWin, getAdsType(), this.adResponse, bMError);
        }
    }

    static /* synthetic */ String lambda$notifyMediationWin$1() {
        return "notifyMediationWin";
    }

    public void notifyMediationLoss() {
        notifyMediationLoss(null, null);
    }

    public void notifyMediationLoss(final String str, final Double d) {
        BMError bMError;
        if (isCompleted()) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("notifyMediationLoss (winnerNetworkName - %s, winnerNetworkPrice - %s)", str, d);
                }
            });
            if (isDestroyed()) {
                bMError = BMError.RequestDestroyed;
            } else {
                bMError = isExpired() ? BMError.RequestExpired : null;
            }
            this.trackingObject.eventFinish(TrackEventType.MediationLoss, getAdsType(), new EventData().setNetworkName(str).setPrice(d), bMError);
        }
    }

    boolean isLoading() {
        return this.isLoading.get();
    }

    private void setLoading(boolean z) {
        this.isLoading.set(z);
    }

    boolean isCompleted() {
        return this.isApiRequestCompleted.get();
    }

    boolean isCanceled() {
        return this.isApiRequestCanceled.get();
    }

    public boolean isDestroyed() {
        return this.isDestroyed.get();
    }

    public void destroy() {
        if (this.isDestroyed.compareAndSet(false, true)) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda5
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return AdRequest.lambda$destroy$3();
                }
            });
            this.trackingObject.eventFinish(TrackEventType.AuctionRequestDestroy, getAdsType(), this.adResponse, (BMError) null);
            cancel();
            unsubscribeTimeOut();
            this.trackingObject.clear();
            BidMachineFetcher.release(this);
            notifyRequestDestroyed();
            this.unifiedAdRequestParams = null;
            AdResponse adResponse = this.adResponse;
            if (adResponse != null) {
                adResponse.detachAdRequest(this);
                this.adResponse = null;
            }
        }
    }

    static /* synthetic */ String lambda$destroy$3() {
        return "destroy";
    }

    void clearNetworkAdUnits() {
        obtainNetworkAdUnitManager().notifyNetworkClearAuction();
    }

    void cancel() {
        this.adResponseLoader.cancel();
    }

    static /* synthetic */ String lambda$processExpired$4() {
        return "Request expired";
    }

    void processExpired() {
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return AdRequest.lambda$processExpired$4();
            }
        });
        this.isRequestExpired.set(true);
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestExpired(this);
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestExpired(this);
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequestExpired, getAdsType(), this.adResponse, (BMError) null);
    }

    public boolean isExpired() {
        return isAdResponseExpired() || this.isRequestExpired.get();
    }

    boolean isAdResponseExpired() {
        AdResponse adResponse = this.adResponse;
        return adResponse != null && adResponse.isExpired();
    }

    public void addListener(AdRequestListener<SelfType> adRequestListener) {
        if (adRequestListener != null) {
            if (this.adRequestListeners == null) {
                this.adRequestListeners = new CopyOnWriteArrayList();
            }
            this.adRequestListeners.add(adRequestListener);
        }
    }

    public void removeListener(AdRequestListener<SelfType> adRequestListener) {
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list == null || adRequestListener == null) {
            return;
        }
        list.remove(adRequestListener);
    }

    void addInternalListener(InternalAdRequestListener<SelfType> internalAdRequestListener) {
        if (internalAdRequestListener != null) {
            if (this.internalAdRequestListeners == null) {
                this.internalAdRequestListeners = new CopyOnWriteArrayList();
            }
            this.internalAdRequestListeners.add(internalAdRequestListener);
        }
    }

    void removeInternalListener(InternalAdRequestListener<SelfType> internalAdRequestListener) {
        List<InternalAdRequestListener<SelfType>> list = this.internalAdRequestListeners;
        if (list == null || internalAdRequestListener == null) {
            return;
        }
        list.remove(internalAdRequestListener);
    }

    void notifyRequestDestroyed() {
        List<InternalAdRequestListener<SelfType>> list = this.internalAdRequestListeners;
        if (list != null) {
            Iterator<InternalAdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestDestroyed(this);
            }
        }
    }

    int obtainTimeOutMs() {
        Integer timeOutMs;
        int requestTimeOutMs = BidMachineImpl.get().getRequestTimeOutMs();
        return (requestTimeOutMs > 0 || (timeOutMs = this.adRequestParameters.getTimeOutMs()) == null || timeOutMs.intValue() <= 0) ? requestTimeOutMs : timeOutMs.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeTimeOut() {
        int iObtainTimeOutMs = obtainTimeOutMs();
        if (iObtainTimeOutMs > 0) {
            Utils.onBackgroundThread(this.timeOutRunnable, iObtainTimeOutMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unsubscribeTimeOut() {
        Utils.cancelBackgroundThreadTask(this.timeOutRunnable);
    }

    void processApiRequestSuccess(final AdResponse adResponse) {
        if (!canProcessApiRequestResult()) {
            adResponse.detachAdRequest(this);
            return;
        }
        setLoading(false);
        this.isApiRequestCompleted.set(true);
        unsubscribeTimeOut();
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda7
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Request success - %s", adResponse);
            }
        });
        this.adResponse = adResponse;
        adResponse.attachAdRequest(this);
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestSuccess(this, adResponse.getAuctionResult());
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestSuccess(this, adResponse.getAuctionResult());
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequest, getAdsType(), adResponse, (BMError) null);
    }

    void processApiRequestLoadedFail(ApiRequest.Builder<Request, Response> builder, BMError bMError) {
        String strPoll;
        if (canProcessApiRequestResult()) {
            if (bMError != BMError.BMServerNoFill && (strPoll = this.auctionUrlQueue.poll()) != null) {
                processRequestBuilder(builder, strPoll);
            } else {
                processApiRequestFail(bMError);
            }
        }
    }

    void processApiRequestFail(BMError bMError) {
        processApiRequestFail(bMError, true);
    }

    void processApiRequestFail(BMError bMError, boolean z) {
        if (canProcessApiRequestResult()) {
            setLoading(false);
            this.isApiRequestCompleted.set(true);
            if (bMError == null) {
                bMError = BMError.BMServerNoFill;
            }
            processRequestFail(bMError, z);
        }
    }

    void processRequestFail(BMError bMError) {
        processRequestFail(bMError, true);
    }

    void processRequestFail(final BMError bMError, boolean z) {
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Request fail - %s", bMError);
            }
        });
        unsubscribeTimeOut();
        if (z) {
            clearNetworkAdUnits();
        }
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestFailed(this, bMError);
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestFailed(this, bMError);
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequest, getAdsType(), (EventData) null, bMError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processApiRequestCancel() {
        if (canProcessApiRequestResult()) {
            setLoading(false);
            this.isApiRequestCanceled.set(true);
            unsubscribeTimeOut();
            this.trackingObject.eventFinish(TrackEventType.AuctionRequestCancel, getAdsType(), (EventData) null, (BMError) null);
            this.trackingObject.clearEvent(TrackEventType.AuctionRequest);
        }
    }

    final UnifiedAdRequestParamsType obtainUnifiedRequestParams() {
        if (this.unifiedAdRequestParams == null) {
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            this.unifiedAdRequestParams = (UnifiedAdRequestParamsType) createUnifiedAdRequestParams(this.adRequestParameters, (TargetingParams) RequestParams.resolveParams(this.adRequestParameters.getTargetingParams(), bidMachineImpl.getTargetingParams()), bidMachineImpl.getUserRestrictionParams());
        }
        return this.unifiedAdRequestParams;
    }

    private NetworkAdUnitManager obtainNetworkAdUnitManager() {
        if (this.networkAdUnitManager == null) {
            this.networkAdUnitManager = new NetworkAdUnitManager();
        }
        return this.networkAdUnitManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(final LazyValue<String> lazyValue) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7340lambda$log$7$iobidmachineAdRequest(lazyValue);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$log$7$io-bidmachine-AdRequest, reason: not valid java name */
    /* synthetic */ String m7340lambda$log$7$iobidmachineAdRequest(LazyValue lazyValue) {
        return String.format("%s - %s", this.adRequestParameters.getAdsType(), lazyValue.get());
    }

    private void logError(final LazyValue<String> lazyValue) {
        Logger.e(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda6
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7341lambda$logError$8$iobidmachineAdRequest(lazyValue);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$logError$8$io-bidmachine-AdRequest, reason: not valid java name */
    /* synthetic */ String m7341lambda$logError$8$iobidmachineAdRequest(LazyValue lazyValue) {
        return String.format("%s - %s", this.adRequestParameters.getAdsType(), lazyValue.get());
    }

    public String toString() {
        return this.tag.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class AdRequestBuilderImpl<SelfType extends RequestBuilder, ReturnType extends AdRequest<ReturnType, AdRequestParametersType, ?>, AdRequestParametersType extends AdRequestParameters> implements RequestBuilder<SelfType, ReturnType> {
        ResponsePayload bidPayload;
        CustomParams customParams;
        AdRequestListener<ReturnType> listener;
        List<NetworkConfig> networkConfigList;
        String placementId;
        PriceFloorParams priceFloorParams;
        SessionAdParams sessionAdParams;
        TargetingParams targetingParams;
        Integer timeOutMs;

        protected abstract ReturnType build(AdRequestParametersType adrequestparameterstype);

        protected abstract AdRequestParametersType createAdRequestParameters();

        protected AdRequestBuilderImpl() {
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setPriceFloorParams(PriceFloorParams priceFloorParams) {
            this.priceFloorParams = priceFloorParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setTargetingParams(TargetingParams targetingParams) {
            this.targetingParams = targetingParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setSessionAdParams(SessionAdParams sessionAdParams) {
            this.sessionAdParams = sessionAdParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setNetworks(List<NetworkConfig> list) {
            fillNetworkConfigs(list);
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setNetworks(String str) {
            ArrayList arrayList = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        JSONArray jSONArray = new JSONArray(str);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            NetworkConfig networkConfigCreate = NetworkConfigFactory.create(BidMachineImpl.get().getAppContext(), jSONArray.getJSONObject(i));
                            if (networkConfigCreate != null) {
                                arrayList2.add(networkConfigCreate);
                            }
                        }
                        arrayList = arrayList2;
                    } catch (Exception e) {
                        e = e;
                        arrayList = arrayList2;
                        Logger.w(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            fillNetworkConfigs(arrayList);
            return this;
        }

        void fillNetworkConfigs(List<NetworkConfig> list) {
            if (list == null) {
                this.networkConfigList = new ArrayList();
            } else {
                this.networkConfigList = list;
            }
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setLoadingTimeOut(Integer num) {
            this.timeOutMs = num;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setBidPayload(String str) {
            if (str == null) {
                this.bidPayload = null;
                return this;
            }
            try {
                this.bidPayload = ResponsePayload.parseFrom(Base64.decode(str, 0));
            } catch (Throwable th) {
                Logger.w(th);
            }
            if (this.bidPayload == null) {
                this.bidPayload = ResponsePayload.getDefaultInstance();
            }
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setPlacementId(String str) {
            this.placementId = str;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setListener(AdRequestListener<ReturnType> adRequestListener) {
            this.listener = adRequestListener;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setCustomParams(CustomParams customParams) {
            this.customParams = customParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public ReturnType build() {
            ReturnType returntype = (ReturnType) BidTokenManager.findPreparedAdRequest(this.bidPayload);
            if (returntype == null) {
                returntype = (ReturnType) build(createAdRequestParameters());
            }
            fillAdRequestParameters(returntype.getAdRequestParameters());
            returntype.addListener(this.listener);
            return returntype;
        }

        private void fillAdRequestParameters(AdRequestParametersType adrequestparameterstype) {
            adrequestparameterstype.setPriceFloorParams(this.priceFloorParams);
            adrequestparameterstype.setTargetingParams(this.targetingParams);
            adrequestparameterstype.setSessionAdParams(this.sessionAdParams);
            adrequestparameterstype.setNetworkConfigList(this.networkConfigList);
            adrequestparameterstype.setTimeOutMs(this.timeOutMs);
            adrequestparameterstype.setBidPayload(this.bidPayload);
            adrequestparameterstype.setPlacementId(this.placementId);
            adrequestparameterstype.setCustomParams(this.customParams);
        }
    }
}
