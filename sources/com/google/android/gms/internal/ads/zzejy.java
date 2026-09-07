package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzejy implements zzekg {
    final /* synthetic */ zzejz zza;

    zzejy(zzejz zzejzVar) {
        this.zza = zzejzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        zzejz zzejzVar = this.zza;
        synchronized (zzejzVar) {
            zzejzVar.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzejz zzejzVar = this.zza;
        zzdea zzdeaVar = (zzdea) obj;
        synchronized (zzejzVar) {
            zzejzVar.zzj = zzdeaVar;
            zzejzVar.zzj.zzk();
        }
    }
}
