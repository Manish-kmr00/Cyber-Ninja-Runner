package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzglm extends zzgdh {
    private final zzgnl zza;
    private final zzgvs zzb;

    public zzglm(zzgnl zzgnlVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        zzgvs zzgvsVarZza;
        zze(zzgnlVar, zzgdzVar);
        this.zza = zzgnlVar;
        if (zzgnlVar.zzc().equals(zzgtt.RAW)) {
            zzgvsVarZza = zzgvs.zzb(new byte[0]);
        } else if (zzgnlVar.zzc().equals(zzgtt.TINK)) {
            zzgvsVarZza = zzgmj.zzb(zzgnlVar.zzf().intValue());
        } else {
            if (!zzgnlVar.zzc().equals(zzgtt.LEGACY) && !zzgnlVar.zzc().equals(zzgtt.CRUNCHY)) {
                throw new GeneralSecurityException("Unknown output prefix type");
            }
            zzgvsVarZza = zzgmj.zza(zzgnlVar.zzf().intValue());
        }
        this.zzb = zzgvsVarZza;
    }

    private static void zze(zzgnl zzgnlVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        int i = zzglj.zzb[zzgnlVar.zzb().ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final zzgdv zza() {
        zzgnl zzgnlVar = this.zza;
        return new zzglk(zzgnlVar.zzg(), zzgnlVar.zzc(), null);
    }

    public final zzgnl zzb(@Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        zzgnl zzgnlVar = this.zza;
        zze(zzgnlVar, zzgdzVar);
        return zzgnlVar;
    }

    public final zzgvs zzc() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzd() {
        return this.zza.zzf();
    }
}
