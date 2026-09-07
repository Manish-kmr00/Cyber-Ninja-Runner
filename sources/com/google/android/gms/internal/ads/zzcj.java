package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcj {
    private static AudioManager zza;

    public static int zza(AudioManager audioManager, zzch zzchVar) {
        return zzeu.zza >= 26 ? audioManager.abandonAudioFocusRequest(zzchVar.zza()) : audioManager.abandonAudioFocus(zzchVar.zzb());
    }

    public static int zzb(AudioManager audioManager, zzch zzchVar) {
        if (zzeu.zza >= 26) {
            return audioManager.requestAudioFocus(zzchVar.zza());
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListenerZzb = zzchVar.zzb();
        zzchVar.zzc();
        return audioManager.requestAudioFocus(onAudioFocusChangeListenerZzb, 3, 1);
    }

    public static synchronized AudioManager zzc(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            zza = null;
        }
        AudioManager audioManager = zza;
        if (audioManager != null) {
            return audioManager;
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
            final zzdj zzdjVar = new zzdj(zzdg.zza);
            zzdd.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzci
                @Override // java.lang.Runnable
                public final void run() {
                    zzcj.zzd(applicationContext, zzdjVar);
                }
            });
            zzdjVar.zzb();
            AudioManager audioManager2 = zza;
            if (audioManager2 == null) {
                throw null;
            }
            return audioManager2;
        }
        AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
        zza = audioManager3;
        if (audioManager3 == null) {
            throw null;
        }
        return audioManager3;
    }

    static /* synthetic */ void zzd(Context context, zzdj zzdjVar) {
        zza = (AudioManager) context.getSystemService("audio");
        zzdjVar.zze();
    }
}
