package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdmr implements zzbjj {
    final /* synthetic */ zzdmt zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbjj zzd;

    /* synthetic */ zzdmr(zzdmt zzdmtVar, WeakReference weakReference, String str, zzbjj zzbjjVar, zzdms zzdmsVar) {
        this.zza = zzdmtVar;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbjjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzn(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
