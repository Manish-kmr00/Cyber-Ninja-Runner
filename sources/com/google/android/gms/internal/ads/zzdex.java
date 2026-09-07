package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdex implements zzhey {
    private final zzdee zza;
    private final zzhfh zzb;

    public zzdex(zzdee zzdeeVar, zzhfh zzhfhVar) {
        this.zza = zzdeeVar;
        this.zzb = zzhfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
