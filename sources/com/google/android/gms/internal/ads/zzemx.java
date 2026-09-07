package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzemx implements zzesv {
    private final zzgcd zza;
    private final Context zzb;

    public zzemx(zzgcd zzgcdVar, Context context) {
        this.zza = zzgcdVar;
        this.zzb = context;
    }

    public static /* synthetic */ zzemy zzc(zzemx zzemxVar) {
        int i;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) zzemxVar.zzb.getSystemService("audio");
        float fZza = com.google.android.gms.ads.internal.zzv.zzs().zza();
        boolean zZze = com.google.android.gms.ads.internal.zzv.zzs().zze();
        if (audioManager == null) {
            return new zzemy(-1, false, false, -1, -1, -1, -1, -1, fZza, zZze, true);
        }
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlc)).booleanValue()) {
            int iZzj = com.google.android.gms.ads.internal.zzv.zzr().zzj(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
            i = iZzj;
        } else {
            i = -1;
            streamMaxVolume = -1;
        }
        return new zzemy(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, i, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), fZza, zZze, false);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 13;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemx.zzc(this.zza);
            }
        });
    }
}
