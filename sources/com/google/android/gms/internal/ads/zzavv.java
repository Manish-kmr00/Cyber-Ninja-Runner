package com.google.android.gms.internal.ads;

import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.safedk.android.analytics.brandsafety.l;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzavv implements zzfoo {
    private final zzfmt zza;
    private final zzfni zzb;
    private final zzawi zzc;
    private final zzavu zzd;
    private final zzave zze;
    private final zzawk zzf;
    private final zzawc zzg;
    private final zzavt zzh;

    zzavv(zzfmt zzfmtVar, zzfni zzfniVar, zzawi zzawiVar, zzavu zzavuVar, zzave zzaveVar, zzawk zzawkVar, zzawc zzawcVar, zzavt zzavtVar) {
        this.zza = zzfmtVar;
        this.zzb = zzfniVar;
        this.zzc = zzawiVar;
        this.zzd = zzavuVar;
        this.zze = zzaveVar;
        this.zzf = zzawkVar;
        this.zzg = zzawcVar;
        this.zzh = zzavtVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzfmt zzfmtVar = this.zza;
        zzasu zzasuVarZzb = this.zzb.zzb();
        map.put("v", zzfmtVar.zzd());
        map.put("gms", Boolean.valueOf(zzfmtVar.zzg()));
        map.put(l.w, zzasuVarZzb.zzg());
        map.put("attts", Long.valueOf(zzasuVarZzb.zzf().zza()));
        map.put("att", zzasuVarZzb.zzf().zzd());
        map.put("attkid", zzasuVarZzb.zzf().zzf());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, new Throwable());
        zzawc zzawcVar = this.zzg;
        if (zzawcVar != null) {
            map.put("tcq", Long.valueOf(zzawcVar.zzc()));
            map.put("tpq", Long.valueOf(zzawcVar.zzg()));
            map.put("tcv", Long.valueOf(zzawcVar.zzd()));
            map.put("tpv", Long.valueOf(zzawcVar.zzh()));
            map.put("tchv", Long.valueOf(zzawcVar.zzb()));
            map.put("tphv", Long.valueOf(zzawcVar.zzf()));
            map.put("tcc", Long.valueOf(zzawcVar.zza()));
            map.put("tpc", Long.valueOf(zzawcVar.zze()));
            zzave zzaveVar = this.zze;
            if (zzaveVar != null) {
                map.put("nt", Long.valueOf(zzaveVar.zza()));
            }
            zzawk zzawkVar = this.zzf;
            if (zzawkVar != null) {
                map.put("vs", Long.valueOf(zzawkVar.zzc()));
                map.put(ApsMetricsDataMap.APSMETRICS_FIELD_VIDEOFLAG, Long.valueOf(zzawkVar.zzb()));
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzfoo
    public final Map zza() {
        zzawi zzawiVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzawiVar.zza()));
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfoo
    public final Map zzb() {
        return zze();
    }

    @Override // com.google.android.gms.internal.ads.zzfoo
    public final Map zzc() {
        zzavt zzavtVar = this.zzh;
        Map mapZze = zze();
        if (zzavtVar != null) {
            mapZze.put("vst", zzavtVar.zza());
        }
        return mapZze;
    }

    final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
