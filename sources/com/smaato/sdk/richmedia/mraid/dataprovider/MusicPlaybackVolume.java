package com.smaato.sdk.richmedia.mraid.dataprovider;

import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;

/* JADX INFO: loaded from: classes13.dex */
public final class MusicPlaybackVolume {
    private static final Uri TARGET_URI = Settings.System.CONTENT_URI.buildUpon().appendPath("volume_music_speaker").build();
    private final AudioManager audioManager;
    private final int maxVolume;

    public MusicPlaybackVolume(AudioManager audioManager) {
        this.audioManager = audioManager;
        this.maxVolume = audioManager == null ? Integer.MAX_VALUE : audioManager.getStreamMaxVolume(3);
    }

    public int getCurrentVolume() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return 0;
        }
        return audioManager.getStreamVolume(3);
    }

    public int getMaxVolume() {
        return this.maxVolume;
    }

    Uri getUri() {
        return TARGET_URI;
    }
}
