package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgih extends zzgem {
    private final zzgin zza;
    private final zzgvt zzb;
    private final zzgvs zzc;

    @Nullable
    private final Integer zzd;

    private zzgih(zzgin zzginVar, zzgvt zzgvtVar, zzgvs zzgvsVar, @Nullable Integer num) {
        this.zza = zzginVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvsVar;
        this.zzd = num;
    }

    public static zzgih zzc(zzgim zzgimVar, zzgvt zzgvtVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        zzgim zzgimVar2 = zzgim.zzc;
        if (zzgimVar != zzgimVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzgimVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzgimVar == zzgimVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgvtVar.zza() != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgvtVar.zza());
        }
        zzgin zzginVarZzc = zzgin.zzc(zzgimVar);
        if (zzginVarZzc.zzb() == zzgimVar2) {
            zzgvsVarZzb = zzgmj.zza;
        } else if (zzginVarZzc.zzb() == zzgim.zzb) {
            zzgvsVarZzb = zzgmj.zza(num.intValue());
        } else {
            if (zzginVarZzc.zzb() != zzgim.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzginVarZzc.zzb().toString()));
            }
            zzgvsVarZzb = zzgmj.zzb(num.intValue());
        }
        return new zzgih(zzginVarZzc, zzgvtVar, zzgvsVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzc;
    }

    public final zzgin zzd() {
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
