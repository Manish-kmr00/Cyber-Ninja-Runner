package com.smaato.sdk.video.vast.vastplayer.system;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.utils.EventValidator;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerAction;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerState;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerTransition;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayer;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayerCreator;

/* JADX INFO: loaded from: classes12.dex */
public class SystemMediaPlayerCreator implements VideoPlayerCreator {
    AudioManager audioManager;
    private final Context context;
    private final MediaPlayer mediaPlayer;
    private final EventValidator mediaPlayerActionsValidator;
    private final EventValidator mediaPlayerTransitionsValidator;
    private final SystemMediaPlayerStateMachineFactory systemMediaPlayerStateMachineFactory;

    public SystemMediaPlayerCreator(Context context, SystemMediaPlayerStateMachineFactory systemMediaPlayerStateMachineFactory, EventValidator<MediaPlayerAction, MediaPlayerState> eventValidator, EventValidator<MediaPlayerTransition, MediaPlayerState> eventValidator2, MediaPlayer mediaPlayer, AudioManager audioManager) {
        this.context = (Context) Objects.requireNonNull(context);
        this.systemMediaPlayerStateMachineFactory = (SystemMediaPlayerStateMachineFactory) Objects.requireNonNull(systemMediaPlayerStateMachineFactory);
        this.mediaPlayerActionsValidator = (EventValidator) Objects.requireNonNull(eventValidator);
        this.mediaPlayerTransitionsValidator = (EventValidator) Objects.requireNonNull(eventValidator2);
        this.mediaPlayer = mediaPlayer;
        this.audioManager = audioManager;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerCreator
    public VideoPlayer createVideoPlayer(Logger logger) {
        Objects.requireNonNull(logger);
        return new SystemMediaPlayer(this.context, this.mediaPlayer, this.systemMediaPlayerStateMachineFactory.create(), this.mediaPlayerActionsValidator, this.mediaPlayerTransitionsValidator, this.audioManager, logger);
    }
}
