package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafu extends zzadp {
    final /* synthetic */ zzaeb zza;
    final /* synthetic */ zzafv zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzafu(zzafv zzafvVar, zzaeb zzaebVar, zzaeb zzaebVar2) {
        super(zzaebVar);
        this.zza = zzaebVar2;
        this.zzb = zzafvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadp, com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        zzadz zzadzVarZzg = this.zza.zzg(j);
        zzaec zzaecVar = zzadzVarZzg.zza;
        long j2 = zzaecVar.zzc;
        zzafv zzafvVar = this.zzb;
        zzaec zzaecVar2 = new zzaec(zzaecVar.zzb, j2 + zzafvVar.zzb);
        zzaec zzaecVar3 = zzadzVarZzg.zzb;
        return new zzadz(zzaecVar2, new zzaec(zzaecVar3.zzb, zzaecVar3.zzc + zzafvVar.zzb));
    }
}
