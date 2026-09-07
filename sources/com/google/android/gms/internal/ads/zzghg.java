package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzghg extends zzgem {
    private final zzghl zza;
    private final zzgvs zzb;

    @Nullable
    private final Integer zzc;

    private zzghg(zzghl zzghlVar, zzgvs zzgvsVar, @Nullable Integer num) {
        this.zza = zzghlVar;
        this.zzb = zzgvsVar;
        this.zzc = num;
    }

    public static zzghg zzc(zzghl zzghlVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        if (zzghlVar.zzc() == zzghj.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzgvsVarZzb = zzgmj.zza;
        } else {
            if (zzghlVar.zzc() != zzghj.zza) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(String.valueOf(zzghlVar.zzc()))));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzgvsVarZzb = zzgmj.zzb(num.intValue());
        }
        return new zzghg(zzghlVar, zzgvsVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzb;
    }

    public final zzghl zzd() {
        return this.zza;
    }

    public final Integer zze() {
        return this.zzc;
    }
}
