package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeou implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;

    public zzeou(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzerh zzerhVar;
        zzemx zzemxVarZzb = ((zzemz) this.zza).zzb();
        zzenn zzennVar = (zzenn) this.zzb.zzb();
        List list = (List) this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        if (list.contains(Protocol.VAST_4_2)) {
            zzerhVar = new zzerh(zzennVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzms)).intValue(), scheduledExecutorService);
        } else {
            zzerhVar = new zzerh(zzemxVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzms)).intValue(), scheduledExecutorService);
        }
        return zzerhVar;
    }
}
