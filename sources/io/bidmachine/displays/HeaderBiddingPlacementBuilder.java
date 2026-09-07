package io.bidmachine.displays;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.AdContentType;
import io.bidmachine.AdsType;
import io.bidmachine.BidMachineTrackingObject;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;
import io.bidmachine.NetworkRegistry;
import io.bidmachine.ProtoExtConstants;
import io.bidmachine.TrackEventType;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class HeaderBiddingPlacementBuilder<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    private static final long DEFAULT_HB_PREPARE_TIMEOUT_SEC = 10;

    HeaderBiddingPlacementBuilder() {
    }

    HeaderBiddingPlacement.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype, AdsType adsType, AdContentType adContentType, Collection<NetworkConfig> collection, List<NetworkAdUnit> list, int i) {
        ArrayList<AdUnitPreloadTask> arrayList = new ArrayList();
        Iterator<NetworkConfig> it = collection.iterator();
        while (it.hasNext()) {
            NetworkConfig next = it.next();
            NetworkAdapter adapter = NetworkRegistry.getAdapter(next.getNetworkKey());
            if ((adapter instanceof HeaderBiddingAdapter) && adapter.isInitialized(contextProvider)) {
                for (NetworkAdUnit networkAdUnit : next.createNetworkAdUnitList(adsType, unifiedadrequestparamstype, adContentType, adapter)) {
                    list.add(networkAdUnit);
                    arrayList.add(new AdUnitPreloadTask(contextProvider, (HeaderBiddingAdapter) adapter, adsType, adContentType, unifiedadrequestparamstype, networkAdUnit));
                    it = it;
                }
            }
            it = it;
        }
        if (!arrayList.isEmpty()) {
            BidMachineTrackingObject bidMachineTrackingObject = new BidMachineTrackingObject();
            bidMachineTrackingObject.eventStart(TrackEventType.HeaderBiddingNetworksPrepare);
            try {
                CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((AdUnitPreloadTask) it2.next()).execute(countDownLatch);
                }
                try {
                    countDownLatch.await(i > 0 ? i : 10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Logger.w(e);
                }
                ArrayList arrayList2 = null;
                for (AdUnitPreloadTask adUnitPreloadTask : arrayList) {
                    HeaderBiddingPlacement.AdUnit adUnit = adUnitPreloadTask.getAdUnit();
                    if (adUnit != null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(adUnit);
                    } else if (!adUnitPreloadTask.isFinished()) {
                        adUnitPreloadTask.cancel();
                    }
                }
                if (!Utils.isEmpty(arrayList2)) {
                    HeaderBiddingPlacement.Builder builderNewBuilder = HeaderBiddingPlacement.newBuilder();
                    builderNewBuilder.addAllAdUnits(arrayList2);
                    bidMachineTrackingObject.eventFinish(TrackEventType.HeaderBiddingNetworksPrepare, adsType, (EventData) null, (BMError) null);
                    return builderNewBuilder;
                }
                bidMachineTrackingObject.eventFinish(TrackEventType.HeaderBiddingNetworksPrepare, adsType, (EventData) null, (BMError) null);
            } catch (Throwable th) {
                bidMachineTrackingObject.eventFinish(TrackEventType.HeaderBiddingNetworksPrepare, adsType, (EventData) null, (BMError) null);
                throw th;
            }
        }
        return null;
    }

    AdObjectParams createAdObjectParams(Ad ad) {
        HeaderBiddingAd headerBiddingAdObtainHeaderBiddingAd = obtainHeaderBiddingAd(ad);
        if (headerBiddingAdObtainHeaderBiddingAd != null) {
            return new HeaderBiddingAdObjectParams(ad, headerBiddingAdObtainHeaderBiddingAd);
        }
        return null;
    }

    HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        HeaderBiddingAd headerBiddingAdObtainHeaderBiddingAd = null;
        if (ad.hasDisplay()) {
            Ad.Display display = ad.getDisplay();
            headerBiddingAdObtainHeaderBiddingAd = display.hasBanner() ? obtainHeaderBiddingAd(display.getBanner().getExtProtoList()) : null;
            if (headerBiddingAdObtainHeaderBiddingAd == null && display.hasNative()) {
                headerBiddingAdObtainHeaderBiddingAd = obtainHeaderBiddingAd(display.getNative().getExtProtoList());
            }
        }
        return (headerBiddingAdObtainHeaderBiddingAd == null && ad.hasVideo()) ? obtainHeaderBiddingAd(ad.getVideo().getExtProtoList()) : headerBiddingAdObtainHeaderBiddingAd;
    }

    private HeaderBiddingAd obtainHeaderBiddingAd(List<Any> list) {
        for (Any any : list) {
            if (any.is(HeaderBiddingAd.class)) {
                try {
                    return (HeaderBiddingAd) any.unpack(HeaderBiddingAd.class);
                } catch (InvalidProtocolBufferException e) {
                    Logger.w(e);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AdUnitPreloadTask<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> implements Runnable, HeaderBiddingAdRequestParams, HeaderBiddingCollectParamsCallback {
        private static final Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        private final AdContentType adContentType;
        private final UnifiedAdRequestParamsType adRequestParams;
        private HeaderBiddingPlacement.AdUnit adUnit;
        private final HeaderBiddingAdapter adapter;
        private final AdsType adsType;
        private final ContextProvider contextProvider;
        private final NetworkAdUnit networkAdUnit;
        private CountDownLatch syncLock;
        private boolean isFinished = false;
        private final TrackingObject trackingObject = new BidMachineTrackingObject();

        AdUnitPreloadTask(ContextProvider contextProvider, HeaderBiddingAdapter headerBiddingAdapter, AdsType adsType, AdContentType adContentType, UnifiedAdRequestParamsType unifiedadrequestparamstype, NetworkAdUnit networkAdUnit) {
            this.contextProvider = contextProvider;
            this.adapter = headerBiddingAdapter;
            this.adsType = adsType;
            this.adContentType = adContentType;
            this.adRequestParams = unifiedadrequestparamstype;
            this.networkAdUnit = networkAdUnit;
        }

        @Override // io.bidmachine.HeaderBiddingAdRequestParams
        public AdsType getAdsType() {
            return this.adsType;
        }

        @Override // io.bidmachine.HeaderBiddingAdRequestParams
        public AdContentType getAdContentType() {
            return this.adContentType;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.adapter.collectHeaderBiddingParams(this.contextProvider, this.adRequestParams, this.networkAdUnit, this, this);
            } catch (Throwable th) {
                Logger.w(th);
                onCollectFail(BMError.throwable("Exception collecting header bidding parameters", th));
            }
        }

        @Override // io.bidmachine.HeaderBiddingCollectParamsCallback
        public void onCollectFinished(Map<String, String> map) {
            if (this.isFinished) {
                return;
            }
            this.adUnit = HeaderBiddingPlacement.AdUnit.newBuilder().setBidder(this.adapter.getKey()).setBidderSdkver(this.adapter.obtainNetworkSdkVersion()).putClientParams(ProtoExtConstants.AD_UNIT_ID, this.networkAdUnit.getId()).putAllClientParams(this.networkAdUnit.getMediationConfig()).putAllClientParams(map).build();
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7423xedc3bc5f();
                }
            });
            finish();
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkPrepare, this.adsType, new EventData().setNetworkName(this.adapter.getKey()), null);
        }

        /* JADX INFO: renamed from: lambda$onCollectFinished$0$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m7423xedc3bc5f() {
            return String.format("%s (%s) - Header bidding collect finished", this.adsType, this.adContentType);
        }

        @Override // io.bidmachine.HeaderBiddingCollectParamsCallback
        public void onCollectFail(final BMError bMError) {
            if (this.isFinished) {
                return;
            }
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7422xd6114512(bMError);
                }
            });
            finish();
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkPrepare, this.adsType, new EventData().setNetworkName(this.adapter.getKey()), bMError);
        }

        /* JADX INFO: renamed from: lambda$onCollectFail$1$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m7422xd6114512(BMError bMError) {
            return String.format("%s (%s) - Header bidding collect fail - %s", this.adsType, this.adContentType, bMError);
        }

        void execute(CountDownLatch countDownLatch) {
            this.trackingObject.eventStart(TrackEventType.HeaderBiddingNetworkPrepare, new TrackEventInfo().withParameter("HB_NETWORK", this.adapter.getKey()).withParameter("BM_AD_TYPE", this.adsType.getName()));
            this.syncLock = countDownLatch;
            executor.execute(this);
        }

        void cancel() {
            if (this.isFinished) {
                return;
            }
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7421xd1611246();
                }
            });
            finish();
        }

        /* JADX INFO: renamed from: lambda$cancel$2$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m7421xd1611246() {
            return String.format("%s (%s) - Header bidding collect fail: timeout", this.adsType, this.adContentType);
        }

        HeaderBiddingPlacement.AdUnit getAdUnit() {
            return this.adUnit;
        }

        boolean isFinished() {
            return this.isFinished;
        }

        private void finish() {
            this.isFinished = true;
            this.syncLock.countDown();
        }
    }
}
