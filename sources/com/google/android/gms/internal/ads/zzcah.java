package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcah implements Runnable {
    final /* synthetic */ zzcak zza;

    zzcah(zzcak zzcakVar) {
        this.zza = zzcakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcak zzcakVar = this.zza;
        if (zzcakVar.zzr != null) {
            zzcakVar.zzr.zzd();
            zzcakVar.zzr.zzi();
        }
    }
}
