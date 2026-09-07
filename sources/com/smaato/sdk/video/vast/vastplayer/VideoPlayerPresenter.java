package com.smaato.sdk.video.vast.vastplayer;

import android.view.Surface;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.utils.RepeatableAction;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.vastplayer.exception.VideoPlayerException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
class VideoPlayerPresenter {
    private long lastCurrentPositionMillis;
    private int lastRingerModeSetting;
    private final SkipButtonVisibilityManager skipButtonVisibilityManager;
    private final VideoPlayer videoPlayer;
    private Listener videoPlayerPresenterListener;
    private final RepeatableAction videoProgressCheckAction;
    private VideoSettings videoSettings;
    private final VideoViewResizeManager videoViewResizeManager;
    private boolean onVideoComplete = false;
    private WeakReference videoPlayerViewRef = new WeakReference(null);

    interface Listener {
        void onMuteClicked();

        void onUnmuteClicked();

        void onVideoClicked(float f, float f2);

        void onVideoCompleted();

        void onVideoError(int i);

        void onVideoImpression();

        void onVideoPaused();

        void onVideoProgressChange(long j, long j2);

        void onVideoResumed();

        void onVideoSkipped();

        void onVideoStarted(long j, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSurfaceChanged(Surface surface, int i, int i2) {
    }

    VideoPlayerPresenter(VideoPlayer videoPlayer, VastMediaFileScenario vastMediaFileScenario, VideoViewResizeManager videoViewResizeManager, SkipButtonVisibilityManager skipButtonVisibilityManager, RepeatableActionFactory repeatableActionFactory, VideoSettings videoSettings) {
        this.videoPlayer = (VideoPlayer) Objects.requireNonNull(videoPlayer);
        this.videoViewResizeManager = (VideoViewResizeManager) Objects.requireNonNull(videoViewResizeManager);
        this.skipButtonVisibilityManager = (SkipButtonVisibilityManager) Objects.requireNonNull(skipButtonVisibilityManager);
        this.videoProgressCheckAction = (RepeatableAction) Objects.requireNonNull(repeatableActionFactory.createRepeatableAction(new RepeatableAction.Listener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.video.utils.RepeatableAction.Listener
            public final void doAction() {
                this.f$0.checkVideoProgress();
            }
        }));
        this.videoSettings = videoSettings;
        videoPlayer.setLifecycleListener(new AnonymousClass1(skipButtonVisibilityManager));
        videoPlayer.setOnVolumeChangeListener(new VideoPlayer.OnVolumeChangeListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.OnVolumeChangeListener
            public final void onVolumeChanged(float f) {
                this.f$0.onVolumeChanged(f);
            }
        });
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements VideoPlayer.LifecycleListener {
        final /* synthetic */ SkipButtonVisibilityManager val$skipButtonVisibilityManager;

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onReleased(VideoPlayer videoPlayer) {
        }

        AnonymousClass1(SkipButtonVisibilityManager skipButtonVisibilityManager) {
            this.val$skipButtonVisibilityManager = skipButtonVisibilityManager;
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onStarted(final VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.videoProgressCheckAction.start();
            Objects.onNotNull(VideoPlayerPresenter.this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    VideoPlayer videoPlayer2 = videoPlayer;
                    ((VideoPlayerPresenter.Listener) obj).onVideoStarted(videoPlayer2.getDuration(), videoPlayer2.getCurrentVolume());
                }
            });
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onResumed(VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.videoProgressCheckAction.start();
            Objects.onNotNull(VideoPlayerPresenter.this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VideoPlayerPresenter.Listener) obj).onVideoResumed();
                }
            });
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onSeekComplete(VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.videoProgressCheckAction.start();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onPaused(VideoPlayer videoPlayer) {
            Objects.onNotNull(VideoPlayerPresenter.this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VideoPlayerPresenter.Listener) obj).onVideoPaused();
                }
            });
            VideoPlayerPresenter.this.videoProgressCheckAction.stop();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onStopped(VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.videoProgressCheckAction.stop();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onCompleted(VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.onProgressChanged(videoPlayer.getDuration());
            Objects.onNotNull(VideoPlayerPresenter.this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VideoPlayerPresenter.Listener) obj).onVideoCompleted();
                }
            });
            VideoPlayerPresenter.this.videoProgressCheckAction.stop();
            VideoPlayerPresenter.this.onVideoComplete = true;
            videoPlayer.isCompleted(true);
            VideoPlayerView videoPlayerView = (VideoPlayerView) VideoPlayerPresenter.this.videoPlayerViewRef.get();
            final SkipButtonVisibilityManager skipButtonVisibilityManager = this.val$skipButtonVisibilityManager;
            java.util.Objects.requireNonNull(skipButtonVisibilityManager);
            Objects.onNotNull(videoPlayerView, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    skipButtonVisibilityManager.onVideoComplete((VideoPlayerView) obj);
                }
            });
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onReset(VideoPlayer videoPlayer) {
            VideoPlayerPresenter.this.videoProgressCheckAction.stop();
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer.LifecycleListener
        public void onError(VideoPlayer videoPlayer, VideoPlayerException videoPlayerException) {
            Objects.onNotNull(VideoPlayerPresenter.this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VideoPlayerPresenter.Listener) obj).onVideoError(400);
                }
            });
            VideoPlayerPresenter.this.videoProgressCheckAction.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVolumeChanged(float f) {
        final boolean z = f == 0.0f;
        Objects.onNotNull((VideoPlayerView) this.videoPlayerViewRef.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerView) obj).changeMuteIcon(z);
            }
        });
        Objects.onNotNull(this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VideoPlayerPresenter.lambda$onVolumeChanged$1(z, (VideoPlayerPresenter.Listener) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onVolumeChanged$1(boolean z, Listener listener) {
        if (z) {
            listener.onMuteClicked();
        } else {
            listener.onUnmuteClicked();
        }
    }

    void setListener(Listener listener) {
        this.videoPlayerPresenterListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVideoProgress() {
        long currentPositionMillis = this.videoPlayer.getCurrentPositionMillis();
        if (currentPositionMillis != this.lastCurrentPositionMillis) {
            this.lastCurrentPositionMillis = currentPositionMillis;
            onProgressChanged(currentPositionMillis);
        }
    }

    void attachView(final VideoPlayerView videoPlayerView) {
        this.videoPlayerViewRef = new WeakReference(videoPlayerView);
        videoPlayerView.setVideoPlayerPresenter(this);
        videoPlayerView.changeMuteIcon(this.videoPlayer.getCurrentVolume() == 0.0f);
        Objects.onNotNull(this.videoSettings, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                videoPlayerView.setSkipButtonSize(((VideoSettings) obj).closeButtonSize);
            }
        });
    }

    void detachView() {
        this.videoPlayerViewRef.clear();
    }

    void close() {
        this.videoPlayerViewRef.clear();
        this.videoPlayer.stop();
        this.videoPlayer.release();
    }

    void pause() {
        this.videoPlayer.pause();
    }

    void resume() {
        this.videoPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSurfaceAvailable(Surface surface) {
        this.videoPlayer.setSurface(surface);
        if (!this.onVideoComplete && this.videoPlayer.getCurrentPositionMillis() == 0) {
            this.videoPlayer.start();
            return;
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        videoPlayer.seekTo(videoPlayer.getCurrentPositionMillis());
        this.videoPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSurfaceDestroyed(Surface surface) {
        this.videoPlayer.setSurface(null);
        this.videoPlayer.pause();
    }

    void onViewMeasured(VideoPlayerView videoPlayerView, int i, int i2) {
        try {
            this.videoViewResizeManager.resizeToContainerSizes(videoPlayerView, i, i2, this.videoPlayer.getMediaWidth(), this.videoPlayer.getMediaHeight());
        } catch (Exception unused) {
            this.videoViewResizeManager.resizeToContainerSizes(videoPlayerView, i, i2, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onVideoClicked(final float f, final float f2) {
        Objects.onNotNull(this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter.Listener) obj).onVideoClicked(f, f2);
            }
        });
    }

    void onSkipClicked() {
        Objects.onNotNull(this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter.Listener) obj).onVideoSkipped();
            }
        });
        close();
    }

    void onMuteClicked() {
        this.videoPlayer.setVolume((this.videoPlayer.getCurrentVolume() > 0.0f ? 1 : (this.videoPlayer.getCurrentVolume() == 0.0f ? 0 : -1)) == 0 ? 1.0f : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressChanged(final long j) {
        final long duration = this.videoPlayer.getDuration();
        VideoSettings videoSettings = this.videoSettings;
        boolean z = videoSettings != null && videoSettings.isVideoSoundOn;
        if (this.lastRingerModeSetting != this.videoPlayer.getRingerMode()) {
            VideoPlayer videoPlayer = this.videoPlayer;
            videoPlayer.setVolume((videoPlayer.getRingerMode() == 2 && z) ? 1.0f : 0.0f);
        }
        this.lastRingerModeSetting = this.videoPlayer.getRingerMode();
        Objects.onNotNull(this.videoPlayerPresenterListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter.Listener) obj).onVideoProgressChange(j, duration);
            }
        });
        Objects.onNotNull((VideoPlayerView) this.videoPlayerViewRef.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerPresenter$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5740x443dcf94(j, duration, (VideoPlayerView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onProgressChanged$5$com-smaato-sdk-video-vast-vastplayer-VideoPlayerPresenter, reason: not valid java name */
    /* synthetic */ void m5740x443dcf94(long j, long j2, VideoPlayerView videoPlayerView) {
        videoPlayerView.updateProgressBar(j, j2);
        if (!this.onVideoComplete) {
            this.skipButtonVisibilityManager.onProgressChange(j, videoPlayerView);
        } else {
            this.skipButtonVisibilityManager.onVideoComplete(videoPlayerView);
        }
    }
}
