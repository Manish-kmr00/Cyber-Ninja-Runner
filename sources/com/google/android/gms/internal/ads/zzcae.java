package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcae implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcak zzc;

    zzcae(zzcak zzcakVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcak zzcakVar = this.zzc;
        if (zzcakVar.zzr != null) {
            zzcakVar.zzr.zzb(this.zza, this.zzb);
        }
    }
}
