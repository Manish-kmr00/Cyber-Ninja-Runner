package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdgk implements zzbjj {
    private final WeakReference zza;
    private final zzfio zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private final zzfgn zzd;

    /* synthetic */ zzdgk(zzdgm zzdgmVar, zzfio zzfioVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfgn zzfgnVar, zzdgl zzdglVar) {
        this.zza = new WeakReference(zzdgmVar);
        this.zzb = zzfioVar;
        this.zzc = zzvVar;
        this.zzd = zzfgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzdgm zzdgmVar = (zzdgm) this.zza.get();
        String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        if (zzdgmVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.zzd(str, this.zzc, this.zzd, zzdgmVar.zzD);
    }
}
