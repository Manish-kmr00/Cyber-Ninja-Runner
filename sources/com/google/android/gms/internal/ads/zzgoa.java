package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgoa extends zzgpb {
    private final zzgoi zza;
    private final zzgvt zzb;
    private final zzgvs zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzgoa(zzgoi zzgoiVar, zzgvt zzgvtVar, zzgvs zzgvsVar, Integer num, zzgnz zzgnzVar) {
        this.zza = zzgoiVar;
        this.zzb = zzgvtVar;
        this.zzc = zzgvsVar;
        this.zzd = num;
    }

    public static zzgny zzb() {
        return new zzgny(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgpb, com.google.android.gms.internal.ads.zzgdh
    public final /* synthetic */ zzgdv zza() {
        return this.zza;
    }

    public final zzgoi zzc() {
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
