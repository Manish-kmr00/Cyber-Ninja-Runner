package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdre {
    private final zzdrj zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdre(zzdrj zzdrjVar, Executor executor) {
        this.zza = zzdrjVar;
        this.zzc = zzdrjVar.zza();
        this.zzb = executor;
    }

    public final zzdrd zza() {
        zzdrd zzdrdVar = new zzdrd(this);
        zzdrd.zza(zzdrdVar);
        return zzdrdVar;
    }

    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlI)).booleanValue()) {
            zzdrd zzdrdVarZza = zza();
            zzdrdVarZza.zzb("action", "pecr");
            zzdrdVarZza.zzj();
        }
    }
}
