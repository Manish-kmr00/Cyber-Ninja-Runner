package com.smaato.sdk.video.ad;

import android.app.Application;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VideoAdViewProperties;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.vastplayer.VastVideoPlayer;
import com.smaato.sdk.video.vast.vastplayer.VastVideoPlayerCreator;
import com.smaato.sdk.video.vast.vastplayer.VideoSettings;
import com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class VideoAdViewFactory {
    Application application;
    private final Logger logger;
    VastErrorTrackerCreator vastErrorTrackerCreator;
    private final VastVideoPlayerCreator vastVideoPlayerCreator;

    public interface VideoPlayerListener {
        void onVideoPlayerBuildError(SomaException somaException);

        void onVideoPlayerEvents(VastPlayerListenerEvent vastPlayerListenerEvent);

        void onVideoPlayerViewCreated(VastVideoAdPlayerView vastVideoAdPlayerView, Runnable runnable);

        void onVideoStarted(float f, float f2, Runnable runnable);
    }

    public VideoAdViewFactory(Logger logger, VastErrorTrackerCreator vastErrorTrackerCreator, VastVideoPlayerCreator vastVideoPlayerCreator, Application application) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.vastErrorTrackerCreator = (VastErrorTrackerCreator) java.util.Objects.requireNonNull(vastErrorTrackerCreator);
        this.vastVideoPlayerCreator = (VastVideoPlayerCreator) Objects.requireNonNull(vastVideoPlayerCreator);
        this.application = application;
    }

    public void createVastVideoPlayer(VastParsingResult vastParsingResult, VideoAdViewProperties videoAdViewProperties, final VideoPlayerListener videoPlayerListener, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer) {
        final VastScenario vastScenario = vastParsingResult.vastScenario;
        Set<String> set = vastParsingResult.errorUrls;
        Objects.requireNonNull(vastScenario);
        buildVastPlayer(vastScenario, this.vastErrorTrackerCreator.create(vastScenario, set), new NonNullConsumer() { // from class: com.smaato.sdk.video.ad.VideoAdViewFactory$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                this.f$0.m5706xf5275dc1(videoPlayerListener, vastScenario, (Either) obj);
            }
        }, videoAdViewProperties, videoPlayerListener, consumer);
    }

    /* JADX INFO: renamed from: lambda$createVastVideoPlayer$0$com-smaato-sdk-video-ad-VideoAdViewFactory, reason: not valid java name */
    /* synthetic */ void m5706xf5275dc1(VideoPlayerListener videoPlayerListener, VastScenario vastScenario, Either either) {
        createVastVideoPlayerView(either, videoPlayerListener, vastScenario.adVerifications);
    }

    private void createVastVideoPlayerView(Either either, VideoPlayerListener videoPlayerListener, List list) {
        Exception exc = (Exception) either.right();
        if (exc != null) {
            onVideoPlayerBuildError(exc.getMessage() != null ? exc.getMessage() : "Vast Video player failed", videoPlayerListener);
            return;
        }
        final VastVideoPlayer vastVideoPlayer = (VastVideoPlayer) Objects.requireNonNull((VastVideoPlayer) either.left());
        if (vastVideoPlayer != null) {
            videoPlayerListener.onVideoPlayerViewCreated(vastVideoPlayer.getNewVideoPlayerView(this.application, list), new Runnable() { // from class: com.smaato.sdk.video.ad.VideoAdViewFactory$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    vastVideoPlayer.onCloseClicked();
                }
            });
            vastVideoPlayer.loaded();
        }
    }

    private void buildVastPlayer(VastScenario vastScenario, VastErrorTracker vastErrorTracker, NonNullConsumer nonNullConsumer, VideoAdViewProperties videoAdViewProperties, VideoPlayerListener videoPlayerListener, Consumer consumer) {
        this.vastVideoPlayerCreator.createVastVideoPlayer(this.logger, vastScenario, vastErrorTracker, nonNullConsumer, VideoSettings.create(vastScenario.vastMediaFileScenario.duration, videoAdViewProperties), videoPlayerListener, consumer);
    }

    private void onVideoPlayerBuildError(String str, VideoPlayerListener videoPlayerListener) {
        this.logger.error(LogDomain.VIDEO, str, new Object[0]);
        videoPlayerListener.onVideoPlayerBuildError(new SomaException(SomaException.Type.BAD_RESPONSE, str));
    }
}
