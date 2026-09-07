package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgph implements zzgnk {
    private static final zzgph zza = new zzgph();
    private static final zzgna zzb = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzgpd
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) {
            return zzgqb.zza((zzglm) zzgdhVar);
        }
    }, zzglm.class, zzgdu.class);

    zzgph() {
    }

    static void zzc() throws GeneralSecurityException {
        zzgmf.zza().zzd(zza);
        zzgmf.zza().zzc(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zza() {
        return zzgdu.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zzb() {
        return zzgdu.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final /* bridge */ /* synthetic */ Object zze(zzglh zzglhVar, zzglq zzglqVar, zzgdl zzgdlVar) throws GeneralSecurityException {
        zzglr zzglrVar;
        zzglr zzglrVarZza;
        zzgvs zzgvsVarZzc;
        zzgmt zzgmtVar = new zzgmt();
        for (int i = 0; i < zzglhVar.zza(); i++) {
            zzglg zzglgVarZzd = zzglhVar.zzd(i);
            zzgdu zzgduVar = (zzgdu) zzgdlVar.zza(zzglgVarZzd);
            zzgdh zzgdhVarZzb = zzglgVarZzd.zzb();
            if (zzgdhVarZzb instanceof zzgpb) {
                zzgvsVarZzc = ((zzgpb) zzgdhVarZzb).zzd();
            } else {
                if (!(zzgdhVarZzb instanceof zzglm)) {
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzgdhVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzgdhVarZzb.zza()));
                }
                zzgvsVarZzc = ((zzglm) zzgdhVarZzb).zzc();
            }
            zzgmtVar.zza(zzgvsVarZzc, new zzgpe(zzgduVar, zzglgVarZzd.zza()));
        }
        if (zzglqVar.zza()) {
            zzglrVar = zzglv.zza;
            zzglrVarZza = zzglrVar;
        } else {
            zzgls zzglsVarZza = zzgmd.zzb().zza();
            zzglr zzglrVarZza2 = zzglsVarZza.zza(zzglhVar, zzglqVar, "mac", "compute");
            zzglrVarZza = zzglsVarZza.zza(zzglhVar, zzglqVar, "mac", "verify");
            zzglrVar = zzglrVarZza2;
        }
        return new zzgpf(new zzgpe((zzgdu) zzgdlVar.zza(zzglhVar.zze()), zzglhVar.zze().zza()), zzgmtVar.zzb(), zzglrVar, zzglrVarZza, null);
    }
}
