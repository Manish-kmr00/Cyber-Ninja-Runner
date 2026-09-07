package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamp implements zzamg {
    private final zzank zza;
    private String zzb;
    private zzaei zzc;
    private zzamo zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzamy zzg = new zzamy(32, 128);
    private final zzamy zzh = new zzamy(33, 128);
    private final zzamy zzi = new zzamy(34, 128);
    private final zzamy zzj = new zzamy(39, 128);
    private final zzamy zzk = new zzamy(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzek zzn = new zzek();

    public zzamp(zzank zzankVar, String str) {
        this.zza = zzankVar;
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzf(long j, int i, int i2, long j2) {
        this.zzd.zza(j, i, this.zze);
        if (!this.zze) {
            zzamy zzamyVar = this.zzg;
            zzamyVar.zzd(i2);
            zzamy zzamyVar2 = this.zzh;
            zzamyVar2.zzd(i2);
            zzamy zzamyVar3 = this.zzi;
            zzamyVar3.zzd(i2);
            if (zzamyVar.zze() && zzamyVar2.zze() && zzamyVar3.zze()) {
                String str = this.zzb;
                int i3 = zzamyVar.zzb;
                byte[] bArr = new byte[zzamyVar2.zzb + i3 + zzamyVar3.zzb];
                System.arraycopy(zzamyVar.zza, 0, bArr, 0, i3);
                System.arraycopy(zzamyVar2.zza, 0, bArr, zzamyVar.zzb, zzamyVar2.zzb);
                System.arraycopy(zzamyVar3.zza, 0, bArr, zzamyVar.zzb + zzamyVar2.zzb, zzamyVar3.zzb);
                String strZzd = null;
                zzfk zzfkVarZzd = zzfq.zzd(zzamyVar2.zza, 3, zzamyVar2.zzb, null);
                zzff zzffVar = zzfkVarZzd.zzb;
                if (zzffVar != null) {
                    int i4 = zzffVar.zzf;
                    int[] iArr = zzffVar.zze;
                    int i5 = zzffVar.zzd;
                    strZzd = zzdh.zzd(zzffVar.zza, zzffVar.zzb, zzffVar.zzc, i5, iArr, i4);
                }
                zzx zzxVar = new zzx();
                zzxVar.zzO(str);
                zzxVar.zzE("video/mp2t");
                zzxVar.zzad("video/hevc");
                zzxVar.zzC(strZzd);
                zzxVar.zzai(zzfkVarZzd.zze);
                zzxVar.zzM(zzfkVarZzd.zzf);
                zzi zziVar = new zzi();
                zziVar.zzc(zzfkVarZzd.zzi);
                zziVar.zzb(zzfkVarZzd.zzj);
                zziVar.zzd(zzfkVarZzd.zzk);
                zziVar.zzf(zzfkVarZzd.zzc + 8);
                zziVar.zza(zzfkVarZzd.zzd + 8);
                zzxVar.zzD(zziVar.zzg());
                zzxVar.zzZ(zzfkVarZzd.zzg);
                zzxVar.zzU(zzfkVarZzd.zzh);
                zzxVar.zzV(zzfkVarZzd.zza + 1);
                zzxVar.zzP(Collections.singletonList(bArr));
                zzz zzzVarZzaj = zzxVar.zzaj();
                this.zzc.zzm(zzzVarZzaj);
                int i6 = zzzVarZzaj.zzq;
                zzftw.zzl(i6 != -1);
                this.zza.zzf(i6);
                this.zze = true;
            }
        }
        zzamy zzamyVar4 = this.zzj;
        if (zzamyVar4.zzd(i2)) {
            int iZzc = zzfq.zzc(zzamyVar4.zza, zzamyVar4.zzb);
            zzek zzekVar = this.zzn;
            zzekVar.zzJ(zzamyVar4.zza, iZzc);
            zzekVar.zzM(5);
            this.zza.zzc(j2, zzekVar);
        }
        zzamy zzamyVar5 = this.zzk;
        if (zzamyVar5.zzd(i2)) {
            int iZzc2 = zzfq.zzc(zzamyVar5.zza, zzamyVar5.zzb);
            zzek zzekVar2 = this.zzn;
            zzekVar2.zzJ(zzamyVar5.zza, iZzc2);
            zzekVar2.zzM(5);
            this.zza.zzc(j2, zzekVar2);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        this.zzd.zzb(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzh(long j, int i, int i2, long j2) {
        this.zzd.zzd(j, i, i2, j2, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i2);
            this.zzh.zzc(i2);
            this.zzi.zzc(i2);
        }
        this.zzj.zzc(i2);
        this.zzk.zzc(i2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        int i;
        int i2;
        zzdc.zzb(this.zzc);
        int i3 = zzeu.zza;
        while (zzekVar.zza() > 0) {
            int iZzc = zzekVar.zzc();
            int iZzd = zzekVar.zzd();
            byte[] bArrZzN = zzekVar.zzN();
            this.zzl += (long) zzekVar.zza();
            this.zzc.zzr(zzekVar, zzekVar.zza());
            while (iZzc < iZzd) {
                int iZza = zzfq.zza(bArrZzN, iZzc, iZzd, this.zzf);
                if (iZza == iZzd) {
                    zzg(bArrZzN, iZzc, iZzd);
                    return;
                }
                int i4 = bArrZzN[iZza + 3] & 126;
                if (iZza > 0) {
                    int i5 = iZza - 1;
                    if (bArrZzN[i5] == 0) {
                        i2 = 4;
                        i = i5;
                    } else {
                        i = iZza;
                        i2 = 3;
                    }
                } else {
                    i = iZza;
                    i2 = 3;
                }
                int i6 = i - iZzc;
                if (i6 > 0) {
                    zzg(bArrZzN, iZzc, i);
                }
                int i7 = iZzd - i;
                long j = this.zzl - ((long) i7);
                zzf(j, i7, i6 < 0 ? -i6 : 0, this.zzm);
                zzh(j, i7, i4 >> 1, this.zzm);
                iZzc = i + i2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzb = zzanuVar.zzb();
        this.zzc = zzadfVar.zzw(zzanuVar.zza(), 2);
        this.zzd = new zzamo(this.zzc);
        this.zza.zzd(zzadfVar, zzanuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        zzdc.zzb(this.zzc);
        int i = zzeu.zza;
        if (z) {
            this.zza.zze();
            zzf(this.zzl, 0, 0, this.zzm);
            zzh(this.zzl, 0, 48, this.zzm);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfq.zzi(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        this.zza.zzb();
        zzamo zzamoVar = this.zzd;
        if (zzamoVar != null) {
            zzamoVar.zzc();
        }
    }
}
