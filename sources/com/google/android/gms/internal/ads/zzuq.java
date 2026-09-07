package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzuq implements zzuw, zzuv {
    public final zzuy zza;
    private final long zzb;
    private zzva zzc;
    private zzuw zzd;
    private zzuv zze;
    private long zzf = -9223372036854775807L;
    private final zzze zzg;

    public zzuq(zzuy zzuyVar, zzze zzzeVar, long j) {
        this.zza = zzuyVar;
        this.zzg = zzzeVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zza(long j, zzma zzmaVar) {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zza(j, zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzd() {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zze(long j) {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzf(zzyp[] zzypVarArr, boolean[] zArr, zzws[] zzwsVarArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zzf(zzypVarArr, zArr, zzwsVarArr, zArr2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzxd zzg() {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        return zzuwVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzh(long j, boolean z) {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        zzuwVar.zzh(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzi() throws IOException {
        zzuw zzuwVar = this.zzd;
        if (zzuwVar != null) {
            zzuwVar.zzi();
            return;
        }
        zzva zzvaVar = this.zzc;
        if (zzvaVar != null) {
            zzvaVar.zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* bridge */ /* synthetic */ void zzj(zzwu zzwuVar) {
        zzuv zzuvVar = this.zze;
        int i = zzeu.zza;
        zzuvVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzk(zzuv zzuvVar, long j) {
        this.zze = zzuvVar;
        zzuw zzuwVar = this.zzd;
        if (zzuwVar != null) {
            zzuwVar.zzk(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuv
    public final void zzl(zzuw zzuwVar) {
        zzuv zzuvVar = this.zze;
        int i = zzeu.zza;
        zzuvVar.zzl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        zzuw zzuwVar = this.zzd;
        int i = zzeu.zza;
        zzuwVar.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        zzuw zzuwVar = this.zzd;
        return zzuwVar != null && zzuwVar.zzo(zzkuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        zzuw zzuwVar = this.zzd;
        return zzuwVar != null && zzuwVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzuy zzuyVar) {
        long jZzv = zzv(this.zzb);
        zzva zzvaVar = this.zzc;
        zzvaVar.getClass();
        zzuw zzuwVarZzI = zzvaVar.zzI(zzuyVar, this.zzg, jZzv);
        this.zzd = zzuwVarZzI;
        if (this.zze != null) {
            zzuwVarZzI.zzk(this, jZzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzva zzvaVar) {
        zzdc.zzf(this.zzc == null);
        this.zzc = zzvaVar;
    }

    public final void zzt() {
        zzuw zzuwVar = this.zzd;
        if (zzuwVar != null) {
            zzva zzvaVar = this.zzc;
            zzvaVar.getClass();
            zzvaVar.zzG(zzuwVar);
        }
    }
}
