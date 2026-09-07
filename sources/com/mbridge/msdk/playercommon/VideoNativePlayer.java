package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes8.dex */
public class VideoNativePlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final int INTERVAL_TIME_PLAY_TIME_PROGRESS = 100;
    public static final String TAG = "VideoNativePlayer";
    private SimpleExoPlayer exoPlayer;
    private Timer mBufferTimeoutTimer;
    private long mCurrentPosition;
    private VideoPlayerStatusListener mInnerVFPLisener;
    private View mLoadingView;
    private String mNetUrl;
    private VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private Surface mSurfaceHolder;
    private MediaSource mediaSource;
    private boolean mIsComplete = false;
    private boolean mIsPlaying = false;
    private boolean mHasPrepare = false;
    private boolean mIsStartPlay = true;
    private boolean mIsAllowLoopPlay = true;
    private boolean mHasChaoDi = false;
    private boolean mIsBuffering = false;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsFrontDesk = true;
    private int mBufferTime = 5;
    private boolean mIsOpenSound = true;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    private Runnable playProgressRunnable = new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer == null || !VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                int i = (int) (VideoNativePlayer.this.mCurrentPosition / 1000);
                o0.c(VideoNativePlayer.TAG, "currentPosition:" + i + " mCurrentPosition:" + VideoNativePlayer.this.mCurrentPosition);
                int duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0 : (int) (VideoNativePlayer.this.exoPlayer.getDuration() / 1000);
                if (VideoNativePlayer.this.mIsStartPlay) {
                    VideoNativePlayer.this.postOnPlayStartOnMainThread(duration);
                    o0.c(VideoNativePlayer.TAG, "onPlayStarted()");
                    VideoNativePlayer.this.mIsStartPlay = false;
                }
                if (i >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer.this.postOnPlayProgressOnMainThread(i, duration);
                }
                VideoNativePlayer.this.mIsComplete = false;
                if (!VideoNativePlayer.this.mIsBuffering) {
                    VideoNativePlayer.this.hideLoading();
                }
                VideoNativePlayer.this.mHandler.postDelayed(this, 1000L);
            } catch (Exception e) {
                o0.b(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };
    private Runnable playProgressMSRunnable = new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer == null || !VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                long j = VideoNativePlayer.this.mCurrentPosition / 100;
                long duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0L : VideoNativePlayer.this.exoPlayer.getDuration() / 100;
                if (j >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer2 = VideoNativePlayer.this;
                    videoNativePlayer2.postOnPlayProgressMSOnMainThread(videoNativePlayer2.mCurrentPosition / 100, duration);
                }
                VideoNativePlayer.this.mHandler.postDelayed(this, 100L);
            } catch (Exception e) {
                o0.b(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };

    private void cancelBufferTimeoutTimer() {
        try {
            Timer timer = this.mBufferTimeoutTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
            this.mHandler.removeCallbacks(this.playProgressMSRunnable);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoNativePlayer.this.mLoadingView != null) {
                        VideoNativePlayer.this.mLoadingView.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingEnd();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingEnd();
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingStart(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingStart(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayCompleted();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayCompleted();
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayError(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayError(str);
                        }
                    }
                });
            }
            j.a(42, this.mPlayUrl, str);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressMSOnMainThread(final long j, final long j2) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgressMS((int) j, (int) j2);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgressMS((int) j, (int) j2);
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i, final int i2) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgress(i, i2);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgress(i, i2);
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                        }
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayStartOnMainThread(final int i) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayStarted(i);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayStarted(i);
                        }
                    }
                });
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    private void startBufferingTimer(final String str) {
        if (!this.mIsNeedBufferingTimeout) {
            o0.b(TAG, "不需要缓冲超时功能");
            return;
        }
        cancelBufferTimeoutTimer();
        Timer timer = new Timer();
        this.mBufferTimeoutTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (!VideoNativePlayer.this.mHasPrepare || VideoNativePlayer.this.mIsBuffering) {
                        o0.b(VideoNativePlayer.TAG, "缓冲超时");
                        VideoNativePlayer.this.postOnBufferingStarOnMainThread(str);
                    }
                } catch (Exception e) {
                    o0.b(VideoNativePlayer.TAG, e.getMessage());
                }
            }
        }, this.mBufferTime * 1000);
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
            this.mHandler.post(this.playProgressMSRunnable);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void closeSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setVolume(0.0f);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.getPlaybackState() == 3 && this.exoPlayer.getPlayWhenReady();
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void initBufferIngParam(int i) {
        if (i > 0) {
            this.mBufferTime = i;
        }
        this.mIsNeedBufferingTimeout = true;
        o0.c(TAG, "mIsNeedBufferingTimeout:" + this.mIsNeedBufferingTimeout + "  mMaxBufferTime:" + this.mBufferTime);
    }

    public boolean initParameter(String str, boolean z, boolean z2, View view, VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                o0.c(TAG, "netUrl为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            }
            if (view == null) {
                o0.c(TAG, "loadingView为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            }
            this.mIsOpenSound = z;
            this.mIsAllowLoopPlay = z2;
            this.mLoadingView = view;
            this.mNetUrl = str;
            this.mOutterVFListener = videoPlayerStatusListener;
            return true;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public boolean isPlayIng() {
        try {
            return this.exoPlayer != null && exoPlayerIsPlaying();
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        return exoPlayerIsPlaying();
    }

    public boolean loadingViewIsVisible() {
        try {
            View view = this.mLoadingView;
            return view != null && view.getVisibility() == 0;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return false;
        }
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0L;
            hideLoading();
            postOnPlayCompletedOnMainThread();
            o0.c(TAG, "======onCompletion");
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public boolean onError(int i, String str) {
        try {
            o0.b(TAG, "onError what:" + i + " extra:" + str);
            hideLoading();
            this.mHasPrepare = false;
            this.mIsPlaying = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            return true;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        o0.b(TAG, "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        o0.b(TAG, "onPlaybackStateChanged : " + i);
        if (i == 1) {
            o0.b(TAG, "onPlaybackStateChanged : IDLE");
            return;
        }
        if (i == 2) {
            o0.b(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferingTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
            return;
        }
        if (i == 3) {
            o0.b(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
            return;
        }
        if (i != 4) {
            return;
        }
        o0.b(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
        cancelPlayProgressTimer();
        onCompletion();
        if (this.mIsAllowLoopPlay) {
            return;
        }
        this.mHasPrepare = false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
        o0.b(TAG, "onPositionDiscontinuity : " + i);
        if (i == 0) {
            onCompletion();
        }
    }

    public void onPrepared() {
        try {
            o0.c(TAG, "onPrepared:" + this.mHasPrepare);
            if (!this.mIsFrontDesk) {
                o0.b(TAG, "At background, Do not process");
                return;
            }
            this.mHasPrepare = true;
            postOnBufferinEndOnMainThread();
            startPlayProgressTimer();
            if (this.exoPlayer != null) {
                this.mIsPlaying = true;
            }
            o0.c(TAG, "onprepare mCurrentPosition:" + this.mCurrentPosition + " mHasPrepare：" + this.mHasPrepare);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void openSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setVolume(1.0f);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            o0.c(TAG, "player pause");
            if (!this.mHasPrepare) {
                o0.c(TAG, "pause !mHasPrepare retrun");
                return;
            }
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return;
            }
            o0.c(TAG, "pause " + this.mIsPlaying);
            hideLoading();
            this.exoPlayer.setPlayWhenReady(false);
            this.mIsPlaying = false;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void play(Context context, String str, int i) {
        try {
            o0.b(TAG, "进来播放 currentionPosition:" + this.mCurrentPosition);
            this.mCurrentPosition = i;
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            setDataSource(context);
            o0.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void releasePlayer() {
        try {
            o0.c(TAG, "releasePlayer");
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.exoPlayer = null;
                this.mIsPlaying = false;
            }
            if (this.mOutterVFListener != null) {
                this.mOutterVFListener = null;
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage(), th);
        }
        hideLoading();
    }

    public void replaySameSource(Context context, String str, Surface surface) {
        MediaSource mediaSource;
        try {
            showLoading();
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null || (mediaSource = this.mediaSource) == null) {
                play(context, str, surface);
            } else {
                simpleExoPlayer.prepare(mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
            }
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void setDataSource(Context context) {
        try {
            o0.c(TAG, "setDataSource begin");
            if (this.exoPlayer != null) {
                try {
                    if (exoPlayerIsPlaying()) {
                        this.exoPlayer.stop();
                    }
                    this.exoPlayer.release();
                } catch (Throwable th) {
                    o0.b(TAG, th.getMessage());
                }
            }
            if (!this.mIsOpenSound) {
                closeSound();
            }
            if (!TextUtils.isEmpty(this.mPlayUrl)) {
                this.exoPlayer = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(context), new DefaultTrackSelector(), new DefaultLoadControl());
                Uri uri = Uri.parse(this.mPlayUrl);
                if (this.mPlayUrl.startsWith("http") || this.mPlayUrl.startsWith("https")) {
                    this.mediaSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("MBridge_ExoPlayer")).createMediaSource(uri);
                } else {
                    this.mediaSource = new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(context, "MBridge_ExoPlayer")).createMediaSource(uri);
                }
                this.exoPlayer.setRepeatMode(this.mIsAllowLoopPlay ? 2 : 0);
                this.exoPlayer.prepare(this.mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
                this.exoPlayer.addListener(this);
            }
            Surface surface = this.mSurfaceHolder;
            if (surface != null) {
                this.exoPlayer.setVideoSurface(surface);
            }
            startBufferingTimer(PlayerErrorConstant.PREPARE_TIMEOUT);
            o0.c(TAG, "setDataSource done");
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            hideLoading();
            if (URLUtil.isNetworkUrl(this.mPlayUrl)) {
                o0.c(TAG, "setDataSource error : Is Online source : " + this.mNetUrl);
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
                postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.SET_DATA_SOURCE_ERROR);
            } else if (TextUtils.isEmpty(this.mNetUrl) || this.mHasChaoDi) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
            } else {
                this.mHasChaoDi = true;
                o0.c(TAG, "setDataSource error : Will play online source : " + this.mNetUrl);
                this.mPlayUrl = this.mNetUrl;
                showLoading();
                setDataSource(context);
            }
            postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.SET_DATA_SOURCE_ERROR);
        }
    }

    public void setIsComplete(boolean z) {
        this.mIsComplete = z;
    }

    public void setIsFrontDesk(boolean z) {
        try {
            this.mIsFrontDesk = z;
            o0.b(TAG, "isFrontDesk: ".concat(z ? "frontStage" : "backStage"));
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void showLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoNativePlayer.this.mLoadingView != null) {
                        VideoNativePlayer.this.mLoadingView.setVisibility(0);
                    }
                }
            });
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void start() {
        start((Surface) null);
    }

    public void stop() {
        try {
            if (!this.mHasPrepare) {
                o0.c(TAG, "stop !mHasPrepare retrun");
                return;
            }
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return;
            }
            hideLoading();
            this.exoPlayer.stop();
            cancelPlayProgressTimer();
            this.mIsPlaying = false;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void start(Surface surface) {
        try {
            if (!this.mHasPrepare) {
                o0.c(TAG, "start !mHasPrepare retrun");
                return;
            }
            boolean z = true;
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                StringBuilder sb = new StringBuilder("exoplayer is null : ");
                if (this.exoPlayer != null) {
                    z = false;
                }
                o0.c(TAG, sb.append(z).toString());
                return;
            }
            showLoading();
            if (surface != null) {
                this.mSurfaceHolder = surface;
                this.exoPlayer.setVideoSurface(surface);
            }
            play();
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        String message;
        if (exoPlaybackException != null) {
            int i = exoPlaybackException.type;
            if (i == 0) {
                message = "Play error, because have a SourceException.";
            } else if (i == 1) {
                message = "Play error, because have a RendererException.";
            } else if (i == 2) {
                message = "Play error, because have a UnexpectedException.";
            } else {
                message = "Play error and ExoPlayer have not message.";
            }
        } else {
            message = "Play error and ExoPlayer have not message.";
        }
        if (exoPlaybackException.getCause() != null && !TextUtils.isEmpty(exoPlaybackException.getCause().getMessage())) {
            message = exoPlaybackException.getCause().getMessage();
        }
        o0.b(TAG, "onPlayerError : " + message);
        onError(exoPlaybackException.type, message);
    }

    public void play(Context context, String str, Surface surface) {
        try {
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            this.mSurfaceHolder = surface;
            setDataSource(context);
            o0.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void start(int i) {
        try {
            if (!this.mHasPrepare) {
                o0.c(TAG, "start mHasprepare is false return");
                return;
            }
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                return;
            }
            if (i > 0) {
                this.exoPlayer.seekTo(i);
            }
            play();
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }

    public void play() {
        try {
            this.exoPlayer.setPlayWhenReady(true);
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            o0.b(TAG, e.getMessage());
        }
    }
}
