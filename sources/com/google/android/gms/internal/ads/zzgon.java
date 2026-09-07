package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgon {

    @Nullable
    private zzgoz zza = null;

    @Nullable
    private zzgvt zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgon() {
    }

    /* synthetic */ zzgon(zzgoo zzgooVar) {
    }

    public final zzgon zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgon zzb(zzgvt zzgvtVar) {
        this.zzb = zzgvtVar;
        return this;
    }

    public final zzgon zzc(zzgoz zzgozVar) {
        this.zza = zzgozVar;
        return this;
    }

    public final zzgop zzd() throws GeneralSecurityException {
        zzgvt zzgvtVar;
        zzgvs zzgvsVarZza;
        zzgoz zzgozVar = this.zza;
        if (zzgozVar == null || (zzgvtVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgozVar.zzc() != zzgvtVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgozVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzgox.zzd) {
            zzgvsVarZza = zzgmj.zza;
        } else if (this.zza.zzg() == zzgox.zzc || this.zza.zzg() == zzgox.zzb) {
            zzgvsVarZza = zzgmj.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzg() != zzgox.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzg()))));
            }
            zzgvsVarZza = zzgmj.zzb(this.zzc.intValue());
        }
        return new zzgop(this.zza, this.zzb, zzgvsVarZza, this.zzc, null);
    }
}
