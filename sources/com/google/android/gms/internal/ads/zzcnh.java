package com.google.android.gms.internal.ads;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcnh {
    private final zzdre zza;
    private final zzfbg zzb;

    zzcnh(zzdre zzdreVar, zzfbg zzfbgVar) {
        this.zza = zzdreVar;
        this.zzb = zzfbgVar;
    }

    public final void zza(long j, int i) {
        String str;
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzd(this.zzb.zzb.zzb);
        zzdrdVarZza.zzb("action", "ad_closed");
        zzdrdVarZza.zzb("show_time", String.valueOf(j));
        zzdrdVarZza.zzb("ad_format", "app_open_ad");
        int i2 = i - 1;
        if (i2 == 0) {
            str = "h";
        } else if (i2 == 1) {
            str = "bb";
        } else if (i2 == 2) {
            str = "cc";
        } else if (i2 != 3) {
            str = i2 != 4 ? ApsMetricsDataMap.APSMETRICS_FIELD_URL : CampaignEx.KEY_ACTIVITY_PATH_AND_NAME;
        } else {
            str = "cb";
        }
        zzdrdVarZza.zzb("acr", str);
        zzdrdVarZza.zzj();
    }
}
