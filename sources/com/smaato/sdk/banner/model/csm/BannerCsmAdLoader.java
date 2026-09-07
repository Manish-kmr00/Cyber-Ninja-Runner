package com.smaato.sdk.banner.model.csm;

import android.content.Context;
import android.view.View;
import com.smaato.sdk.banner.csm.SMABannerNetworkEvent;
import com.smaato.sdk.banner.csm.SMABannerNetworkEventListener;
import com.smaato.sdk.banner.model.BannerAdRequest;
import com.smaato.sdk.banner.model.soma.BannerSomaRemoteSource;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.csm.Network;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.csm.CsmParameters;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes8.dex */
public class BannerCsmAdLoader {
    BannerSomaRemoteSource bannerSomaRemoteSource;
    private final Context context;
    private final CsmParameters csmParameters;
    private boolean isCancelled;
    private final ArrayDeque networks;
    Map<String, Object> objectExtras;
    private final Consumer onAdLoadingFailed;
    private final Consumer onAdLoadingSucceeded;
    private final Runnable onCsmAdClicked;
    private final Runnable onCsmAdTtlExpired;
    private final String passbackUrl;

    public BannerCsmAdLoader(List<Network> list, String str, BannerAdRequest bannerAdRequest, CsmParameters csmParameters, Consumer<AdResponse> consumer, Consumer<Throwable> consumer2, BannerSomaRemoteSource bannerSomaRemoteSource, Context context) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.networks = arrayDeque;
        arrayDeque.addAll(list);
        this.passbackUrl = str;
        this.objectExtras = bannerAdRequest.getAdRequest().getObjectExtras();
        this.csmParameters = csmParameters;
        this.onAdLoadingSucceeded = consumer;
        this.onAdLoadingFailed = consumer2;
        this.onCsmAdClicked = bannerAdRequest.getAdRequest().getOnCsmAdClicked();
        this.onCsmAdTtlExpired = bannerAdRequest.getAdRequest().getOnCsmAdExpired();
        this.bannerSomaRemoteSource = bannerSomaRemoteSource;
        this.context = context;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void loadAd() {
        if (this.isCancelled) {
            return;
        }
        Network nextNetwork = getNextNetwork();
        if (nextNetwork == null) {
            loadAdFromPassbackUrl();
            return;
        }
        SMABannerNetworkEvent bannerNetworkEvent = getBannerNetworkEvent(nextNetwork);
        if (bannerNetworkEvent == null) {
            loadAdFromPassbackUrl();
            return;
        }
        Context context = this.context;
        SMABannerNetworkEventListener sMABannerNetworkEventListenerCreateNetworkEventListener = createNetworkEventListener(nextNetwork);
        Map<String, String> mapCreateParamsMap = createParamsMap(nextNetwork);
        Map<String, Object> map = this.objectExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        bannerNetworkEvent.requestBanner(context, sMABannerNetworkEventListenerCreateNetworkEventListener, mapCreateParamsMap, map);
    }

    private void loadAdFromPassbackUrl() {
        try {
            this.onAdLoadingSucceeded.accept(this.bannerSomaRemoteSource.loadAd(Request.get(this.passbackUrl)));
        } catch (Exception e) {
            e = e;
            Consumer consumer = this.onAdLoadingFailed;
            if (!(e instanceof SomaException)) {
                e = new SomaException(SomaException.Type.BAD_RESPONSE, "No banner network event found (adapter not installed?) and passback url failed");
            }
            consumer.accept(e);
        }
    }

    private SMABannerNetworkEvent getBannerNetworkEvent(Network network) {
        final String className = network.isCustomCsmNetwork() ? network.getClassName() : network.getName();
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(SMABannerNetworkEvent.class, this.context.getClassLoader());
        if (serviceLoaderLoad == null) {
            return null;
        }
        return (SMABannerNetworkEvent) Iterables.filterFirst(serviceLoaderLoad, new Predicate() { // from class: com.smaato.sdk.banner.model.csm.BannerCsmAdLoader$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return ((SMABannerNetworkEvent) obj).getNetworkName().equalsIgnoreCase(className);
            }
        });
    }

    private SMABannerNetworkEventListener createNetworkEventListener(final Network network) {
        return new SMABannerNetworkEventListener() { // from class: com.smaato.sdk.banner.model.csm.BannerCsmAdLoader.1
            @Override // com.smaato.sdk.banner.csm.SMABannerNetworkEventListener
            public void onAdLoaded(View view) {
                BannerCsmAdLoader.this.onAdLoadingSucceeded.accept(AdResponse.builder().setAdType(AdType.IMAGE).setSessionId(BannerCsmAdLoader.this.csmParameters.sessionId).setSci(BannerCsmAdLoader.this.csmParameters.sci).setImpressionCountingType(BannerCsmAdLoader.this.csmParameters.impressionCountingType).setBundleId(BannerCsmAdLoader.this.csmParameters.bundleId).setTtlMs(BannerCsmAdLoader.this.csmParameters.ttlMs).setWidth(Integer.valueOf(network.getWidth())).setHeight(Integer.valueOf(network.getHeight())).setImpressionTrackingUrls(Collections.singletonList(network.getImpression())).setClickTrackingUrls(Collections.singletonList(network.getClickUrl())).setCsmObject(view).build());
            }

            @Override // com.smaato.sdk.banner.csm.SMABannerNetworkEventListener
            public void onAdFailedToLoad() {
                BannerCsmAdLoader.this.loadAd();
            }

            @Override // com.smaato.sdk.banner.csm.SMABannerNetworkEventListener
            public void onAdClicked() {
                BannerCsmAdLoader.this.onCsmAdClicked.run();
            }

            @Override // com.smaato.sdk.banner.csm.SMABannerNetworkEventListener
            public void onAdTTLExpired() {
                BannerCsmAdLoader.this.onCsmAdTtlExpired.run();
            }
        };
    }

    private Map createParamsMap(Network network) {
        final HashMap map = new HashMap();
        map.put("width", String.valueOf(network.getWidth()));
        map.put("height", String.valueOf(network.getHeight()));
        Objects.onNotNull(network.getAdUnitId(), new Consumer() { // from class: com.smaato.sdk.banner.model.csm.BannerCsmAdLoader$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                map.put("adUnitId", (String) obj);
            }
        });
        map.putAll(TextUtils.convertJsonStringToMap(network.getCustomData()));
        return map;
    }

    private synchronized Network getNextNetwork() {
        try {
        } catch (Exception unused) {
            return null;
        }
        return (Network) this.networks.pop();
    }
}
