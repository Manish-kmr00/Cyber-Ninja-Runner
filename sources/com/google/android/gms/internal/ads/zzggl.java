package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggl extends zzgem {
    private final zzggq zza;
    private final zzgvt zzb;
    private final zzgvs zzc;

    @Nullable
    private final Integer zzd;

    private zzggl(zzggq zzggqVar, zzgvt zzgvtVar, zzgvs zzgvsVar, @Nullable Integer num) {
        this.zza = zzggqVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvsVar;
        this.zzd = num;
    }

    public static zzggl zzc(zzggp zzggpVar, zzgvt zzgvtVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        zzggp zzggpVar2 = zzggp.zzc;
        if (zzggpVar != zzggpVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzggpVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzggpVar == zzggpVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgvtVar.zza() != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgvtVar.zza());
        }
        zzggq zzggqVarZzc = zzggq.zzc(zzggpVar);
        if (zzggqVarZzc.zzb() == zzggpVar2) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (zzggqVarZzc.zzb() == zzggp.zzb) {
            zzgvsVarZzb = zzgmj.zza(num.intValue());
        } else {
            if (zzggqVarZzc.zzb() != zzggp.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzggqVarZzc.zzb().toString()));
            }
            zzgvsVarZzb = zzgmj.zzb(num.intValue());
        }
        return new zzggl(zzggqVarZzc, zzgvtVar, zzgvsVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzc;
    }

    public final zzggq zzd() {
        return this.zza;
    }

    public final zzgvt zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzd;
    }
}
