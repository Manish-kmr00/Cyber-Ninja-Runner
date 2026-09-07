package com.smaato.sdk.video.vast.vastplayer;

import android.net.Uri;
import android.view.Surface;
import com.smaato.sdk.video.vast.vastplayer.exception.VideoPlayerException;

/* JADX INFO: loaded from: classes5.dex */
public interface VideoPlayer {

    public interface LifecycleListener {
        void onCompleted(VideoPlayer videoPlayer);

        void onError(VideoPlayer videoPlayer, VideoPlayerException videoPlayerException);

        void onPaused(VideoPlayer videoPlayer);

        void onReleased(VideoPlayer videoPlayer);

        void onReset(VideoPlayer videoPlayer);

        void onResumed(VideoPlayer videoPlayer);

        void onSeekComplete(VideoPlayer videoPlayer);

        void onStarted(VideoPlayer videoPlayer);

        void onStopped(VideoPlayer videoPlayer);
    }

    public interface OnVolumeChangeListener {
        void onVolumeChanged(float f);
    }

    public interface PrepareListener {
        void onError(VideoPlayer videoPlayer, VideoPlayerException videoPlayerException);

        void onInitialized(VideoPlayer videoPlayer);

        void onPrepared(VideoPlayer videoPlayer);

        void onPreparing(VideoPlayer videoPlayer);
    }

    long getCurrentPositionMillis();

    float getCurrentVolume();

    long getDuration();

    int getMediaHeight();

    int getMediaWidth();

    int getRingerMode();

    void isCompleted(boolean z);

    void pause();

    void prepare();

    void release();

    void reset();

    void seekTo(long j);

    void setDataSource(Uri uri);

    void setDataSource(String str);

    void setLifecycleListener(LifecycleListener lifecycleListener);

    void setOnVolumeChangeListener(OnVolumeChangeListener onVolumeChangeListener);

    void setPrepareListener(PrepareListener prepareListener);

    void setSurface(Surface surface);

    void setVolume(float f);

    void start();

    void stop();
}
