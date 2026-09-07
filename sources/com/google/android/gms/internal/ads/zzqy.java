package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzqy {
    private final AudioTrack zza;
    private final zzpg zzb;
    private AudioRouting.OnRoutingChangedListener zzc = new AudioRouting.OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzqx
        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public final void onRoutingChanged(AudioRouting audioRouting) {
            zzqy.zza(this.zza, audioRouting);
        }
    };

    public zzqy(AudioTrack audioTrack, zzpg zzpgVar) {
        this.zza = audioTrack;
        this.zzb = zzpgVar;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    public static /* synthetic */ void zza(zzqy zzqyVar, AudioRouting audioRouting) {
        AudioDeviceInfo routedDevice;
        if (zzqyVar.zzc == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
            return;
        }
        zzqyVar.zzb.zzh(routedDevice);
    }

    public final void zzb() {
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = this.zzc;
        onRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(onRoutingChangedListener);
        this.zzc = null;
    }
}
