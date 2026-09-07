package com.playon.bridge.reflection;

import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;

/* JADX INFO: loaded from: classes11.dex */
public class ExoPlayerReflection {
    private static final int EXOPLAYER_v15 = 2015000;
    private static final String TAG = "ExoPlayerReflection";

    public static void setAudioAttributes(ExoPlayer exoPlayer, AudioAttributes audioAttributes, boolean z) {
        try {
            exoPlayer.getClass().getDeclaredMethod("setAudioAttributes", AudioAttributes.class, Boolean.TYPE).invoke(exoPlayer, audioAttributes, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.i(TAG, "setAudioAttributes() method wasn't found in ExoPlayer class during reflection.", e);
        }
    }

    public static int getVersion() {
        try {
            return ExoPlayerLibraryInfo.class.getField("VERSION_INT").getInt(null);
        } catch (Exception e) {
            Log.i(TAG, "Failed to get exoplayer version. Using 2015000", e);
            return EXOPLAYER_v15;
        }
    }
}
