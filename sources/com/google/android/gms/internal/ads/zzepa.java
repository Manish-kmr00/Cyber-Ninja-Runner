package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzepa implements zzhey {
    private final zzhfh zza;

    public zzepa(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzerh(zzepx.zza(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmo)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
