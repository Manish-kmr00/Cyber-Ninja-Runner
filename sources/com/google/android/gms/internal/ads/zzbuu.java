package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuu extends zzbus {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbnq zzd;
    private final VersionInfoParcel zze;

    public zzbuu(Context context, zzbnq zzbnqVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbnqVar;
    }

    public static /* synthetic */ Void zzb(zzbuu zzbuuVar, JSONObject jSONObject) {
        zzbbz zzbbzVar = zzbci.zza;
        com.google.android.gms.ads.internal.client.zzbd.zzb();
        SharedPreferences sharedPreferencesZza = zzbcb.zza(zzbuuVar.zzb);
        if (sharedPreferencesZza == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesZza.edit();
        com.google.android.gms.ads.internal.client.zzbd.zza();
        int i = zzbdy.zza;
        com.google.android.gms.ads.internal.client.zzbd.zza().zze(editorEdit, 1, jSONObject);
        com.google.android.gms.ads.internal.client.zzbd.zzb();
        editorEdit.commit();
        SharedPreferences sharedPreferences = zzbuuVar.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis()).apply();
        return null;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbei.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put(POBConstants.KEY_JS, versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbei.zzc.zze());
            jSONObject.put("cl", "741296643");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final ListenableFuture zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        if (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L) < ((Long) zzbei.zzd.zze()).longValue()) {
            return zzgbs.zzh(null);
        }
        return zzgbs.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzftl() { // from class: com.google.android.gms.internal.ads.zzbut
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                zzbuu.zzb(this.zza, (JSONObject) obj);
                return null;
            }
        }, zzbzk.zzg);
    }
}
