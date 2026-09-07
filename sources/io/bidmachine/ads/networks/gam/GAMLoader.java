package io.bidmachine.ads.networks.gam;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.ads.networks.gam.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes7.dex */
public class GAMLoader {
    static final int DEFAULT_BOTTOM_BORDER_LOADED_AD = 2;
    private static final int DEFAULT_REST_AD_LOAD_MS = 500;
    private final Context applicationContext;
    private final long expirationTimeMs;
    private final String networkName;
    private final String requestAgent;
    private final Tag tag;
    private final VersionWrapper versionWrapper;
    private final Map<AdsFormat, GAMTypeConfig> gamTypeConfigMap = new HashMap();
    private final GAMTaskLoader gamTaskLoader = new GAMTaskLoader();
    final List<InternalGAMAd> gamAdList = new ArrayList();
    final Map<NetworkAdUnit, InternalGAMAd> reservedGamAdMap = new WeakHashMap();
    private final Object gamAdListLock = new Object();
    private final Object reservedGamAdMapLock = new Object();

    GAMLoader(Context context, VersionWrapper versionWrapper, String str, Map<AdsFormat, GAMTypeConfig> map, String str2, long j) {
        this.tag = new Tag(str + "Loader");
        this.applicationContext = context;
        this.versionWrapper = versionWrapper;
        this.networkName = str;
        this.requestAgent = str2;
        this.expirationTimeMs = j;
        for (AdsFormat adsFormat : AdsFormat.values()) {
            GAMTypeConfig gAMTypeConfig = map.get(adsFormat);
            if (gAMTypeConfig != null && !gAMTypeConfig.getGAMUnitDataList().isEmpty()) {
                sortDescByScore(gAMTypeConfig.getGAMUnitDataList());
                this.gamTypeConfigMap.put(gAMTypeConfig.getAdsFormat(), gAMTypeConfig);
            }
        }
    }

    public VersionWrapper getVersionWrapper() {
        return this.versionWrapper;
    }

    public String getNetworkName() {
        return this.networkName;
    }

    public String getRequestAgent() {
        return this.requestAgent;
    }

    public long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    void load() {
        for (AdsFormat adsFormat : AdsFormat.values()) {
            load(adsFormat);
        }
    }

    boolean load(AdsFormat adsFormat) {
        GAMTypeConfig gAMTypeConfig = this.gamTypeConfigMap.get(adsFormat);
        if (gAMTypeConfig == null || loadedGAMAdCount(gAMTypeConfig) >= gAMTypeConfig.getCacheSize()) {
            return false;
        }
        this.gamTaskLoader.loadTask(adsFormat, new LoadAdUnitListTask(gAMTypeConfig, 500));
        return true;
    }

    GAMUnitData reserveMostExpensiveGAMAd(NetworkAdUnit networkAdUnit, String str) {
        synchronized (this.gamAdListLock) {
            InternalGAMAd internalGAMAdFindMostExpensiveIdleGAMAd = findMostExpensiveIdleGAMAd(str);
            if (internalGAMAdFindMostExpensiveIdleGAMAd == null) {
                return null;
            }
            reserveGAMAd(networkAdUnit, internalGAMAdFindMostExpensiveIdleGAMAd);
            return internalGAMAdFindMostExpensiveIdleGAMAd.getGamUnitData();
        }
    }

