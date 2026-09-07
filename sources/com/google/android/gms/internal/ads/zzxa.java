package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzxa implements zzuw, zzuv {
    private final zzuw zza;
    private final long zzb;
    private zzuv zzc;

    public zzxa(zzuw zzuwVar, long j) {
        this.zza = zzuwVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zza(long j, zzma zzmaVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmaVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzd() {
        long jZzd = this.zza.zzd();
        if (jZzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzf(zzyp[] zzypVarArr, boolean[] zArr, zzws[] zzwsVarArr, boolean[] zArr2, long j) {
        zzws[] zzwsVarArr2 = new zzws[zzwsVarArr.length];
        int i = 0;
        while (true) {
            zzws zzwsVarZzc = null;
            if (i >= zzwsVarArr.length) {
                break;
            }
            zzwz zzwzVar = (zzwz) zzwsVarArr[i];
            if (zzwzVar != null) {
                zzwsVarZzc = zzwzVar.zzc();
            }
            zzwsVarArr2[i] = zzwsVarZzc;
            i++;
        }
        zzuw zzuwVar = this.zza;
        long j2 = this.zzb;
        long jZzf = zzuwVar.zzf(zzypVarArr, zArr, zzwsVarArr2, zArr2, j - j2);
        for (int i2 = 0; i2 < zzwsVarArr.length; i2++) {
            zzws zzwsVar = zzwsVarArr2[i2];
            if (zzwsVar == null) {
                zzwsVarArr[i2] = null;
            } else {
                zzws zzwsVar2 = zzwsVarArr[i2];
                if (zzwsVar2 == null || ((zzwz) zzwsVar2).zzc() != zzwsVar) {
                    zzwsVarArr[i2] = new zzwz(zzwsVar, j2);
                }
            }
        }
        return jZzf + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzxd zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzh(long j, boolean z) {
        this.zza.zzh(j - this.zzb, false);
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
        this.zza.zzk(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzuw zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        long j = zzkuVar.zza;
        long j2 = this.zzb;
        zzks zzksVarZza = zzkuVar.zza();
        zzksVarZza.zze(j - j2);
        return this.zza.zzo(zzksVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzuv
    public final void zzl(zzuw zzuwVar) {
        zzuv zzuvVar = this.zzc;
        zzuvVar.getClass();
        zzuvVar.zzl(this);
    }
}
