package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3823o extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC3825p f8293a;
    private final AudioManager b;
    private final int c;
    private int d;

    public C3823o(Handler handler, AudioManager audioManager, InterfaceC3825p interfaceC3825p) {
        super(handler);
        this.b = audioManager;
        this.c = 3;
        this.f8293a = interfaceC3825p;
        this.d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.b;
        if (audioManager == null || this.f8293a == null || (streamVolume = audioManager.getStreamVolume(this.c)) == this.d) {
            return;
        }
        this.d = streamVolume;
        this.f8293a.onAudioVolumeChanged(streamVolume);
    }
}