    void reserveGAMAd(final NetworkAdUnit networkAdUnit, final InternalGAMAd internalGAMAd) {
        synchronized (this.reservedGamAdMapLock) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$$ExternalSyntheticLambda4
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("reserveGAMAd (networkAdUnitId - %s, %s)", networkAdUnit.getId(), internalGAMAd);
                }
            });
            this.reservedGamAdMap.put(networkAdUnit, internalGAMAd);
        }
    }

    void unReserveGAMAd(final NetworkAdUnit networkAdUnit) {
        synchronized (this.reservedGamAdMapLock) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("unReserveGAMAd (networkAdUnitId - %s)", networkAdUnit.getId());
                }
            });
            this.reservedGamAdMap.remove(networkAdUnit);
        }
    }

    InternalGAMAd getReservedGAMAd(NetworkAdUnit networkAdUnit) {
        InternalGAMAd internalGAMAd;
        synchronized (this.reservedGamAdMapLock) {
            internalGAMAd = this.reservedGamAdMap.get(networkAdUnit);
        }
        return internalGAMAd;
    }

    void onGAMAdShown(InternalGAMAd internalGAMAd) {
        removeFromCaches(internalGAMAd);
    }

    void onGAMAdDestroy(InternalGAMAd internalGAMAd, boolean z) {
        if (z) {
            internalGAMAd.release();
            removeFromCaches(internalGAMAd);
        } else {
            unReserveGAMAd(internalGAMAd);
        }
    }

    private void sortDescByScore(List<GAMUnitData> list) {
        Collections.sort(list, new Comparator() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return GAMLoader.lambda$sortDescByScore$2((GAMUnitData) obj, (GAMUnitData) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortDescByScore$2(GAMUnitData gAMUnitData, GAMUnitData gAMUnitData2) {
        return -Float.compare(gAMUnitData.getScore(), gAMUnitData2.getScore());
    }

    InternalGAMAd findMostExpensiveIdleGAMAd(String str) {
        synchronized (this.gamAdListLock) {
            for (InternalGAMAd internalGAMAd : this.gamAdList) {
                if (internalGAMAd.getAdUnitId().equals(str) && !isReserved(internalGAMAd)) {
                    return internalGAMAd;
                }
            }
            return null;
        }
    }

    boolean isReserved(InternalGAMAd internalGAMAd) {
        boolean zContainsValue;
        synchronized (this.reservedGamAdMapLock) {
            zContainsValue = this.reservedGamAdMap.containsValue(internalGAMAd);
        }
        return zContainsValue;
    }

    void storeGAMAd(InternalGAMAd internalGAMAd) {
        synchronized (this.gamAdListLock) {
            if (this.gamAdList.contains(internalGAMAd)) {
                return;
            }
            this.gamAdList.add(internalGAMAd);
            Collections.sort(this.gamAdList, new Comparator() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return GAMLoader.lambda$storeGAMAd$3((InternalGAMAd) obj, (InternalGAMAd) obj2);
                }
            });
        }
    }

    static /* synthetic */ int lambda$storeGAMAd$3(InternalGAMAd internalGAMAd, InternalGAMAd internalGAMAd2) {
        return -Float.compare(internalGAMAd.getScope(), internalGAMAd2.getScope());
    }

    private void removeFromCaches(final InternalGAMAd internalGAMAd) {
        synchronized (this.gamAdListLock) {
            if (this.gamAdList.remove(internalGAMAd)) {
                Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$$ExternalSyntheticLambda3
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("removeFromCaches (%s)", internalGAMAd);
                    }
                });
            }
            unReserveGAMAd(internalGAMAd);
        }
    }

    void unReserveGAMAd(InternalGAMAd internalGAMAd) {
        synchronized (this.reservedGamAdMapLock) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<NetworkAdUnit, InternalGAMAd> entry : this.reservedGamAdMap.entrySet()) {
                if (entry.getValue().equals(internalGAMAd)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                unReserveGAMAd((NetworkAdUnit) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyGAMAd(InternalGAMAd internalGAMAd) {
        try {
            internalGAMAd.destroy();
        } catch (Throwable unused) {
        }
        removeFromCaches(internalGAMAd);
    }

    private int loadedGAMAdCount(GAMTypeConfig gAMTypeConfig) {
        int i;
        synchronized (this.gamAdListLock) {
            Iterator<InternalGAMAd> it = this.gamAdList.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getAdsFormat() == gAMTypeConfig.getAdsFormat()) {
                    i++;
                }
            }
        }
        return i;
    }

    void clear() {
        this.gamTypeConfigMap.clear();
        this.gamAdList.clear();
        this.reservedGamAdMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class LoadAdUnitListTask implements Runnable {
        private final GAMLoader gamLoader;
        private final GAMTypeConfig gamTypeConfig;
        private final String id;
        private final int restAdLoadMs;

        private LoadAdUnitListTask(GAMLoader gAMLoader, GAMTypeConfig gAMTypeConfig, int i) {
            this.id = UUID.randomUUID().toString();
            this.gamLoader = gAMLoader;
            this.gamTypeConfig = gAMTypeConfig;
            this.restAdLoadMs = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(this.gamTypeConfig.getGAMUnitDataList()).iterator();
                while (it.hasNext()) {
                    InternalGAMAd internalGAMAdCreateAd = this.gamLoader.versionWrapper.createAd(this.gamLoader, this.gamTypeConfig.getAdsFormat(), (GAMUnitData) it.next());
                    if (internalGAMAdCreateAd != null) {
                        if (loadGAMAdSync(internalGAMAdCreateAd)) {
                            return;
                        } else {
                            Thread.sleep(this.restAdLoadMs);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }

        private boolean loadGAMAdSync(InternalGAMAd internalGAMAd) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                internalGAMAd.load(this.gamLoader.applicationContext, new AwaitLoadListener(countDownLatch));
                countDownLatch.await();
            } catch (Throwable unused) {
                countDownLatch.countDown();
            }
            if (!internalGAMAd.isLoaded()) {
                this.gamLoader.destroyGAMAd(internalGAMAd);
                return false;
            }
            this.gamLoader.storeGAMAd(internalGAMAd);
            return true;
        }

        private static class AwaitLoadListener implements InternalLoadListener {
            private final CountDownLatch countDownLatch;

            private AwaitLoadListener(CountDownLatch countDownLatch) {
                this.countDownLatch = countDownLatch;
            }

            @Override // io.bidmachine.ads.networks.gam.InternalLoadListener
            public void onAdLoaded(InternalGAMAd internalGAMAd) {
                this.countDownLatch.countDown();
            }

            @Override // io.bidmachine.ads.networks.gam.InternalLoadListener
            public void onAdLoadFailed(InternalGAMAd internalGAMAd, BMError bMError) {
                this.countDownLatch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class GAMTaskLoader {
        private static final int CORE_POOL_SIZE;
        private static final int CPU_COUNT;
        private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        private final Map<AdsFormat, Map<String, Future<?>>> submittedFutureMap = new EnumMap(AdsFormat.class);
        private final Object submittedFutureMapLocker = new Object();

        static {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            CPU_COUNT = iAvailableProcessors;
            CORE_POOL_SIZE = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadTask(final AdsFormat adsFormat, final LoadAdUnitListTask loadAdUnitListTask) {
            try {
                synchronized (this.submittedFutureMapLocker) {
                    Map<String, Future<?>> map = this.submittedFutureMap.get(adsFormat);
                    if (map == null || map.isEmpty()) {
                        Future<?> futureSubmit = this.executorService.submit(new Runnable() { // from class: io.bidmachine.ads.networks.gam.GAMLoader$GAMTaskLoader$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m7372x88eeacb4(loadAdUnitListTask, adsFormat);
                            }
                        });
                        if (map == null) {
                            map = new HashMap<>();
                            this.submittedFutureMap.put(adsFormat, map);
                        }
                        map.put(loadAdUnitListTask.id, futureSubmit);
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: renamed from: lambda$loadTask$0$io-bidmachine-ads-networks-gam-GAMLoader$GAMTaskLoader, reason: not valid java name */
        /* synthetic */ void m7372x88eeacb4(LoadAdUnitListTask loadAdUnitListTask, AdsFormat adsFormat) {
            loadAdUnitListTask.run();
            removeTask(adsFormat, loadAdUnitListTask.id);
        }

        private void removeTask(AdsFormat adsFormat, String str) {
            synchronized (this.submittedFutureMapLocker) {
                Map<String, Future<?>> map = this.submittedFutureMap.get(adsFormat);
                if (map != null) {
                    map.remove(str);
                }
            }
        }
    }
}
