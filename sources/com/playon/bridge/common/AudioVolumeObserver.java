package com.playon.bridge.common;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes12.dex */
public class AudioVolumeObserver {
    private final AudioManager mAudioManager;
    private AudioVolumeContentObserver mAudioVolumeContentObserver;
    private final Context mContext;

    public AudioVolumeObserver(Context context) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
    }

    public void register(int i, OnAudioVolumeChangedListener onAudioVolumeChangedListener) {
        this.mAudioVolumeContentObserver = new AudioVolumeContentObserver(new Handler(), this.mAudioManager, i, onAudioVolumeChangedListener);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mAudioVolumeContentObserver);
    }

    public void unregister() {
        if (this.mAudioVolumeContentObserver != null) {
            this.mContext.getContentResolver().unregisterContentObserver(this.mAudioVolumeContentObserver);
            this.mAudioVolumeContentObserver = null;
        }
    }
}
