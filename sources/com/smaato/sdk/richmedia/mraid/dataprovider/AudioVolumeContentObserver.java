package com.smaato.sdk.richmedia.mraid.dataprovider;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.notifier.ChangeSender;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public class AudioVolumeContentObserver extends ContentObserver {
    private final ChangeSender changeSender;
    private final Context context;
    private final AtomicBoolean isRegistered;
    private final MusicPlaybackVolume musicPlaybackVolume;

    public AudioVolumeContentObserver(Context context, MusicPlaybackVolume musicPlaybackVolume, ChangeSender<Integer> changeSender) {
        super(Threads.newUiHandler());
        this.isRegistered = new AtomicBoolean();
        this.context = (Context) Objects.requireNonNull(context);
        this.musicPlaybackVolume = (MusicPlaybackVolume) Objects.requireNonNull(musicPlaybackVolume);
        this.changeSender = (ChangeSender) Objects.requireNonNull(changeSender);
    }

    void register() {
        if (this.isRegistered.compareAndSet(false, true)) {
            this.context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
        }
    }

    void unregister() {
        if (this.isRegistered.compareAndSet(true, false)) {
            this.context.getContentResolver().unregisterContentObserver(this);
        }
    }

    boolean isRegistered() {
        return this.isRegistered.get();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        if (uri == null || !uri.equals(this.musicPlaybackVolume.getUri())) {
            return;
        }
        this.changeSender.newValue(Integer.valueOf(this.musicPlaybackVolume.getCurrentVolume()));
    }

    public ChangeSender<Integer> getChangeSender() {
        return this.changeSender;
    }
}
