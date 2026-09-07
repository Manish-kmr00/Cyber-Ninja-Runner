package com.smaato.sdk.video.vast.vastplayer.system;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.SmaatoVideoBridge;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Metadata;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.utils.EventValidator;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerAction;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerState;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerTransition;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayer;
import com.smaato.sdk.video.vast.vastplayer.exception.VideoPlayerException;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class SystemMediaPlayer implements VideoPlayer {
    AudioManager audioManager;
    private final Context context;
    private VideoPlayer.LifecycleListener lifecycleListener;
    private final Logger logger;
    private final MediaPlayer mediaPlayer;
    private final EventValidator mediaPlayerActionsValidator;
    private final StateMachine mediaPlayerStatMachine;
    private final EventValidator mediaPlayerTransitionsValidator;
    private VideoPlayer.PrepareListener prepareListener;
    private VideoPlayer.OnVolumeChangeListener volumeChangeListener;
    private float currentVolume = -1.0f;
    private long videoPausedAt = 0;
    boolean isCompleted = false;

    SystemMediaPlayer(Context context, MediaPlayer mediaPlayer, StateMachine<MediaPlayerTransition, MediaPlayerState> stateMachine, EventValidator<MediaPlayerAction, MediaPlayerState> eventValidator, EventValidator<MediaPlayerTransition, MediaPlayerState> eventValidator2, AudioManager audioManager, Logger logger) {
        this.context = (Context) Objects.requireNonNull(context, "Parameter context should not be null for SystemMediaPlayer::new");
        MediaPlayer mediaPlayer2 = (MediaPlayer) Objects.requireNonNull(mediaPlayer, "Parameter mediaPlayer should not be null for SystemMediaPlayer::new");
        this.mediaPlayer = mediaPlayer2;
        this.mediaPlayerStatMachine = (StateMachine) Objects.requireNonNull(stateMachine, "Parameter mediaPlayerStatMachine should not be null for SystemMediaPlayer::new");
        this.mediaPlayerActionsValidator = (EventValidator) Objects.requireNonNull(eventValidator, "Parameter mediaPlayerActionsValidator should not be null for SystemMediaPlayer::new");
        this.mediaPlayerTransitionsValidator = (EventValidator) Objects.requireNonNull(eventValidator2, "Parameter mediaPlayerTransitionsValidator should not be null for SystemMediaPlayer::new");
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger should not be null for SystemMediaPlayer::new");
        this.audioManager = audioManager;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer3) {
                com.safedk.android.utils.Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/video/vast/vastplayer/system/SystemMediaPlayer$$ExternalSyntheticLambda0;->onCompletion(Landroid/media/MediaPlayer;)V");
                CreativeInfoManager.onVideoCompleted(h.v, mediaPlayer3, "media-player");
                safedk_SystemMediaPlayer$$ExternalSyntheticLambda0_onCompletion_ba72b921c3d4f47c1d407629dd1ff7e2(mediaPlayer3);
            }

            public void safedk_SystemMediaPlayer$$ExternalSyntheticLambda0_onCompletion_ba72b921c3d4f47c1d407629dd1ff7e2(MediaPlayer p0) {
                this.f$0.onCompletion(p0);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer3, int i, int i2) {
                return this.f$0.onError(mediaPlayer3, i, i2);
            }
        });
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer3, int i, int i2) {
                return this.f$0.onInfo(mediaPlayer3, i, i2);
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer3) {
                this.f$0.onPrepared(mediaPlayer3);
            }
        });
        mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer mediaPlayer3) {
                this.f$0.onSeekComplete(mediaPlayer3);
            }
        });
        stateMachine.addListener(new StateMachine.Listener() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.StateMachine.Listener
            public final void onStateChanged(Object obj, Object obj2, Metadata metadata) {
                this.f$0.onStateChanged((MediaPlayerState) obj, (MediaPlayerState) obj2, metadata);
            }
        });
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 != null) {
            mediaPlayer2.setAudioSessionId(audioManager2.generateAudioSessionId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (!isValidStateForAction(MediaPlayerAction.SEEK_TO) || this.lifecycleListener == null) {
            return;
        }
        if (!this.isCompleted) {
            SmaatoVideoBridge.MediaPlayerStart(mediaPlayer);
        }
        this.lifecycleListener.onSeekComplete(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.ON_COMPLETE;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        } else {
            this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.ON_PREPARED;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        } else {
            this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        this.logger.info(LogDomain.VAST, "MediaPlayer Info: [what: %d, extra: %d]; For more details check android.media.MediaPlayer info codes", Integer.valueOf(i), Integer.valueOf(i2));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.logger.error(LogDomain.VAST, "MediaPlayer Error: [what: %d, extra: %d]; For more details check android.media.MediaPlayer error codes", Integer.valueOf(i), Integer.valueOf(i2));
        this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR, MetadataMapperUtils.mapToMetadata(i, i2));
        return true;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState;

        static {
            int[] iArr = new int[MediaPlayerState.values().length];
            $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState = iArr;
            try {
                iArr[MediaPlayerState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.PREPARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.PREPARED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.RESUMED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.STOPPED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.PLAYBACK_COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[MediaPlayerState.END.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChanged(MediaPlayerState mediaPlayerState, MediaPlayerState mediaPlayerState2, Metadata metadata) {
        switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$video$vast$vastplayer$MediaPlayerState[mediaPlayerState2.ordinal()]) {
            case 1:
                VideoPlayer.LifecycleListener lifecycleListener = this.lifecycleListener;
                if (lifecycleListener != null) {
                    lifecycleListener.onReset(this);
                    return;
                }
                return;
            case 2:
                VideoPlayer.PrepareListener prepareListener = this.prepareListener;
                if (prepareListener != null) {
                    prepareListener.onInitialized(this);
                    return;
                }
                return;
            case 3:
                VideoPlayer.PrepareListener prepareListener2 = this.prepareListener;
                if (prepareListener2 != null) {
                    prepareListener2.onPreparing(this);
                    return;
                }
                return;
            case 4:
                VideoPlayer.PrepareListener prepareListener3 = this.prepareListener;
                if (prepareListener3 != null) {
                    prepareListener3.onPrepared(this);
                    return;
                }
                return;
            case 5:
                VideoPlayer.LifecycleListener lifecycleListener2 = this.lifecycleListener;
                if (lifecycleListener2 != null) {
                    lifecycleListener2.onStarted(this);
                    return;
                }
                return;
            case 6:
                VideoPlayer.LifecycleListener lifecycleListener3 = this.lifecycleListener;
                if (lifecycleListener3 != null) {
                    lifecycleListener3.onResumed(this);
                    return;
                }
                return;
            case 7:
                VideoPlayer.LifecycleListener lifecycleListener4 = this.lifecycleListener;
                if (lifecycleListener4 != null) {
                    lifecycleListener4.onPaused(this);
                    return;
                }
                return;
            case 8:
                VideoPlayer.LifecycleListener lifecycleListener5 = this.lifecycleListener;
                if (lifecycleListener5 != null) {
                    lifecycleListener5.onStopped(this);
                    return;
                }
                return;
            case 9:
                VideoPlayer.LifecycleListener lifecycleListener6 = this.lifecycleListener;
                if (lifecycleListener6 != null) {
                    lifecycleListener6.onCompleted(this);
                    return;
                }
                return;
            case 10:
                VideoPlayerException videoPlayerExceptionMapToVideoPlayerException = MetadataMapperUtils.mapToVideoPlayerException(metadata);
                VideoPlayer.LifecycleListener lifecycleListener7 = this.lifecycleListener;
                if (lifecycleListener7 != null) {
                    lifecycleListener7.onError(this, videoPlayerExceptionMapToVideoPlayerException);
                }
                VideoPlayer.PrepareListener prepareListener4 = this.prepareListener;
                if (prepareListener4 != null) {
                    prepareListener4.onError(this, videoPlayerExceptionMapToVideoPlayerException);
                    return;
                }
                return;
            case 11:
                VideoPlayer.LifecycleListener lifecycleListener8 = this.lifecycleListener;
                if (lifecycleListener8 != null) {
                    lifecycleListener8.onReleased(this);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("Unexpected MediaPlayerState: %s", mediaPlayerState2));
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setDataSource(Uri uri) {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.SET_DATA_SOURCE;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            try {
                SmaatoVideoBridge.MediaPlayerSetDataSource(this.mediaPlayer, this.context, uri);
                this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
            } catch (IOException | IllegalArgumentException | SecurityException e) {
                this.logger.error(LogDomain.VAST, "Unable to set DataSource uri:[%s] to MediaPlayer. Exception %s", uri, e);
                this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR);
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setDataSource(String str) {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.SET_DATA_SOURCE;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            try {
                SmaatoVideoBridge.MediaPlayerSetDataSource(this.mediaPlayer, str);
                this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
            } catch (IOException | IllegalArgumentException | SecurityException e) {
                this.logger.error(LogDomain.VAST, "Unable to set DataSource path:[%s] to MediaPlayer. Exception %s", str, e);
                this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR);
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void prepare() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.PREPARE_ASYNC;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            try {
                this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
                this.mediaPlayer.prepare();
            } catch (IOException e) {
                this.logger.error(LogDomain.VAST, "Unable to prepare DataSource for MediaPlayer. Exception %s", e);
                this.mediaPlayerStatMachine.onEvent(MediaPlayerTransition.ON_ERROR);
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void start() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.START;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            long j = this.videoPausedAt;
            if (j > 0) {
                seekTo(j);
            } else {
                SmaatoVideoBridge.MediaPlayerStart(this.mediaPlayer);
            }
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void pause() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.PAUSE;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            SmaatoVideoBridge.MediaPlayerPause(this.mediaPlayer);
            this.videoPausedAt = this.isCompleted ? getDuration() : getCurrentPositionMillis();
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void stop() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.STOP;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            SmaatoVideoBridge.MediaPlayerStop(this.mediaPlayer);
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void seekTo(long j) {
        if (this.isCompleted) {
            j = getDuration() - 100;
        }
        if (isValidStateForAction(MediaPlayerAction.SEEK_TO)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mediaPlayer.seekTo(j, 3);
            } else {
                this.mediaPlayer.seekTo((int) j);
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void reset() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.RESET;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            this.mediaPlayer.reset();
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void release() {
        MediaPlayerTransition mediaPlayerTransition = MediaPlayerTransition.RELEASE;
        if (isValidStateForTransition(mediaPlayerTransition)) {
            SmaatoVideoBridge.MediaPlayerRelease(this.mediaPlayer);
            this.mediaPlayer.setOnCompletionListener(null);
            this.mediaPlayer.setOnErrorListener(null);
            this.mediaPlayer.setOnInfoListener(null);
            this.mediaPlayer.setOnPreparedListener(null);
            this.mediaPlayer.setOnSeekCompleteListener(null);
            this.volumeChangeListener = null;
            this.mediaPlayerStatMachine.onEvent(mediaPlayerTransition);
            this.mediaPlayerStatMachine.deleteListeners();
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setPrepareListener(VideoPlayer.PrepareListener prepareListener) {
        this.prepareListener = prepareListener;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setLifecycleListener(VideoPlayer.LifecycleListener lifecycleListener) {
        this.lifecycleListener = lifecycleListener;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setSurface(Surface surface) {
        if (isValidStateForAction(MediaPlayerAction.SET_SURFACE)) {
            SmaatoVideoBridge.MediaPlayerSetSurface(this.mediaPlayer, surface);
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setOnVolumeChangeListener(VideoPlayer.OnVolumeChangeListener onVolumeChangeListener) {
        this.volumeChangeListener = onVolumeChangeListener;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void setVolume(float f) {
        if (Math.abs(f - this.currentVolume) <= 0.0f || !isValidStateForAction(MediaPlayerAction.SET_VOLUME)) {
            return;
        }
        this.mediaPlayer.setVolume(f, f);
        this.currentVolume = f;
        Objects.onNotNull(this.volumeChangeListener, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.system.SystemMediaPlayer$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5759x4272768f((VideoPlayer.OnVolumeChangeListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setVolume$0$com-smaato-sdk-video-vast-vastplayer-system-SystemMediaPlayer, reason: not valid java name */
    /* synthetic */ void m5759x4272768f(VideoPlayer.OnVolumeChangeListener onVolumeChangeListener) {
        onVolumeChangeListener.onVolumeChanged(this.currentVolume);
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public float getCurrentVolume() {
        return this.currentVolume;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public int getRingerMode() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return 0;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public long getCurrentPositionMillis() {
        if (isValidStateForAction(MediaPlayerAction.GET_CURRENT_POSITION)) {
            return this.mediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public long getDuration() {
        if (isValidStateForAction(MediaPlayerAction.GET_DURATION)) {
            return this.mediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public int getMediaWidth() {
        return this.mediaPlayer.getVideoWidth();
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public int getMediaHeight() {
        return this.mediaPlayer.getVideoHeight();
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayer
    public void isCompleted(boolean z) {
        this.isCompleted = z;
    }

    public MediaPlayerState getState() {
        return (MediaPlayerState) this.mediaPlayerStatMachine.getCurrentState();
    }

    private boolean isValidStateForAction(MediaPlayerAction mediaPlayerAction) {
        MediaPlayerState mediaPlayerState = (MediaPlayerState) this.mediaPlayerStatMachine.getCurrentState();
        if (this.mediaPlayerActionsValidator.isValid(mediaPlayerAction, mediaPlayerState)) {
            return true;
        }
        this.logger.error(LogDomain.VAST, "Invalid MediaPlayer state: %s, for action: %s ", mediaPlayerState, mediaPlayerAction);
        return false;
    }

    private boolean isValidStateForTransition(MediaPlayerTransition mediaPlayerTransition) {
        MediaPlayerState mediaPlayerState = (MediaPlayerState) this.mediaPlayerStatMachine.getCurrentState();
        if (this.mediaPlayerTransitionsValidator.isValid(mediaPlayerTransition, mediaPlayerState)) {
            return true;
        }
        this.logger.error(LogDomain.VAST, "Invalid MediaPlayer state: %s, for transition: %s ", mediaPlayerState, mediaPlayerTransition);
        return false;
    }
}
