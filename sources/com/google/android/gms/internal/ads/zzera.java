package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzera implements zzesu {
    private final zzfbp zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzera(zzfbp zzfbpVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfbpVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i;
        zzbfi zzbfiVar = this.zza.zzi;
        if (zzbfiVar == null || (i = zzbfiVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbfiVar.zzj);
        bundle.putInt("sccg_dir", i);
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ArrayList arrayList = this.zza.zzg;
        zzcue zzcueVar = (zzcue) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcueVar.zzb);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00fe  */
    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        JSONArray jSONArrayOptJSONArray;
        String str;
        zzfbp zzfbpVar = this.zza;
        ArrayList<String> arrayList = zzfbpVar.zzg;
        zzcue zzcueVar = (zzcue) obj;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            zzcueVar.zza.putInt("native_version", 0);
            return;
        }
        Bundle bundle = zzcueVar.zza;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", zzfbpVar.zzh);
        zzbfi zzbfiVar = zzfbpVar.zzi;
        if (zzbfiVar != null) {
            String str2 = "landscape";
            if (zzbfiVar.zza > 3) {
                bundle.putBoolean("enable_native_media_orientation", true);
                int i = zzbfiVar.zzh;
                if (i == 1) {
                    str = "any";
                } else if (i == 2) {
                    str = "landscape";
                } else if (i != 3) {
                    str = i != 4 ? "unknown" : "square";
                } else {
                    str = "portrait";
                }
                if (!"unknown".equals(str)) {
                    bundle.putString("native_media_orientation", str);
                }
            }
            int i2 = zzbfiVar.zzc;
            if (i2 == 0) {
                str2 = "any";
            } else if (i2 == 1) {
                str2 = "portrait";
            } else if (i2 != 2) {
                str2 = "unknown";
            }
            if (!"unknown".equals(str2)) {
                bundle.putString("native_image_orientation", str2);
            }
            bundle.putBoolean("native_multiple_images", zzbfiVar.zzd);
            bundle.putBoolean("use_custom_mute", zzbfiVar.zzg);
            zzc(bundle);
        }
        PackageInfo packageInfo = this.zzb;
        int i3 = packageInfo != null ? packageInfo.versionCode : 0;
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
        if (i3 > zzgVar.zza()) {
            zzgVar.zzq();
            zzgVar.zzt(i3);
        }
        JSONObject jSONObjectZzn = zzgVar.zzn();
        String string = null;
        if (jSONObjectZzn != null && (jSONArrayOptJSONArray = jSONObjectZzn.optJSONArray(zzfbpVar.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i4 = zzfbpVar.zzk;
        if (i4 > 1) {
            bundle.putInt("max_num_ads", i4);
        }
        zzblt zzbltVar = zzfbpVar.zzb;
        if (zzbltVar != null) {
            String str3 = zzbltVar.zzc;
            if (TextUtils.isEmpty(str3)) {
                String str4 = "p";
                if (zzbltVar.zza >= 2) {
                    int i5 = zzbltVar.zzd;
                    if (i5 == 2 || i5 != 3) {
                        str4 = "l";
                    }
                } else {
                    int i6 = zzbltVar.zzb;
                    if (i6 == 1) {
                        str4 = "l";
                    } else if (i6 != 2) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream ad video aspect ratio " + i6 + " is wrong.");
                        str4 = "l";
                    }
                }
                bundle.putString("ia_var", str4);
            } else {
                bundle.putString("ad_tag", str3);
            }
            bundle.putBoolean("instr", true);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlV)).booleanValue() || zzbfiVar == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzbfiVar.zzf;
        if (zzfwVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("startMuted", zzfwVar.zza);
            bundle2.putBoolean("clickToExpandRequested", zzfwVar.zzc);
            bundle2.putBoolean("customControlsRequested", zzfwVar.zzb);
            bundle.putBundle("video", bundle2);
        }
        bundle.putBoolean("disable_image_loading", zzbfiVar.zzb);
        bundle.putInt("preferred_ad_choices_position", zzbfiVar.zze);
    }
}
