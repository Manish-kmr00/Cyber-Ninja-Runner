package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzlr extends zzum {
    private final zzbk zzc;

    zzlr(zzls zzlsVar, zzbl zzblVar) {
        super(zzblVar);
        this.zzc = new zzbk();
    }

    @Override // com.google.android.gms.internal.ads.zzum, com.google.android.gms.internal.ads.zzbl
    public final zzbj zzd(int i, zzbj zzbjVar, boolean z) {
        zzbl zzblVar = this.zzb;
        zzbj zzbjVarZzd = zzblVar.zzd(i, zzbjVar, z);
        if (zzblVar.zze(zzbjVarZzd.zzc, this.zzc, 0L).zzb()) {
            Object obj = zzbjVar.zza;
            Object obj2 = zzbjVar.zzb;
            int i2 = zzbjVar.zzc;
            long j = zzbjVar.zzd;
            long j2 = zzbjVar.zze;
            zzbjVarZzd.zzi(obj, obj2, i2, j, 0L, zzb.zza, true);
        } else {
            zzbjVarZzd.zzf = true;
        }
        return zzbjVarZzd;
    }
}
