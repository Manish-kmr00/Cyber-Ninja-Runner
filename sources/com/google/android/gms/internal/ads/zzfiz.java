package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfiz {
    private final zzdre zza;
    private final String zzb;

    zzfiz(zzdre zzdreVar, Context context) {
        CharSequence applicationLabel;
        this.zza = zzdreVar;
        zzfqf zzfqfVar = com.google.android.gms.ads.internal.util.zzs.zza;
        try {
            applicationLabel = Wrappers.packageManager(context).getApplicationLabel(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get application name", e);
            applicationLabel = "";
        }
        this.zzb = applicationLabel.toString();
    }

    private final void zzj(AdFormat adFormat, String str, String str2, long j, int i, int i2, String str3) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb(str2, Long.toString(j));
        zzdrdVarZza.zzb("app", this.zzb);
        zzdrdVarZza.zzb("ad_format", adFormat == null ? "unknown" : adFormat.name());
        if (str != null) {
            zzdrdVarZza.zzb("action", str);
        }
        if (str3 != null) {
            zzdrdVarZza.zzb("gqi", str3);
        }
        if (i >= 0) {
            zzdrdVarZza.zzb("max_ads", Integer.toString(i));
        }
        if (i2 >= 0) {
            zzdrdVarZza.zzb("cache_size", Integer.toString(i2));
        }
        zzdrdVarZza.zzj();
    }

    public final void zza(AdFormat adFormat, int i, int i2, long j) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("action", "cache_resize");
        zzdrdVarZza.zzb("cs_ts", Long.toString(j));
        zzdrdVarZza.zzb("app", this.zzb);
        zzdrdVarZza.zzb("orig_ma", Integer.toString(i));
        zzdrdVarZza.zzb("max_ads", Integer.toString(i2));
        zzdrdVarZza.zzb("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdrdVarZza.zzj();
    }

    public final void zzb(AdFormat adFormat, int i, int i2, long j, Long l, String str) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("plaac_ts", Long.toString(j));
        zzdrdVarZza.zzb("ad_format", adFormat.name());
        zzdrdVarZza.zzb("app", this.zzb);
        zzdrdVarZza.zzb("max_ads", Integer.toString(i));
        zzdrdVarZza.zzb("cache_size", Integer.toString(i2));
        zzdrdVarZza.zzb("action", "is_ad_available");
        if (l != null) {
            zzdrdVarZza.zzb("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zzdrdVarZza.zzb("gqi", str);
        }
        zzdrdVarZza.zzj();
    }

    public final void zzc(AdFormat adFormat, long j, String str) {
        zzj(adFormat, null, "pano_ts", j, -1, -1, str);
    }

    public final void zzd(AdFormat adFormat, long j) {
        zzj(adFormat, null, "paeo_ts", j, -1, -1, null);
    }

    public final void zze(AdFormat adFormat, long j) {
        zzj(adFormat, "poll_ad", "ppac_ts", j, -1, -1, null);
    }

    public final void zzf(AdFormat adFormat, long j, int i, int i2, String str) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("ppla_ts", Long.toString(j));
        zzdrdVarZza.zzb("ad_format", adFormat.name());
        zzdrdVarZza.zzb("app", this.zzb);
        zzdrdVarZza.zzb("max_ads", Integer.toString(i));
        zzdrdVarZza.zzb("cache_size", Integer.toString(i2));
        zzdrdVarZza.zzb("action", "poll_ad");
        if (str != null) {
            zzdrdVarZza.zzb("gqi", str);
        }
        zzdrdVarZza.zzj();
    }

    public final void zzg(AdFormat adFormat, long j, int i, int i2, String str) {
        zzj(adFormat, "poll_ad", "psvroc_ts", j, i, i2, str);
    }

    public final void zzh(Map map, long j) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("action", "start_preload");
        zzdrdVarZza.zzb("sp_ts", Long.toString(j));
        zzdrdVarZza.zzb("app", this.zzb);
        for (AdFormat adFormat : map.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdrdVarZza.zzb(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdrdVarZza.zzj();
    }

    public final void zzi(AdFormat adFormat, int i, long j) {
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("action", "start_preload");
        zzdrdVarZza.zzb("sp_ts", Long.toString(j));
        zzdrdVarZza.zzb("app", this.zzb);
        zzdrdVarZza.zzb("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdrdVarZza.zzb("max_ads", Integer.toString(i));
        zzdrdVarZza.zzj();
    }
}
