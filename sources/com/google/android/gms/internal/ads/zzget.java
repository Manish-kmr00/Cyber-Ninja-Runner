package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzget {

    @Nullable
    private zzgfe zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private zzgvt zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzget() {
    }

    /* synthetic */ zzget(zzgeu zzgeuVar) {
    }

    public final zzget zza(zzgvt zzgvtVar) {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzget zzb(zzgvt zzgvtVar) {
        this.zzc = zzgvtVar;
        return this;
    }

    public final zzget zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzget zzd(zzgfe zzgfeVar) {
        this.zza = zzgfeVar;
        return this;
    }

    public final zzgev zze() throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        zzgfe zzgfeVar = this.zza;
        if (zzgfeVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzgvt zzgvtVar = this.zzb;
        if (zzgvtVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzgfeVar.zzb() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzgfeVar.zzc() != this.zzc.zza()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzh() == zzgfc.zzc) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (this.zza.zzh() == zzgfc.zzb) {
            zzgvsVarZzb = zzgmj.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzh() != zzgfc.zza) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzh()))));
            }
            zzgvsVarZzb = zzgmj.zzb(this.zzd.intValue());
        }
        return new zzgev(this.zza, this.zzb, this.zzc, zzgvsVarZzb, this.zzd, null);
    }
}
