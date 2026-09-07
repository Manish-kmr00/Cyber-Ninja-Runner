package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzano implements zzanh {
    final /* synthetic */ zzanq zza;
    private final zzej zzb = new zzej(new byte[4], 4);

    public zzano(zzanq zzanqVar) {
        this.zza = zzanqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzek zzekVar) {
        if (zzekVar.zzm() == 0 && (zzekVar.zzm() & 128) != 0) {
            zzekVar.zzM(6);
            int iZza = zzekVar.zza() / 4;
            for (int i = 0; i < iZza; i++) {
                zzej zzejVar = this.zzb;
                zzekVar.zzG(zzejVar, 4);
                int iZzd = zzejVar.zzd(16);
                zzejVar.zzn(3);
                if (iZzd == 0) {
                    zzejVar.zzn(13);
                } else {
                    int iZzd2 = zzejVar.zzd(13);
                    zzanq zzanqVar = this.zza;
                    if (zzanqVar.zzg.get(iZzd2) == null) {
                        zzanqVar.zzg.put(iZzd2, new zzani(new zzanp(zzanqVar, iZzd2)));
                        zzanqVar.zzm++;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(zzer zzerVar, zzadf zzadfVar, zzanu zzanuVar) {
    }
}
