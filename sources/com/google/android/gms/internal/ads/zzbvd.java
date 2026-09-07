package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbvd implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvf zzb;

    zzbvd(zzbvf zzbvfVar, Context context) {
        this.zza = context;
        this.zzb = zzbvfVar;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0038  */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbvc zzbvcVarZza;
        zzbvf zzbvfVar = this.zzb;
        WeakHashMap weakHashMap = zzbvfVar.zza;
        Context context = this.zza;
        zzbve zzbveVar = (zzbve) weakHashMap.get(context);
        if (zzbveVar != null) {
            if (zzbveVar.zza + ((Long) zzbdx.zzd.zze()).longValue() < com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis()) {
                zzbvcVarZza = new zzbvb(context).zza();
            } else {
                zzbvcVarZza = new zzbvb(context, zzbveVar.zzb).zza();
            }
        } else {
            zzbvcVarZza = new zzbvb(context).zza();
        }
        zzbvfVar.zza.put(context, new zzbve(zzbvfVar, zzbvcVarZza));
        return zzbvcVarZza;
    }
}
