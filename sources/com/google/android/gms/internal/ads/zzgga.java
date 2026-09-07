package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgga {

    @Nullable
    private zzggk zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgga() {
    }

    /* synthetic */ zzgga(zzggb zzggbVar) {
    }

    public final zzgga zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgga zzb(zzgvt zzgvtVar) {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzgga zzc(zzggk zzggkVar) {
        this.zza = zzggkVar;
        return this;
    }

    public final zzggc zzd() throws GeneralSecurityException {
        zzgvt zzgvtVar;
        zzgvs zzgvsVarZzb;
        zzggk zzggkVar = this.zza;
        if (zzggkVar == null || (zzgvtVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzggkVar.zzb() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzggkVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzggi.zzc) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (this.zza.zzd() == zzggi.zzb) {
            zzgvsVarZzb = zzgmj.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzggi.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            zzgvsVarZzb = zzgmj.zzb(this.zzc.intValue());
        }
        return new zzggc(this.zza, this.zzb, zzgvsVarZzb, this.zzc, null);
    }
}
