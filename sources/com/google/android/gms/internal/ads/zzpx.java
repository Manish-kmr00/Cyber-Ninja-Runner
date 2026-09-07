package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzpx {
    private final Handler zza;
    private final zzpy zzb;

    public zzpx(Handler handler, zzpy zzpyVar) {
        if (zzpyVar == null) {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzpyVar;
    }

    public static /* synthetic */ void zza(zzpx zzpxVar, zzhy zzhyVar) {
        int i = zzeu.zza;
        zzpxVar.zzb.zze(zzhyVar);
    }

    public static /* synthetic */ void zzb(zzpx zzpxVar, String str) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzc(str);
    }

    public static /* synthetic */ void zzc(zzpx zzpxVar, long j) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzg(j);
    }

    public static /* synthetic */ void zzd(zzpx zzpxVar, zzpz zzpzVar) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzj(zzpzVar);
    }

    public static /* synthetic */ void zze(zzpx zzpxVar, int i, long j, long j2) {
        int i2 = zzeu.zza;
        zzpxVar.zzb.zzk(i, j, j2);
    }

    public static /* synthetic */ void zzf(zzpx zzpxVar, Exception exc) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzh(exc);
    }

    public static /* synthetic */ void zzg(zzpx zzpxVar, Exception exc) {
        int i = zzeu.zza;
        zzpxVar.zzb.zza(exc);
    }

    public static /* synthetic */ void zzh(zzpx zzpxVar, zzz zzzVar, zzhz zzhzVar) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzf(zzzVar, zzhzVar);
    }

    public static /* synthetic */ void zzi(zzpx zzpxVar, boolean z) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzn(z);
    }

    public static /* synthetic */ void zzj(zzpx zzpxVar, zzpz zzpzVar) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzi(zzpzVar);
    }

    public static /* synthetic */ void zzk(zzpx zzpxVar, String str, long j, long j2) {
        int i = zzeu.zza;
        zzpxVar.zzb.zzb(str, j, j2);
    }

    public static /* synthetic */ void zzl(zzpx zzpxVar, zzhy zzhyVar) {
        zzhyVar.zza();
        int i = zzeu.zza;
        zzpxVar.zzb.zzd(zzhyVar);
    }

    public final void zzm(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzg(this.zza, exc);
                }
            });
        }
    }

    public final void zzn(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzps
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzf(this.zza, exc);
                }
            });
        }
    }

    public final void zzo(final zzpz zzpzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpp
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzj(this.zza, zzpzVar);
                }
            });
        }
    }

    public final void zzp(final zzpz zzpzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpq
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzd(this.zza, zzpzVar);
                }
            });
        }
    }

    public final void zzq(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzk(this.zza, str, j, j2);
                }
            });
        }
    }

    public final void zzr(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzb(this.zza, str);
                }
            });
        }
    }

    public final void zzs(final zzhy zzhyVar) {
        zzhyVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpm
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzl(this.zza, zzhyVar);
                }
            });
        }
    }

    public final void zzt(final zzhy zzhyVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpl
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zza(this.zza, zzhyVar);
                }
            });
        }
    }

    public final void zzu(final zzz zzzVar, final zzhz zzhzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpt
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzh(this.zza, zzzVar, zzhzVar);
                }
            });
        }
    }

    public final void zzv(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpn
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzc(this.zza, j);
                }
            });
        }
    }

    public final void zzw(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpu
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zzi(this.zza, z);
                }
            });
        }
    }

    public final void zzx(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpo
                @Override // java.lang.Runnable
                public final void run() {
                    zzpx.zze(this.zza, i, j, j2);
                }
            });
        }
    }
}
