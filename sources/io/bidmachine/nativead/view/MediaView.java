package io.bidmachine.nativead.view;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.BidMachineVideoBridge;
import com.safedk.android.utils.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.nativead.NativeAdObject;
import io.bidmachine.nativead.NativeData;
import io.bidmachine.nativead.NativeInteractor;
import io.bidmachine.nativead.NativeMediaPrivateData;
import io.bidmachine.nativead.tasks.DownloadVastVideoTask;
import io.bidmachine.nativead.tasks.DownloadVideoTask;
import io.bidmachine.nativead.utils.ImageHelper;
import io.bidmachine.nativead.utils.NativeNetworkExecutor;
import io.bidmachine.utils.lazy.LazyValue;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class MediaView extends RelativeLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, VideoPlayerActivity.VideoPlayerActivityListener {
    private static final float ASPECT_MULTIPLIER_HEIGHT_TO_WIDTH = 1.7777778f;
    private static final float ASPECT_MULTIPLIER_WIDTH_TO_HEIGHT = 0.5625f;
    public static VideoPlayerActivity.VideoPlayerActivityListener listener;
    private volatile boolean error;
    private boolean finishedOrExpanded;
    private boolean hasVideo;
    private ImageView imageView;
    boolean isInitialized;
    private boolean isMuted;
    private boolean isVideoFinishNotified;
    private boolean isVideoStartNotified;
    private MediaPlayer mediaPlayer;
    private boolean mediaPlayerPrepared;
    private boolean mediaPlayerPreparing;
    private CircleCountdownView muteButton;
    NativeData nativeData;
    NativeInteractor nativeInteractor;
    NativeMediaPrivateData nativeMediaData;
    private ImageView playButton;
    private ProgressBar progressBarView;
    private int quartile;
    private boolean startPlayVideoWhenReady;
    private NativeState state;
    private TextureView textureView;
    private int videoDuration;
    private int videoHeight;
    private boolean videoSizeWasChanged;
    private Timer videoVisibilityCheckerTimer;
    private int videoWidth;
    private boolean viewOnScreen;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/nativead/view/MediaView;->onCompletion(Landroid/media/MediaPlayer;)V");
        CreativeInfoManager.onVideoCompleted("io.bidmachine", mediaPlayer, "media-player");
        safedk_MediaView_onCompletion_9a6fc569c4345f0055f4c344a0c3d77e(mediaPlayer);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    static /* synthetic */ int access$1708(MediaView mediaView) {
        int i = mediaView.quartile;
        mediaView.quartile = i + 1;
        return i;
    }

    public MediaView(Context context) {
        super(context);
        this.isInitialized = false;
        this.isMuted = true;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoSizeWasChanged = true;
        this.state = NativeState.Image;
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInitialized = false;
        this.isMuted = true;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoSizeWasChanged = true;
        this.state = NativeState.Image;
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInitialized = false;
        this.isMuted = true;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoSizeWasChanged = true;
        this.state = NativeState.Image;
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isInitialized = false;
        this.isMuted = true;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.videoSizeWasChanged = true;
        this.state = NativeState.Image;
    }

    public void setNativeAdObject(NativeAdObject nativeAdObject) {
        applyNative(nativeAdObject, nativeAdObject, nativeAdObject);
    }

    public void applyNative(NativeData nativeData, NativeMediaPrivateData nativeMediaPrivateData, NativeInteractor nativeInteractor) {
        this.nativeData = nativeData;
        this.nativeMediaData = nativeMediaPrivateData;
        this.nativeInteractor = nativeInteractor;
        if (nativeMediaPrivateData.getVideoUri() != null || !TextUtils.isEmpty(nativeData.getVideoUrl()) || !TextUtils.isEmpty(nativeData.getVideoAdm())) {
            this.hasVideo = true;
        }
        createView();
    }

    void createView() {
        if (!this.isInitialized) {
            this.isInitialized = true;
            ImageView imageView = new ImageView(getContext());
            this.imageView = imageView;
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.imageView.setAdjustViewBounds(true);
            addView(this.imageView);
            if (this.hasVideo) {
                int iRound = Math.round(Utils.getScreenDensity(getContext()) * 50.0f);
                this.progressBarView = new ProgressBar(getContext(), null, R.attr.progressBarStyleLarge);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iRound, iRound);
                layoutParams.addRule(13, -1);
                this.progressBarView.setLayoutParams(layoutParams);
                this.progressBarView.setBackgroundColor(Color.parseColor("#6b000000"));
                this.progressBarView.setVisibility(4);
                addView(this.progressBarView);
                ImageView imageView2 = new ImageView(getContext());
                this.playButton = imageView2;
                imageView2.setImageResource(R.drawable.ic_media_play);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iRound, iRound);
                layoutParams2.addRule(13, -1);
                this.playButton.setLayoutParams(layoutParams2);
                this.playButton.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.nativead.view.MediaView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MediaView.this.startPlayVideoWhenReady = true;
                        MediaView.this.tryPlayVideo();
                    }
                });
                this.playButton.setVisibility(4);
                addView(this.playButton);
                TextureView textureView = new TextureView(getContext());
                this.textureView = textureView;
                textureView.setSurfaceTextureListener(this);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(13);
                this.textureView.setLayoutParams(layoutParams3);
                this.textureView.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.nativead.view.MediaView.2
                    public static void safedk_Utils_startActivity_37db7eccde16e1b8fab21081e3ffdcc7(Context p0, Intent p1) {
                        Logger.d("SafeDK-Special|SafeDK: Call> Lio/bidmachine/core/Utils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
                        if (p1 == null) {
                            return;
                        }
                        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
                        Utils.startActivity(p0, p1);
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MediaView.this.nativeMediaData == null || MediaView.this.nativeMediaData.getVideoUri() == null) {
                            return;
                        }
                        io.bidmachine.core.Logger.d("Video has been clicked");
                        MediaView.listener = MediaView.this;
                        MediaView.this.finishedOrExpanded = true;
                        int currentPosition = (MediaView.this.isMediaPlayerAvailable() && MediaView.this.mediaPlayer.isPlaying()) ? MediaView.this.mediaPlayer.getCurrentPosition() : 0;
                        MediaView.this.pausePlayer();
                        safedk_Utils_startActivity_37db7eccde16e1b8fab21081e3ffdcc7(MediaView.this.getContext(), VideoPlayerActivity.getIntent(MediaView.this.getContext(), MediaView.this.nativeMediaData.getVideoUri().getPath(), currentPosition));
                    }
                });
                addView(this.textureView);
                createMuteButton();
                createMediaPlayer();
                NativeMediaPrivateData nativeMediaPrivateData = this.nativeMediaData;
                if (nativeMediaPrivateData != null && nativeMediaPrivateData.getVideoUri() != null && this.nativeMediaData.getVideoUri().getPath() != null && new File(this.nativeMediaData.getVideoUri().getPath()).exists()) {
                    this.startPlayVideoWhenReady = true;
                } else if (this.nativeData != null) {
                    updateViewState(NativeState.Loading);
                    if (!TextUtils.isEmpty(this.nativeData.getVideoUrl())) {
                        executeTask(new DownloadVideoTask(getContext(), new DownloadVideoTask.OnLoadedListener() { // from class: io.bidmachine.nativead.view.MediaView.3
                            @Override // io.bidmachine.nativead.tasks.DownloadVideoTask.OnLoadedListener
                            public void onVideoLoaded(DownloadVideoTask downloadVideoTask, Uri uri) {
                                io.bidmachine.core.Logger.d("MediaView video is loaded");
                                MediaView.this.nativeMediaData.setVideoUri(uri);
                                MediaView.this.prepareMediaPlayer();
                            }

                            @Override // io.bidmachine.nativead.tasks.DownloadVideoTask.OnLoadedListener
                            public void onVideoLoadingError(DownloadVideoTask downloadVideoTask) {
                                io.bidmachine.core.Logger.d("MediaView video is not loaded");
                                MediaView.this.updateViewState(NativeState.Image);
                                MediaView.this.hasVideo = false;
                            }
                        }, this.nativeData.getVideoUrl()));
                    } else if (!TextUtils.isEmpty(this.nativeData.getVideoAdm())) {
                        executeTask(new DownloadVastVideoTask(getContext(), new DownloadVastVideoTask.OnLoadedListener() { // from class: io.bidmachine.nativead.view.MediaView.4
                            @Override // io.bidmachine.nativead.tasks.DownloadVastVideoTask.OnLoadedListener
                            public void onVideoLoaded(DownloadVastVideoTask downloadVastVideoTask, Uri uri, VastRequest vastRequest) {
                                io.bidmachine.core.Logger.d("MediaView video is loaded");
                                MediaView.this.nativeMediaData.setVideoUri(uri);
                                MediaView.this.nativeMediaData.setVastRequest(vastRequest);
                                MediaView.this.prepareMediaPlayer();
                            }

                            @Override // io.bidmachine.nativead.tasks.DownloadVastVideoTask.OnLoadedListener
                            public void onVideoLoadingError(DownloadVastVideoTask downloadVastVideoTask) {
                                io.bidmachine.core.Logger.d("MediaView video is not loaded");
                                MediaView.this.updateViewState(NativeState.Image);
                                MediaView.this.hasVideo = false;
                            }
                        }, this.nativeData.getVideoAdm()));
                    }
                }
            } else {
                updateViewState(NativeState.Image);
            }
        }
        if (this.nativeMediaData != null) {
            ImageHelper.fillImageView(getContext(), this.imageView, this.nativeMediaData.getImageUri(), this.nativeMediaData.getImageDrawable());
        }
    }

    public void release() {
        new Thread(new Runnable() { // from class: io.bidmachine.nativead.view.MediaView.5
            @Override // java.lang.Runnable
            public void run() {
                MediaView.this.cleanUpMediaPlayer();
            }
        }).start();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (i == 0) {
            if (this.startPlayVideoWhenReady) {
                tryPlayVideo();
            }
        } else {
            pausePlayer();
        }
        super.onWindowVisibilityChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayer() {
        try {
            if (isMediaPlayerAvailable() && this.mediaPlayer.isPlaying()) {
                BidMachineVideoBridge.MediaPlayerPause(this.mediaPlayer);
            }
            if (this.state != NativeState.Loading) {
                updateViewState(NativeState.Paused);
            }
        } catch (Exception e) {
            io.bidmachine.core.Logger.w(e);
        }
    }

    private void createMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this);
        this.mediaPlayer.setOnErrorListener(this);
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnVideoSizeChangedListener(this);
        this.mediaPlayer.setAudioStreamType(3);
        updateVolume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareMediaPlayer() {
        NativeMediaPrivateData nativeMediaPrivateData;
        try {
            if (this.mediaPlayerPrepared || (nativeMediaPrivateData = this.nativeMediaData) == null || nativeMediaPrivateData.getVideoUri() == null || this.mediaPlayerPreparing || this.error) {
                return;
            }
            BidMachineVideoBridge.MediaPlayerSetDataSource(this.mediaPlayer, getContext(), this.nativeMediaData.getVideoUri());
            this.mediaPlayer.prepareAsync();
            this.mediaPlayerPreparing = true;
        } catch (Exception e) {
            io.bidmachine.core.Logger.w(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanUpMediaPlayer() {
        if (this.mediaPlayer != null) {
            try {
                if (!this.error) {
                    if (this.mediaPlayer.isPlaying()) {
                        BidMachineVideoBridge.MediaPlayerStop(this.mediaPlayer);
                    }
                    this.mediaPlayer.reset();
                }
                this.mediaPlayer.setOnCompletionListener(null);
                this.mediaPlayer.setOnErrorListener(null);
                this.mediaPlayer.setOnPreparedListener(null);
                this.mediaPlayer.setOnVideoSizeChangedListener(null);
                BidMachineVideoBridge.MediaPlayerRelease(this.mediaPlayer);
            } catch (Exception e) {
                io.bidmachine.core.Logger.w(e);
            }
            this.mediaPlayer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryPlayVideo() {
        try {
            if (this.mediaPlayer == null) {
                createMediaPlayer();
            }
            if (!this.mediaPlayerPrepared) {
                prepareMediaPlayer();
            }
            if (isMediaPlayerAvailable() && this.mediaPlayerPrepared && this.viewOnScreen && isAdOnScreen()) {
                if (!this.mediaPlayer.isPlaying()) {
                    BidMachineVideoBridge.MediaPlayerStart(this.mediaPlayer);
                    notifyVideoStarted();
                    if (this.videoVisibilityCheckerTimer == null) {
                        startVideoVisibilityCheckerTimer();
                    }
                }
                if (this.mediaPlayer.getCurrentPosition() <= 0 || this.state == NativeState.Playing) {
                    return;
                }
                updateViewState(NativeState.Playing);
            }
        } catch (Exception e) {
            io.bidmachine.core.Logger.w(e);
            clearPlayerOnError();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.nativead.view.MediaView$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$nativead$view$NativeState;

        static {
            int[] iArr = new int[NativeState.values().length];
            $SwitchMap$io$bidmachine$nativead$view$NativeState = iArr;
            try {
                iArr[NativeState.Image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$nativead$view$NativeState[NativeState.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$nativead$view$NativeState[NativeState.Playing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$nativead$view$NativeState[NativeState.Paused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewState(NativeState nativeState) {
        this.state = nativeState;
        int i = AnonymousClass9.$SwitchMap$io$bidmachine$nativead$view$NativeState[nativeState.ordinal()];
        if (i == 1) {
            ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.imageView.bringToFront();
            }
            if (this.hasVideo) {
                this.textureView.setVisibility(4);
                this.progressBarView.setVisibility(4);
                this.playButton.setVisibility(4);
                this.muteButton.setVisibility(4);
                return;
            }
            return;
        }
        if (i == 2) {
            ImageView imageView2 = this.imageView;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.imageView.bringToFront();
            }
            if (this.hasVideo) {
                this.progressBarView.setVisibility(0);
                this.progressBarView.bringToFront();
                this.textureView.setVisibility(4);
                this.playButton.setVisibility(4);
                this.muteButton.setVisibility(4);
                return;
            }
            return;
        }
        if (i == 3) {
            ImageView imageView3 = this.imageView;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
            if (this.hasVideo) {
                this.textureView.setVisibility(0);
                this.textureView.bringToFront();
                this.muteButton.setVisibility(0);
                this.muteButton.bringToFront();
                updateMuteButton();
                this.progressBarView.setVisibility(4);
                this.playButton.setVisibility(4);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        ImageView imageView4 = this.imageView;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
            this.imageView.bringToFront();
        }
        if (this.hasVideo) {
            this.playButton.setVisibility(0);
            this.playButton.bringToFront();
            this.textureView.setVisibility(4);
            this.progressBarView.setVisibility(4);
            this.muteButton.setVisibility(4);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, measuredWidth) : measuredWidth;
        }
        int i3 = (int) (size * ASPECT_MULTIPLIER_WIDTH_TO_HEIGHT);
        if (mode2 != 1073741824 || size2 >= i3) {
            size2 = i3;
        } else {
            size = (int) (size2 * ASPECT_MULTIPLIER_HEIGHT_TO_WIDTH);
        }
        if (Math.abs(size2 - measuredHeight) >= 2 || Math.abs(size - measuredWidth) >= 2) {
            getLayoutParams().width = size;
            getLayoutParams().height = size2;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateTextureLayoutParams();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            if (this.mediaPlayer == null) {
                createMediaPlayer();
            }
            BidMachineVideoBridge.MediaPlayerSetSurface(this.mediaPlayer, new Surface(surfaceTexture));
            prepareMediaPlayer();
        } catch (Exception e) {
            io.bidmachine.core.Logger.w(e);
            updateViewState(NativeState.Image);
            this.hasVideo = false;
        }
    }

    public void safedk_MediaView_onCompletion_9a6fc569c4345f0055f4c344a0c3d77e(MediaPlayer p0) {
        videoFinished();
    }

    private void videoFinished() {
        notifyVideoFinished();
        stopVideoVisibilityCheckerTimer();
        pausePlayer();
        if (isMediaPlayerAvailable()) {
            this.mediaPlayer.seekTo(0);
        }
        this.finishedOrExpanded = true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        io.bidmachine.core.Logger.d("MediaView: onError");
        clearPlayerOnError();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayerOnError() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.nativead.view.MediaView.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaView.this.startPlayVideoWhenReady = false;
                    MediaView.this.cleanUpMediaPlayer();
                    MediaView.this.updateViewState(NativeState.Image);
                    MediaView.this.stopVideoVisibilityCheckerTimer();
                    MediaView.this.error = true;
                    MediaView.this.hasVideo = false;
                    MediaView.this.processErrorEvent();
                } catch (Exception e) {
                    io.bidmachine.core.Logger.w(e);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        io.bidmachine.core.Logger.d("MediaView: onPrepared");
        this.mediaPlayerPrepared = true;
        if (this.startPlayVideoWhenReady) {
            tryPlayVideo();
        } else {
            updateViewState(NativeState.Paused);
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
        this.videoSizeWasChanged = true;
        updateTextureLayoutParams();
    }

    private void updateTextureLayoutParams() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0 || !this.videoSizeWasChanged || this.videoWidth == 0 || this.videoHeight == 0) {
            return;
        }
        this.videoSizeWasChanged = false;
        ViewGroup.LayoutParams layoutParams = this.textureView.getLayoutParams();
        int i = this.videoWidth;
        int i2 = this.videoHeight;
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (width * this.videoHeight) / this.videoWidth;
        } else {
            layoutParams.width = (i * height) / i2;
            layoutParams.height = height;
        }
        this.textureView.setLayoutParams(layoutParams);
    }

    public void onViewAppearOnScreen() {
        io.bidmachine.core.Logger.d("MediaView: onViewAppearOnScreen");
        this.viewOnScreen = true;
        if (this.startPlayVideoWhenReady) {
            tryPlayVideo();
        } else if (this.state != NativeState.Loading) {
            updateViewState(NativeState.Paused);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMediaPlayerAvailable() {
        return (this.error || this.mediaPlayer == null) ? false : true;
    }

    private void notifyVideoStarted() {
        if (this.isVideoStartNotified) {
            return;
        }
        processImpressions();
        this.isVideoStartNotified = true;
        io.bidmachine.core.Logger.d("MediaView: video started");
    }

    private void notifyVideoFinished() {
        if (this.isVideoFinishNotified) {
            return;
        }
        processEvent(TrackingEvent.complete);
        this.isVideoFinishNotified = true;
        io.bidmachine.core.Logger.d("MediaView: video finished");
    }

    private void createMuteButton() {
        Context context = getContext();
        float screenDensity = Utils.getScreenDensity(context);
        int iRound = Math.round(40.0f * screenDensity);
        int iRound2 = Math.round(screenDensity * 8.0f);
        CircleCountdownView circleCountdownView = new CircleCountdownView(context);
        this.muteButton = circleCountdownView;
        circleCountdownView.setColors(Assets.MAIN_ASSETS_COLOR, Assets.BACKGROUND_COLOR);
        this.muteButton.setPadding(iRound2, iRound2, iRound2, iRound2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iRound, iRound);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        this.muteButton.setLayoutParams(layoutParams);
        updateMuteButton();
        this.muteButton.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.nativead.view.MediaView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaView.this.isMediaPlayerAvailable()) {
                    if (MediaView.this.isMuted) {
                        MediaView.this.mediaPlayer.setVolume(1.0f, 1.0f);
                        MediaView.this.isMuted = false;
                    } else {
                        MediaView.this.mediaPlayer.setVolume(0.0f, 0.0f);
                        MediaView.this.isMuted = true;
                    }
                    MediaView.this.updateMuteButton();
                }
            }
        });
        addView(this.muteButton);
    }

    private void updateVolume() {
        if (isMediaPlayerAvailable()) {
            if (this.isMuted) {
                this.mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMuteButton() {
        CircleCountdownView circleCountdownView = this.muteButton;
        if (circleCountdownView != null) {
            if (this.isMuted) {
                circleCountdownView.setImage(Assets.getBitmapFromBase64(Assets.UNMUTE));
            } else {
                circleCountdownView.setImage(Assets.getBitmapFromBase64(Assets.MUTE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAdOnScreen() {
        return getGlobalVisibleRect(new Rect()) && isShown() && hasWindowFocus();
    }

    public void startVideoVisibilityCheckerTimer() {
        if (this.hasVideo) {
            Timer timer = new Timer();
            this.videoVisibilityCheckerTimer = timer;
            timer.schedule(new AnonymousClass8(), 0L, 500);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.nativead.view.MediaView$8, reason: invalid class name */
    class AnonymousClass8 extends TimerTask {
        AnonymousClass8() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final int currentPosition;
            try {
                if (MediaView.this.error) {
                    MediaView.this.clearPlayerOnError();
                    return;
                }
                if (MediaView.this.isAdOnScreen()) {
                    try {
                        if (MediaView.this.isMediaPlayerAvailable() && !MediaView.this.error && MediaView.this.mediaPlayer.isPlaying()) {
                            if (MediaView.this.videoDuration == 0) {
                                MediaView mediaView = MediaView.this;
                                mediaView.videoDuration = mediaView.mediaPlayer.getDuration();
                            }
                            if (MediaView.this.videoDuration != 0 && (currentPosition = (MediaView.this.mediaPlayer.getCurrentPosition() * 100) / MediaView.this.videoDuration) >= MediaView.this.quartile * 25) {
                                if (MediaView.this.quartile != 0) {
                                    if (MediaView.this.quartile != 1) {
                                        if (MediaView.this.quartile != 2) {
                                            if (MediaView.this.quartile == 3) {
                                                io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.MediaView$8$$ExternalSyntheticLambda3
                                                    @Override // io.bidmachine.utils.lazy.LazyValue
                                                    public final Object get() {
                                                        return String.format("Video at third quartile: %s%%", Integer.valueOf(currentPosition));
                                                    }
                                                });
                                                MediaView.this.processEvent(TrackingEvent.thirdQuartile);
                                            }
                                        } else {
                                            io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.MediaView$8$$ExternalSyntheticLambda2
                                                @Override // io.bidmachine.utils.lazy.LazyValue
                                                public final Object get() {
                                                    return String.format("Video at midpoint: %s%%", Integer.valueOf(currentPosition));
                                                }
                                            });
                                            MediaView.this.processEvent(TrackingEvent.midpoint);
                                        }
                                    } else {
                                        io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.MediaView$8$$ExternalSyntheticLambda1
                                            @Override // io.bidmachine.utils.lazy.LazyValue
                                            public final Object get() {
                                                return String.format("Video at first quartile: %s%%", Integer.valueOf(currentPosition));
                                            }
                                        });
                                        MediaView.this.processEvent(TrackingEvent.firstQuartile);
                                    }
                                } else {
                                    io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.MediaView$8$$ExternalSyntheticLambda0
                                        @Override // io.bidmachine.utils.lazy.LazyValue
                                        public final Object get() {
                                            return String.format("Video started: %s%%", Integer.valueOf(currentPosition));
                                        }
                                    });
                                    MediaView.this.processEvent(TrackingEvent.start);
                                }
                                MediaView.access$1708(MediaView.this);
                            }
                        }
                        io.bidmachine.core.Logger.d("MediaView is on screen");
                        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.nativead.view.MediaView.8.2
                            @Override // java.lang.Runnable
                            public void run() {
                                MediaView.this.tryPlayVideo();
                            }
                        });
                        return;
                    } catch (IllegalStateException unused) {
                        MediaView.this.clearPlayerOnError();
                        return;
                    }
                }
                Utils.onUiThread(new Runnable() { // from class: io.bidmachine.nativead.view.MediaView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaView.this.pausePlayer();
                        if (MediaView.this.finishedOrExpanded) {
                            MediaView.this.stopVideoVisibilityCheckerTimer();
                        }
                    }
                });
            } catch (Throwable unused2) {
                MediaView.this.clearPlayerOnError();
            }
        }
    }

    public void stopVideoVisibilityCheckerTimer() {
        Timer timer = this.videoVisibilityCheckerTimer;
        if (timer != null) {
            timer.cancel();
            this.videoVisibilityCheckerTimer = null;
        }
    }

    private void executeTask(Runnable runnable) {
        NativeNetworkExecutor.getInstance().execute(runnable);
    }

    private void processImpressions() {
        NativeMediaPrivateData nativeMediaPrivateData = this.nativeMediaData;
        if (nativeMediaPrivateData == null || nativeMediaPrivateData.getVastRequest() == null || this.nativeMediaData.getVastRequest().getVastAd() == null) {
            return;
        }
        fireUrls(this.nativeMediaData.getVastRequest().getVastAd().getImpressionUrlList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processEvent(TrackingEvent trackingEvent) {
        NativeInteractor nativeInteractor;
        NativeMediaPrivateData nativeMediaPrivateData = this.nativeMediaData;
        if (nativeMediaPrivateData != null && nativeMediaPrivateData.getVastRequest() != null && this.nativeMediaData.getVastRequest().getVastAd() != null) {
            fireUrls(this.nativeMediaData.getVastRequest().getVastAd().getTrackingEventListMap().get(trackingEvent));
        }
        if (trackingEvent != TrackingEvent.complete || (nativeInteractor = this.nativeInteractor) == null) {
            return;
        }
        nativeInteractor.dispatchVideoPlayFinished();
    }

    private void fireUrls(List<String> list) {
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Utils.simpleTrackUrl(it.next(), NativeNetworkExecutor.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processErrorEvent() {
        NativeMediaPrivateData nativeMediaPrivateData = this.nativeMediaData;
        if (nativeMediaPrivateData == null || nativeMediaPrivateData.getVastRequest() == null) {
            return;
        }
        this.nativeMediaData.getVastRequest().sendVastSpecError(VastSpecError.SHOWING);
    }

    @Override // io.bidmachine.nativead.view.VideoPlayerActivity.VideoPlayerActivityListener
    public void videoPlayerActivityClosed(final int i, final boolean z) {
        io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.MediaView$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("MediaView videoPlayerActivityClosed, position: %s, finished: %s", Integer.valueOf(i), Boolean.valueOf(z));
            }
        });
        try {
            if (z) {
                videoFinished();
            } else if (isMediaPlayerAvailable()) {
                this.mediaPlayer.seekTo(i);
            }
        } catch (Exception e) {
            io.bidmachine.core.Logger.w(e);
        }
        listener = null;
    }
}
