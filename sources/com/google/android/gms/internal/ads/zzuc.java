package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzuc implements zzuw, zzuv {
    public final zzuw zza;
    long zzb;
    private zzuv zzc;
    private zzub[] zzd = new zzub[0];
    private long zze = 0;

    public zzuc(zzuw zzuwVar, boolean z, long j, long j2) {
        this.zza = zzuwVar;
        this.zzb = j2;
    }

    private static long zzr(long j, long j2, long j3) {
        long jMax = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zza(long j, zzma zzmaVar) {
        if (j == 0) {
            return 0L;
        }
        long j2 = zzmaVar.zzc;
        int i = zzeu.zza;
        long jMax = Math.max(0L, Math.min(j2, j));
        long j3 = zzmaVar.zzd;
        long j4 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j));
        if (jMax != j2 || jMax2 != j3) {
            zzmaVar = new zzma(jMax, jMax2);
        }
        return this.zza.zza(j, zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzb < j) {
                return jZzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzc < j) {
                return jZzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzd() {
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long jZzd = zzd();
            return jZzd != -9223372036854775807L ? jZzd : j;
        }
        long jZzd2 = this.zza.zzd();
        if (jZzd2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzr(jZzd2, 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zze(long j) {
        this.zze = -9223372036854775807L;
        for (zzub zzubVar : this.zzd) {
            if (zzubVar != null) {
                zzubVar.zzc();
            }
        }
        return zzr(this.zza.zze(j), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzf(zzyp[] zzypVarArr, boolean[] zArr, zzws[] zzwsVarArr, boolean[] zArr2, long j) {
        int length = zzwsVarArr.length;
        this.zzd = new zzub[length];
        zzws[] zzwsVarArr2 = new zzws[length];
        int i = 0;
        while (true) {
            zzws zzwsVar = null;
            if (i >= zzwsVarArr.length) {
                break;
            }
            zzub[] zzubVarArr = this.zzd;
            zzub zzubVar = (zzub) zzwsVarArr[i];
            zzubVarArr[i] = zzubVar;
            if (zzubVar != null) {
                zzwsVar = zzubVar.zza;
            }
            zzwsVarArr2[i] = zzwsVar;
            i++;
        }
        long jZzf = this.zza.zzf(zzypVarArr, zArr, zzwsVarArr2, zArr2, j);
        long jZzr = zzr(jZzf, j, this.zzb);
        long j2 = -9223372036854775807L;
        if (zzq()) {
            if (jZzf < j) {
                j2 = jZzr;
                break;
            }
            if (jZzf != 0) {
                for (zzyp zzypVar : zzypVarArr) {
                    if (zzypVar != null) {
                        zzz zzzVarZzf = zzypVar.zzf();
                        if (!zzay.zzf(zzzVarZzf.zzo, zzzVarZzf.zzk)) {
                            j2 = jZzr;
                            break;
                        }
                    }
                }
            }
        }
        this.zze = j2;
        for (int i2 = 0; i2 < zzwsVarArr.length; i2++) {
            zzws zzwsVar2 = zzwsVarArr2[i2];
            if (zzwsVar2 == null) {
                this.zzd[i2] = null;
            } else {
                zzub[] zzubVarArr2 = this.zzd;
                zzub zzubVar2 = zzubVarArr2[i2];
                if (zzubVar2 == null || zzubVar2.zza != zzwsVar2) {
                    zzubVarArr2[i2] = new zzub(this, zzwsVar2);
                }
            }
            zzwsVarArr[i2] = this.zzd[i2];
        }
        return jZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzxd zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzh(long j, boolean z) {
        this.zza.zzh(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzi() throws IOException {
        this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* bridge */ /* synthetic */ void zzj(zzwu zzwuVar) {
        zzuv zzuvVar = this.zzc;
        zzuvVar.getClass();
        zzuvVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzk(zzuv zzuvVar, long j) {
        this.zzc = zzuvVar;
        this.zza.zzk(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        return this.zza.zzo(zzkuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        return this.zza.zzp();
    }

    final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzuv
    public final void zzl(zzuw zzuwVar) {
        zzuv zzuvVar = this.zzc;
        zzuvVar.getClass();
        zzuvVar.zzl(this);
    }
}
