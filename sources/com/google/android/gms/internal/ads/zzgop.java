package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgop extends zzgpb {
    private final zzgoz zza;
    private final zzgvt zzb;
    private final zzgvs zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzgop(zzgoz zzgozVar, zzgvt zzgvtVar, zzgvs zzgvsVar, Integer num, zzgoo zzgooVar) {
        this.zza = zzgozVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvsVar;
        this.zzd = num;
    }

    public static zzgon zzb() {
        return new zzgon(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgpb, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    public final zzgoz zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgpb
    public final zzgvs zzd() {
        return this.zzc;
    }

    public final zzgvt zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzd;
    }
}
