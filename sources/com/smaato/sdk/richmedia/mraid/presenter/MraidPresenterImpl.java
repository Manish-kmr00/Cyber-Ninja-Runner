package com.smaato.sdk.richmedia.mraid.presenter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeNotifier;
import com.smaato.sdk.richmedia.mraid.RepeatableActionScheduler;
import com.smaato.sdk.richmedia.mraid.Views;
import com.smaato.sdk.richmedia.mraid.bridge.ErrorListener;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsBridge;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsEvents;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAppOrientation;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAudioVolumeLevel;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExpandProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExposureProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidLocationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidOrientationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidResizeProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidSupportsProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.PlacementType;
import com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor;
import com.smaato.sdk.richmedia.mraid.mvp.BasePresenter;
import com.smaato.sdk.richmedia.util.RectUtils;
import com.smaato.sdk.richmedia.util.ViewUtils;
import com.smaato.sdk.richmedia.widget.OrientationChangeWatcher;
import com.smaato.sdk.richmedia.widget.RichMediaAdContentView;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class MraidPresenterImpl extends BasePresenter<RichMediaAdContentView> implements MraidPresenter {
    private BiConsumer adViolationCallback;
    private final AppBackgroundDetector appBackgroundDetector;
    private final AppBackgroundDetector.Listener appBackgroundListener;
    private final AudioVolumeObserver audioVolumeObserver;
    private Consumer collapseCallback;
    private BiConsumer expandCallback;
    private Consumer hideCallback;
    private final MraidInteractor interactor;
    private final MraidJsBridge mraidJsBridge;
    private final MraidJsEvents mraidJsEvents;
    private final MraidJsMethods mraidJsMethods;
    private final MraidJsProperties mraidJsProperties;
    private final MraidSupportsProperties mraidSupportsProperties;
    private Consumer openCallback;
    private final OrientationChangeWatcher orientationChangeWatcher;
    private final OrientationManager orientationManager;
    private final ChangeNotifier.Listener orientationPropertiesChangeListener;
    private Consumer playVideoCallback;
    private final RepeatableActionScheduler repeatableActionScheduler;
    private final RequestInfoMapper requestInfoMapper;
    private final RequestInfoProvider requestInfoProvider;
    private Consumer resizeCallback;
    private final SdkConfiguration sdkConfiguration;
    private Consumer unloadCallback;
    private Consumer useCustomCloseCallback;
    private final OrientationChangeWatcher.Listener orientationChangeListener = new OrientationChangeWatcher.Listener() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda16
        @Override // com.smaato.sdk.richmedia.widget.OrientationChangeWatcher.Listener
        public final void onOrientationChange() {
            this.f$0.checkOrientationDependentParams();
        }
    };
    private final AudioVolumeObserver.Listener onAudioVolumeChangedListener = new AudioVolumeObserver.Listener() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda17
        @Override // com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver.Listener
        public final void onVolumeChange(int i, int i2) {
            this.f$0.audioVolumeChangeNotification(i, i2);
        }
    };
    private final MraidInteractor.Callback interactorCallback = new AnonymousClass1();

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onWasExpanded() {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/richmedia/mraid/presenter/MraidPresenterImpl;->onWasExpanded()V");
        BrandSafetyUtils.onMraidWasExpanded(h.v);
        safedk_MraidPresenterImpl_onWasExpanded_985893290ad5a457b83a36d568c93bd3();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1, reason: invalid class name */
    class AnonymousClass1 implements MraidInteractor.Callback {
        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processExpand(String str) {
            Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/richmedia/mraid/presenter/MraidPresenterImpl$1;->processExpand(Ljava/lang/String;)V");
            BrandSafetyUtils.onMraidProcessExpand(h.v, str);
            safedk_MraidPresenterImpl$1_processExpand_e8991afd02b606892e4f2e64699fd143(str);
        }

        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processExposureChange(MraidExposureProperties mraidExposureProperties) {
            MraidPresenterImpl.this.mraidJsEvents.fireExposureChangeEvent(mraidExposureProperties);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processCurrentAppOrientationChange(MraidAppOrientation mraidAppOrientation) {
            MraidPresenterImpl.this.mraidJsProperties.setCurrentAppOrientation(mraidAppOrientation);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processStateChange(MraidStateMachineFactory.State state) {
            MraidPresenterImpl.this.mraidJsEvents.fireStateChangeEvent(state);
        }

        /* JADX INFO: renamed from: lambda$processOrientationPropertiesChange$0$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl$1, reason: not valid java name */
        /* synthetic */ void m5681x21353e86(MraidOrientationProperties mraidOrientationProperties, RichMediaAdContentView richMediaAdContentView) {
            MraidPresenterImpl.this.orientationManager.applyOrientationProperties(richMediaAdContentView.getContext(), mraidOrientationProperties);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processOrientationPropertiesChange(final MraidOrientationProperties mraidOrientationProperties) {
            MraidPresenterImpl.this.ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5681x21353e86(mraidOrientationProperties, (RichMediaAdContentView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processRestoreOriginalOrientation$1$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl$1, reason: not valid java name */
        /* synthetic */ void m5683xbafc7609(RichMediaAdContentView richMediaAdContentView) {
            MraidPresenterImpl.this.orientationManager.restoreOriginalOrientation(richMediaAdContentView.getContext());
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processRestoreOriginalOrientation() {
            MraidPresenterImpl.this.ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5683xbafc7609((RichMediaAdContentView) obj);
                }
            });
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processCollapse() {
            Objects.onNotNull(MraidPresenterImpl.this.collapseCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Whatever.INSTANCE);
                }
            });
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processHide() {
            Objects.onNotNull(MraidPresenterImpl.this.hideCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Whatever.INSTANCE);
                }
            });
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processCurrentPositionChange(Rect rect) {
            MraidPresenterImpl.this.mraidJsProperties.setCurrentPosition(rect);
            MraidPresenterImpl.this.mraidJsEvents.fireSizeChangeEvent(rect);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processDefaultPositionChange(Rect rect) {
            MraidPresenterImpl.this.mraidJsProperties.setDefaultPosition(rect);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processScreenSizeChange(Rect rect) {
            MraidPresenterImpl.this.mraidJsProperties.setScreenSize(new Size(rect.width(), rect.height()));
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processMaxSizeChange(Rect rect) {
            MraidPresenterImpl.this.mraidJsProperties.setMaxSize(new Size(rect.width(), rect.height()));
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processOpen(final String str) {
            Objects.onNotNull(MraidPresenterImpl.this.openCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda8
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(str);
                }
            });
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processError(String str, String str2) {
            MraidPresenterImpl.this.mraidJsEvents.fireErrorEvent(str, str2);
        }

        public void safedk_MraidPresenterImpl$1_processExpand_e8991afd02b606892e4f2e64699fd143(final String p0) {
            final MraidOrientationProperties value = MraidPresenterImpl.this.mraidJsProperties.getOrientationPropertiesChangeSender().getValue();
            MraidPresenterImpl.this.ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda6
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5680x4b0f9917(value, p0, (RichMediaAdContentView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processExpand$6$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl$1, reason: not valid java name */
        /* synthetic */ void m5680x4b0f9917(MraidOrientationProperties mraidOrientationProperties, final String str, RichMediaAdContentView richMediaAdContentView) {
            MraidPresenterImpl.this.orientationManager.applyOrientationProperties(richMediaAdContentView.getContext(), mraidOrientationProperties);
            Objects.onNotNull(MraidPresenterImpl.this.expandCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5679x578014d6(str, (BiConsumer) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$processExpand$5$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl$1, reason: not valid java name */
        /* synthetic */ void m5679x578014d6(String str, BiConsumer biConsumer) {
            biConsumer.accept(str, MraidPresenterImpl.this.mraidJsProperties.getExpandProperties());
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processResize(Rect rect, final Rect rect2) {
            MraidResizeProperties resizeProperties = MraidPresenterImpl.this.mraidJsProperties.getResizeProperties();
            if (resizeProperties == null) {
                MraidPresenterImpl.this.interactor.handleFailedToResize("Resize properties should be set before resize");
            } else {
                final Rect rectRelativeToMaxSize = resizeProperties.getRectRelativeToMaxSize(rect, rect2);
                MraidPresenterImpl.this.ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda4
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5682x27d58fb3(rectRelativeToMaxSize, rect2, (RichMediaAdContentView) obj);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$processResize$8$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl$1, reason: not valid java name */
        /* synthetic */ void m5682x27d58fb3(Rect rect, Rect rect2, RichMediaAdContentView richMediaAdContentView) {
            Context context = richMediaAdContentView.getContext();
            final Rect rectMapToPx = RectUtils.mapToPx(context, rect);
            final Rect rectMapToPx2 = RectUtils.mapToPx(context, rect2);
            Objects.onNotNull(MraidPresenterImpl.this.resizeCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(new ResizeParams(rectMapToPx2, rectMapToPx));
                }
            });
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processAudioVolumeChange(MraidAudioVolumeLevel mraidAudioVolumeLevel) {
            MraidPresenterImpl.this.mraidJsEvents.fireAudioVolumeChangeEvent(mraidAudioVolumeLevel);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processLocationPropertiesChange(MraidLocationProperties mraidLocationProperties) {
            MraidPresenterImpl.this.mraidJsProperties.setLocation(mraidLocationProperties);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processPlacementType(PlacementType placementType) {
            MraidPresenterImpl.this.mraidJsProperties.setPlacementType(placementType);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processSupportedFeatures(List list) {
            MraidPresenterImpl.this.mraidJsProperties.setSupportedFeatures(list, MraidPresenterImpl.this.mraidSupportsProperties.getAllMraidFeatures());
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processViewableChange(boolean z) {
            MraidPresenterImpl.this.mraidJsEvents.fireViewableChangeEvent(z);
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processVisibilityParamsCheck() {
            MraidPresenterImpl.this.checkVisibilityParams();
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processLoadCompleted() {
            MraidPresenterImpl.this.mraidJsBridge.fireReadyEvent();
        }

        @Override // com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor.Callback
        public void processPlayVideo(final String str) {
            Objects.onNotNull(MraidPresenterImpl.this.playVideoCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$1$$ExternalSyntheticLambda9
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(str);
                }
            });
        }
    }

    public MraidPresenterImpl(final MraidInteractor mraidInteractor, MraidJsBridge mraidJsBridge, MraidJsEvents mraidJsEvents, MraidJsMethods mraidJsMethods, MraidJsProperties mraidJsProperties, RepeatableActionScheduler repeatableActionScheduler, OrientationChangeWatcher orientationChangeWatcher, OrientationManager orientationManager, AppBackgroundDetector appBackgroundDetector, RequestInfoProvider requestInfoProvider, SdkConfiguration sdkConfiguration, RequestInfoMapper requestInfoMapper, MraidSupportsProperties mraidSupportsProperties, AudioVolumeObserver audioVolumeObserver) {
        AppBackgroundDetector.Listener listener = new AppBackgroundDetector.Listener() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl.2
            @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
            public void onAppEnteredInBackground() {
                MraidPresenterImpl.this.unsubscribeFromOrientationChange();
            }

            @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
            public void onAppEnteredInForeground() {
                MraidPresenterImpl.this.subscribeToOrientationChange();
            }
        };
        this.appBackgroundListener = listener;
        this.interactor = (MraidInteractor) Objects.requireNonNull(mraidInteractor);
        this.mraidJsBridge = (MraidJsBridge) Objects.requireNonNull(mraidJsBridge);
        this.mraidJsEvents = (MraidJsEvents) Objects.requireNonNull(mraidJsEvents);
        this.mraidJsMethods = (MraidJsMethods) Objects.requireNonNull(mraidJsMethods);
        this.mraidJsProperties = (MraidJsProperties) Objects.requireNonNull(mraidJsProperties);
        this.repeatableActionScheduler = (RepeatableActionScheduler) Objects.requireNonNull(repeatableActionScheduler);
        this.orientationChangeWatcher = (OrientationChangeWatcher) Objects.requireNonNull(orientationChangeWatcher);
        this.orientationManager = (OrientationManager) Objects.requireNonNull(orientationManager);
        this.appBackgroundDetector = (AppBackgroundDetector) Objects.requireNonNull(appBackgroundDetector);
        this.requestInfoProvider = (RequestInfoProvider) Objects.requireNonNull(requestInfoProvider);
        this.sdkConfiguration = (SdkConfiguration) Objects.requireNonNull(sdkConfiguration);
        this.requestInfoMapper = (RequestInfoMapper) Objects.requireNonNull(requestInfoMapper);
        this.mraidSupportsProperties = (MraidSupportsProperties) Objects.requireNonNull(mraidSupportsProperties);
        this.audioVolumeObserver = (AudioVolumeObserver) Objects.requireNonNull(audioVolumeObserver);
        java.util.Objects.requireNonNull(mraidInteractor);
        this.orientationPropertiesChangeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
            public final void onNextValue(Object obj) {
                mraidInteractor.handleOrientationPropertiesChange((MraidOrientationProperties) obj);
            }
        };
        appBackgroundDetector.addListener(listener, false);
        setComponentCallbacks();
        setJsCallbacks();
    }

    private void setComponentCallbacks() {
        this.interactor.setCallback(this.interactorCallback);
        MraidJsProperties mraidJsProperties = this.mraidJsProperties;
        final MraidInteractor.Callback callback = this.interactorCallback;
        java.util.Objects.requireNonNull(callback);
        mraidJsProperties.setErrorListener(new ErrorListener() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.richmedia.mraid.bridge.ErrorListener
            public final void onError(String str, String str2) {
                callback.processError(str, str2);
            }
        });
    }

    private void setJsCallbacks() {
        MraidJsMethods mraidJsMethods = this.mraidJsMethods;
        final MraidInteractor mraidInteractor = this.interactor;
        java.util.Objects.requireNonNull(mraidInteractor);
        mraidJsMethods.setAddEventListenerCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                mraidInteractor.handleAddEventListener((String) obj);
            }
        });
        MraidJsMethods mraidJsMethods2 = this.mraidJsMethods;
        final MraidInteractor mraidInteractor2 = this.interactor;
        java.util.Objects.requireNonNull(mraidInteractor2);
        mraidJsMethods2.setOpenCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                mraidInteractor2.handleUrlOpen((String) obj);
            }
        });
        this.mraidJsMethods.setResizeCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5674x481f0778((Whatever) obj);
            }
        });
        MraidJsMethods mraidJsMethods3 = this.mraidJsMethods;
        final MraidInteractor mraidInteractor3 = this.interactor;
        java.util.Objects.requireNonNull(mraidInteractor3);
        mraidJsMethods3.setExpandCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                mraidInteractor3.handleExpand((String) obj);
            }
        });
        this.mraidJsMethods.setUnloadCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5675xbd0a487a((Whatever) obj);
            }
        });
        MraidJsMethods mraidJsMethods4 = this.mraidJsMethods;
        final MraidInteractor mraidInteractor4 = this.interactor;
        java.util.Objects.requireNonNull(mraidInteractor4);
        mraidJsMethods4.setPlayVideoCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                mraidInteractor4.handlePlayVideo((String) obj);
            }
        });
        this.mraidJsMethods.setCloseCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5676x777fe8fb((Whatever) obj);
            }
        });
        this.mraidJsMethods.setUseCustomCloseCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5677xec6b29fd((Boolean) obj);
            }
        });
        this.mraidJsMethods.setAdViolationCallback(new BiConsumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m5678x61566aff((String) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setJsCallbacks$0$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5674x481f0778(Whatever whatever) {
        this.interactor.handleResize(this.mraidJsProperties.getResizeProperties());
    }

    /* JADX INFO: renamed from: lambda$setJsCallbacks$2$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5675xbd0a487a(final Whatever whatever) {
        Objects.onNotNull(this.unloadCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(whatever);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setJsCallbacks$3$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5676x777fe8fb(Whatever whatever) {
        this.interactor.handleClose();
    }

    /* JADX INFO: renamed from: lambda$setJsCallbacks$5$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5677xec6b29fd(final Boolean bool) {
        Objects.onNotNull(this.useCustomCloseCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(bool);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setJsCallbacks$7$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5678x61566aff(final String str, final String str2) {
        Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BiConsumer) obj).accept(str, str2);
            }
        });
    }

    @Override // com.smaato.sdk.richmedia.mraid.mvp.BasePresenter, com.smaato.sdk.richmedia.mraid.mvp.Presenter
    public void attachView(RichMediaAdContentView richMediaAdContentView) {
        super.attachView(richMediaAdContentView);
        updateSupportedFeatures(richMediaAdContentView);
        RepeatableActionScheduler repeatableActionScheduler = this.repeatableActionScheduler;
        final MraidInteractor mraidInteractor = this.interactor;
        java.util.Objects.requireNonNull(mraidInteractor);
        repeatableActionScheduler.start(new Runnable() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                mraidInteractor.handleVisibilityParamsCheck();
            }
        });
        subscribeToOrientationChange();
        this.audioVolumeObserver.register(this.onAudioVolumeChangedListener);
    }

    @Override // com.smaato.sdk.richmedia.mraid.mvp.BasePresenter, com.smaato.sdk.richmedia.mraid.mvp.Presenter
    public void detachView() {
        super.detachView();
        this.repeatableActionScheduler.stop();
        unsubscribeFromOrientationChange();
        this.audioVolumeObserver.unregister(this.onAudioVolumeChangedListener);
    }

    @Override // com.smaato.sdk.richmedia.mraid.mvp.Presenter
    public void destroy() {
        this.appBackgroundDetector.deleteListener(this.appBackgroundListener);
    }

    private void updateSupportedFeatures(RichMediaAdContentView richMediaAdContentView) {
        this.interactor.handleSupportedFeaturesChange(this.mraidSupportsProperties.getSupportedFeatures(richMediaAdContentView.getContext(), richMediaAdContentView.getWebView()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVisibilityParams() {
        ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5673xefcb4943((RichMediaAdContentView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$checkVisibilityParams$8$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5673xefcb4943(RichMediaAdContentView richMediaAdContentView) {
        Context context = richMediaAdContentView.getContext();
        RichMediaWebView webView = richMediaAdContentView.getWebView();
        this.interactor.handleDefaultPositionChange(RectUtils.mapToDp(context, Views.positionOnScreenOf(richMediaAdContentView)));
        this.interactor.handleCurrentPositionChange(RectUtils.mapToDp(context, Views.positionOnScreenOf(webView)));
        Views.ViewVisibilityContext viewVisibilityContextVisibilityContextRelativeToView = Views.visibilityContextRelativeToView(webView);
        MraidExposureProperties mraidExposurePropertiesValueOf = MraidExposureProperties.valueOf(viewVisibilityContextVisibilityContextRelativeToView.visibilityPercent, RectUtils.mapToDp(context, viewVisibilityContextVisibilityContextRelativeToView.visibleRect));
        this.interactor.handleExposureChange(mraidExposurePropertiesValueOf);
        this.interactor.handleViewableChange(Views.isViewable(mraidExposurePropertiesValueOf.exposedPercentage));
        this.interactor.handleLocationPropertiesChange(MraidLocationProperties.create(this.requestInfoProvider, this.sdkConfiguration, this.requestInfoMapper));
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onHtmlLoaded() {
        checkOrientationDependentParams();
        this.interactor.handleHtmlLoaded();
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void handleMraidUrl(String str, boolean z) {
        this.mraidJsBridge.handleMraidUrl(str, z);
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnOpenCallback(Consumer<String> consumer) {
        this.openCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnPlayVideoCallback(Consumer<String> consumer) {
        this.playVideoCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnExpandCallback(BiConsumer<String, MraidExpandProperties> biConsumer) {
        this.expandCallback = biConsumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void handleClose() {
        this.interactor.handleClose();
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnCollapseCallback(Consumer<Whatever> consumer) {
        this.collapseCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnHideCallback(Consumer<Whatever> consumer) {
        this.hideCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setOnUnloadCallback(Consumer<Whatever> consumer) {
        this.unloadCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setResizeCallback(Consumer<ResizeParams> consumer) {
        this.resizeCallback = consumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onWasResized() {
        this.interactor.handleWasResized();
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onFailedToResize(String str) {
        this.interactor.handleFailedToResize(str);
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onFailedToExpand() {
        this.interactor.handleFailedToExpand();
    }

    public void safedk_MraidPresenterImpl_onWasExpanded_985893290ad5a457b83a36d568c93bd3() {
        this.interactor.handleWasExpanded();
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void onWasClosed() {
        this.interactor.handleWasClosed();
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setAdViolationCallback(BiConsumer<String, String> biConsumer) {
        this.adViolationCallback = biConsumer;
    }

    @Override // com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter
    public void setUseCustomCloseCallback(Consumer<Boolean> consumer) {
        this.useCustomCloseCallback = consumer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioVolumeChangeNotification(int i, int i2) {
        this.interactor.handleAudioVolumeLevelChange(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeToOrientationChange() {
        this.orientationChangeWatcher.addListener(this.orientationChangeListener);
        this.mraidJsProperties.getOrientationPropertiesChangeSender().addListener(this.orientationPropertiesChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOrientationDependentParams() {
        ifViewAttached(new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5671xb403ddaf((RichMediaAdContentView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$checkOrientationDependentParams$10$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5671xb403ddaf(RichMediaAdContentView richMediaAdContentView) {
        final Context context = richMediaAdContentView.getContext();
        this.interactor.handleOrientationChange(MraidAppOrientation.from(context));
        Size displaySizeInDp = UIUtils.getDisplaySizeInDp(context);
        Rect rect = new Rect(0, 0, displaySizeInDp.width, displaySizeInDp.height);
        this.interactor.handleScreenSizeInDpChange(rect);
        final View rootView = ViewUtils.getRootView(richMediaAdContentView);
        if (rootView == null) {
            this.interactor.handleScreenMaxSizeInDpChange(rect);
        } else {
            rootView.post(new Runnable() { // from class: com.smaato.sdk.richmedia.mraid.presenter.MraidPresenterImpl$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5672x80125581(rootView, context);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$checkOrientationDependentParams$9$com-smaato-sdk-richmedia-mraid-presenter-MraidPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5672x80125581(View view, Context context) {
        this.interactor.handleScreenMaxSizeInDpChange(RectUtils.mapToDp(context, Views.positionOnScreenOf(view)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unsubscribeFromOrientationChange() {
        this.orientationChangeWatcher.removeListener(this.orientationChangeListener);
        this.mraidJsProperties.getOrientationPropertiesChangeSender().removeListener(this.orientationPropertiesChangeListener);
    }
}
