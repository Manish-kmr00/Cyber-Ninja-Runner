package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaex {
    private final zzaew zza;
    private final zzaei zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long[] zzm;
    private int[] zzn;

    public zzaex(int i, zzaew zzaewVar, zzaei zzaeiVar) {
        this.zza = zzaewVar;
        int iZzb = zzaewVar.zzb();
        boolean z = true;
        if (iZzb != 1) {
            if (iZzb == 2) {
                iZzb = 2;
            } else {
                z = false;
            }
        }
        zzdc.zzd(z);
        this.zzc = zzh(i, iZzb == 2 ? 1667497984 : 1651965952);
        this.zze = zzaewVar.zzc();
        this.zzb = zzaeiVar;
        this.zzd = iZzb == 2 ? zzh(i, 1650720768) : -1;
        this.zzl = -1L;
        this.zzm = new long[512];
        this.zzn = new int[512];
        this.zzf = zzaewVar.zzd;
    }

    private static int zzh(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzi(int i) {
        return (this.zze * ((long) i)) / ((long) this.zzf);
    }

    private final zzaec zzj(int i) {
        return new zzaec(((long) this.zzn[i]) * zzi(1), this.zzm[i]);
    }

    public final zzadz zza(long j) {
        if (this.zzk == 0) {
            zzaec zzaecVar = new zzaec(0L, this.zzl);
            return new zzadz(zzaecVar, zzaecVar);
        }
        int iZzi = (int) (j / zzi(1));
        int iZzc = zzeu.zzc(this.zzn, iZzi, true, true);
        if (this.zzn[iZzc] == iZzi) {
            zzaec zzaecVarZzj = zzj(iZzc);
            return new zzadz(zzaecVarZzj, zzaecVarZzj);
        }
        zzaec zzaecVarZzj2 = zzj(iZzc);
        int i = iZzc + 1;
        return i < this.zzm.length ? new zzadz(zzaecVarZzj2, zzj(i)) : new zzadz(zzaecVarZzj2, zzaecVarZzj2);
    }

    public final void zzb(long j, boolean z) {
        if (this.zzl == -1) {
            this.zzl = j;
        }
        if (z) {
            if (this.zzk == this.zzn.length) {
                long[] jArr = this.zzm;
                this.zzm = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzn;
                this.zzn = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzm;
            int i = this.zzk;
            jArr2[i] = j;
            this.zzn[i] = this.zzj;
            this.zzk = i + 1;
        }
        this.zzj++;
    }

    public final void zzc() {
        int i;
        this.zzm = Arrays.copyOf(this.zzm, this.zzk);
        this.zzn = Arrays.copyOf(this.zzn, this.zzk);
        if ((this.zzc & 1651965952) != 1651965952 || this.zza.zzf == 0 || (i = this.zzk) <= 0) {
            return;
        }
        this.zzf = i;
    }

    public final void zzd(int i) {
        this.zzg = i;
        this.zzh = i;
    }

    public final void zze(long j) {
        if (this.zzk == 0) {
            this.zzi = 0;
        } else {
            this.zzi = this.zzn[zzeu.zzd(this.zzm, j, true, true)];
        }
    }

    public final boolean zzf(int i) {
        return this.zzc == i || this.zzd == i;
    }

    public final boolean zzg(zzadd zzaddVar) throws IOException {
        int i = this.zzh;
        zzaei zzaeiVar = this.zzb;
        int iZzf = i - zzaeiVar.zzf(zzaddVar, i, false);
        this.zzh = iZzf;
        boolean z = iZzf == 0;
        if (z) {
            if (this.zzg > 0) {
                zzaeiVar.zzt(zzi(this.zzi), Arrays.binarySearch(this.zzn, this.zzi) >= 0 ? 1 : 0, this.zzg, 0, null);
            }
            this.zzi++;
        }
        return z;
    }
}
