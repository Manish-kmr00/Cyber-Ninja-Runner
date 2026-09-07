package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgfp {

    @Nullable
    private zzgfz zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgfp() {
    }

    /* synthetic */ zzgfp(zzgfq zzgfqVar) {
    }

    public final zzgfp zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgfp zzb(zzgvt zzgvtVar) {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzgfp zzc(zzgfz zzgfzVar) {
        this.zza = zzgfzVar;
        return this;
    }

    public final zzgfr zzd() throws GeneralSecurityException {
        zzgvt zzgvtVar;
        zzgvs zzgvsVarZzb;
        zzgfz zzgfzVar = this.zza;
        if (zzgfzVar == null || (zzgvtVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgfzVar.zzb() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgfzVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgfx.zzc) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (this.zza.zzd() == zzgfx.zzb) {
            zzgvsVarZzb = zzgmj.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzgfx.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            zzgvsVarZzb = zzgmj.zzb(this.zzc.intValue());
        }
        return new zzgfr(this.zza, this.zzb, zzgvsVarZzb, this.zzc, null);
    }
}
