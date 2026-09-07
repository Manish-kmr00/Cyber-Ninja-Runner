package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamn implements zzamg {
    private final zzank zza;
    private long zzf;
    private String zzh;
    private zzaei zzi;
    private zzamm zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzamy zzc = new zzamy(7, 128);
    private final zzamy zzd = new zzamy(8, 128);
    private final zzamy zze = new zzamy(6, 128);
    private long zzl = -9223372036854775807L;
    private final zzek zzn = new zzek();

    public zzamn(zzank zzankVar, boolean z, boolean z2, String str) {
        this.zza = zzankVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zza(bArr, i, i2);
            this.zzd.zza(bArr, i, i2);
        }
        this.zze.zza(bArr, i, i2);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzh(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0044  */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        int i;
        int i2;
        zzdc.zzb(this.zzi);
        int i3 = zzeu.zza;
        int iZzc = zzekVar.zzc();
        int iZzd = zzekVar.zzd();
        byte[] bArrZzN = zzekVar.zzN();
        this.zzf += (long) zzekVar.zza();
        this.zzi.zzr(zzekVar, zzekVar.zza());
        while (true) {
            int iZza = zzfq.zza(bArrZzN, iZzc, iZzd, this.zzg);
            if (iZza == iZzd) {
                zzg(bArrZzN, iZzc, iZzd);
                return;
            }
            int i4 = bArrZzN[iZza + 3] & Ascii.US;
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
            long j = this.zzf - ((long) i7);
            zzf(j, i7, i6 < 0 ? -i6 : 0, this.zzl);
            zzh(j, i4, this.zzl);
            iZzc = i + i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzh = zzanuVar.zzb();
        this.zzi = zzadfVar.zzw(zzanuVar.zza(), 2);
        this.zzj = new zzamm(this.zzi, false, false);
        this.zza.zzd(zzadfVar, zzanuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        zzdc.zzb(this.zzi);
        int i = zzeu.zza;
        if (z) {
            this.zza.zze();
            zzf(this.zzf, 0, 0, this.zzl);
            zzh(this.zzf, 9, this.zzl);
            zzf(this.zzf, 0, 0, this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzfq.zzi(this.zzg);
        this.zzc.zzb();
        this.zzd.zzb();
        this.zze.zzb();
        this.zza.zzb();
        zzamm zzammVar = this.zzj;
        if (zzammVar != null) {
            zzammVar.zzc();
        }
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzf(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzamy zzamyVar = this.zzc;
            zzamyVar.zzd(i2);
            zzamy zzamyVar2 = this.zzd;
            zzamyVar2.zzd(i2);
            if (this.zzk) {
                if (zzamyVar.zze()) {
                    zzfp zzfpVarZzg = zzfq.zzg(zzamyVar.zza, 4, zzamyVar.zzb);
                    this.zza.zzf(zzfpVarZzg.zzm);
                    this.zzj.zzb(zzfpVarZzg);
                    zzamyVar.zzb();
                } else if (zzamyVar2.zze()) {
                    this.zzj.zza(zzfq.zzf(zzamyVar2.zza, 4, zzamyVar2.zzb));
                    zzamyVar2.zzb();
                }
            } else if (zzamyVar.zze() && zzamyVar2.zze()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzamyVar.zza, zzamyVar.zzb));
                arrayList.add(Arrays.copyOf(zzamyVar2.zza, zzamyVar2.zzb));
                zzfp zzfpVarZzg2 = zzfq.zzg(zzamyVar.zza, 4, zzamyVar.zzb);
                zzfo zzfoVarZzf = zzfq.zzf(zzamyVar2.zza, 4, zzamyVar2.zzb);
                String strZzc = zzdh.zzc(zzfpVarZzg2.zza, zzfpVarZzg2.zzb, zzfpVarZzg2.zzc);
                zzaei zzaeiVar = this.zzi;
                zzx zzxVar = new zzx();
                zzxVar.zzO(this.zzh);
                zzxVar.zzE(this.zzb);
                zzxVar.zzad("video/avc");
                zzxVar.zzC(strZzc);
                zzxVar.zzai(zzfpVarZzg2.zze);
                zzxVar.zzM(zzfpVarZzg2.zzf);
                zzi zziVar = new zzi();
                zziVar.zzc(zzfpVarZzg2.zzj);
                zziVar.zzb(zzfpVarZzg2.zzk);
                zziVar.zzd(zzfpVarZzg2.zzl);
                zziVar.zzf(zzfpVarZzg2.zzh + 8);
                zziVar.zza(zzfpVarZzg2.zzi + 8);
                zzxVar.zzD(zziVar.zzg());
                zzxVar.zzZ(zzfpVarZzg2.zzg);
                zzxVar.zzP(arrayList);
                int i3 = zzfpVarZzg2.zzm;
                zzxVar.zzU(i3);
                zzaeiVar.zzm(zzxVar.zzaj());
                this.zzk = true;
                this.zza.zzf(i3);
                this.zzj.zzb(zzfpVarZzg2);
                this.zzj.zza(zzfoVarZzf);
                zzamyVar.zzb();
                zzamyVar2.zzb();
            }
        }
        zzamy zzamyVar3 = this.zze;
        if (zzamyVar3.zzd(i2)) {
            int iZzc = zzfq.zzc(zzamyVar3.zza, zzamyVar3.zzb);
            zzek zzekVar = this.zzn;
            zzekVar.zzJ(zzamyVar3.zza, iZzc);
            zzekVar.zzL(4);
            this.zza.zzc(j2, zzekVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }
}
