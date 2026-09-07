package io.bidmachine.ads.networks.gam_dynamic;

import android.text.TextUtils;
import com.explorestack.protobuf.StringValue;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
class GAMAdManager {
    final List<InternalAd> internalAdList = new ArrayList();
    private final Object internalAdListLock = new Object();
    final Map<NetworkAdUnit, InternalAd> reservedInternalAdMap = new WeakHashMap();
    private final Object reservedInternalAdMapLock = new Object();
    private final Tag tag;

    public GAMAdManager(String str) {
        this.tag = new Tag(str + "AdManager");
    }

    void storeAd(final InternalAd internalAd) {
        synchronized (this.internalAdListLock) {
            if (this.internalAdList.contains(internalAd)) {
                return;
            }
            this.internalAdList.add(internalAd);
            sortDescByPrice(this.internalAdList);
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7383x46dae8cf(internalAd);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$storeAd$0$io-bidmachine-ads-networks-gam_dynamic-GAMAdManager, reason: not valid java name */
    /* synthetic */ String m7383x46dae8cf(InternalAd internalAd) {
        return String.format("Store ad (%s, size - %s)", internalAd, Integer.valueOf(getLoadedAdCount(internalAd.getAdsFormat())));
    }

    InternalAd storeOrSwapCheapestIdleAd(InternalAd internalAd, int i) {
        synchronized (this.internalAdListLock) {
            AdsFormat adsFormat = internalAd.getAdsFormat();
            InternalAd internalAd2 = null;
            if (getLoadedAdCount(adsFormat) >= i) {
                final InternalAd internalAdFindCheapestIdleAd = findCheapestIdleAd(adsFormat);
                if (internalAdFindCheapestIdleAd != null && internalAdFindCheapestIdleAd.getPrice() <= internalAd.getPrice()) {
                    Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda2
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return String.format("Remove cheapest ad (%s)", internalAdFindCheapestIdleAd);
                        }
                    });
                    removeAdFromCaches(internalAdFindCheapestIdleAd);
                    internalAd2 = internalAdFindCheapestIdleAd;
                }
                return null;
            }
            storeAd(internalAd);
            return internalAd2;
        }
    }

    int getLoadedAdCount(AdsFormat adsFormat) {
        int i;
        synchronized (this.internalAdListLock) {
            Iterator<InternalAd> it = this.internalAdList.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getAdsFormat() == adsFormat) {
                    i++;
                }
            }
        }
        return i;
    }

    InternalAdData reserveMostExpensiveAd(NetworkAdUnit networkAdUnit, AdsFormat adsFormat) {
        synchronized (this.internalAdListLock) {
            InternalAd internalAdFindMostExpensiveIdleAd = findMostExpensiveIdleAd(adsFormat);
            if (internalAdFindMostExpensiveIdleAd == null) {
                return null;
            }
            reserveAd(networkAdUnit, internalAdFindMostExpensiveIdleAd);
            return internalAdFindMostExpensiveIdleAd;
        }
    }

    InternalAd findMostExpensiveIdleAd(AdsFormat adsFormat) {
        synchronized (this.internalAdListLock) {
            for (InternalAd internalAd : this.internalAdList) {
                if (internalAd.getAdsFormat() == adsFormat && !isAdReserved(internalAd)) {
                    return internalAd;
                }
            }
            return null;
        }
    }

    InternalAd findCheapestIdleAd(AdsFormat adsFormat) {
        synchronized (this.internalAdListLock) {
            for (int size = this.internalAdList.size() - 1; size >= 0; size--) {
                InternalAd internalAd = this.internalAdList.get(size);
                if (internalAd.getAdsFormat() == adsFormat && !isAdReserved(internalAd)) {
                    return internalAd;
                }
            }
            return null;
        }
    }

    boolean removeAdFromCaches(final InternalAd internalAd) {
        boolean zRemove;
        synchronized (this.internalAdListLock) {
            zRemove = this.internalAdList.remove(internalAd);
            if (zRemove) {
                Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda4
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return this.f$0.m7381x3fdffd69(internalAd);
                    }
                });
            }
            unReserveAd(internalAd);
        }
        return zRemove;
    }

    /* JADX INFO: renamed from: lambda$removeAdFromCaches$2$io-bidmachine-ads-networks-gam_dynamic-GAMAdManager, reason: not valid java name */
    /* synthetic */ String m7381x3fdffd69(InternalAd internalAd) {
        return String.format("Remove ad from caches (%s, size - %s)", internalAd, Integer.valueOf(getLoadedAdCount(internalAd.getAdsFormat())));
    }

    List<Waterfall.Result.CachedAdUnit> getCachedAdUnitList(AdsFormat adsFormat) {
        synchronized (this.internalAdListLock) {
            if (this.internalAdList.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (InternalAd internalAd : this.internalAdList) {
                if (internalAd.getAdsFormat() == adsFormat) {
                    Waterfall.Configuration.AdUnit adUnit = internalAd.getAdUnit();
                    Waterfall.Result.CachedAdUnit.Builder frozen = Waterfall.Result.CachedAdUnit.newBuilder().setPrice(adUnit.getPrice()).setFrozen(isAdReserved(internalAd));
                    if (adUnit.getAdUnitId() != null) {
                        frozen.setAdUnitId(adUnit.getAdUnitId());
                    }
                    StringValue serverParams = adUnit.getServerParams();
                    if (serverParams != null) {
                        frozen.setServerParams(serverParams);
                    }
                    InternalAdLoadData internalAdLoadData = internalAd.getInternalAdLoadData();
                    if (internalAdLoadData != null) {
                        Waterfall.Result.EstimatedPrice price = internalAdLoadData.getPrice();
                        if (price != null) {
                            frozen.setEstimatedPrice(price);
                        }
                        String adResponse = internalAdLoadData.getAdResponse();
                        if (!TextUtils.isEmpty(adResponse)) {
                            frozen.setAdResponse(StringValue.newBuilder().setValue(adResponse).build());
                        }
                    }
                    arrayList.add(frozen.build());
                }
            }
            return arrayList;
        }
    }

    boolean isAdReserved(InternalAd internalAd) {
        boolean zContainsValue;
        synchronized (this.reservedInternalAdMapLock) {
            zContainsValue = this.reservedInternalAdMap.containsValue(internalAd);
        }
        return zContainsValue;
    }

    void reserveAd(final NetworkAdUnit networkAdUnit, final InternalAd internalAd) {
        synchronized (this.reservedInternalAdMapLock) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7382xf9d576d(networkAdUnit, internalAd);
                }
            });
            this.reservedInternalAdMap.put(networkAdUnit, internalAd);
        }
    }

    /* JADX INFO: renamed from: lambda$reserveAd$3$io-bidmachine-ads-networks-gam_dynamic-GAMAdManager, reason: not valid java name */
    /* synthetic */ String m7382xf9d576d(NetworkAdUnit networkAdUnit, InternalAd internalAd) {
        return String.format("Reserve ad (networkAdUnitId - %s, %s, %s / %s)", networkAdUnit.getId(), internalAd, Integer.valueOf(getReservedAdCount(internalAd.getAdsFormat())), Integer.valueOf(getLoadedAdCount(internalAd.getAdsFormat())));
    }

    void unReserveAd(InternalAd internalAd) {
        synchronized (this.reservedInternalAdMapLock) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<NetworkAdUnit, InternalAd> entry : this.reservedInternalAdMap.entrySet()) {
                if (entry.getValue().equals(internalAd)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                unReserveAd((NetworkAdUnit) it.next());
            }
        }
    }

    void unReserveAd(final NetworkAdUnit networkAdUnit) {
        synchronized (this.reservedInternalAdMapLock) {
            final InternalAd internalAdRemove = this.reservedInternalAdMap.remove(networkAdUnit);
            if (internalAdRemove != null) {
                Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda5
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return this.f$0.m7384x13abc655(networkAdUnit, internalAdRemove);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$unReserveAd$4$io-bidmachine-ads-networks-gam_dynamic-GAMAdManager, reason: not valid java name */
    /* synthetic */ String m7384x13abc655(NetworkAdUnit networkAdUnit, InternalAd internalAd) {
        return String.format("UnReserve ad (networkAdUnitId - %s, %s, %s / %s)", networkAdUnit.getId(), internalAd, Integer.valueOf(getReservedAdCount(internalAd.getAdsFormat())), Integer.valueOf(getLoadedAdCount(internalAd.getAdsFormat())));
    }

    InternalAd getReservedAd(NetworkAdUnit networkAdUnit) {
        InternalAd internalAd;
        synchronized (this.reservedInternalAdMapLock) {
            internalAd = this.reservedInternalAdMap.get(networkAdUnit);
        }
        return internalAd;
    }

    int getReservedAdCount(AdsFormat adsFormat) {
        int i;
        synchronized (this.reservedInternalAdMapLock) {
            Iterator<InternalAd> it = this.reservedInternalAdMap.values().iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getAdsFormat() == adsFormat) {
                    i++;
                }
            }
        }
        return i;
    }

    void sortDescByPrice(List<InternalAd> list) {
        Collections.sort(list, new Comparator() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMAdManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return GAMAdManager.lambda$sortDescByPrice$5((InternalAd) obj, (InternalAd) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortDescByPrice$5(InternalAd internalAd, InternalAd internalAd2) {
        return -Double.compare(internalAd.getPrice(), internalAd2.getPrice());
    }
}
