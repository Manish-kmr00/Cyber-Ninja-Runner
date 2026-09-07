package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgib extends zzgem {
    private final zzgig zza;
    private final zzgvt zzb;
    private final zzgvs zzc;

    @Nullable
    private final Integer zzd;

    private zzgib(zzgig zzgigVar, zzgvt zzgvtVar, zzgvs zzgvsVar, @Nullable Integer num) {
        this.zza = zzgigVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvsVar;
        this.zzd = num;
    }

    public static zzgib zzc(zzgig zzgigVar, zzgvt zzgvtVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgvs zzgvsVarZzb;
        zzgif zzgifVarZzc = zzgigVar.zzc();
        zzgif zzgifVar = zzgif.zzb;
        if (zzgifVarZzc != zzgifVar && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzgigVar.zzc().toString() + " the value of idRequirement must be non-null");
        }
        if (zzgigVar.zzc() == zzgifVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgvtVar.zza() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzgvtVar.zza());
        }
        if (zzgigVar.zzc() == zzgifVar) {
            zzgvsVarZzb = zzgmj.zza;
        } else {
            if (zzgigVar.zzc() != zzgif.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgigVar.zzc().toString()));
            }
            zzgvsVarZzb = zzgmj.zzb(num.intValue());
        }
        return new zzgib(zzgigVar, zzgvtVar, zzgvsVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzc;
    }

    public final zzgig zzd() {
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
