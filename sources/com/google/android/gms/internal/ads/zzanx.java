package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanx {
    private final List zza;
    private final String zzb = "video/mp2t";
    private final zzaei[] zzc;

    public zzanx(List list, String str) {
        this.zza = list;
        this.zzc = new zzaei[list.size()];
    }

    public final void zza(long j, zzek zzekVar) {
        if (zzekVar.zza() < 9) {
            return;
        }
        int iZzg = zzekVar.zzg();
        int iZzg2 = zzekVar.zzg();
        int iZzm = zzekVar.zzm();
        if (iZzg == 434 && iZzg2 == 1195456820 && iZzm == 3) {
            zzaco.zzb(j, zzekVar, this.zzc);
        }
    }

    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        int i = 0;
        while (true) {
            zzaei[] zzaeiVarArr = this.zzc;
            if (i >= zzaeiVarArr.length) {
                return;
            }
            zzanuVar.zzc();
            zzaei zzaeiVarZzw = zzadfVar.zzw(zzanuVar.zza(), 3);
            zzz zzzVar = (zzz) this.zza.get(i);
            String str = zzzVar.zzo;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzdc.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzx zzxVar = new zzx();
            zzxVar.zzO(zzanuVar.zzb());
            zzxVar.zzE(this.zzb);
            zzxVar.zzad(str);
            zzxVar.zzaf(zzzVar.zze);
            zzxVar.zzS(zzzVar.zzd);
            zzxVar.zzz(zzzVar.zzJ);
            zzxVar.zzP(zzzVar.zzr);
            zzaeiVarZzw.zzm(zzxVar.zzaj());
            zzaeiVarArr[i] = zzaeiVarZzw;
            i++;
        }
    }
}
