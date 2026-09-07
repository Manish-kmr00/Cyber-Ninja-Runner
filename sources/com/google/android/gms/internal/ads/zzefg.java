package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefg implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;

    public zzefg(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5) {
        this.zza = zzhfhVar2;
        this.zzb = zzhfhVar3;
        this.zzc = zzhfhVar4;
        this.zzd = zzhfhVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzefe zzb() {
        return new zzefe(zzfen.zzc(), (ScheduledExecutorService) this.zza.zzb(), (zzcqj) this.zzb.zzb(), (zzefu) this.zzc.zzb(), (zzfik) this.zzd.zzb());
    }
}
