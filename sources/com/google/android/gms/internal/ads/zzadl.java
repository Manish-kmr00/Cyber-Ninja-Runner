package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadl implements zzaeb {
    private final zzadn zza;
    private final long zzb;

    public zzadl(zzadn zzadnVar, long j) {
        this.zza = zzadnVar;
        this.zzb = j;
    }

    private final zzaec zzb(long j, long j2) {
        return new zzaec((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        zzadn zzadnVar = this.zza;
        zzadm zzadmVar = zzadnVar.zzk;
        zzdc.zzb(zzadmVar);
        long[] jArr = zzadmVar.zza;
        long[] jArr2 = zzadmVar.zzb;
        int iZzd = zzeu.zzd(jArr, zzadnVar.zzb(j), true, false);
        zzaec zzaecVarZzb = zzb(iZzd == -1 ? 0L : jArr[iZzd], iZzd != -1 ? jArr2[iZzd] : 0L);
        if (zzaecVarZzb.zzb == j || iZzd == jArr.length - 1) {
            return new zzadz(zzaecVarZzb, zzaecVarZzb);
        }
        int i = iZzd + 1;
        return new zzadz(zzaecVarZzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
