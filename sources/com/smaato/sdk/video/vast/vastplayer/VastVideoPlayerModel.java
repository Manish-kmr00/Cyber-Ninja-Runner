package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.ad.VastPlayerListenerEvent;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.vast.model.VastBeaconEvent;
import com.smaato.sdk.video.vast.model.VastEvent;
import com.smaato.sdk.video.vast.tracking.VastBeaconTracker;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.tracking.VastEventTracker;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
class VastVideoPlayerModel {
    private float clickPositionXPx;
    private float clickPositionYPx;
    private final ComponentClickHandler componentClickHandler;
    private boolean isMuted;
    private final boolean isVideoClickable;
    private long lastKnownPositionMillis;
    VastBeaconTracker vastBeaconTracker;
    private final VastErrorTracker vastErrorTracker;
    private final VastEventTracker vastEventTracker;
    VideoAdViewFactory.VideoPlayerListener videoAdViewFactoryPlayerListener;
    private final AtomicReference vastVideoPlayerEventListener = new AtomicReference();
    private Quartile currentQuartile = Quartile.ZERO;

    public enum Quartile {
        ZERO,
        FIRST,
        MID,
        THIRD
    }

    VastVideoPlayerModel(VastErrorTracker vastErrorTracker, VastEventTracker vastEventTracker, VastBeaconTracker vastBeaconTracker, ComponentClickHandler componentClickHandler, boolean z, boolean z2, VideoAdViewFactory.VideoPlayerListener videoPlayerListener) {
        this.vastErrorTracker = (VastErrorTracker) Objects.requireNonNull(vastErrorTracker);
        this.vastEventTracker = (VastEventTracker) Objects.requireNonNull(vastEventTracker);
        this.componentClickHandler = (ComponentClickHandler) Objects.requireNonNull(componentClickHandler);
        this.isMuted = z;
        this.isVideoClickable = z2;
        this.vastBeaconTracker = vastBeaconTracker;
        this.videoAdViewFactoryPlayerListener = videoPlayerListener;
    }

    void setEventListener(VastVideoPlayer.EventListener eventListener) {
        this.vastVideoPlayerEventListener.set(eventListener);
    }

