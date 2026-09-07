package io.bidmachine;

import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.AdCachePlacementControl;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
class AdResponseManager {
    static final int DEF_BUSY_LIMIT = 2;
    static final int DEF_MAX_CACHE_SIZE = 8;
    private static final String TAG = "AdResponseManager";
    private static final Map<String, AdCachePlacementControl> adCachePlacementControlMap = new ConcurrentHashMap();
    private static volatile AdResponseManager instance;
    private final Object lock = new Object();
    private final List<AdResponse> adResponseList = new ArrayList();

    AdResponseManager() {
    }

    public static AdResponseManager get() {
        AdResponseManager adResponseManager = instance;
        if (adResponseManager == null) {
            synchronized (AdResponseManager.class) {
                adResponseManager = instance;
                if (adResponseManager == null) {
                    adResponseManager = new AdResponseManager();
                    instance = adResponseManager;
                }
            }
        }
        return adResponseManager;
    }

    boolean contains(AdResponse adResponse) {
        boolean zContains;
        synchronized (this.lock) {
            zContains = this.adResponseList.contains(adResponse);
        }
        return zContains;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    void store(final AdResponse adResponse) {
        if (adResponse.canCache()) {
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("store - %s", adResponse);
                }
            });
            synchronized (this.lock) {
                AdRequestParameters adRequestParameters = adResponse.getAdRequestParameters();
                AdResponse adResponse2 = null;
                int i = 0;
                int i2 = 0;
                AdResponse adResponse3 = null;
                for (AdResponse adResponse4 : this.adResponseList) {
                    if (adRequestParameters.isParametersMatched(adResponse4.getAdRequestParameters())) {
                        i2++;
                        if (adResponse4.getStatus() == AdResponseStatus.Idle) {
                            if (adResponse3 == null || adResponse3.getPrice() > adResponse4.getPrice()) {
                                adResponse3 = adResponse4;
                            }
                        } else if (adResponse4.getStatus() == AdResponseStatus.Busy) {
                            i++;
                            if (adResponse2 == null) {
                                adResponse2 = adResponse4;
                            }
                        }
                    }
                }
                if (adResponse.getStatus() != AdResponseStatus.Busy || adResponse2 == null || i < getBusyLimitForAdsType(adRequestParameters)) {
                    adResponse2 = adResponse3;
                } else {
                    adResponse2.setStatus(AdResponseStatus.Idle);
                    if (adResponse3 != null && adResponse3.getPrice() <= adResponse2.getPrice()) {
                        adResponse2 = adResponse3;
                    }
                }
                if (i2 >= getMaxCacheSizeForAdsType(adRequestParameters) && adResponse2 != null) {
                    if (adResponse.getPrice() < adResponse2.getPrice()) {
                        return;
                    }
                    adResponse2.notifyExpired(true);
                    this.adResponseList.remove(adResponse2);
                }
                this.adResponseList.add(adResponse);
            }
        }
    }

    AdResponse receive(AdRequestParameters adRequestParameters) {
        synchronized (this.lock) {
            int busyLimitForAdsType = getBusyLimitForAdsType(adRequestParameters);
            int i = 0;
            final AdResponse adResponse = null;
            AdResponse adResponse2 = null;
            for (AdResponse adResponse3 : this.adResponseList) {
                if (!adResponse3.wasShown() && adRequestParameters.isParametersMatched(adResponse3.getAdRequestParameters())) {
                    if (adResponse3.getStatus() == AdResponseStatus.Idle) {
                        if (adResponse == null || adResponse3.getPrice() > adResponse.getPrice()) {
                            adResponse = adResponse3;
                        }
                    } else if (adResponse3.getStatus() == AdResponseStatus.Busy) {
                        i++;
                        if (adResponse2 == null) {
                            adResponse2 = adResponse3;
                        }
                        if (i >= busyLimitForAdsType) {
                            adResponse2.expireAdRequests(null);
                            adResponse2.clearAdRequestList();
                            adResponse2.setStatus(AdResponseStatus.Idle);
                            if (adResponse == null || adResponse2.getPrice() >= adResponse.getPrice()) {
                                adResponse = adResponse2;
                            }
                        }
                    }
                }
            }
            if (adResponse == null || !adRequestParameters.isPricePassedByPriceFloor(adResponse.getPrice())) {
                return null;
            }
            adResponse.setStatus(AdResponseStatus.Busy);
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("receive - %s", adResponse);
                }
            });
            this.adResponseList.remove(adResponse);
            this.adResponseList.add(adResponse);
            return adResponse;
        }
    }

    List<AdResponse> peek(AdRequestParameters adRequestParameters) {
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList();
            for (AdResponse adResponse : this.adResponseList) {
                if (adResponse.getStatus() == AdResponseStatus.Idle && adRequestParameters.isParametersMatched(adResponse.getAdRequestParameters())) {
                    arrayList.add(adResponse);
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
            Collections.sort(arrayList, new Comparator<AdResponse>() { // from class: io.bidmachine.AdResponseManager.1
                @Override // java.util.Comparator
                public int compare(AdResponse adResponse2, AdResponse adResponse3) {
                    return -Double.compare(adResponse2.getPrice(), adResponse3.getPrice());
                }
            });
            return arrayList.subList(0, Math.min(getBusyLimitForAdsType(adRequestParameters), arrayList.size()));
        }
    }

    void remove(final AdResponse adResponse) {
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("remove - %s", adResponse);
            }
        });
        synchronized (this.lock) {
            this.adResponseList.remove(adResponse);
        }
    }

    int getMaxCacheSizeForAdsType(AdRequestParameters adRequestParameters) {
        AdCachePlacementControl adCachePlacementControl = getAdCachePlacementControl(adRequestParameters);
        int maxCacheSize = adCachePlacementControl != null ? adCachePlacementControl.getMaxCacheSize() : 0;
        if (maxCacheSize > 0) {
            return maxCacheSize;
        }
        return 8;
    }

    int getBusyLimitForAdsType(AdRequestParameters adRequestParameters) {
        AdCachePlacementControl adCachePlacementControl = getAdCachePlacementControl(adRequestParameters);
        int maxRetainCount = adCachePlacementControl != null ? adCachePlacementControl.getMaxRetainCount() : 0;
        if (maxRetainCount > 0) {
            return maxRetainCount;
        }
        return 2;
    }

    private AdCachePlacementControl getAdCachePlacementControl(AdRequestParameters adRequestParameters) {
        return adCachePlacementControlMap.get(adRequestParameters.getAdsType().getName());
    }

    int size() {
        return this.adResponseList.size();
    }

    static void reset() {
        setAdCachePlacementControlMap(null);
    }

    static void setAdCachePlacementControlMap(Map<String, AdCachePlacementControl> map) {
        Map<String, AdCachePlacementControl> map2 = adCachePlacementControlMap;
        map2.clear();
        if (map != null) {
            map2.putAll(map);
        }
    }
}
