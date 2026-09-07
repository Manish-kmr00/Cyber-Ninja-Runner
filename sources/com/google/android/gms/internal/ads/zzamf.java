package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamf implements zzamg {
    private final List zza;
    private final zzaei[] zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private final String zzb = "video/mp2t";
    private long zzg = -9223372036854775807L;

    public zzamf(List list, String str) {
        this.zza = list;
        this.zzc = new zzaei[list.size()];
    }

    private final boolean zzf(zzek zzekVar, int i) {
        if (zzekVar.zza() == 0) {
            return false;
        }
        if (zzekVar.zzm() != i) {
            this.zzd = false;
        }
        this.zze--;
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        if (this.zzd) {
            if (this.zze != 2 || zzf(zzekVar, 32)) {
                if (this.zze != 1 || zzf(zzekVar, 0)) {
                    int iZzc = zzekVar.zzc();
                    int iZza = zzekVar.zza();
                    for (zzaei zzaeiVar : this.zzc) {
                        zzekVar.zzL(iZzc);
                        zzaeiVar.zzr(zzekVar, iZza);
                    }
                    this.zzf += iZza;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        int i = 0;
        while (true) {
            zzaei[] zzaeiVarArr = this.zzc;
            if (i >= zzaeiVarArr.length) {
                return;
            }
            zzanr zzanrVar = (zzanr) this.zza.get(i);
            zzanuVar.zzc();
            zzaei zzaeiVarZzw = zzadfVar.zzw(zzanuVar.zza(), 3);
            zzx zzxVar = new zzx();
            zzxVar.zzO(zzanuVar.zzb());
            zzxVar.zzE(this.zzb);
            zzxVar.zzad("application/dvbsubs");
            zzxVar.zzP(Collections.singletonList(zzanrVar.zzb));
            zzxVar.zzS(zzanrVar.zza);
            zzaeiVarZzw.zzm(zzxVar.zzaj());
            zzaeiVarArr[i] = zzaeiVarZzw;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        if (this.zzd) {
            zzdc.zzf(this.zzg != -9223372036854775807L);
            for (zzaei zzaeiVar : this.zzc) {
                zzaeiVar.zzt(this.zzg, 1, this.zzf, 0, null);
            }
            this.zzd = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zzg = j;
        this.zzf = 0;
        this.zze = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzd = false;
        this.zzg = -9223372036854775807L;
    }
}