    void onAdError() {
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onAdError();
            }
        });
    }

    void onPlayerClosed() {
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onClose();
            }
        });
        this.vastEventTracker.triggerEventByName(VastEvent.CLOSE_LINEAR, createPlayerState());
        this.vastEventTracker.triggerEventByName(VastEvent.CLOSE, createPlayerState());
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_CLOSED);
    }

    void loaded() {
        this.vastEventTracker.triggerEventByName(VastEvent.LOADED, createPlayerState());
    }

    void onVideoStarted(final float f, final float f2) {
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onStart(f, f2);
            }
        });
        Objects.onNotNull(this.videoAdViewFactoryPlayerListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5731xb544da34(f, f2, (VideoAdViewFactory.VideoPlayerListener) obj);
            }
        });
        this.vastEventTracker.triggerEventByName(VastEvent.CREATIVE_VIEW, createPlayerState());
    }

    /* JADX INFO: renamed from: lambda$onVideoStarted$1$com-smaato-sdk-video-vast-vastplayer-VastVideoPlayerModel, reason: not valid java name */
    /* synthetic */ void m5731xb544da34(float f, float f2, VideoAdViewFactory.VideoPlayerListener videoPlayerListener) {
        videoPlayerListener.onVideoStarted(f, f2, new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onVideoImpression();
            }
        });
    }

    void onVideoImpression() {
        track(VastBeaconEvent.SMAATO_VIEWABLE_IMPRESSION);
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onVideoImpression();
            }
        });
    }

    void onVideoSkipped() {
        this.vastEventTracker.triggerEventByName(VastEvent.SKIP, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onSkipped();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_SKIPPED);
    }

    void onVideoMuteClicked() {
        this.isMuted = true;
        this.vastEventTracker.triggerEventByName(VastEvent.MUTE, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onMute();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_MUTE_CLICKED);
    }

    void onVideoUnmuteClicked() {
        this.isMuted = false;
        this.vastEventTracker.triggerEventByName(VastEvent.UNMUTE, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onUnmute();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_UNMUTE_CLICKED);
    }

    void onVideoCompleted() {
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onComplete();
            }
        });
        this.vastEventTracker.triggerEventByName(VastEvent.COMPLETE, createPlayerState());
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_COMPLETED);
    }

    void onVideoPaused() {
        this.vastEventTracker.triggerEventByName(VastEvent.PAUSE, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onPaused();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_PAUSED);
    }

    void onVideoProgressChange(long j, long j2) {
        this.lastKnownPositionMillis = j;
        this.vastEventTracker.triggerProgressDependentEvent(createPlayerState(), j2);
        float f = j / j2;
        if (f >= 0.01f) {
            track(VastBeaconEvent.SMAATO_IMPRESSION);
        }
        Quartile quartile = Quartile.ZERO;
        if (f >= 0.25f && f < 0.5f) {
            quartile = Quartile.FIRST;
        } else if (f >= 0.5f && f < 0.75f) {
            quartile = Quartile.MID;
        } else if (f >= 0.75f) {
            quartile = Quartile.THIRD;
        }
        if (this.currentQuartile != quartile) {
            this.currentQuartile = quartile;
            onQuartileChange(quartile);
        }
    }

    void onPlayerExpanded() {
        this.vastEventTracker.triggerEventByName(VastEvent.PLAYER_EXPAND, createPlayerState());
    }

    void onPlayerCollapsed() {
        this.vastEventTracker.triggerEventByName(VastEvent.PLAYER_COLLAPSE, createPlayerState());
    }

    void onVideoResumed() {
        this.vastEventTracker.triggerEventByName(VastEvent.RESUME, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onResumed();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_RESUMED);
    }

    void onCompanionShown() {
        this.vastEventTracker.triggerEventByName(VastEvent.CREATIVE_VIEW_COMPANION, createPlayerState());
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastVideoPlayer.EventListener) obj).onCompanionShown();
            }
        });
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_COMPANION_SHOWN);
    }

    void onIconShown() {
        track(VastBeaconEvent.SMAATO_ICON_VIEW_TRACKING);
    }

    void onVideoError(int i) {
        trackError(i);
    }

    void onIconError(int i) {
        trackError(i);
    }

    void onCompanionError(int i) {
        trackError(i);
    }

    private void trackError(int i) {
        this.vastErrorTracker.track(new PlayerState.Builder().setOffsetMillis(this.lastKnownPositionMillis).setMuted(this.isMuted).setErrorCode(i).setClickPositionX(this.clickPositionXPx).setClickPositionY(this.clickPositionYPx).build());
    }

    private void onQuartileChange(Quartile quartile) {
        VastVideoPlayer.EventListener eventListener = (VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get();
        if (eventListener != null) {
            int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile[quartile.ordinal()];
            if (i == 1) {
                eventListener.onFirstQuartile();
            } else if (i == 2) {
                eventListener.onMidPoint();
            } else if (i == 3) {
                eventListener.onThirdQuartile();
            }
        }
        if (this.videoAdViewFactoryPlayerListener != null) {
            int i2 = AnonymousClass1.$SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile[quartile.ordinal()];
            if (i2 == 1) {
                notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_FIRST_QUARTILE);
            } else if (i2 == 2) {
                notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_MIDPOINT);
            } else {
                if (i2 != 3) {
                    return;
                }
                notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_THIRD_QUARTILE);
            }
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile;

        static {
            int[] iArr = new int[Quartile.values().length];
            $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile = iArr;
            try {
                iArr[Quartile.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile[Quartile.MID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile[Quartile.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$VastVideoPlayerModel$Quartile[Quartile.ZERO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void track(VastBeaconEvent vastBeaconEvent) {
        this.vastBeaconTracker.trigger(vastBeaconEvent, createPlayerState());
    }

    private void notifyPlayerListener(VastPlayerListenerEvent vastPlayerListenerEvent) {
        VideoAdViewFactory.VideoPlayerListener videoPlayerListener = this.videoAdViewFactoryPlayerListener;
        if (videoPlayerListener != null) {
            videoPlayerListener.onVideoPlayerEvents(vastPlayerListenerEvent);
        }
    }

    void videoClick(float f, float f2, Runnable runnable, Runnable runnable2) {
        if (this.isVideoClickable) {
            this.clickPositionXPx = f;
            this.clickPositionYPx = f2;
            track(VastBeaconEvent.SMAATO_VIDEO_CLICK_TRACKING);
            notifyPlayerListener(VastPlayerListenerEvent.SMAATO_VIDEO_CLICKED);
            Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new VastVideoPlayerModel$$ExternalSyntheticLambda3());
            this.componentClickHandler.handleClick(null, runnable, runnable2);
        }
    }

    void companionClick(String str, Runnable runnable, Runnable runnable2) {
        track(VastBeaconEvent.SMAATO_COMPANION_CLICK_TRACKING);
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_COMPANION_CLICKED);
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new VastVideoPlayerModel$$ExternalSyntheticLambda3());
        this.componentClickHandler.handleClick(str, runnable, runnable2);
    }

    void iconClick(String str, Runnable runnable) {
        track(VastBeaconEvent.SMAATO_ICON_CLICK_TRACKING);
        notifyPlayerListener(VastPlayerListenerEvent.SMAATO_ICON_CLICKED);
        Objects.onNotNull((VastVideoPlayer.EventListener) this.vastVideoPlayerEventListener.get(), new VastVideoPlayerModel$$ExternalSyntheticLambda3());
        this.componentClickHandler.handleClick(str, runnable, null);
    }

    private PlayerState createPlayerState() {
        return new PlayerState.Builder().setOffsetMillis(this.lastKnownPositionMillis).setMuted(this.isMuted).setClickPositionX(this.clickPositionXPx).setClickPositionY(this.clickPositionYPx).build();
    }
}
