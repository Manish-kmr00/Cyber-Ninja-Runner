package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggy extends zzgem {
    private final zzgha zza;
    private final zzgvs zzb;

    @Nullable
    private final Integer zzc;

    private zzggy(zzgha zzghaVar, zzgvs zzgvsVar, @Nullable Integer num) {
        this.zza = zzghaVar;
        this.zzb = zzgvsVar;
        this.zzc = num;
    }

    public static zzggy zzc(zzgha zzghaVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        if (zzghaVar.zzb() == zzggz.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzgvsVarZzb = zzgvs.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzghaVar.zzb() != zzggz.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzghaVar.zzb().toString()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzgvsVarZzb = zzgvs.zzb(new byte[0]);
        }
        return new zzggy(zzghaVar, zzgvsVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzb;
    }

    public final zzgha zzd() {
        return this.zza;
    }

    public final Integer zze() {
        return this.zzc;
    }
}
