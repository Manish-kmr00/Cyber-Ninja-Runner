package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaho implements zzahn {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzaho(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i;
    }

    public static zzaho zzb(long j, long j2, zzadu zzaduVar, zzek zzekVar) {
        long jMax;
        int iZzm;
        zzekVar.zzM(6);
        int iZzg = zzekVar.zzg();
        long j3 = zzaduVar.zzc;
        long j4 = iZzg;
        int iZzg2 = zzekVar.zzg();
        if (iZzg2 <= 0) {
            return null;
        }
        long jZzt = zzeu.zzt((((long) iZzg2) * ((long) zzaduVar.zzg)) - 1, zzaduVar.zzd);
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        int iZzq3 = zzekVar.zzq();
        zzekVar.zzM(2);
        long j5 = j2 + ((long) zzaduVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        for (int i = 0; i < iZzq; i++) {
            jArr[i] = (((long) i) * jZzt) / ((long) iZzq);
            jArr2[i] = j5;
            if (iZzq3 == 1) {
                iZzm = zzekVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzekVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzekVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzekVar.zzp();
            }
            j5 += ((long) iZzm) * ((long) iZzq2);
        }
        long j6 = j2 + j3;
        long j7 = j4 + j6;
        if (j != -1 && j != j7) {
            zzdx.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j7);
        }
        if (j7 != j5) {
            zzdx.zzf("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + j7 + ", " + j5 + "\nSeeking will be inaccurate.");
            jMax = Math.max(j7, j5);
        } else {
            jMax = j7;
        }
        return new zzaho(jArr, jArr2, jZzt, j6, jMax, zzaduVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final long zze(long j) {
        return this.zza[zzeu.zzd(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        long[] jArr = this.zza;
        int iZzd = zzeu.zzd(jArr, j, true, true);
        long j2 = jArr[iZzd];
        long[] jArr2 = this.zzb;
        zzaec zzaecVar = new zzaec(j2, jArr2[iZzd]);
        if (zzaecVar.zzb >= j || iZzd == jArr.length - 1) {
            return new zzadz(zzaecVar, zzaecVar);
        }
        int i = iZzd + 1;
        return new zzadz(zzaecVar, new zzaec(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }
}
