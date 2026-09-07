package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.internal.KotlinEngine;
import io.bidmachine.protobuf.AdCachePlacementControl;
import io.bidmachine.protobuf.AdNetwork;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.rendering.utils.UserAgentProvider;
import io.bidmachine.tracking.EventTrackerImpl;
import io.bidmachine.tracking.SessionTracker;
import io.bidmachine.utils.BluetoothUtils;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.ThrowableRunnable;
import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.log.DefaultLoggerInstance;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
final class BidMachineImpl {
    private static final AtomicBoolean IS_PRE_INITIALIZED = new AtomicBoolean(false);
    private static final String ZERO_BM_IFV = "00000000-0000-0000-0000-000000000000";
    private static volatile BidMachineImpl instance;
    private final List<AdRequest.AdRequestListener<?>> adRequestListeners;
    private final BidMachineAnalyticsInitializer analyticsInitializer;
    Context appContext;
    private final AppIdDataManager appIdDataManager;
    private final AppParams appParams;
    String bmIFV;
    private CustomParams customParams;
    private final DeviceParams deviceParams;
    private final EventTrackerImpl eventTracker;
    long firstLaunchTimeMs;
    private final IABSharedPreference iabSharedPreference;
    private final InitialRequestLoader.Listener initialRequestListener;
    InitialRequestLoader initialRequestLoader;
    private boolean isTestMode;
    private int networksLoadingTimeOutSec;
    private final PriceFloorParams priceFloorParams;
    private Publisher publisher;
    int requestTimeOutMs;
    private String sellerId;
    private final SessionParams sessionParams;
    private final SessionTracker sessionTracker;
    private TargetingParams targetingParams;
    private final Map<TrackEventType, List<String>> trackingEventTypes;
    private final UserRestrictionParams userRestrictionParams;
    private final Set<InitializationCallback> callbackSet = new CopyOnWriteArraySet();
    private final AtomicBoolean isInitializing = new AtomicBoolean(false);
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);

    BidMachineImpl() {
        EventTrackerImpl eventTrackerImpl = new EventTrackerImpl();
        this.eventTracker = eventTrackerImpl;
        this.sessionTracker = new BidMachineSessionTracker(eventTrackerImpl);
        this.userRestrictionParams = new UserRestrictionParams();
        this.priceFloorParams = new PriceFloorParams().addPriceFloor(UUID.randomUUID().toString(), 0.01d);
        this.appParams = new AppParams(new AppReleaseParams());
        this.deviceParams = new DeviceParams(new DeviceConnectionParams());
        this.sessionParams = new SessionParams();
        this.iabSharedPreference = new IABSharedPreferenceImpl();
        this.trackingEventTypes = new EnumMap(TrackEventType.class);
        this.adRequestListeners = new CopyOnWriteArrayList();
        this.appIdDataManager = new AppIdDataManager();
        this.analyticsInitializer = new BidMachineAnalyticsInitializer();
        this.targetingParams = new TargetingParams();
        this.customParams = new CustomParams();
        this.requestTimeOutMs = 0;
        this.networksLoadingTimeOutSec = 0;
        this.firstLaunchTimeMs = 0L;
        this.initialRequestListener = new InitialRequestLoaderListener();
    }

    static {
        Logger.setEnabledInstance(new DefaultLoggerInstance("BidMachineLog") { // from class: io.bidmachine.BidMachineImpl.1
            @Override // io.bidmachine.utils.log.DefaultLoggerInstance
            protected String buildMessage(Object obj, String str, LazyValue<String> lazyValue, Throwable th) {
                String strBuildMessage = super.buildMessage(obj, str, lazyValue, th);
                return BidMachineImpl.get().isTestMode() ? "(TEST MODE) " + strBuildMessage : strBuildMessage;
            }
        });
    }

    static BidMachineImpl get() {
        BidMachineImpl bidMachineImpl = instance;
        if (bidMachineImpl == null) {
            synchronized (BidMachineImpl.class) {
                bidMachineImpl = instance;
                if (bidMachineImpl == null) {
                    bidMachineImpl = new BidMachineImpl();
                    instance = bidMachineImpl;
                }
            }
        }
        return bidMachineImpl;
    }

    static void preInitialize(final Context context) {
        if (IS_PRE_INITIALIZED.compareAndSet(false, true)) {
            Utils.runCatching(new ThrowableRunnable() { // from class: io.bidmachine.BidMachineImpl$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.ThrowableRunnable
                public final void run() {
                    BidMachineActivityManager.initialize(context);
                }
            });
            Utils.runCatching(new ThrowableRunnable() { // from class: io.bidmachine.BidMachineImpl$$ExternalSyntheticLambda4
                @Override // io.bidmachine.utils.ThrowableRunnable
                public final void run() {
                    BidMachineAnalyticsInitializer.initialize(context);
                }
            });
        }
    }

    void initialize(Context context, String str, InitializationCallback initializationCallback) {
        preInitialize(context);
        if (isInitialized()) {
            sendOnInitialized(initializationCallback);
            return;
        }
        if (context == null) {
            Logger.d("Initialization fail: Context is not provided");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Logger.d("Initialization fail: Source id is not provided");
            return;
        }
        if (initializationCallback != null) {
            this.callbackSet.add(initializationCallback);
        }
        if (this.isInitializing.compareAndSet(false, true)) {
            final Context applicationContext = context.getApplicationContext();
            SessionManager sessionManager = SessionManager.get();
            sessionManager.attachContext(applicationContext);
            this.appContext = applicationContext;
            this.sellerId = str;
            sessionManager.resume();
            BluetoothUtils.register(applicationContext);
            UserAgentManager.initialize(context);
            Rendering.setUserAgentProvider(new RenderingUserAgentProvider(applicationContext));
            this.initialRequestLoader = new InitialRequestLoader(applicationContext, str, this.initialRequestListener);
            Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.BidMachineImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m7357lambda$initialize$2$iobidmachineBidMachineImpl(applicationContext);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$2$io-bidmachine-BidMachineImpl, reason: not valid java name */
    /* synthetic */ void m7357lambda$initialize$2$iobidmachineBidMachineImpl(Context context) {
        try {
            Debugger.setup(context);
            this.iabSharedPreference.initialize(context);
            this.appIdDataManager.updateIfv(context);
            this.initialRequestLoader.loadStored();
            obtainFirstLaunchTimeMs(context);
            InstallInfoProvider.initialize(context);
            initializeNetworks(context, null);
            notifyInitializationFinished();
            this.initialRequestLoader.loadRemote();
            KotlinEngine.init();
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    Context getAppContext() {
        return this.appContext;
    }

    String getIFV() {
        return this.appIdDataManager.getIfv();
    }

    String obtainBMIFV(Context context) {
        if (!this.userRestrictionParams.canSendBmIfv()) {
            return ZERO_BM_IFV;
        }
        if (!TextUtils.isEmpty(this.bmIFV)) {
            return this.bmIFV;
        }
        String strObtainBMIFV = BidMachineSharedPreference.obtainBMIFV(context);
        this.bmIFV = strObtainBMIFV;
        return strObtainBMIFV;
    }

    long obtainFirstLaunchTimeMs(Context context) {
        long j = this.firstLaunchTimeMs;
        if (j != 0) {
            return j;
        }
        long jObtainFirstLaunchTimeMs = BidMachineSharedPreference.obtainFirstLaunchTimeMs(context);
        this.firstLaunchTimeMs = jObtainFirstLaunchTimeMs;
        return jObtainFirstLaunchTimeMs;
    }

    private static void sendOnInitialized(final InitializationCallback initializationCallback) {
        if (initializationCallback == null) {
            return;
        }
        Objects.requireNonNull(initializationCallback);
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.BidMachineImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                initializationCallback.onInitialized();
            }
        });
    }

    void handleInitResponse(final String str, final InitResponse initResponse, final String str2) {
        UrlProvider.setAuctionUrlFromInit(initResponse.getEndpoint());
        this.trackingEventTypes.clear();
        ProtoUtils.prepareEvents(this.trackingEventTypes, initResponse.getEventList());
        this.eventTracker.setDefaultEventConfiguration(initResponse.getEventConfiguration());
        SessionManager.get().setSessionResetAfter(initResponse.getSessionResetAfter());
        this.requestTimeOutMs = initResponse.getAdRequestTmax();
        this.networksLoadingTimeOutSec = initResponse.getAdNetworksLoadingTimeout();
        BidMachineSettings.setShowWithoutInternet(initResponse.getShowWithoutInternet());
        BidTokenManager.setupTokenConfigurations(initResponse.getTokenConfigurationsList());
        Map<String, AdCachePlacementControl> adCachePlacementControlMap = initResponse.getAdCachePlacementControlMap();
        if (adCachePlacementControlMap != null) {
            AdResponseManager.setAdCachePlacementControlMap(adCachePlacementControlMap);
            AdCachePlacementControl adCachePlacementControl = adCachePlacementControlMap.get(AdsType.Interstitial.getName());
            int maxCacheSize = adCachePlacementControl != null ? adCachePlacementControl.getMaxCacheSize() : 0;
            AdCachePlacementControl adCachePlacementControl2 = adCachePlacementControlMap.get(AdsType.Rewarded.getName());
            if (adCachePlacementControl2 != null) {
                maxCacheSize += adCachePlacementControl2.getMaxCacheSize();
            }
            if (maxCacheSize > 5) {
                VastRequest.setCacheSize(maxCacheSize);
            }
        }
        Utils.ifNotNull(this.appContext, new Executable() { // from class: io.bidmachine.BidMachineImpl$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                this.f$0.m7356lambda$handleInitResponse$3$iobidmachineBidMachineImpl(str, initResponse, str2, (Context) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleInitResponse$3$io-bidmachine-BidMachineImpl, reason: not valid java name */
    /* synthetic */ void m7356lambda$handleInitResponse$3$iobidmachineBidMachineImpl(String str, InitResponse initResponse, String str2, Context context) {
        this.analyticsInitializer.configure(context, str, initResponse, str2);
    }

    void initializeInitNetworks(Context context, List<AdNetwork> list) {
        if (list == null) {
            return;
        }
        Iterator<AdNetwork> it = list.iterator();
        while (it.hasNext()) {
            NetworkRegistry.registerInitNetwork(context, it.next());
        }
    }

    void initializeNetworks(Context context, NetworkRegistry.NetworksInitializeCallback networksInitializeCallback) {
        NetworkRegistry.registerCoreNetworks();
        NetworkRegistry.initializeNetworksAsync(context, networksInitializeCallback);
    }

    void notifyInitializationFinished() {
        Logger.d("Notify initialization finished");
        this.isInitialized.set(true);
        this.isInitializing.set(false);
        Iterator<InitializationCallback> it = this.callbackSet.iterator();
        while (it.hasNext()) {
            sendOnInitialized(it.next());
        }
        this.callbackSet.clear();
    }

    List<String> getTrackingUrls(TrackEventType trackEventType) {
        return this.trackingEventTypes.get(trackEventType);
    }

    int getRequestTimeOutMs() {
        return this.requestTimeOutMs;
    }

    int getNetworksLoadingTimeOutSec() {
        return this.networksLoadingTimeOutSec;
    }

    boolean isInitializationStarted() {
        return isInitializing() || isInitialized();
    }

    boolean isInitializing() {
        return this.isInitializing.get();
    }

    boolean isInitialized() {
        return this.isInitialized.get();
    }

    boolean isTestMode() {
        return this.isTestMode;
    }

    void setTestMode(boolean z) {
        this.isTestMode = z;
    }

    SessionTracker getSessionTracker() {
        return this.sessionTracker;
    }

    String getSellerId() {
        return this.sellerId;
    }

    TargetingParams getTargetingParams() {
        return this.targetingParams;
    }

    void setTargetingParams(TargetingParams targetingParams) {
        if (targetingParams == null) {
            targetingParams = new TargetingParams();
        }
        this.targetingParams = targetingParams;
    }

    Publisher getPublisher() {
        return this.publisher;
    }

    void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    CustomParams getCustomParams() {
        return this.customParams;
    }

    void setCustomParams(CustomParams customParams) {
        if (customParams == null) {
            customParams = new CustomParams();
        }
        this.customParams = customParams;
    }

    UserRestrictionParams getUserRestrictionParams() {
        return this.userRestrictionParams;
    }

    PriceFloorParams getPriceFloorParams() {
        return this.priceFloorParams;
    }

    AppParams getAppParams() {
        return this.appParams;
    }

    DeviceParams getDeviceParams() {
        return this.deviceParams;
    }

    public SessionParams getSessionParams() {
        return this.sessionParams;
    }

    IABSharedPreference getIabSharedPreference() {
        return this.iabSharedPreference;
    }

    void registerAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        if (adRequestListener == null) {
            return;
        }
        this.adRequestListeners.add(adRequestListener);
    }

    void unregisterAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        if (adRequestListener == null) {
            return;
        }
        this.adRequestListeners.remove(adRequestListener);
    }

    List<AdRequest.AdRequestListener<?>> getAdRequestListeners() {
        return this.adRequestListeners;
    }

    static class RenderingUserAgentProvider implements UserAgentProvider {
        private final Context applicationContext;

        public RenderingUserAgentProvider(Context context) {
            this.applicationContext = context.getApplicationContext();
        }

        @Override // io.bidmachine.rendering.utils.UserAgentProvider
        public String getUserAgent() {
            return UserAgentManager.getUserAgent(this.applicationContext);
        }
    }

    private class InitialRequestLoaderListener implements InitialRequestLoader.Listener {
        private InitialRequestLoaderListener() {
        }

        @Override // io.bidmachine.InitialRequestLoader.Listener
        public void onLoadFromStoreSuccess(InitialRequestLoader.InitResponseData initResponseData) {
            BidMachineImpl.this.handleInitResponse(SessionManager.get().getSessionId(), initResponseData.getResponse(), initResponseData.getSessionId());
        }

        @Override // io.bidmachine.InitialRequestLoader.Listener
        public void onLoadFromRemoteSuccess(InitialRequestLoader.InitResponseData initResponseData) {
            InitResponse response = initResponseData.getResponse();
            BidMachineImpl.this.handleInitResponse(SessionManager.get().getSessionId(), response, initResponseData.getSessionId());
            if (BidMachineImpl.this.appContext == null) {
                return;
            }
            ExtraParamsManager.get().setExtras(BidMachineImpl.this.appContext, response.getExtras());
            BidMachineImpl bidMachineImpl = BidMachineImpl.this;
            bidMachineImpl.initializeInitNetworks(bidMachineImpl.appContext, response.getAdNetworksList());
        }

        @Override // io.bidmachine.InitialRequestLoader.Listener
        public void onLoadFromRemoteFailed(InitialRequestLoader.InitResponseData initResponseData) {
            if (BidMachineImpl.this.appContext == null) {
                return;
            }
            BidMachineImpl bidMachineImpl = BidMachineImpl.this;
            bidMachineImpl.initializeInitNetworks(bidMachineImpl.appContext, initResponseData.getResponse().getAdNetworksList());
        }
    }
}
