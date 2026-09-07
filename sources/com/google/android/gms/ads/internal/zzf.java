package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbnq;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzn;
import com.google.android.gms.internal.ads.zzdrd;
import com.google.android.gms.internal.ads.zzdre;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfgc;
import com.google.android.gms.internal.ads.zzfgq;
import com.google.android.gms.internal.ads.zzgaz;
import com.google.android.gms.internal.ads.zzgbs;
import com.google.common.util.concurrent.ListenableFuture;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzf {
    private Context zza;
    private long zzb = 0;

    public static /* synthetic */ ListenableFuture zza(zzf zzfVar, Long l, zzdre zzdreVar, zzfgc zzfgcVar, zzfgq zzfgqVar, JSONObject jSONObject) throws JSONException {
        boolean zOptBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (zOptBoolean) {
            zzv.zzp().zzi().zzs(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdreVar, "cld_s", zzv.zzC().elapsedRealtime() - l.longValue());
            }
        }
        String strOptString = jSONObject.optString("errorMessage", "");
        if (!TextUtils.isEmpty(strOptString)) {
            zzfgcVar.zzc(strOptString);
        }
        zzfgcVar.zzg(zOptBoolean);
        zzfgqVar.zzc(zzfgcVar.zzm());
        return zzgbs.zzh(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(zzdre zzdreVar, String str, long j) {
        if (zzdreVar != null) {
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzmJ)).booleanValue()) {
                zzdrd zzdrdVarZza = zzdreVar.zza();
                zzdrdVarZza.zzb("action", "lat_init");
                zzdrdVarZza.zzb(str, Long.toString(j));
                zzdrdVarZza.zzj();
            }
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfgq zzfgqVar, zzdre zzdreVar, Long l, boolean z) {
        zzd(context, versionInfoParcel, true, null, str, null, runnable, zzfgqVar, zzdreVar, l, z);
    }

    final void zzd(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzbyu zzbyuVar, String str, String str2, Runnable runnable, final zzfgq zzfgqVar, final zzdre zzdreVar, final Long l, boolean z2) {
        PackageInfo packageInfo;
        if (zzv.zzC().elapsedRealtime() - this.zzb < 5000) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzv.zzC().elapsedRealtime();
        if (zzbyuVar != null && !TextUtils.isEmpty(zzbyuVar.zzc())) {
            if (zzv.zzC().currentTimeMillis() - zzbyuVar.zza() <= ((Long) zzbd.zzc().zzb(zzbci.zzeq)).longValue() && zzbyuVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfgc zzfgcVarZza = zzfgb.zza(context, 4);
        zzfgcVarZza.zzi();
        zzbnq zzbnqVarZza = zzv.zzg().zza(this.zza, versionInfoParcel, zzfgqVar).zza("google.afma.config.fetchAppSettings", zzbnx.zza, zzbnx.zza);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbbz zzbbzVar = zzbci.zza;
            jSONObject.put("experiment_ids", TextUtils.join(StringUtils.COMMA, zzbd.zza().zza()));
            jSONObject.put(POBConstants.KEY_JS, versionInfoParcel.afmaVersion);
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzjD)).booleanValue()) {
                jSONObject.put("inspector_enabled", z2);
            }
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            ListenableFuture listenableFutureZzb = zzbnqVarZza.zzb(jSONObject);
            ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFutureZzb, new zzgaz() { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    return zzf.zza(this.zza, l, zzdreVar, zzfgcVarZza, zzfgqVar, (JSONObject) obj);
                }
            }, zzbzk.zzg);
            if (runnable != null) {
                listenableFutureZzb.addListener(runnable, zzbzk.zzg);
            }
            if (l != null) {
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzf zzfVar = this.zza;
                        zzf.zzf(zzdreVar, "cld_r", zzv.zzC().elapsedRealtime() - l.longValue());
                    }
                }, zzbzk.zzg);
            }
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzhM)).booleanValue()) {
                zzbzn.zzb(listenableFutureZzn, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzbzn.zza(listenableFutureZzn, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e) {
            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error requesting application settings", e);
            zzfgcVarZza.zzh(e);
            zzfgcVarZza.zzg(false);
            zzfgqVar.zzc(zzfgcVarZza.zzm());
        }
    }

    public final void zze(Context context, VersionInfoParcel versionInfoParcel, String str, zzbyu zzbyuVar, zzfgq zzfgqVar, boolean z) {
        zzd(context, versionInfoParcel, false, zzbyuVar, zzbyuVar != null ? zzbyuVar.zzb() : null, str, null, zzfgqVar, null, null, z);
    }
}
