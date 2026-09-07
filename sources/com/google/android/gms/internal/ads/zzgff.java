package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgff {

    @Nullable
    private zzgfo zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgff() {
    }

    /* synthetic */ zzgff(zzgfg zzgfgVar) {
    }

    public final zzgff zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgff zzb(zzgvt zzgvtVar) {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzgff zzc(zzgfo zzgfoVar) {
        this.zza = zzgfoVar;
        return this;
    }

    public final zzgfh zzd() throws GeneralSecurityException {
        zzgvt zzgvtVar;
        zzgvs zzgvsVarZzb;
        zzgfo zzgfoVar = this.zza;
        if (zzgfoVar == null || (zzgvtVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgfoVar.zzc() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgfoVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzgfm.zzc) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (this.zza.zze() == zzgfm.zzb) {
            zzgvsVarZzb = zzgmj.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzgfm.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zze()))));
            }
            zzgvsVarZzb = zzgmj.zzb(this.zzc.intValue());
        }
        return new zzgfh(this.zza, this.zzb, zzgvsVarZzb, this.zzc, null);
    }
}
