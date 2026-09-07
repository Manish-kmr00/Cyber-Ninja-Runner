package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcag implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcak zzc;

    zzcag(zzcak zzcakVar, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcak zzcakVar = this.zzc;
        if (zzcakVar.zzr != null) {
            zzcakVar.zzr.zzj(this.zza, this.zzb);
        }
    }
}
