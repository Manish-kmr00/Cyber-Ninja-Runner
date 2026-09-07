package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqb implements zzgdu {
    private zzgqb(zzgdu zzgduVar, zzgtt zzgttVar, byte[] bArr) {
    }

    public static zzgdu zza(zzglm zzglmVar) throws GeneralSecurityException {
        byte[] bArrZzd;
        zzgnl zzgnlVarZzb = zzglmVar.zzb(zzgdg.zza());
        zzgsm zzgsmVarZza = zzgsp.zza();
        zzgsmVarZza.zzb(zzgnlVarZzb.zzg());
        zzgsmVarZza.zzc(zzgnlVarZzb.zze());
        zzgsmVarZza.zza(zzgnlVarZzb.zzb());
        zzgdu zzgduVar = (zzgdu) zzgdy.zza((zzgsp) zzgsmVarZza.zzbr(), zzgdu.class);
        zzgtt zzgttVarZzc = zzgnlVarZzb.zzc();
        int iOrdinal = zzgttVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzd = zzgmj.zzb(zzglmVar.zzd().intValue()).zzd();
        } else if (iOrdinal == 2) {
            bArrZzd = zzgmj.zza(zzglmVar.zzd().intValue()).zzd();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzd = zzgmj.zza(zzglmVar.zzd().intValue()).zzd();
        } else {
            bArrZzd = zzgmj.zza.zzd();
        }
        return new zzgqb(zzgduVar, zzgttVarZzc, bArrZzd);
    }
}
