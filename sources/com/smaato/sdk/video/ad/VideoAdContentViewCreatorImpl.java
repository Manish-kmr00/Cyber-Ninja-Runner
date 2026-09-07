package com.smaato.sdk.video.ad;

import android.view.View;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.mvvm.view.VideoAdContentViewCreator;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.remoteconfig.ButtonConfigurations;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VideoAdViewProperties;
import com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView;

/* JADX INFO: loaded from: classes2.dex */
public class VideoAdContentViewCreatorImpl implements VideoAdContentViewCreator {
    private final ButtonConfigurations buttonConfigurations;
    private final Logger logger;
    VastErrorTrackerCreator vastErrorTrackerCreator;
    private final VideoAdViewFactory videoAdViewFactory;

    public VideoAdContentViewCreatorImpl(VideoAdViewFactory videoAdViewFactory, VastErrorTrackerCreator vastErrorTrackerCreator, ButtonConfigurations buttonConfigurations, Logger logger) {
        this.videoAdViewFactory = videoAdViewFactory;
        this.vastErrorTrackerCreator = vastErrorTrackerCreator;
        this.buttonConfigurations = buttonConfigurations;
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.mvvm.view.VideoAdContentViewCreator
    public void createAdContentView(Object obj, final boolean z, boolean z2, ImpressionCountingType impressionCountingType, final SmaatoSdkViewDelegate smaatoSdkViewDelegate, final Consumer<AdContentView> consumer, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer2) {
        if (!(obj instanceof VastParsingResult)) {
            smaatoSdkViewDelegate.onWrongVastObjectCreated(obj);
            return;
        }
        final VastParsingResult vastParsingResult = (VastParsingResult) obj;
        long skipOffset = getSkipOffset(vastParsingResult, smaatoSdkViewDelegate.getBundleId());
        final VideoAdViewProperties videoAdViewPropertiesBuild = VideoAdViewProperties.builder().skipInterval(skipOffset).closeButtonSize(this.buttonConfigurations.getButtonSize(smaatoSdkViewDelegate.getBundleId())).isSkippable(z).isClickable(z2).hasCompanionAd(hasCompanion(vastParsingResult)).isSoundOn(this.buttonConfigurations.getPublisherConfig().getSoundSettings().isSoundOn()).build();
        this.videoAdViewFactory.createVastVideoPlayer(vastParsingResult, videoAdViewPropertiesBuild, new VideoAdViewFactory.VideoPlayerListener() { // from class: com.smaato.sdk.video.ad.VideoAdContentViewCreatorImpl.1
            @Override // com.smaato.sdk.video.ad.VideoAdViewFactory.VideoPlayerListener
            public void onVideoPlayerEvents(VastPlayerListenerEvent vastPlayerListenerEvent) {
                switch (AnonymousClass2.$SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[vastPlayerListenerEvent.ordinal()]) {
                    case 1:
                    case 2:
                        smaatoSdkViewDelegate.onVideoClicked();
                        break;
                    case 3:
                        smaatoSdkViewDelegate.onVideoFirstQuartileReached();
                        break;
                    case 4:
                        smaatoSdkViewDelegate.onVideoMidpointReached();
                        break;
                    case 5:
                        smaatoSdkViewDelegate.onVideoThirdQuartileReached();
                        break;
                    case 6:
                        smaatoSdkViewDelegate.onVideoCompleted(VideoAdContentViewCreatorImpl.this.hasCompanion(vastParsingResult));
                        break;
                    case 7:
                        smaatoSdkViewDelegate.onVideoPaused();
                        break;
                    case 8:
                        smaatoSdkViewDelegate.onVideoResumed();
                        break;
                    case 9:
                        smaatoSdkViewDelegate.onMuteClicked();
                        break;
                    case 10:
                        smaatoSdkViewDelegate.onUnmuteClicked();
                        break;
                    case 11:
                        smaatoSdkViewDelegate.onVideoSkipped();
                        break;
                    case 12:
                        smaatoSdkViewDelegate.onCompanionShown();
                        break;
                    case 13:
                        smaatoSdkViewDelegate.onCompanionAdClicked();
                        break;
                    case 14:
                        smaatoSdkViewDelegate.onVideoClosed();
                        break;
                }
            }

            @Override // com.smaato.sdk.video.ad.VideoAdViewFactory.VideoPlayerListener
            public void onVideoPlayerViewCreated(VastVideoAdPlayerView vastVideoAdPlayerView, Runnable runnable) {
                vastVideoAdPlayerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.smaato.sdk.video.ad.VideoAdContentViewCreatorImpl.1.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        smaatoSdkViewDelegate.onVideoViewAttached(z, videoAdViewPropertiesBuild.skipInterval());
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        view.removeOnAttachStateChangeListener(this);
                        smaatoSdkViewDelegate.onVideoViewDetached();
                    }
                });
                consumer.accept(vastVideoAdPlayerView);
                smaatoSdkViewDelegate.setVideoPlayerCloser(runnable);
            }

            @Override // com.smaato.sdk.video.ad.VideoAdViewFactory.VideoPlayerListener
            public void onVideoStarted(float f, float f2, Runnable runnable) {
                smaatoSdkViewDelegate.onVideoStarted(f, f2, runnable);
            }

            @Override // com.smaato.sdk.video.ad.VideoAdViewFactory.VideoPlayerListener
            public void onVideoPlayerBuildError(SomaException somaException) {
                smaatoSdkViewDelegate.onVideoPlayerBuildError(somaException);
            }
        }, consumer2);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.ad.VideoAdContentViewCreatorImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent;

        static {
            int[] iArr = new int[VastPlayerListenerEvent.values().length];
            $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent = iArr;
            try {
                iArr[VastPlayerListenerEvent.SMAATO_VIDEO_CLICKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_ICON_CLICKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_FIRST_QUARTILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_MIDPOINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_THIRD_QUARTILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_RESUMED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_MUTE_CLICKED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_UNMUTE_CLICKED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_SKIPPED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_COMPANION_SHOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_COMPANION_CLICKED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$ad$VastPlayerListenerEvent[VastPlayerListenerEvent.SMAATO_VIDEO_CLOSED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    boolean hasCompanion(VastParsingResult vastParsingResult) {
        VastScenario vastScenario;
        VastCompanionScenario vastCompanionScenario;
        return (vastParsingResult == null || (vastScenario = vastParsingResult.vastScenario) == null || (vastCompanionScenario = vastScenario.vastCompanionScenario) == null || vastCompanionScenario.resourceData.isCompanionInvalid()) ? false : true;
    }

    protected long getSkipOffset(VastParsingResult vastParsingResult, String str) {
        VastScenario vastScenario = vastParsingResult.vastScenario;
        long j = vastScenario != null ? vastScenario.vastMediaFileScenario.skipOffset : -1L;
        return j == -1 ? ((long) this.buttonConfigurations.getVideoAdSkipButtonDelay(str)) * 1000 : j;
    }
}
