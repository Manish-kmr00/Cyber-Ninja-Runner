package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzank {
    private final List zza;
    private final zzaei[] zzc;
    private final String zzb = "video/mp2t";
    private final zzfu zzd = new zzfu(new zzft() { // from class: com.google.android.gms.internal.ads.zzanj
        @Override // com.google.android.gms.internal.ads.zzft
        public final void zza(long j, zzek zzekVar) {
            zzaco.zza(j, zzekVar, this.zza.zzc);
        }
    });

    public zzank(List list, String str) {
        this.zza = list;
        this.zzc = new zzaei[list.size()];
    }

    public final void zzb() {
        this.zzd.zzd();
    }

    public final void zzc(long j, zzek zzekVar) {
        this.zzd.zzb(j, zzekVar);
    }

    public final void zzd(zzadf zzadfVar, zzanu zzanuVar) {
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
            String strZzb = zzzVar.zza;
            if (strZzb == null) {
                strZzb = zzanuVar.zzb();
            }
            zzx zzxVar = new zzx();
            zzxVar.zzO(strZzb);
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

    public final void zze() {
        this.zzd.zzd();
    }

    public final void zzf(int i) {
        this.zzd.zze(i);
    }
}
