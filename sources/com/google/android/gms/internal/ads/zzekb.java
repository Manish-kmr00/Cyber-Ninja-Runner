package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzekb implements zzekg {
    final /* synthetic */ zzekc zza;

    zzekb(zzekc zzekcVar) {
        this.zza = zzekcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcqg zzcqgVar = (zzcqg) obj;
        zzekc zzekcVar = this.zza;
        synchronized (zzekcVar) {
            zzekcVar.zzc = zzcqgVar.zzl();
            zzcqgVar.zzk();
        }
    }
}
