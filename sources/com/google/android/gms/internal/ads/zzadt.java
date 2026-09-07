package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadt implements zzaeb {
    private final zzdy zza;
    private final zzdy zzb;
    private long zzc;

    public zzadt(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdc.zzd(length == length2);
        if (length2 <= 0 || jArr2[0] <= 0) {
            this.zza = new zzdy(length2);
            this.zzb = new zzdy(length2);
        } else {
            int i = length2 + 1;
            zzdy zzdyVar = new zzdy(i);
            this.zza = zzdyVar;
            zzdy zzdyVar2 = new zzdy(i);
            this.zzb = zzdyVar2;
            zzdyVar.zzc(0L);
            zzdyVar2.zzc(0L);
        }
        this.zza.zzd(jArr);
        this.zzb.zzd(jArr2);
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        zzdy zzdyVar = this.zzb;
        if (zzdyVar.zza() == 0) {
            zzaec zzaecVar = zzaec.zza;
            return new zzadz(zzaecVar, zzaecVar);
        }
        int iZzb = zzeu.zzb(zzdyVar, j, true, true);
        long jZzb = zzdyVar.zzb(iZzb);
        zzdy zzdyVar2 = this.zza;
        zzaec zzaecVar2 = new zzaec(jZzb, zzdyVar2.zzb(iZzb));
        if (zzaecVar2.zzb == j || iZzb == zzdyVar.zza() - 1) {
            return new zzadz(zzaecVar2, zzaecVar2);
        }
        int i = iZzb + 1;
        return new zzadz(zzaecVar2, new zzaec(zzdyVar.zzb(i), zzdyVar2.zzb(i)));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return this.zzb.zza() > 0;
    }
}
