package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamz implements zzanh {
    private zzz zza;
    private zzer zzb;
    private zzaei zzc;

    public zzamz(String str, String str2) {
        zzx zzxVar = new zzx();
        zzxVar.zzE("video/mp2t");
        zzxVar.zzad(str);
        this.zza = zzxVar.zzaj();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzek zzekVar) {
        zzdc.zzb(this.zzb);
        int i = zzeu.zza;
        long jZze = this.zzb.zze();
        long jZzf = this.zzb.zzf();
        if (jZze == -9223372036854775807L || jZzf == -9223372036854775807L) {
            return;
        }
        zzz zzzVar = this.zza;
        if (jZzf != zzzVar.zzt) {
            zzx zzxVarZzb = zzzVar.zzb();
            zzxVarZzb.zzah(jZzf);
            zzz zzzVarZzaj = zzxVarZzb.zzaj();
            this.zza = zzzVarZzaj;
            this.zzc.zzm(zzzVarZzaj);
        }
        int iZza = zzekVar.zza();
        this.zzc.zzr(zzekVar, iZza);
        this.zzc.zzt(jZze, 1, iZza, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(zzer zzerVar, zzadf zzadfVar, zzanu zzanuVar) {
        this.zzb = zzerVar;
        zzanuVar.zzc();
        zzaei zzaeiVarZzw = zzadfVar.zzw(zzanuVar.zza(), 5);
        this.zzc = zzaeiVarZzw;
        zzaeiVarZzw.zzm(this.zza);
    }
}
