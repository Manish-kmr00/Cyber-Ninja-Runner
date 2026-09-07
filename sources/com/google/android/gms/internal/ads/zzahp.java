package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahp {
    public final zzadu zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzahp(zzadu zzaduVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzadu(zzaduVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzahp zzb(zzadu zzaduVar, zzek zzekVar) {
        long[] jArr;
        int i;
        int i2;
        int iZzg = zzekVar.zzg();
        int iZzp = (iZzg & 1) != 0 ? zzekVar.zzp() : -1;
        long jZzu = (iZzg & 2) != 0 ? zzekVar.zzu() : -1L;
        if ((iZzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = zzekVar.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzg & 8) != 0) {
            zzekVar.zzM(4);
        }
        if (zzekVar.zza() >= 24) {
            zzekVar.zzM(21);
            int iZzo = zzekVar.zzo();
            i2 = iZzo & 4095;
            i = iZzo >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzahp(zzaduVar, iZzp, jZzu, jArr, i, i2);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        zzadu zzaduVar = this.zza;
        return zzeu.zzt((j * ((long) zzaduVar.zzg)) - 1, zzaduVar.zzd);
    }
}
