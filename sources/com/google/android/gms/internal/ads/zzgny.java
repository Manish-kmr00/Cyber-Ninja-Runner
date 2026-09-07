package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgny {

    @Nullable
    private zzgoi zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgny() {
    }

    /* synthetic */ zzgny(zzgnz zzgnzVar) {
    }

    public final zzgny zza(zzgvt zzgvtVar) throws GeneralSecurityException {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzgny zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgny zzc(zzgoi zzgoiVar) {
        this.zza = zzgoiVar;
        return this;
    }

    public final zzgoa zzd() throws GeneralSecurityException {
        zzgvt zzgvtVar;
        zzgvs zzgvsVarZza;
        zzgoi zzgoiVar = this.zza;
        if (zzgoiVar == null || (zzgvtVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgoiVar.zzc() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgoiVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzgog.zzd) {
            zzgvsVarZza = zzgmj.zza;
        } else if (this.zza.zzf() == zzgog.zzc || this.zza.zzf() == zzgog.zzb) {
            zzgvsVarZza = zzgmj.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzgog.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            zzgvsVarZza = zzgmj.zzb(this.zzc.intValue());
        }
        return new zzgoa(this.zza, this.zzb, zzgvsVarZza, this.zzc, null);
    }
}
