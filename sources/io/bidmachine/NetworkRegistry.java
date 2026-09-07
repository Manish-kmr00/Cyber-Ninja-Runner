package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import io.bidmachine.ads.networks.mraid.MraidConfig;
import io.bidmachine.ads.networks.nast.NastConfig;
import io.bidmachine.ads.networks.vast.VastConfig;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.internal.utils.LogSafeRunnable;
import io.bidmachine.protobuf.AdNetwork;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkRegistry {
    static final Map<String, NetworkAdapter> NETWORK_ADAPTER_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> CORE_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> FROM_INIT_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> PENDING_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> INITIALIZING_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> INITIALIZED_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<AdsType, Map<String, NetworkConfig>> INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP = new ConcurrentHashMap(AdsType.values().length);
    static final Map<AdsType, Map<String, NetworkConfig>> INITIALIZED_NETWORK_CONFIG_TYPED_MAP = new ConcurrentHashMap(AdsType.values().length);
    private static final AtomicBoolean IS_NETWORKS_INITIALIZING_EXECUTED = new AtomicBoolean(false);
    private static final AtomicBoolean IS_CORE_NETWORKS_INITIALIZING = new AtomicBoolean(false);
    private static final AtomicBoolean IS_CORE_NETWORKS_INITIALIZED = new AtomicBoolean(false);
    private static final Object CORE_INITIALIZING_LOCK = new Object();
    private static final Object INITIALIZING_LOCK = new Object();

    interface NetworksInitializeCallback {
        void onExecuted();
    }

    static NetworkAdapter obtainAdapter(NetworkConfig networkConfig) {
        synchronized (NetworkRegistry.class) {
            String networkKey = networkConfig.getNetworkKey();
            NetworkAdapter adapter = getAdapter(networkKey);
            if (adapter != null) {
                return adapter;
            }
            NetworkAdapter networkAdapterCreateNetworkAdapter = networkConfig.createNetworkAdapter();
            NETWORK_ADAPTER_MAP.put(networkKey, networkAdapterCreateNetworkAdapter);
            return networkAdapterCreateNetworkAdapter;
        }
    }

    public static NetworkAdapter getAdapter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return NETWORK_ADAPTER_MAP.get(str);
    }

    static Map<String, NetworkConfig> copyOrNullInitializedCoreNetworkConfigs(AdsType adsType) {
        Map<String, NetworkConfig> map = INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP.get(adsType);
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    static Map<String, NetworkConfig> copyOrNullInitializedNetworkConfigs(AdsType adsType) {
        Map<String, NetworkConfig> map = INITIALIZED_NETWORK_CONFIG_TYPED_MAP.get(adsType);
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    static Collection<NetworkConfig> getCoreNetworkConfigList() {
        return CORE_NETWORK_CONFIG_MAP.values();
    }

    static void registerCoreNetworks() {
        registerCoreNetwork(new MraidConfig().withMediationConfig(AdsFormat.Banner, new HashMap()).withMediationConfig(AdsFormat.InterstitialStatic, new HashMap()).withMediationConfig(AdsFormat.RewardedStatic, new HashMap()));
        registerCoreNetwork(new VastConfig().withMediationConfig(AdsFormat.InterstitialVideo, new HashMap()).withMediationConfig(AdsFormat.RewardedVideo, new HashMap()));
        registerCoreNetwork(new NastConfig().withMediationConfig(AdsFormat.Native, new HashMap()));
        registerCoreNetwork(new AdaptiveRenderingConfig().withMediationConfig(AdsFormat.Banner, new HashMap()).withMediationConfig(AdsFormat.Interstitial, new HashMap()).withMediationConfig(AdsFormat.Rewarded, new HashMap()));
    }

    static void registerCoreNetwork(NetworkConfig networkConfig) {
        String networkKey = networkConfig.getNetworkKey();
        Map<String, NetworkConfig> map = CORE_NETWORK_CONFIG_MAP;
        if (map.containsKey(networkKey)) {
            return;
        }
        map.put(networkKey, networkConfig);
        registerNetwork(networkConfig);
    }

    static void registerAndInitializeCoreNetworks(Context context) {
        AtomicBoolean atomicBoolean = IS_CORE_NETWORKS_INITIALIZED;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (CORE_INITIALIZING_LOCK) {
            if (IS_CORE_NETWORKS_INITIALIZING.compareAndSet(false, true)) {
                registerCoreNetworks();
                initializeNetworksAwait(context, getCoreNetworkConfigList());
                atomicBoolean.set(true);
            }
        }
    }

    static NetworkConfig getConfig(String str) {
        if (str == null) {
            return null;
        }
        return INITIALIZED_NETWORK_CONFIG_MAP.get(str);
    }

    static Map<String, NetworkConfig> createInitNetworkConfigMap() {
        return new HashMap(FROM_INIT_NETWORK_CONFIG_MAP);
    }

    static boolean isNetworkRegistered(String str) {
        return getAdapter(str) != null;
    }

    static String checkAndPutNetwork(Context context, AdsType adsType, NetworkConfig networkConfig, Map<String, NetworkConfig> map) {
        NetworkAdapter adapter = getAdapter(networkConfig.getNetworkKey());
        if (adapter == null) {
            return "Network not registered";
        }
        if (!adapter.isAdsTypeSupported(adsType)) {
            return "Network does not support this ad type";
        }
        if (!adapter.isInitialized(context)) {
            return "Network not initialized";
        }
        map.put(networkConfig.getNetworkKey(), networkConfig);
        return null;
    }

    static Collection<NetworkConfig> getPendingNetworkConfigList() {
        return PENDING_NETWORK_CONFIG_MAP.values();
    }

    static void registerNetworks(NetworkConfig... networkConfigArr) {
        if (networkConfigArr == null) {
            return;
        }
        for (NetworkConfig networkConfig : networkConfigArr) {
            registerNetwork(networkConfig);
        }
    }

    static void registerNetworks(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                NetworkConfig networkConfigCreate = NetworkConfigFactory.create(context, jSONArray.getJSONObject(i));
                if (networkConfigCreate != null) {
                    registerNetwork(networkConfigCreate);
                }
            }
        } catch (JSONException e) {
            Logger.w(e);
        }
    }

    static void registerNetworks(final Context context, final String str, final NetworkRegistryCallback networkRegistryCallback) {
        CommonBackgroundTaskManager.get().execute(new LogSafeRunnable() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.SafeRunnable
            public final void onRun() throws Throwable {
                NetworkRegistry.lambda$registerNetworks$1(context, str, networkRegistryCallback);
            }
        });
    }

    static /* synthetic */ void lambda$registerNetworks$1(Context context, String str, final NetworkRegistryCallback networkRegistryCallback) throws Throwable {
        registerNetworks(context, str);
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NetworkRegistry.lambda$registerNetworks$0(networkRegistryCallback);
            }
        });
    }

    static /* synthetic */ void lambda$registerNetworks$0(NetworkRegistryCallback networkRegistryCallback) {
        if (networkRegistryCallback != null) {
            networkRegistryCallback.onRegistered();
        }
    }

    static void registerNetwork(NetworkConfig networkConfig) {
        BidMachineImpl bidMachineImpl;
        Context appContext;
        if (networkConfig == null || isNetworkRegistered(networkConfig.getNetworkKey())) {
            return;
        }
        obtainAdapter(networkConfig);
        PENDING_NETWORK_CONFIG_MAP.put(networkConfig.getNetworkKey(), networkConfig);
        if (!isNetworksInitializingExecuted() || (appContext = (bidMachineImpl = BidMachineImpl.get()).getAppContext()) == null) {
            return;
        }
        initializeNetwork(new SimpleContextProvider(appContext), new InitializationParamsImpl(bidMachineImpl.getTargetingParams(), bidMachineImpl.getUserRestrictionParams()), networkConfig, null);
    }

    static void registerInitNetwork(Context context, AdNetwork adNetwork) {
        NetworkConfig networkConfigCreate;
        if (isNetworkRegistered(adNetwork.getName()) || (networkConfigCreate = NetworkConfigFactory.create(context, adNetwork)) == null) {
            return;
        }
        FROM_INIT_NETWORK_CONFIG_MAP.put(networkConfigCreate.getNetworkKey(), networkConfigCreate);
        registerNetwork(networkConfigCreate);
    }

    static boolean isNetworksInitializingExecuted() {
        return IS_NETWORKS_INITIALIZING_EXECUTED.get();
    }

    static void initializeNetworksSync(Context context) {
        if (IS_NETWORKS_INITIALIZING_EXECUTED.compareAndSet(false, true)) {
            initializeNetworksAwait(context.getApplicationContext());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.bidmachine.NetworkRegistry$1] */
    static void initializeNetworksAsync(Context context, final NetworksInitializeCallback networksInitializeCallback) {
        if (IS_NETWORKS_INITIALIZING_EXECUTED.compareAndSet(false, true)) {
            final Context applicationContext = context.getApplicationContext();
            new Thread() { // from class: io.bidmachine.NetworkRegistry.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    NetworkRegistry.initializeNetworksAwait(applicationContext);
                    NetworksInitializeCallback networksInitializeCallback2 = networksInitializeCallback;
                    if (networksInitializeCallback2 != null) {
                        networksInitializeCallback2.onExecuted();
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initializeNetworksAwait(Context context) {
        initializeNetworksAwait(context, getPendingNetworkConfigList());
    }

    private static void initializeNetworksAwait(Context context, Collection<NetworkConfig> collection) {
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        initializeNetworksAwait(new SimpleContextProvider(context), new InitializationParamsImpl(bidMachineImpl.getTargetingParams(), bidMachineImpl.getUserRestrictionParams()), collection);
    }

    private static void initializeNetworksAwait(ContextProvider contextProvider, InitializationParams initializationParams, Collection<NetworkConfig> collection) {
        if (collection.isEmpty()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(collection.size());
        for (NetworkConfig networkConfig : collection) {
            Objects.requireNonNull(countDownLatch);
            initializeNetwork(contextProvider, initializationParams, networkConfig, new NetworksInitializeCallback() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda1
                @Override // io.bidmachine.NetworkRegistry.NetworksInitializeCallback
                public final void onExecuted() {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Logger.w(e);
        }
    }

    private static void initializeNetwork(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfig networkConfig, NetworksInitializeCallback networksInitializeCallback) {
        synchronized (INITIALIZING_LOCK) {
            String networkKey = networkConfig.getNetworkKey();
            Map<String, NetworkConfig> map = INITIALIZING_NETWORK_CONFIG_MAP;
            if (map.containsKey(networkKey)) {
                PENDING_NETWORK_CONFIG_MAP.remove(networkKey);
                if (networksInitializeCallback != null) {
                    networksInitializeCallback.onExecuted();
                }
            } else {
                map.put(networkKey, networkConfig);
                new NetworkLoadTask(contextProvider, initializationParams, networkConfig, networksInitializeCallback).executeAsync();
            }
        }
    }

    static void setLoggingEnabled(boolean z) {
        Iterator<Map.Entry<String, NetworkAdapter>> it = NETWORK_ADAPTER_MAP.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().setLogging(z);
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
    }

    static void reset() {
        NETWORK_ADAPTER_MAP.clear();
        CORE_NETWORK_CONFIG_MAP.clear();
        FROM_INIT_NETWORK_CONFIG_MAP.clear();
        PENDING_NETWORK_CONFIG_MAP.clear();
        INITIALIZING_NETWORK_CONFIG_MAP.clear();
        INITIALIZED_NETWORK_CONFIG_MAP.clear();
        INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP.clear();
        INITIALIZED_NETWORK_CONFIG_TYPED_MAP.clear();
        IS_NETWORKS_INITIALIZING_EXECUTED.set(false);
        IS_CORE_NETWORKS_INITIALIZING.set(false);
        IS_CORE_NETWORKS_INITIALIZED.set(false);
        NetworkLoadTask.NETWORK_LOAD_TASK_LIST.clear();
    }

    static final class NetworkLoadTask implements Runnable {
        private static final Executor EXECUTOR = Executors.newFixedThreadPool(Math.max(8, Runtime.getRuntime().availableProcessors() * 4));
        private static final Object INITIALIZED_NETWORK_CONFIG_TYPED_LOCK = new Object();
        static final List<NetworkLoadTask> NETWORK_LOAD_TASK_LIST = new CopyOnWriteArrayList();
        private final NetworksInitializeCallback callback;
        private final ContextProvider contextProvider;
        private final InitializationParams initializationParams;
        private final NetworkConfig networkConfig;
        private final String networkKey;
        private final TrackingObject trackingObject;

        private NetworkLoadTask(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfig networkConfig, NetworksInitializeCallback networksInitializeCallback) {
            this.contextProvider = contextProvider;
            this.initializationParams = initializationParams;
            this.networkConfig = networkConfig;
            this.callback = networksInitializeCallback;
            String networkKey = networkConfig.getNetworkKey();
            this.networkKey = networkKey;
            this.trackingObject = new BidMachineTrackingObject(networkKey + "_initialize");
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(this.networkKey, "Initialization started");
            try {
                this.trackingObject.eventStart(TrackEventType.HeaderBiddingNetworkInitialize, new TrackEventInfo().withParameter("HB_NETWORK", this.networkKey));
                NetworkAdapter networkAdapterObtainAdapter = NetworkRegistry.obtainAdapter(this.networkConfig);
                networkAdapterObtainAdapter.setLogging(Logger.isLoggingEnabled());
                networkAdapterObtainAdapter.initialize(this.contextProvider, this.initializationParams, this.networkConfig.getNetworkConfigParams(), new InitializationCallback(this));
                if (!NetworkRegistry.INITIALIZED_NETWORK_CONFIG_MAP.containsKey(this.networkKey)) {
                    NetworkRegistry.INITIALIZED_NETWORK_CONFIG_MAP.put(this.networkKey, this.networkConfig);
                }
                for (AdsType adsType : this.networkConfig.getSupportedAdsTypes(networkAdapterObtainAdapter)) {
                    synchronized (INITIALIZED_NETWORK_CONFIG_TYPED_LOCK) {
                        if (NetworkRegistry.CORE_NETWORK_CONFIG_MAP.containsKey(this.networkKey)) {
                            addAdsTypeNetworkConfig(NetworkRegistry.INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP, adsType, this.networkKey, this.networkConfig);
                        }
                        addAdsTypeNetworkConfig(NetworkRegistry.INITIALIZED_NETWORK_CONFIG_TYPED_MAP, adsType, this.networkKey, this.networkConfig);
                    }
                }
                NetworkRegistry.PENDING_NETWORK_CONFIG_MAP.remove(this.networkKey);
            } catch (Throwable th) {
                Logger.w(th);
                onInitializationFail("Network initialization exception");
            }
            NetworksInitializeCallback networksInitializeCallback = this.callback;
            if (networksInitializeCallback != null) {
                networksInitializeCallback.onExecuted();
            }
        }

        void executeSync() {
            NETWORK_LOAD_TASK_LIST.add(this);
            run();
        }

        void executeAsync() {
            NETWORK_LOAD_TASK_LIST.add(this);
            try {
                EXECUTOR.execute(this);
            } catch (Throwable th) {
                Logger.w(th);
                onInitializationFail("Exception creating network initialization task");
            }
        }

        void onInitializationSuccess(final NetworkAdapter networkAdapter) {
            Logger.d(this.networkKey, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkRegistry$NetworkLoadTask$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    NetworkAdapter networkAdapter2 = networkAdapter;
                    return String.format("Initialization completed: %s, %s", networkAdapter2.obtainNetworkSdkVersion(), networkAdapter2.getAdapterVersion());
                }
            });
            if (networkAdapter instanceof HeaderBiddingAdapter) {
                this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkInitialize, null, new EventData().setNetworkName(this.networkKey), null);
            } else {
                this.trackingObject.clearEvent(TrackEventType.HeaderBiddingNetworkInitialize);
            }
            NETWORK_LOAD_TASK_LIST.remove(this);
        }

        void onInitializationFail(final String str) {
            Logger.e(this.networkKey, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkRegistry$NetworkLoadTask$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Initialization error: %s", str);
                }
            });
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkInitialize, null, new EventData().setNetworkName(this.networkKey), BMError.adapterInitialization(str));
            NETWORK_LOAD_TASK_LIST.remove(this);
        }

        private void addAdsTypeNetworkConfig(Map<AdsType, Map<String, NetworkConfig>> map, AdsType adsType, String str, NetworkConfig networkConfig) {
            Map<String, NetworkConfig> concurrentHashMap = map.get(adsType);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                map.put(adsType, concurrentHashMap);
            }
            concurrentHashMap.put(str, networkConfig);
        }

        private static class InitializationCallback implements InternalNetworkInitializationCallback {
            private final WeakReference<NetworkLoadTask> weakNetworkLoadTask;

            public InitializationCallback(NetworkLoadTask networkLoadTask) {
                this.weakNetworkLoadTask = new WeakReference<>(networkLoadTask);
            }

            @Override // io.bidmachine.InternalNetworkInitializationCallback
            public void onSuccess(NetworkAdapter networkAdapter) {
                NetworkLoadTask networkLoadTask = this.weakNetworkLoadTask.get();
                if (networkLoadTask != null) {
                    networkLoadTask.onInitializationSuccess(networkAdapter);
                }
            }

            @Override // io.bidmachine.InternalNetworkInitializationCallback
            public void onFail(NetworkAdapter networkAdapter, String str) {
                NetworkLoadTask networkLoadTask = this.weakNetworkLoadTask.get();
                if (networkLoadTask != null) {
                    networkLoadTask.onInitializationFail(str);
                }
            }
        }
    }
}
