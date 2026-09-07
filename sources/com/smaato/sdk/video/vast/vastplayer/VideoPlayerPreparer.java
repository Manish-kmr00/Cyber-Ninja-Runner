package com.smaato.sdk.video.vast.vastplayer;

import android.net.Uri;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.ad.VideoAdViewFactory;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.vastplayer.exception.VideoPlayerException;

/* JADX INFO: loaded from: classes11.dex */
public class VideoPlayerPreparer {
    private final VideoPlayerCreator videoPlayerCreator;

    public VideoPlayerPreparer(VideoPlayerCreator videoPlayerCreator) {
        this.videoPlayerCreator = (VideoPlayerCreator) Objects.requireNonNull(videoPlayerCreator);
    }

    public void prepareNewVideoPlayer(final Logger logger, MediaFile mediaFile, final NonNullConsumer<Either<VideoPlayer, Exception>> nonNullConsumer, VideoAdViewFactory.VideoPlayerListener videoPlayerListener, Consumer<SmaatoSdkViewDelegate.VideoActivityLifecycleListener> consumer) {
        Objects.requireNonNull(logger);
        final Uri uri = Uri.parse(mediaFile.url);
        final VideoPlayer videoPlayerCreateVideoPlayer = this.videoPlayerCreator.createVideoPlayer(logger);
        videoPlayerCreateVideoPlayer.setPrepareListener(new VideoPlayer.PrepareListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPreparer.1
            @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.PrepareListener
            public void onPreparing(VideoPlayer videoPlayer) {
            }

            @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.PrepareListener
            public void onInitialized(VideoPlayer videoPlayer) {
                logger.debug(LogDomain.VAST, "VAST VideoPlayer initialised. Preparing...", new Object[0]);
                videoPlayer.prepare();
            }

            @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.PrepareListener
            public void onPrepared(VideoPlayer videoPlayer) {
                logger.debug(LogDomain.VAST, "VAST VideoPlayer prepared with DataSource: %s", uri);
                videoPlayer.setPrepareListener(null);
                nonNullConsumer.accept(Either.left(videoPlayer));
            }

            @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.PrepareListener
            public void onError(VideoPlayer videoPlayer, VideoPlayerException videoPlayerException) {
                logger.error(LogDomain.VAST, String.format("Unable to prepare VAST VideoPlayer with DataSource: %s", uri), new Object[0]);
                videoPlayer.setPrepareListener(null);
                nonNullConsumer.accept(Either.right(videoPlayerException));
            }
        });
        logger.debug(LogDomain.VAST, "Initialising VAST VideoPlayer with DataSource: %s", uri);
        videoPlayerCreateVideoPlayer.setDataSource(uri.toString());
        if (consumer != null) {
            consumer.accept(new SmaatoSdkViewDelegate.VideoActivityLifecycleListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPreparer.2
                @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate.VideoActivityLifecycleListener
                public void onActivityResume() {
                }

                @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate.VideoActivityLifecycleListener
                public void onActivityPause() {
                    VideoPlayer videoPlayer = videoPlayerCreateVideoPlayer;
                    if (videoPlayer != null) {
                        videoPlayer.pause();
                    }
                }
            });
        }
    }
}
