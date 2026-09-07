package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcsd implements zzhey {
    private final zzhfh zza;

    public zzcsd(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar;
    }

    public static zzdcu zza(zzcmj zzcmjVar, Executor executor) {
        return new zzdcu(zzcmjVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza((zzcmj) this.zza.zzb(), zzfen.zzc());
    }
}
