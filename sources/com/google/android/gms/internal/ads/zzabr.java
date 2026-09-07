package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabr {
    private final Handler zza;
    private final zzabs zzb;

    public zzabr(Handler handler, zzabs zzabsVar) {
        if (zzabsVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzabsVar;
    }

    public static /* synthetic */ void zza(zzabr zzabrVar, Exception exc) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzo(exc);
    }

    public static /* synthetic */ void zzb(zzabr zzabrVar, String str) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzq(str);
    }

    public static /* synthetic */ void zzc(zzabr zzabrVar, long j, int i) {
        int i2 = zzeu.zza;
        zzabrVar.zzb.zzt(j, i);
    }

    public static /* synthetic */ void zzd(zzabr zzabrVar, int i, long j) {
        int i2 = zzeu.zza;
        zzabrVar.zzb.zzl(i, j);
    }

    public static /* synthetic */ void zze(zzabr zzabrVar, zzcd zzcdVar) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzv(zzcdVar);
    }

    public static /* synthetic */ void zzf(zzabr zzabrVar, zzhy zzhyVar) {
        zzhyVar.zza();
        int i = zzeu.zza;
        zzabrVar.zzb.zzr(zzhyVar);
    }

    public static /* synthetic */ void zzg(zzabr zzabrVar, zzz zzzVar, zzhz zzhzVar) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzu(zzzVar, zzhzVar);
    }

    public static /* synthetic */ void zzh(zzabr zzabrVar, Object obj, long j) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzm(obj, j);
    }

    public static /* synthetic */ void zzi(zzabr zzabrVar, zzhy zzhyVar) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzs(zzhyVar);
    }

    public static /* synthetic */ void zzj(zzabr zzabrVar, String str, long j, long j2) {
        int i = zzeu.zza;
        zzabrVar.zzb.zzp(str, j, j2);
    }

    public final void zzk(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzj(this.zza, str, j, j2);
                }
            });
        }
    }

    public final void zzl(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabq
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzb(this.zza, str);
                }
            });
        }
    }

    public final void zzm(final zzhy zzhyVar) {
        zzhyVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabp
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzf(this.zza, zzhyVar);
                }
            });
        }
    }

    public final void zzn(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabj
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzd(this.zza, i, j);
                }
            });
        }
    }

    public final void zzo(final zzhy zzhyVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabn
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzi(this.zza, zzhyVar);
                }
            });
        }
    }

    public final void zzp(final zzz zzzVar, final zzhz zzhzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabo
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzg(this.zza, zzzVar, zzhzVar);
                }
            });
        }
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabk
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzh(this.zza, obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabl
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zzc(this.zza, j, i);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabm
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zza(this.zza, exc);
                }
            });
        }
    }

    public final void zzt(final zzcd zzcdVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabi
                @Override // java.lang.Runnable
                public final void run() {
                    zzabr.zze(this.zza, zzcdVar);
                }
            });
        }
    }
}
