package com.smaato.sdk.interstitial.model.csm;

import android.content.Context;
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
import com.smaato.sdk.interstitial.csm.SMAInterstitialNetworkEvent;
import com.smaato.sdk.interstitial.model.InterstitialAdRequest;
import com.smaato.sdk.interstitial.model.soma.InterstitialSomaRemoteSource;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes13.dex */
public class InterstitialCsmAdLoader {
    private final Context context;
    private final CsmParameters csmParameters;
    InterstitialSomaRemoteSource interstitialSomaRemoteSource;
    private boolean isCancelled;
    private final ArrayDeque networks;
    Map<String, Object> objectExtras;
    private final Consumer onAdLoadingFailed;
    private final Consumer onAdLoadingSucceeded;
    private final Runnable onCsmAdClicked;
    private final Runnable onCsmAdTtlExpired;
    private final String passbackUrl;

    public InterstitialCsmAdLoader(List<Network> list, String str, InterstitialAdRequest interstitialAdRequest, CsmParameters csmParameters, Consumer<AdResponse> consumer, Consumer<Throwable> consumer2, InterstitialSomaRemoteSource interstitialSomaRemoteSource, Context context) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.networks = arrayDeque;
        arrayDeque.addAll(list);
        this.passbackUrl = str;
        this.objectExtras = interstitialAdRequest.getAdRequest().getObjectExtras();
        this.csmParameters = csmParameters;
        this.onAdLoadingSucceeded = consumer;
        this.onAdLoadingFailed = consumer2;
        this.onCsmAdClicked = interstitialAdRequest.getAdRequest().getOnCsmAdClicked();
        this.onCsmAdTtlExpired = interstitialAdRequest.getAdRequest().getOnCsmAdExpired();
        this.interstitialSomaRemoteSource = interstitialSomaRemoteSource;
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
        SMAInterstitialNetworkEvent interstitialNetworkEvent = getInterstitialNetworkEvent(nextNetwork);
        if (interstitialNetworkEvent == null) {
            loadAdFromPassbackUrl();
            return;
        }
        InterstitialCsmDelegate interstitialCsmDelegate = new InterstitialCsmDelegate(interstitialNetworkEvent, createOnAdLoadedRunnable(nextNetwork), new Runnable() { // from class: com.smaato.sdk.interstitial.model.csm.InterstitialCsmAdLoader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.loadAd();
            }
        }, this.onCsmAdClicked, this.onCsmAdTtlExpired);
        Context context = this.context;
        Map<String, String> mapCreateParamsMap = createParamsMap(nextNetwork);
        Map<String, Object> map = this.objectExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        interstitialNetworkEvent.requestInterstitial(context, interstitialCsmDelegate, mapCreateParamsMap, map);
    }

    private Consumer createOnAdLoadedRunnable(final Network network) {
        return new Consumer() { // from class: com.smaato.sdk.interstitial.model.csm.InterstitialCsmAdLoader$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5581xffaa6676(network, (InterstitialCsmBaseDelegate) obj);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createOnAdLoadedRunnable$0$com-smaato-sdk-interstitial-model-csm-InterstitialCsmAdLoader, reason: not valid java name */
    /* synthetic */ void m5581xffaa6676(Network network, InterstitialCsmBaseDelegate interstitialCsmBaseDelegate) {
        this.onAdLoadingSucceeded.accept(AdResponse.builder().setAdType(AdType.IMAGE).setSessionId(this.csmParameters.sessionId).setSci(this.csmParameters.sci).setImpressionCountingType(this.csmParameters.impressionCountingType).setBundleId(this.csmParameters.bundleId).setTtlMs(this.csmParameters.ttlMs).setWidth(Integer.valueOf(network.getWidth())).setHeight(Integer.valueOf(network.getHeight())).setImpressionTrackingUrls(Collections.singletonList(network.getImpression())).setClickTrackingUrls(Collections.singletonList(network.getClickUrl())).setCsmObject(interstitialCsmBaseDelegate).build());
    }

    private void loadAdFromPassbackUrl() {
        try {
            this.onAdLoadingSucceeded.accept(this.interstitialSomaRemoteSource.loadAd(Request.get(this.passbackUrl)));
        } catch (Exception e) {
            e = e;
            Consumer consumer = this.onAdLoadingFailed;
            if (!(e instanceof SomaException)) {
                e = new SomaException(SomaException.Type.BAD_RESPONSE, "No interstitial network event found (adapter not installed?) and passback url failed");
            }
            consumer.accept(e);
        }
    }

    private SMAInterstitialNetworkEvent getInterstitialNetworkEvent(Network network) {
        final String className = network.isCustomCsmNetwork() ? network.getClassName() : network.getName();
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(SMAInterstitialNetworkEvent.class, this.context.getClassLoader());
        if (serviceLoaderLoad == null) {
            return null;
        }
        return (SMAInterstitialNetworkEvent) Iterables.filterFirst(serviceLoaderLoad, new Predicate() { // from class: com.smaato.sdk.interstitial.model.csm.InterstitialCsmAdLoader$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return ((SMAInterstitialNetworkEvent) obj).getNetworkName().equalsIgnoreCase(className);
            }
        });
    }

    private Map createParamsMap(Network network) {
        final HashMap map = new HashMap();
        map.put("width", String.valueOf(network.getWidth()));
        map.put("height", String.valueOf(network.getHeight()));
        Objects.onNotNull(network.getAdUnitId(), new Consumer() { // from class: com.smaato.sdk.interstitial.model.csm.InterstitialCsmAdLoader$$ExternalSyntheticLambda1
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
