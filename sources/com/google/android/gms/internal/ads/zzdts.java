package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdts implements zzhey {
    private final zzhfh zza;

    public zzdts(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
    }

    public static zzdcu zza(zzdtr zzdtrVar, Executor executor) {
        return new zzdcu(zzdtrVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza((zzdtr) this.zza.zzb(), zzfen.zzc());
    }
}
