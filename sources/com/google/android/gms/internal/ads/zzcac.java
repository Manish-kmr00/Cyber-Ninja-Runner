package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcac implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcak zzb;

    zzcac(zzcak zzcakVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcak zzcakVar = this.zzb;
        zzcak.zzm(zzcakVar, this.zza);
        if (zzcakVar.zzr != null) {
            zzcakVar.zzr.zzf();
        }
    }
}
