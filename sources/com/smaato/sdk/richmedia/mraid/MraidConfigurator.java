package com.smaato.sdk.richmedia.mraid;

import android.content.Context;
import android.webkit.WebView;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsBridge;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsEvents;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidDataProvider;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidSupportsProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MusicPlaybackVolume;
import com.smaato.sdk.richmedia.mraid.dataprovider.PlacementType;
import com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor;
import com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter;
import com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl;
import com.smaato.sdk.richmedia.mraid.presenter.OrientationManager;
import com.smaato.sdk.richmedia.util.ActivityHelper;
import com.smaato.sdk.richmedia.widget.LoadedWebViewCache;
import com.smaato.sdk.richmedia.widget.OrientationChangeWatcher;
import com.smaato.sdk.richmedia.widget.RichMediaAdContentView;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class MraidConfigurator {
    private final AppBackgroundAwareHandler appBackgroundAwareHandler;
    private final AppBackgroundDetector appBackgroundDetector;
    private final AudioVolumeObserver audioVolumeObserver;
    private final DataCollector dataCollector;
    private final Logger logger;
    private final MraidSupportsProperties mraidSupportsProperties;
    private final MusicPlaybackVolume musicPlaybackVolume;
    private final OrientationChangeWatcher orientationChangeWatcher;
    private final RequestInfoMapper requestInfoMapper;
    private final RequestInfoProvider requestInfoProvider;
    private final SdkConfiguration sdkConfiguration;
    private final MraidStateMachineFactory stateMachineFactory;
    private final LoadedWebViewCache webViewCache;
    private final RichMediaWebViewFactory webViewFactory;

    public MraidConfigurator(AppBackgroundAwareHandler appBackgroundAwareHandler, OrientationChangeWatcher orientationChangeWatcher, AppBackgroundDetector appBackgroundDetector, Logger logger, RequestInfoProvider requestInfoProvider, SdkConfiguration sdkConfiguration, MraidStateMachineFactory mraidStateMachineFactory, RichMediaWebViewFactory richMediaWebViewFactory, RequestInfoMapper requestInfoMapper, MraidSupportsProperties mraidSupportsProperties, AudioVolumeObserver audioVolumeObserver, MusicPlaybackVolume musicPlaybackVolume, DataCollector dataCollector, LoadedWebViewCache loadedWebViewCache) {
        this.appBackgroundAwareHandler = (AppBackgroundAwareHandler) Objects.requireNonNull(appBackgroundAwareHandler);
        this.orientationChangeWatcher = (OrientationChangeWatcher) Objects.requireNonNull(orientationChangeWatcher);
        this.appBackgroundDetector = (AppBackgroundDetector) Objects.requireNonNull(appBackgroundDetector);
        this.requestInfoProvider = (RequestInfoProvider) Objects.requireNonNull(requestInfoProvider);
        this.sdkConfiguration = (SdkConfiguration) Objects.requireNonNull(sdkConfiguration);
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.stateMachineFactory = (MraidStateMachineFactory) Objects.requireNonNull(mraidStateMachineFactory);
        this.webViewFactory = (RichMediaWebViewFactory) Objects.requireNonNull(richMediaWebViewFactory);
        this.requestInfoMapper = (RequestInfoMapper) Objects.requireNonNull(requestInfoMapper);
        this.mraidSupportsProperties = (MraidSupportsProperties) Objects.requireNonNull(mraidSupportsProperties);
        this.audioVolumeObserver = (AudioVolumeObserver) Objects.requireNonNull(audioVolumeObserver);
        this.musicPlaybackVolume = (MusicPlaybackVolume) Objects.requireNonNull(musicPlaybackVolume);
        this.dataCollector = dataCollector;
        this.webViewCache = (LoadedWebViewCache) Objects.requireNonNull(loadedWebViewCache);
    }

    public RichMediaAdContentView createView(Context context, String str, int i, int i2, boolean z, RichMediaWebView richMediaWebView, RichMediaAdContentView.Callback callback) {
        return RichMediaAdContentView.create(this.logger, context, str, callback, this.webViewFactory, richMediaWebView, createPresenter(richMediaWebView, z ? this.stateMachineFactory.newInstanceForInterstitial() : this.stateMachineFactory.newInstanceForBanner(), z ? PlacementType.INTERSTITIAL : PlacementType.INLINE), createMraidEnvironmentProperties(context), i, i2);
    }

    public MraidPresenter createPresenter(WebView webView, StateMachine<MraidStateMachineFactory.Event, MraidStateMachineFactory.State> stateMachine, PlacementType placementType) {
        Context context = webView.getContext();
        MraidInteractor mraidInteractorCreateInteractor = createInteractor(context, stateMachine, placementType, this.mraidSupportsProperties.getSupportedFeatures(context, webView));
        MraidJsBridge mraidJsBridge = new MraidJsBridge(webView, this.logger);
        return new MraidPresenterImpl(mraidInteractorCreateInteractor, mraidJsBridge, new MraidJsEvents(this.logger, mraidJsBridge), new MraidJsMethods(mraidJsBridge), new MraidJsProperties(this.logger, mraidJsBridge), createRepeatableActionScheduler(this.logger), this.orientationChangeWatcher, new OrientationManager(this.logger, new ActivityHelper()), this.appBackgroundDetector, this.requestInfoProvider, this.sdkConfiguration, this.requestInfoMapper, this.mraidSupportsProperties, this.audioVolumeObserver);
    }

    private MraidInteractor createInteractor(Context context, StateMachine stateMachine, PlacementType placementType, List list) {
        return new MraidInteractor(new MraidDataProvider(context, placementType, (MraidStateMachineFactory.State) stateMachine.getCurrentState(), this.requestInfoProvider, this.sdkConfiguration, list, this.requestInfoMapper, this.musicPlaybackVolume), stateMachine);
    }

    private RepeatableActionScheduler createRepeatableActionScheduler(Logger logger) {
        return new RepeatableActionScheduler(logger, this.appBackgroundAwareHandler, 200L);
    }

    private MraidEnvironmentProperties createMraidEnvironmentProperties(Context context) {
        return new MraidEnvironmentProperties(SmaatoSdk.getVersion(), context.getPackageName(), this.requestInfoProvider.getGoogleAdId(), this.dataCollector.getSystemInfo().isGoogleLimitAdTrackingEnabled(), SmaatoSdk.getCoppa() ? 1 : null);
    }
}
