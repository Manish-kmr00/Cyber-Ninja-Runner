package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzepf implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzepf(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar2;
        this.zzb = zzhfhVar3;
        this.zzc = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzerh zzerhVar;
        zzeqs zzeqsVarZza = zzequ.zza();
        zzenn zzennVar = (zzenn) this.zza.zzb();
        List list = (List) this.zzb.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (list.contains("24")) {
            zzerhVar = new zzerh(zzennVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmm)).intValue(), scheduledExecutorService);
        } else {
            zzerhVar = new zzerh(zzeqsVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmm)).intValue(), scheduledExecutorService);
        }
        return zzerhVar;
    }
}
