package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzges implements zzgnk {
    private static final zzges zza = new zzges();
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgeo
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgjy.zzb((zzglm) zzgdhVar);
        }
    }, zzglm.class, zzgcy.class);

    zzges() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzgmf.zza().zzd(zza);
        zzgmf.zza().zzc(zzb);
    }

    public static void zzd(zzgnb zzgnbVar) throws GeneralSecurityException {
        zzgnbVar.zzb(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zza() {
        return zzgcy.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zzb() {
        return zzgcy.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final /* bridge */ /* synthetic */ Object zze(zzglh zzglhVar, zzglq zzglqVar, zzgdl zzgdlVar) throws GeneralSecurityException {
        zzglr zzglrVar;
        zzglr zzglrVarZza;
        zzgvs zzgvsVarZzc;
        zzgmt zzgmtVar = new zzgmt();
        for (int i = 0; i < zzglhVar.zza(); i++) {
            zzglg zzglgVarZzd = zzglhVar.zzd(i);
            zzgdh zzgdhVarZzb = zzglgVarZzd.zzb();
            if (zzgdhVarZzb instanceof zzgem) {
                zzgvsVarZzc = ((zzgem) zzgdhVarZzb).zzb();
            } else {
                if (!(zzgdhVarZzb instanceof zzglm)) {
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzgdhVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzgdhVarZzb.zza()));
                }
                zzgvsVarZzc = ((zzglm) zzgdhVarZzb).zzc();
            }
            zzgmtVar.zza(zzgvsVarZzc, new zzgep((zzgcy) zzgdlVar.zza(zzglgVarZzd), zzglgVarZzd.zza()));
        }
        if (zzglqVar.zza()) {
            zzglrVar = zzglv.zza;
            zzglrVarZza = zzglrVar;
        } else {
            zzgls zzglsVarZza = zzgmd.zzb().zza();
            zzglr zzglrVarZza2 = zzglsVarZza.zza(zzglhVar, zzglqVar, "aead", "encrypt");
            zzglrVarZza = zzglsVarZza.zza(zzglhVar, zzglqVar, "aead", "decrypt");
            zzglrVar = zzglrVarZza2;
        }
        return new zzgeq(new zzgep((zzgcy) zzgdlVar.zza(zzglhVar.zze()), zzglhVar.zze().zza()), zzgmtVar.zzb(), zzglrVar, zzglrVarZza, null);
    }
}
