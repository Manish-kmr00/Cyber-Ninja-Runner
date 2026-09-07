package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaer implements zzaeb {
    final /* synthetic */ zzaeu zza;
    private final long zzb;

    public zzaer(zzaeu zzaeuVar, long j) {
        this.zza = zzaeuVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        zzaeu zzaeuVar = this.zza;
        zzadz zzadzVarZza = zzaeuVar.zzi[0].zza(j);
        for (int i = 1; i < zzaeuVar.zzi.length; i++) {
            zzadz zzadzVarZza2 = zzaeuVar.zzi[i].zza(j);
            if (zzadzVarZza2.zza.zzc < zzadzVarZza.zza.zzc) {
                zzadzVarZza = zzadzVarZza2;
            }
        }
        return zzadzVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
