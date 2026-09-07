package com.smaato.sdk.video.vast.vastplayer.system;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.video.utils.EventValidator;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerAction;
import com.smaato.sdk.video.vast.vastplayer.MediaPlayerState;
import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public class SystemMediaPlayerActionValidatorFactory implements ClassFactory<EventValidator> {
    @Override // com.smaato.sdk.core.di.ClassFactory
    /* JADX INFO: renamed from: get */
    public EventValidator get2(DiConstructor diConstructor) {
        EventValidator.Builder builder = new EventValidator.Builder();
        MediaPlayerAction mediaPlayerAction = MediaPlayerAction.SET_SURFACE;
        MediaPlayerState mediaPlayerState = MediaPlayerState.INITIALIZED;
        MediaPlayerState mediaPlayerState2 = MediaPlayerState.PREPARED;
        MediaPlayerState mediaPlayerState3 = MediaPlayerState.STARTED;
        MediaPlayerState mediaPlayerState4 = MediaPlayerState.RESUMED;
        MediaPlayerState mediaPlayerState5 = MediaPlayerState.PAUSED;
        MediaPlayerState mediaPlayerState6 = MediaPlayerState.STOPPED;
        MediaPlayerState mediaPlayerState7 = MediaPlayerState.PLAYBACK_COMPLETED;
        EventValidator.Builder validStatesForEvent = builder.setValidStatesForEvent(mediaPlayerAction, Arrays.asList(mediaPlayerState, mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState6, mediaPlayerState7));
        MediaPlayerAction mediaPlayerAction2 = MediaPlayerAction.GET_CURRENT_POSITION;
        MediaPlayerState mediaPlayerState8 = MediaPlayerState.IDLE;
        validStatesForEvent.setValidStatesForEvent(mediaPlayerAction2, Arrays.asList(mediaPlayerState8, mediaPlayerState, mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState6, mediaPlayerState7)).setValidStatesForEvent(MediaPlayerAction.GET_DURATION, Arrays.asList(mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState6, mediaPlayerState7)).setValidStatesForEvent(MediaPlayerAction.IS_PLAYING, Arrays.asList(mediaPlayerState8, mediaPlayerState, mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState6, mediaPlayerState7)).setValidStatesForEvent(MediaPlayerAction.SEEK_TO, Arrays.asList(mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState7)).setValidStatesForEvent(MediaPlayerAction.SET_VOLUME, Arrays.asList(mediaPlayerState8, mediaPlayerState, mediaPlayerState2, mediaPlayerState3, mediaPlayerState4, mediaPlayerState5, mediaPlayerState6, mediaPlayerState7));
        return builder.build();
    }
}
