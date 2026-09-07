package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Metadata;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView;
import com.smaato.sdk.video.vast.widget.element.VastElementPresenter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class VastVideoPlayerPresenter {
    private final VastElementPresenter.Listener companionListener;
    private final VastElementPresenter companionPresenter;
    private final VastElementPresenter.Listener iconListener;
    private final VastElementPresenter iconPresenter;
    private boolean isCompanionHasError;
    private final Logger logger;
    private final StateMachine.Listener vastPlayerStateListener;
    private final StateMachine vastVideoPlayerStateMachine;
    private WeakReference vastVideoPlayerViewReference = new WeakReference(null);
    private final VideoPlayerPresenter.Listener videoPlayerListener;
    private final VastVideoPlayerModel videoPlayerModel;
    private final VideoPlayerPresenter videoPlayerPresenter;

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements VastElementPresenter.Listener {
        static /* synthetic */ void lambda$onVastElementClicked$0() {
        }

        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementClicked(String str) {
            VastVideoPlayerPresenter.this.videoPlayerModel.iconClick(str, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VastVideoPlayerPresenter.AnonymousClass1.lambda$onVastElementClicked$0();
                }
            });
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementRendered() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onIconRendered", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onIconShown();
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementError(int i) {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onIconError", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onIconError(i);
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onRenderProcessGone() {
            VastVideoPlayerPresenter.this.videoPlayerModel.onAdError();
            VastVideoPlayerPresenter.this.closePlayer();
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$2, reason: invalid class name */
    class AnonymousClass2 implements VideoPlayerPresenter.Listener {
        AnonymousClass2() {
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoStarted(long j, float f) {
            VastVideoPlayerPresenter.this.logger.info(LogDomain.VAST, "VAST video has started", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoStarted(j, f);
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoImpression() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onVideoImpression", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoImpression();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoProgressChange(long j, long j2) {
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoProgressChange(j, j2);
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoClicked(float f, float f2) {
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.CLICKED);
            Objects.onNotNull((VastVideoAdPlayerView) VastVideoPlayerPresenter.this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$2$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VastVideoAdPlayerView) obj).showProgressIndicator(true);
                }
            });
            VastVideoPlayerPresenter.this.videoPlayerModel.videoClick(f, f2, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5734x72de3627();
                }
            }, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5735xc09dae28();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onVideoClicked$1$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter$2, reason: not valid java name */
        /* synthetic */ void m5734x72de3627() {
            VastVideoPlayerPresenter.this.onClickSuccess();
        }

        /* JADX INFO: renamed from: lambda$onVideoClicked$2$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter$2, reason: not valid java name */
        /* synthetic */ void m5735xc09dae28() {
            VastVideoPlayerPresenter.this.onClickFailure();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoSkipped() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onVideoSkipped", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoSkipped();
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.VIDEO_SKIPPED);
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onMuteClicked() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onMuteClicked", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoMuteClicked();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onUnmuteClicked() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onUnmuteClicked", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoUnmuteClicked();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoCompleted() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onVideoCompleted", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoCompleted();
            VastVideoAdPlayerView vastVideoAdPlayerView = VastVideoPlayerPresenter.this.vastVideoPlayerViewReference != null ? (VastVideoAdPlayerView) VastVideoPlayerPresenter.this.vastVideoPlayerViewReference.get() : null;
            if (vastVideoAdPlayerView != null && vastVideoAdPlayerView.getIconView() != null) {
                vastVideoAdPlayerView.getIconView().setVisibility(8);
            }
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.VIDEO_COMPLETED);
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoError(int i) {
            VastVideoPlayerPresenter.this.logger.error(LogDomain.VAST, "onVideoError", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoError(i);
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.ERROR);
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoPaused() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onVideoPaused", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoPaused();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter.Listener
        public void onVideoResumed() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onVideoResumed", new Object[0]);
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.RESUME);
            VastVideoPlayerPresenter.this.videoPlayerModel.onVideoResumed();
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter, reason: not valid java name */
    /* synthetic */ void m5733xbd0ba1b3(VastPlayerState vastPlayerState, VastPlayerState vastPlayerState2, Metadata metadata) {
        setupPlayerForState(vastPlayerState2);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3, reason: invalid class name */
    class AnonymousClass3 implements VastElementPresenter.Listener {
        AnonymousClass3() {
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementClicked(String str) {
            Objects.onNotNull((VastVideoAdPlayerView) VastVideoPlayerPresenter.this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VastVideoAdPlayerView) obj).showProgressIndicator(true);
                }
            });
            VastVideoPlayerPresenter.this.videoPlayerModel.companionClick(str, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5736x8a942a34();
                }
            }, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5737x26131a36();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onVastElementClicked$2$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter$3, reason: not valid java name */
        /* synthetic */ void m5736x8a942a34() {
            VastVideoPlayerPresenter.this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.CLICKED);
            Objects.onNotNull((VastVideoAdPlayerView) VastVideoPlayerPresenter.this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VastVideoAdPlayerView) obj).showProgressIndicator(false);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onVastElementClicked$4$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter$3, reason: not valid java name */
        /* synthetic */ void m5737x26131a36() {
            Objects.onNotNull((VastVideoAdPlayerView) VastVideoPlayerPresenter.this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$3$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VastVideoAdPlayerView) obj).showProgressIndicator(false);
                }
            });
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementRendered() {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onCompanionRendered", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onCompanionShown();
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onVastElementError(int i) {
            VastVideoPlayerPresenter.this.logger.debug(LogDomain.VAST, "onCompanionError", new Object[0]);
            VastVideoPlayerPresenter.this.videoPlayerModel.onCompanionError(i);
            VastVideoPlayerPresenter.this.isCompanionHasError = true;
        }

        @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter.Listener
        public void onRenderProcessGone() {
            VastVideoPlayerPresenter.this.videoPlayerModel.onAdError();
            VastVideoPlayerPresenter.this.closePlayer();
        }
    }

    VastVideoPlayerPresenter(Logger logger, VastVideoPlayerModel vastVideoPlayerModel, VastElementPresenter vastElementPresenter, VastElementPresenter vastElementPresenter2, VideoPlayerPresenter videoPlayerPresenter, StateMachine<VastPlayerEvent, VastPlayerState> stateMachine) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.iconListener = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.videoPlayerListener = anonymousClass2;
        StateMachine.Listener listener = new StateMachine.Listener() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.StateMachine.Listener
            public final void onStateChanged(Object obj, Object obj2, Metadata metadata) {
                this.f$0.m5733xbd0ba1b3((VastPlayerState) obj, (VastPlayerState) obj2, metadata);
            }
        };
        this.vastPlayerStateListener = listener;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        this.companionListener = anonymousClass3;
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.videoPlayerModel = (VastVideoPlayerModel) Objects.requireNonNull(vastVideoPlayerModel);
        VastElementPresenter vastElementPresenter3 = (VastElementPresenter) Objects.requireNonNull(vastElementPresenter);
        this.companionPresenter = vastElementPresenter3;
        VastElementPresenter vastElementPresenter4 = (VastElementPresenter) Objects.requireNonNull(vastElementPresenter2);
        this.iconPresenter = vastElementPresenter4;
        VideoPlayerPresenter videoPlayerPresenter2 = (VideoPlayerPresenter) Objects.requireNonNull(videoPlayerPresenter);
        this.videoPlayerPresenter = videoPlayerPresenter2;
        StateMachine stateMachine2 = (StateMachine) Objects.requireNonNull(stateMachine);
        this.vastVideoPlayerStateMachine = stateMachine2;
        videoPlayerPresenter2.setListener(anonymousClass2);
        vastElementPresenter3.setListener(anonymousClass3);
        vastElementPresenter4.setListener(anonymousClass1);
        stateMachine2.addListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickSuccess() {
        Objects.onNotNull((VastVideoAdPlayerView) this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoAdPlayerView) obj).showProgressIndicator(false);
            }
        });
        this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.RESUME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickFailure() {
        Objects.onNotNull((VastVideoAdPlayerView) this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoAdPlayerView) obj).showProgressIndicator(false);
            }
        });
        this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.RESUME);
        resume();
    }

    VastVideoPlayerModel getVideoPlayerModel() {
        return this.videoPlayerModel;
    }

    void attachView(VastVideoAdPlayerView vastVideoAdPlayerView) {
        detachView();
        this.vastVideoPlayerViewReference = new WeakReference(vastVideoAdPlayerView);
        vastVideoAdPlayerView.getIconView().setPresenter(this.iconPresenter);
        vastVideoAdPlayerView.getCompanionAdView().setPresenter(this.companionPresenter);
        setupPlayerForState((VastPlayerState) this.vastVideoPlayerStateMachine.getCurrentState());
    }

    void onCloseClicked() {
        this.vastVideoPlayerStateMachine.onEvent(VastPlayerEvent.CLOSE_BUTTON_CLICKED);
    }

    void detachView() {
        Objects.onNotNull((VastVideoAdPlayerView) this.vastVideoPlayerViewReference.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5732x3b92c108((VastVideoAdPlayerView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$detachView$3$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerPresenter, reason: not valid java name */
    /* synthetic */ void m5732x3b92c108(VastVideoAdPlayerView vastVideoAdPlayerView) {
        this.vastVideoPlayerViewReference.clear();
    }

    void loaded() {
        this.videoPlayerModel.loaded();
    }

    void pause() {
        this.videoPlayerPresenter.pause();
    }

    void resume() {
        this.videoPlayerPresenter.resume();
    }

    private void setupPlayerForState(VastPlayerState vastPlayerState) {
        if (this.isCompanionHasError && vastPlayerState == VastPlayerState.SHOW_COMPANION) {
            closePlayer();
        }
        switch (AnonymousClass4.$SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[vastPlayerState.ordinal()]) {
            case 1:
                showVideoPlayerView();
                break;
            case 2:
                showCompanion();
                break;
            case 3:
                closePlayer();
                break;
            case 4:
                pause();
                break;
            case 5:
            case 6:
                break;
            default:
                this.logger.error(LogDomain.VAST, "Unknown state for VastVideoPlayer: " + vastPlayerState, new Object[0]);
                closePlayer();
                break;
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState;

        static {
            int[] iArr = new int[VastPlayerState.values().length];
            $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState = iArr;
            try {
                iArr[VastPlayerState.SHOW_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[VastPlayerState.SHOW_COMPANION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[VastPlayerState.CLOSE_PLAYER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[VastPlayerState.PAUSE_PLAYER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[VastPlayerState.IDLE_PLAYER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastPlayerState[VastPlayerState.SHOW_COMPANION_AFTER_CLICK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void clear() {
        this.videoPlayerPresenter.close();
        detachView();
    }

    private void showCompanion() {
        VastVideoAdPlayerView vastVideoAdPlayerView = (VastVideoAdPlayerView) this.vastVideoPlayerViewReference.get();
        if (vastVideoAdPlayerView != null) {
            vastVideoAdPlayerView.hidePlayer();
            vastVideoAdPlayerView.showCompanion();
        }
    }

    private void showVideoPlayerView() {
        VastVideoAdPlayerView vastVideoAdPlayerView = (VastVideoAdPlayerView) this.vastVideoPlayerViewReference.get();
        VideoPlayerView videoPlayerView = vastVideoAdPlayerView == null ? null : vastVideoAdPlayerView.getVideoPlayerView();
        final VideoPlayerPresenter videoPlayerPresenter = this.videoPlayerPresenter;
        java.util.Objects.requireNonNull(videoPlayerPresenter);
        Objects.onNotNull(videoPlayerView, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerPresenter$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                videoPlayerPresenter.attachView((VideoPlayerView) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePlayer() {
        this.videoPlayerModel.onPlayerClosed();
        clear();
    }
}
