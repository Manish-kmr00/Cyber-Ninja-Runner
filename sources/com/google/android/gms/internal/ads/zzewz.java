package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzewz implements zzekg {
    final /* synthetic */ zzexa zza;

    zzewz(zzexa zzexaVar) {
        this.zza = zzexaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zza() {
        zzexa zzexaVar = this.zza;
        synchronized (zzexaVar) {
            zzexaVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnt zzcntVar = (zzcnt) obj;
        zzexa zzexaVar = this.zza;
        synchronized (zzexaVar) {
            zzcnt zzcntVar2 = zzexaVar.zza;
            if (zzcntVar2 != null) {
                zzcntVar2.zzb();
            }
            zzexaVar.zza = zzcntVar;
            zzcntVar.zzc(zzexaVar);
            zzexaVar.zzg.zzk(new zzcnu(zzcntVar, zzexaVar, zzexaVar.zzg, zzexaVar.zzi));
            zzcntVar.zzk();
        }
    }
}
