package com.google.android.gms.internal.ads;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class zzbih implements zzbjj {
    public final /* synthetic */ zzddc zza;
    public final /* synthetic */ zzclx zzb;

    public /* synthetic */ zzbih(zzddc zzddcVar, zzclx zzclxVar) {
        this.zza = zzddcVar;
        this.zzb = zzclxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        zzbji.zzc(map, this.zza);
        final String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from click GMSG.");
        } else {
            final zzclx zzclxVar = this.zzb;
            zzgbs.zzr((zzgbj) zzgbs.zzn(zzgbj.zzE(zzbji.zza(zzcelVar, str)), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzbik
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj2) {
                    zzclx zzclxVar2;
                    String str2 = (String) obj2;
                    zzbjj zzbjjVar = zzbji.zza;
                    return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkf)).booleanValue() && (zzclxVar2 = zzclxVar) != null && zzclx.zzj(str)) ? zzclxVar2.zze(str2, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgbs.zzh(str2);
                }
            }, zzbzk.zza), new zzbix(zzcelVar), zzbzk.zza);
        }
    }
}
