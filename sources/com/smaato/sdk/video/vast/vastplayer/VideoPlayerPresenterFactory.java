package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import com.smaato.sdk.video.vast.vastplayer.exception.MalformedVideoPlayerException;
import com.smaato.sdk.video.vast.vastplayer.exception.UnsupportedVideoPlayerException;

/* JADX INFO: loaded from: classes13.dex */
class VideoPlayerPresenterFactory {
    private final boolean isMuted;
    private final RepeatableActionFactory repeatableActionFactory;
    private final VideoPlayerPreparer videoPlayerPreparer;

    VideoPlayerPresenterFactory(VideoPlayerPreparer videoPlayerPreparer, RepeatableActionFactory repeatableActionFactory, boolean z) {
        this.videoPlayerPreparer = (VideoPlayerPreparer) Objects.requireNonNull(videoPlayerPreparer);
        this.repeatableActionFactory = (RepeatableActionFactory) Objects.requireNonNull(repeatableActionFactory);
        this.isMuted = z;
    }

    void createVideoPlayerPresenter(Logger logger, final VastMediaFileScenario vastMediaFileScenario, final VastErrorTracker vastErrorTracker, final NonNullConsumer<Either<VideoPlayerPresenter, Exception>> nonNullConsumer, final VideoSettings videoSettings, VideoAdViewFactory.VideoPlayerListener videoPlayerListener, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(nonNullConsumer);
        this.videoPlayerPreparer.prepareNewVideoPlayer(logger, vastMediaFileScenario.mediaFile, new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenterFactory$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5741x8b91a761(vastMediaFileScenario, vastErrorTracker, nonNullConsumer, videoSettings, (Either) obj);
            }
        }, videoPlayerListener, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onVideoPlayerPresenterResult, reason: merged with bridge method [inline-methods] */
    public void m5741x8b91a761(VastMediaFileScenario vastMediaFileScenario, Either either, VastErrorTracker vastErrorTracker, NonNullConsumer nonNullConsumer, VideoSettings videoSettings) {
        MediaFile mediaFile = vastMediaFileScenario.mediaFile;
        Exception exc = (Exception) either.right();
        if (exc != null) {
            try {
                throw exc;
            } catch (MalformedVideoPlayerException | UnsupportedVideoPlayerException unused) {
                vastErrorTracker.track(new PlayerState.Builder().setErrorCode(405).build());
                nonNullConsumer.accept(Either.right(exc));
                return;
            } catch (Exception unused2) {
                vastErrorTracker.track(new PlayerState.Builder().setErrorCode(400).build());
                nonNullConsumer.accept(Either.right(exc));
                return;
            }
        }
        VideoPlayer videoPlayer = (VideoPlayer) Objects.requireNonNull((VideoPlayer) either.left());
        videoSettings.updateVideoDurationMillis(videoPlayer.getDuration());
        VideoViewResizeManager videoViewResizeManagerCreate = VideoViewResizeManager.create(mediaFile);
        SkipButtonVisibilityManager skipButtonVisibilityManagerCreate = SkipButtonVisibilityManager.create(videoSettings);
        videoPlayer.setVolume((videoPlayer.getRingerMode() == 2 && videoSettings.isVideoSoundOn) ? 1.0f : 0.0f);
        nonNullConsumer.accept(Either.left(new VideoPlayerPresenter(videoPlayer, vastMediaFileScenario, videoViewResizeManagerCreate, skipButtonVisibilityManagerCreate, this.repeatableActionFactory, videoSettings)));
    }
}
