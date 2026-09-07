package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahq implements zzahn {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzahq(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = i2;
        this.zze = j3;
        this.zzg = jArr;
        this.zzf = j3 != -1 ? j + j3 : -1L;
    }

    public static zzahq zzb(zzahp zzahpVar, long j) {
        long jZza = zzahpVar.zza();
        if (jZza == -9223372036854775807L) {
            return null;
        }
        zzadu zzaduVar = zzahpVar.zza;
        return new zzahq(j, zzaduVar.zzc, jZza, zzaduVar.zzf, zzahpVar.zzc, zzahpVar.zzf);
    }

    private final long zzf(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zze(long j) {
        if (!zzh()) {
            return 0L;
        }
        long j2 = j - this.zza;
        if (j2 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        zzdc.zzb(jArr);
        double d = (j2 * 256.0d) / this.zze;
        long[] jArr2 = jArr;
        int iZzd = zzeu.zzd(jArr2, (long) d, true, true);
        long jZzf = zzf(iZzd);
        long j3 = jArr2[iZzd];
        int i = iZzd + 1;
        long jZzf2 = zzf(i);
        long j4 = iZzd == 99 ? 256L : jArr2[i];
        return jZzf + Math.round((j3 == j4 ? 0.0d : (d - j3) / (j4 - j3)) * (jZzf2 - jZzf));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        if (!zzh()) {
            zzaec zzaecVar = new zzaec(0L, this.zza + ((long) this.zzb));
            return new zzadz(zzaecVar, zzaecVar);
        }
        long j2 = this.zzc;
        int i = zzeu.zza;
        long jMax = Math.max(0L, Math.min(j, j2));
        double d = (jMax * 100.0d) / j2;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i2 = (int) d;
                long[] jArr = this.zzg;
                zzdc.zzb(jArr);
                long[] jArr2 = jArr;
                double d3 = jArr2[i2];
                d2 = d3 + ((d - ((double) i2)) * ((i2 == 99 ? 256.0d : jArr2[i2 + 1]) - d3));
            }
        }
        long j3 = this.zze;
        zzaec zzaecVar2 = new zzaec(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d2 / 256.0d) * j3), j3 - 1)));
        return new zzadz(zzaecVar2, zzaecVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return this.zzg != null;
    }
}
