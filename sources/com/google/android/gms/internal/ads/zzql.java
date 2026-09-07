package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzql {
    private final Context zza;
    private Boolean zzb;

    public zzql() {
        this.zza = null;
    }

    public zzql(Context context) {
        this.zza = context;
    }

    public final zzpk zza(zzz zzzVar, zze zzeVar) {
        int i;
        boolean zBooleanValue;
        zzzVar.getClass();
        zzeVar.getClass();
        if (zzeu.zza < 29 || (i = zzzVar.zzF) == -1) {
            return zzpk.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        boolean z = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = zzcj.zzc(context).getParameters("offloadVariableRateSupported");
                this.zzb = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                this.zzb = false;
            }
            zBooleanValue = this.zzb.booleanValue();
        }
        String str = zzzVar.zzo;
        str.getClass();
        int iZza = zzay.zza(str, zzzVar.zzk);
        if (iZza == 0 || zzeu.zza < zzeu.zzh(iZza)) {
            return zzpk.zza;
        }
        int iZzi = zzeu.zzi(zzzVar.zzE);
        if (iZzi == 0) {
            return zzpk.zza;
        }
        try {
            AudioFormat audioFormatZzx = zzeu.zzx(i, iZzi, iZza);
            if (zzeu.zza < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatZzx, zzeVar.zza().zza)) {
                    return zzpk.zza;
                }
                zzpi zzpiVar = new zzpi();
                zzpiVar.zza(true);
                zzpiVar.zzc(zBooleanValue);
                return zzpiVar.zzd();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatZzx, zzeVar.zza().zza);
            if (playbackOffloadSupport == 0) {
                return zzpk.zza;
            }
            zzpi zzpiVar2 = new zzpi();
            if (zzeu.zza > 32 && playbackOffloadSupport == 2) {
                z = true;
            }
            zzpiVar2.zza(true);
            zzpiVar2.zzb(z);
            zzpiVar2.zzc(zBooleanValue);
            return zzpiVar2.zzd();
        } catch (IllegalArgumentException unused) {
            return zzpk.zza;
        }
    }
}
