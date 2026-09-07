package com.smaato.sdk.richmedia.mraid.interactor;

import android.graphics.Rect;
import com.smaato.sdk.core.util.Metadata;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeNotifier;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsEvents;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAppOrientation;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAudioVolumeLevel;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidDataProvider;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExposureProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidLocationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidOrientationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidResizeProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.PlacementType;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class MraidInteractor {
    private Callback callback;
    private final MraidDataProvider dataProvider;
    private final StateMachine stateMachine;
    private String urlToExpand;
    private final ChangeNotifier.Listener exposureListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda11
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processExposureProperties((MraidExposureProperties) obj);
        }
    };
    private final ChangeNotifier.Listener orientationListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda33
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processAppOrientation((MraidAppOrientation) obj);
        }
    };
    private final ChangeNotifier.Listener audioVolumeLevelListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda34
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processAudioVolumeLevel((MraidAudioVolumeLevel) obj);
        }
    };
    private final ChangeNotifier.Listener currentPositionListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda35
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processCurrentPosition((Rect) obj);
        }
    };
    private final ChangeNotifier.Listener defaultPositionListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda36
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processDefaultPosition((Rect) obj);
        }
    };
    private final ChangeNotifier.Listener screenSizeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda37
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processScreenSize((Rect) obj);
        }
    };
    private final ChangeNotifier.Listener maxSizeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda38
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processMaxSize((Rect) obj);
        }
    };
    private final ChangeNotifier.Listener stateChangeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda1
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processChangeState((MraidStateMachineFactory.State) obj);
        }
    };
    private final ChangeNotifier.Listener supportedFeaturesChangeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda2
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processSupportedFeatures((List) obj);
        }
    };
    private final ChangeNotifier.Listener viewableChangeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda3
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processViewableChange((Boolean) obj);
        }
    };
    private final ChangeNotifier.Listener locationPropertiesChangeListener = new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda22
        @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
        public final void onNextValue(Object obj) {
            this.f$0.processLocationProperties((MraidLocationProperties) obj);
        }
    };

    public interface Callback {
        void processAudioVolumeChange(MraidAudioVolumeLevel mraidAudioVolumeLevel);

        void processCollapse();

        void processCurrentAppOrientationChange(MraidAppOrientation mraidAppOrientation);

        void processCurrentPositionChange(Rect rect);

        void processDefaultPositionChange(Rect rect);

        void processError(String str, String str2);

        void processExpand(String str);

        void processExposureChange(MraidExposureProperties mraidExposureProperties);

        void processHide();

        void processLoadCompleted();

        void processLocationPropertiesChange(MraidLocationProperties mraidLocationProperties);

        void processMaxSizeChange(Rect rect);

        void processOpen(String str);

        void processOrientationPropertiesChange(MraidOrientationProperties mraidOrientationProperties);

        void processPlacementType(PlacementType placementType);

        void processPlayVideo(String str);

        void processResize(Rect rect, Rect rect2);

        void processRestoreOriginalOrientation();

        void processScreenSizeChange(Rect rect);

        void processStateChange(MraidStateMachineFactory.State state);

        void processSupportedFeatures(List<String> list);

        void processViewableChange(boolean z);

        void processVisibilityParamsCheck();
    }

    public MraidInteractor(MraidDataProvider mraidDataProvider, StateMachine<MraidStateMachineFactory.Event, MraidStateMachineFactory.State> stateMachine) {
        this.dataProvider = (MraidDataProvider) Objects.requireNonNull(mraidDataProvider);
        this.stateMachine = (StateMachine) Objects.requireNonNull(stateMachine);
        stateMachine.addListener(new StateMachine.Listener() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda32
            @Override // com.smaato.sdk.core.util.StateMachine.Listener
            public final void onStateChanged(Object obj, Object obj2, Metadata metadata) {
                this.f$0.m5667x86a39681((MraidStateMachineFactory.State) obj, (MraidStateMachineFactory.State) obj2, metadata);
            }
        });
        initDataChangeListeners();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-mraid-interactor-MraidInteractor, reason: not valid java name */
    /* synthetic */ void m5667x86a39681(MraidStateMachineFactory.State state, MraidStateMachineFactory.State state2, Metadata metadata) {
        onStateChanged(state2);
    }

    private void initDataChangeListeners() {
        this.dataProvider.getOrientationChangeSender().addListener(this.orientationListener);
        this.dataProvider.getExposureChangeSender().addListener(this.exposureListener);
        this.dataProvider.getCurrentPositionInDpChangeSender().addListener(this.currentPositionListener);
        this.dataProvider.getDefaultPositionInDpChangeSender().addListener(this.defaultPositionListener);
        this.dataProvider.getScreenSizeInDpSender().addListener(this.screenSizeListener);
        this.dataProvider.getMaxSizeInDpChangeSender().addListener(this.maxSizeListener);
        this.dataProvider.getAudioVolumeChangeSender().addListener(this.audioVolumeLevelListener);
        this.dataProvider.getStateChangeSender().addListener(this.stateChangeListener);
        this.dataProvider.getSupportedFeatures().addListener(this.supportedFeaturesChangeListener);
        this.dataProvider.getViewableChangeSender().addListener(this.viewableChangeListener);
        this.dataProvider.getLocationPropertiesSender().addListener(this.locationPropertiesChangeListener);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State;

        static {
            int[] iArr = new int[MraidStateMachineFactory.State.values().length];
            $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State = iArr;
            try {
                iArr[MraidStateMachineFactory.State.RESIZE_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.EXPAND_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.COLLAPSE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.HIDDEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.DEFAULT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.RESIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.EXPANDED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void onStateChanged(MraidStateMachineFactory.State state) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[state.ordinal()];
        if (i == 1) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda12
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5668x7768f4de((MraidInteractor.Callback) obj);
                }
            });
            return;
        }
        if (i == 2) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda10
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5669x881ec19f((MraidInteractor.Callback) obj);
                }
            });
            this.urlToExpand = null;
        } else {
            if (i == 3) {
                Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda8());
                return;
            }
            if (i == 4) {
                Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda9
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((MraidInteractor.Callback) obj).processHide();
                    }
                });
            }
            this.dataProvider.getStateChangeSender().newValue(state);
        }
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$1$com-smaato-sdk-richmedia-mraid-interactor-MraidInteractor, reason: not valid java name */
    /* synthetic */ void m5668x7768f4de(Callback callback) {
        Rect value = this.dataProvider.getMaxSizeInDpChangeSender().getValue();
        callback.processResize(this.dataProvider.getCurrentPositionInDpChangeSender().getValue(), new Rect(0, 0, value.width(), value.height()));
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$2$com-smaato-sdk-richmedia-mraid-interactor-MraidInteractor, reason: not valid java name */
    /* synthetic */ void m5669x881ec19f(Callback callback) {
        callback.processExpand(this.urlToExpand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processChangeState(final MraidStateMachineFactory.State state) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda29
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processStateChange(state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processExposureProperties(final MraidExposureProperties mraidExposureProperties) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processExposureChange(mraidExposureProperties);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAppOrientation(final MraidAppOrientation mraidAppOrientation) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processCurrentAppOrientationChange(mraidAppOrientation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAudioVolumeLevel(final MraidAudioVolumeLevel mraidAudioVolumeLevel) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processAudioVolumeChange(mraidAudioVolumeLevel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCurrentPosition(final Rect rect) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processCurrentPositionChange(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDefaultPosition(final Rect rect) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda24
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processDefaultPositionChange(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processScreenSize(final Rect rect) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processScreenSizeChange(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMaxSize(final Rect rect) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda25
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processMaxSizeChange(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLocationProperties(final MraidLocationProperties mraidLocationProperties) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda26
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processLocationPropertiesChange(mraidLocationProperties);
            }
        });
    }

    private void processPlacementType(final PlacementType placementType) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processPlacementType(placementType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processViewableChange(final Boolean bool) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processViewableChange(bool.booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSupportedFeatures(final List list) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processSupportedFeatures(list);
            }
        });
    }

    public void handleHtmlLoaded() {
        initMraidProperties();
        Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda4());
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.LOAD_COMPLETE);
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processLoadCompleted();
            }
        });
    }

    private void initMraidProperties() {
        processAppOrientation(this.dataProvider.getOrientationChangeSender().getValue());
        processScreenSize(this.dataProvider.getScreenSizeInDpSender().getValue());
        processMaxSize(this.dataProvider.getMaxSizeInDpChangeSender().getValue());
        processLocationProperties(this.dataProvider.getLocationPropertiesSender().getValue());
        processPlacementType(this.dataProvider.getPlacementType());
        processSupportedFeatures(this.dataProvider.getSupportedFeatures().getValue());
        processAudioVolumeLevel(this.dataProvider.getAudioVolumeChangeSender().getValue());
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void handleAddEventListener(String str) {
        if (MraidJsEvents.AUDIO_VOLUME_CHANGE.equalsIgnoreCase(str)) {
            processAudioVolumeLevel(this.dataProvider.getAudioVolumeChangeSender().getValue());
        }
        if (MraidJsEvents.EXPOSURE_CHANGE.equalsIgnoreCase(str)) {
            processExposureProperties(this.dataProvider.getExposureChangeSender().getValue());
        }
    }

    public void handleUrlOpen(final String str) {
        if (TextUtils.isEmpty(str)) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda20
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processError("open", "An empty URL received");
                }
            });
        } else {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda21
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processOpen(str);
                }
            });
        }
    }

    public void handlePlayVideo(final String str) {
        if (TextUtils.isEmpty(str)) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda30
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processError(MraidJsMethods.PLAY_VIDEO, "An empty URL received");
                }
            });
        } else {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda31
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processPlayVideo(str);
                }
            });
        }
    }

    public void handleResize(MraidResizeProperties mraidResizeProperties) {
        if (mraidResizeProperties == null) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda27
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processError("resize", "Resize properties should be set before resize");
                }
            });
        } else if (this.stateMachine.getCurrentState() == MraidStateMachineFactory.State.EXPANDED) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda28
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processError("resize", "MRAID 3.0 specs violation (4.2.1 Ad States transition: expanded -> resized)");
                }
            });
        } else {
            this.stateMachine.onEvent(MraidStateMachineFactory.Event.RESIZE);
        }
    }

    public void handleExposureChange(MraidExposureProperties mraidExposureProperties) {
        this.dataProvider.getExposureChangeSender().newValue(mraidExposureProperties);
    }

    public void handleOrientationChange(MraidAppOrientation mraidAppOrientation) {
        this.dataProvider.getOrientationChangeSender().newValue(mraidAppOrientation);
    }

    public void handleScreenSizeInDpChange(Rect rect) {
        this.dataProvider.getScreenSizeInDpSender().newValue(rect);
    }

    public void handleScreenMaxSizeInDpChange(Rect rect) {
        this.dataProvider.getMaxSizeInDpChangeSender().newValue(rect);
    }

    public void handleOrientationPropertiesChange(final MraidOrientationProperties mraidOrientationProperties) {
        boolean z = this.stateMachine.getCurrentState() == MraidStateMachineFactory.State.EXPANDED;
        boolean z2 = this.dataProvider.getPlacementType() == PlacementType.INTERSTITIAL;
        if (z || z2) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda19
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processOrientationPropertiesChange(mraidOrientationProperties);
                }
            });
        }
    }

    public void handleAudioVolumeLevelChange(int i, int i2) {
        this.dataProvider.getAudioVolumeChangeSender().newValue(MraidAudioVolumeLevel.create(i, i2));
    }

    public void handleExpand(String str) {
        if (this.dataProvider.getPlacementType() == PlacementType.INTERSTITIAL) {
            return;
        }
        this.urlToExpand = str;
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.EXPAND);
    }

    public void handleDefaultPositionChange(Rect rect) {
        this.dataProvider.getDefaultPositionInDpChangeSender().newValue(getRectRelativeToMaxSize(rect));
    }

    public void handleCurrentPositionChange(Rect rect) {
        this.dataProvider.getCurrentPositionInDpChangeSender().newValue(getRectRelativeToMaxSize(rect));
    }

    public void handleViewableChange(boolean z) {
        this.dataProvider.getViewableChangeSender().newValue(Boolean.valueOf(z));
    }

    private Rect getRectRelativeToMaxSize(Rect rect) {
        Rect value = this.dataProvider.getMaxSizeInDpChangeSender().getValue();
        Rect value2 = this.dataProvider.getScreenSizeInDpSender().getValue();
        int iAbs = Math.abs(value2.left - value.left);
        int iAbs2 = Math.abs(value2.top - value.top);
        return new Rect(rect.left - iAbs, rect.top - iAbs2, rect.right - iAbs, rect.bottom - iAbs2);
    }

    public void handleSupportedFeaturesChange(List<String> list) {
        this.dataProvider.getSupportedFeatures().newValue(list);
    }

    public void handleLocationPropertiesChange(MraidLocationProperties mraidLocationProperties) {
        this.dataProvider.getLocationPropertiesSender().newValue(mraidLocationProperties);
    }

    public void handleWasResized() {
        Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda4());
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.RESIZING_FINISHED);
    }

    public void handleWasExpanded() {
        Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda4());
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.EXPANDING_FINISHED);
    }

    public void handleFailedToResize(final String str) {
        Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((MraidInteractor.Callback) obj).processError("resize", str);
            }
        });
        if (this.stateMachine.getCurrentState() == MraidStateMachineFactory.State.RESIZED) {
            Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda8());
        }
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.ERROR);
    }

    public void handleFailedToExpand() {
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.ERROR);
    }

    public void handleClose() {
        boolean z = this.stateMachine.getCurrentState() == MraidStateMachineFactory.State.EXPANDED;
        boolean z2 = this.dataProvider.getPlacementType() == PlacementType.INTERSTITIAL;
        if (z || z2) {
            Objects.onNotNull(this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.interactor.MraidInteractor$$ExternalSyntheticLambda14
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((MraidInteractor.Callback) obj).processRestoreOriginalOrientation();
                }
            });
        }
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.CLOSE);
    }

    public void handleWasClosed() {
        Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda4());
        this.stateMachine.onEvent(MraidStateMachineFactory.Event.CLOSE_FINISHED);
    }

    public void handleVisibilityParamsCheck() {
        if (this.stateMachine.isTransitionAllowed(MraidStateMachineFactory.Event.VISIBILITY_PARAMS_CHECK)) {
            Objects.onNotNull(this.callback, new MraidInteractor$$ExternalSyntheticLambda4());
        }
    }
}
