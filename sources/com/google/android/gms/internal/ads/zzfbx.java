package com.google.android.gms.internal.ads;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class zzfbx implements zzbjj {
    public final /* synthetic */ zzddc zza;
    public final /* synthetic */ zzclx zzb;
    public final /* synthetic */ zzfio zzc;
    public final /* synthetic */ zzeat zzd;

    public /* synthetic */ zzfbx(zzddc zzddcVar, zzclx zzclxVar, zzfio zzfioVar, zzeat zzeatVar) {
        this.zza = zzddcVar;
        this.zzb = zzclxVar;
        this.zzc = zzfioVar;
        this.zzd = zzeatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        zzbji.zzc(map, this.zza);
        String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from click GMSG.");
        } else {
            zzeat zzeatVar = this.zzd;
            zzfio zzfioVar = this.zzc;
            zzgbs.zzr(zzbji.zza(zzcelVar, str), new zzfbz(zzcelVar, this.zzb, zzfioVar, zzeatVar), zzbzk.zza);
        }
    }
}
