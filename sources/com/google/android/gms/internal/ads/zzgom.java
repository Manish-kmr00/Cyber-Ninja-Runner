package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgom implements zzgnk {
    private static final zzgom zza = new zzgom();

    private zzgom() {
    }

    static void zzc() throws GeneralSecurityException {
        zzgmf.zza().zzd(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zza() {
        return zzgoj.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zzb() {
        return zzgoj.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final /* bridge */ /* synthetic */ Object zze(zzglh zzglhVar, zzglq zzglqVar, zzgdl zzgdlVar) throws GeneralSecurityException {
        zzgvs zzgvsVarZzc;
        zzglg zzglgVarZze = zzglhVar.zze();
        if (zzglgVarZze == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        zzgmt zzgmtVar = new zzgmt();
        for (int i = 0; i < zzglhVar.zza(); i++) {
            zzglg zzglgVarZzd = zzglhVar.zzd(i);
            zzgoj zzgojVar = (zzgoj) zzgdlVar.zza(zzglgVarZzd);
            zzgdh zzgdhVarZzb = zzglgVarZzd.zzb();
            if (zzgdhVarZzb instanceof zzgpb) {
                zzgvsVarZzc = ((zzgpb) zzgdhVarZzb).zzd();
            } else {
                if (!(zzgdhVarZzb instanceof zzglm)) {
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzgdhVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzgdhVarZzb.zza()));
                }
                zzgvsVarZzc = ((zzglm) zzgdhVarZzb).zzc();
            }
            zzgmtVar.zza(zzgvsVarZzc, zzgojVar);
        }
        return new zzgok(zzgmtVar.zzb(), (zzgoj) zzgdlVar.zza(zzglgVarZze), null);
    }
}
