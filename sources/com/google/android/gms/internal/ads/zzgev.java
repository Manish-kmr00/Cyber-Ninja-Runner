package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgev extends zzgem {
    private final zzgfe zza;
    private final zzgvt zzb;
    private final zzgvt zzc;
    private final zzgvs zzd;

    @Nullable
    private final Integer zze;

    /* synthetic */ zzgev(zzgfe zzgfeVar, zzgvt zzgvtVar, zzgvt zzgvtVar2, zzgvs zzgvsVar, Integer num, zzgeu zzgeuVar) {
        this.zza = zzgfeVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvtVar2;
        this.zzd = zzgvsVar;
        this.zze = num;
    }

    public static zzget zzc() {
        return new zzget(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgem, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgem
    public final zzgvs zzb() {
        return this.zzd;
    }

    public final zzgfe zzd() {
        return this.zza;
    }

    public final zzgvt zze() {
        return this.zzb;
    }

    public final zzgvt zzf() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzg() {
        return this.zze;
    }
}
