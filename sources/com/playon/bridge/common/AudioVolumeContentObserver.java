package com.playon.bridge.common;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: classes12.dex */
public class AudioVolumeContentObserver extends ContentObserver {
    private final AudioManager mAudioManager;
    private final int mAudioStreamType;
    private int mLastVolume;
    private final OnAudioVolumeChangedListener mListener;

    public AudioVolumeContentObserver(Handler handler, AudioManager audioManager, int i, OnAudioVolumeChangedListener onAudioVolumeChangedListener) {
        super(handler);
        this.mAudioManager = audioManager;
        this.mAudioStreamType = i;
        this.mListener = onAudioVolumeChangedListener;
        this.mLastVolume = audioManager.getStreamVolume(i);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null || this.mListener == null) {
            return;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(this.mAudioStreamType);
        int streamVolume = this.mAudioManager.getStreamVolume(this.mAudioStreamType);
        if (streamVolume != this.mLastVolume) {
            this.mLastVolume = streamVolume;
            this.mListener.onAudioVolumeChanged(streamVolume, streamMaxVolume);
        }
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }
}
