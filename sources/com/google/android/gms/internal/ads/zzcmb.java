package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcmb implements zzcvf {
    private final zzfax zza;
    private final zzfbg zzb;
    private final zzfik zzc;
    private final zzfio zzd;

    public zzcmb(zzfbg zzfbgVar, zzfio zzfioVar, zzfik zzfikVar) {
        this.zzb = zzfbgVar;
        this.zzd = zzfioVar;
        this.zzc = zzfikVar;
        this.zza = zzfbgVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zze(this.zzc.zzd(this.zzb, null, list), null);
    }
}
