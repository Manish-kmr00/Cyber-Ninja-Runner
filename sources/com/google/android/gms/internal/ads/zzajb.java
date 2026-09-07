package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajb implements zzaeb {
    final /* synthetic */ zzajd zza;

    /* synthetic */ zzajb(zzajd zzajdVar, zzajc zzajcVar) {
        this.zza = zzajdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        zzajd zzajdVar = this.zza;
        return zzajdVar.zzd.zzf(zzajdVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        zzajd zzajdVar = this.zza;
        long jLongValue = zzajdVar.zzb + BigInteger.valueOf(zzajdVar.zzd.zzg(j)).multiply(BigInteger.valueOf(zzajdVar.zzc - zzajdVar.zzb)).divide(BigInteger.valueOf(zzajdVar.zzf)).longValue();
        long j2 = zzajdVar.zzb;
        long j3 = zzajdVar.zzc - 1;
        int i = zzeu.zza;
        zzaec zzaecVar = new zzaec(j, Math.max(j2, Math.min(jLongValue - 30000, j3)));
        return new zzadz(zzaecVar, zzaecVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
