package com.smaato.sdk.nativead.viewmodel;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.lifecycle.Lifecycle;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.viewmodel.AdStatus;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.openmeasurement.ViewabilityTracker;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.nativead.NativeAd;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdError;
import com.smaato.sdk.nativead.NativeAdException;
import com.smaato.sdk.nativead.NativeAdLink;
import com.smaato.sdk.nativead.NativeAdRenderer;
import com.smaato.sdk.nativead.NativeAdRequest;
import com.smaato.sdk.nativead.NativeAdTracker;
import com.smaato.sdk.nativead.model.NativeAdComponents;
import com.smaato.sdk.nativead.model.NativeSomaAdRequest;
import com.smaato.sdk.nativead.repository.NativeAdRepository;
import com.smaato.sdk.nativead.view.FakeContentViewForOmTracking;
import com.smaato.sdk.nativead.view.NativeAdRendererImpl;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class NativeAdViewModel extends SmaatoSdkViewModel {
    private static final Map ERROR_MAP;
    private AdResponse adResponse;
    private boolean is100PercentVisible;
    private boolean is50PercentVisible;
    private NativeAdComponents nativeAdComponents;
    private NativeAd.Listener nativeAdListener;
    private WeakReference nativeAdRendererRef;
    private final NativeAdRepository nativeAdRepository;
    private NativeAdRequest nativeAdRequest;
    private ViewabilityTracker omViewabilityTracker;

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdContentViewCreated(AdContentView adContentView, AdType adType) {
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onExecuteCtaLinkSuccess() {
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onFailedToCreateContentView(Exception exc) {
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaAdRendererProcessGone() {
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewUnloaded() {
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onVideoPlayerBuildError(SomaException somaException) {
    }

    static {
        HashMap map = new HashMap();
        ERROR_MAP = map;
        map.put(SomaException.Type.NO_CONTENT, NativeAdError.NO_AD_AVAILABLE);
        map.put(SomaException.Type.BAD_REQUEST, NativeAdError.INVALID_REQUEST);
        map.put(SomaException.Type.BAD_RESPONSE, NativeAdError.INTERNAL_ERROR);
        map.put(SomaException.Type.TIMEOUT_ERROR, NativeAdError.NETWORK_ERROR);
        map.put(SomaException.Type.AGE_RESTRICTED_USER, NativeAdError.AGE_RESTRICTED);
    }

    public NativeAdViewModel(NativeAdRepository nativeAdRepository, Logger logger) {
        super(nativeAdRepository, logger);
        this.nativeAdRendererRef = new WeakReference(null);
        this.nativeAdRepository = nativeAdRepository;
    }

    public void loadAd(Lifecycle lifecycle, NativeAdRequest nativeAdRequest, NativeAd.Listener listener) {
        this.nativeAdRequest = nativeAdRequest;
        this.nativeAdListener = listener;
        setLifecycleObserver(lifecycle);
        this.nativeAdRepository.loadAd(NativeSomaAdRequest.buildFrom(nativeAdRequest), new Consumer() { // from class: com.smaato.sdk.nativead.viewmodel.NativeAdViewModel$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.onNativeAdLoaded((AdResponse) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.nativead.viewmodel.NativeAdViewModel$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.onLoadingError((Throwable) obj);
            }
        });
    }

    public void onRegisterForImpression(View view) {
        if (this.adResponse == null) {
            throw NativeAdException.noAdLoaded;
        }
        List trackerUrls = getTrackerUrls(NativeAdTracker.Type.OPEN_MEASUREMENT);
        if (trackerUrls.isEmpty()) {
            return;
        }
        ViewabilityTracker oMImageViewabilityTracker = this.nativeAdRepository.getOMImageViewabilityTracker(new FakeContentViewForOmTracking(view, (String) trackerUrls.get(0)));
        this.omViewabilityTracker = oMImageViewabilityTracker;
        this.nativeAdRepository.trackOMAdLoaded(oMImageViewabilityTracker);
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdImpressed() {
        AdStatus adStatus = this.adStatus;
        AdStatus adStatus2 = AdStatus.DISPLAYED;
        if (adStatus != adStatus2) {
            this.adStatus = adStatus2;
            this.nativeAdRepository.trackOMImpression(this.omViewabilityTracker);
            this.nativeAdRepository.handleTrackerUrls(getTrackerUrls(NativeAdTracker.Type.IMPRESSION));
            this.nativeAdListener.onAdImpressed(new NativeAd(this.nativeAdRequest));
        }
    }

    public void onUpdateAdView(RichMediaWebView richMediaWebView) {
        this.nativeAdRepository.trackOMUpdateView(this.omViewabilityTracker, richMediaWebView);
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void executeCtaLink(String str, Consumer<Boolean> consumer) {
        NativeAdLink nativeAdLinkLink = this.nativeAdComponents.link();
        this.nativeAdRepository.handleLink(nativeAdLinkLink.url(), null);
        this.nativeAdRepository.handleTrackerUrls(nativeAdLinkLink.trackers());
        this.nativeAdListener.onAdClicked(new NativeAd(this.nativeAdRequest));
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdExpired() {
        if (this.adStatus != AdStatus.DISPLAYED) {
            this.adStatus = AdStatus.EXPIRED;
            this.nativeAdListener.onTtlExpired(new NativeAd(this.nativeAdRequest));
        }
    }

    public BiConsumer<Uri, ImageView> getImageLoader() {
        return this.nativeAdRepository.getImageLoader();
    }

    public void launchPrivacyUrl() {
        String strPrivacyUrl = this.nativeAdComponents.privacyUrl();
        if (strPrivacyUrl != null) {
            this.nativeAdRepository.launchAsUncheckedIntent(strPrivacyUrl);
        }
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void on50PercentVisible() {
        if (this.is50PercentVisible) {
            return;
        }
        this.nativeAdRepository.handleTrackerUrls(getTrackerUrls(NativeAdTracker.Type.VIEWABLE_MRC_50));
        this.is50PercentVisible = true;
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void on100PercentVisible() {
        if (this.is100PercentVisible) {
            return;
        }
        this.nativeAdRepository.handleTrackerUrls(getTrackerUrls(NativeAdTracker.Type.VIEWABLE_MRC_100));
        this.is100PercentVisible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNativeAdLoaded(AdResponse adResponse) {
        if (adResponse.getNativeObject() instanceof NativeAdComponents) {
            this.adResponse = adResponse;
            NativeAdComponents nativeAdComponents = (NativeAdComponents) adResponse.getNativeObject();
            this.nativeAdComponents = nativeAdComponents;
            NativeAdRendererImpl nativeAdRendererImpl = new NativeAdRendererImpl(this.nativeAdComponents.assets(), this, this.nativeAdComponents.mraidWrappedVast(), adResponse.getImpressionCountingType(), getAdTypeFromResponse(nativeAdComponents));
            this.nativeAdRendererRef = new WeakReference(nativeAdRendererImpl);
            this.nativeAdListener.onAdLoaded(new NativeAd(this.nativeAdRequest), nativeAdRendererImpl);
            startTtlTimer(adResponse.getTtlMs());
            return;
        }
        onLoadingError(new SomaException(SomaException.Type.BAD_RESPONSE, "No native ad data in response"));
    }

    private AdType getAdTypeFromResponse(NativeAdComponents nativeAdComponents) {
        String strMraidWrappedVast = nativeAdComponents.mraidWrappedVast();
        String strMraidJs = nativeAdComponents.assets().mraidJs();
        List<NativeAdAssets.Image> listImages = nativeAdComponents.assets().images();
        if (strMraidWrappedVast != null && !strMraidWrappedVast.isEmpty()) {
            return AdType.VIDEO;
        }
        if (strMraidJs != null && !strMraidJs.isEmpty()) {
            return AdType.RICH_MEDIA;
        }
        if (!listImages.isEmpty()) {
            return AdType.IMAGE;
        }
        return AdType.IMAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingError(Throwable th) {
        NativeAdError nativeAdError = getNativeAdError(th);
        this.nativeAdListener.onAdFailedToLoad(new NativeAd(this.nativeAdRequest), nativeAdError);
    }

    private NativeAdError getNativeAdError(Throwable th) {
        this.nativeAdRepository.stopOMTracking(this.omViewabilityTracker);
        NativeAdError nativeAdError = th instanceof SomaException ? (NativeAdError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        return nativeAdError == null ? NativeAdError.NO_AD_AVAILABLE : nativeAdError;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.nativead.viewmodel.NativeAdViewModel$1, reason: invalid class name */
    class AnonymousClass1 implements Lifecycle.Observer {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.lifecycle.Lifecycle.Observer
        public void onDestroy(Lifecycle lifecycle) {
            NativeAdViewModel.this.nativeAdRepository.stopOMTracking(NativeAdViewModel.this.omViewabilityTracker);
            Objects.onNotNull((NativeAdRenderer) NativeAdViewModel.this.nativeAdRendererRef.get(), new Consumer() { // from class: com.smaato.sdk.nativead.viewmodel.NativeAdViewModel$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5627x11e7fd20((NativeAdRenderer) obj);
                }
            });
            NativeAdViewModel.this.stopTTLTimer();
        }

        /* JADX INFO: renamed from: lambda$onDestroy$0$com-smaato-sdk-nativead-viewmodel-NativeAdViewModel$1, reason: not valid java name */
        /* synthetic */ void m5627x11e7fd20(NativeAdRenderer nativeAdRenderer) {
            NativeAdViewModel.this.nativeAdRendererRef.clear();
            nativeAdRenderer.onDestroyView();
        }
    }

    private void setLifecycleObserver(Lifecycle lifecycle) {
        lifecycle.addObserver(new AnonymousClass1());
    }

    private List getTrackerUrls(NativeAdTracker.Type type) {
        ArrayList arrayList = new ArrayList();
        for (NativeAdTracker nativeAdTracker : this.nativeAdComponents.trackers()) {
            if (nativeAdTracker.type() == type) {
                arrayList.add(nativeAdTracker.url());
            }
        }
        return arrayList;
    }
}
