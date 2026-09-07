package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeox implements zzhey {
    private final zzhfh zza;

    public zzeox(zzhfh zzhfhVar, zzhfh zzhfhVar2) {
        this.zza = zzhfhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxbVarZzn;
        zzenp zzenpVarZza = zzenr.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzen)).booleanValue()) {
            zzfxbVarZzn = zzfxb.zzo(new zzerh(zzenpVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeo)).intValue(), scheduledExecutorService));
        } else {
            zzfxbVarZzn = zzfxb.zzn();
        }
        zzhfg.zzb(zzfxbVarZzn);
        return zzfxbVarZzn;
    }
}
