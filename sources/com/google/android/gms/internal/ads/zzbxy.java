package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.json.b9;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzbxy {
    static Uri zza(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + b9.i.c + str.substring(i));
    }

    public static String zzb(Uri uri, Context context, Map map) {
        if (!com.google.android.gms.ads.internal.zzv.zzo().zzp(context)) {
            return uri.toString();
        }
        String strZzb = com.google.android.gms.ads.internal.zzv.zzo().zzb(context);
        if (strZzb == null) {
            return uri.toString();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaw);
        String string = uri.toString();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzav)).booleanValue() && string.contains(str)) {
            com.google.android.gms.ads.internal.zzv.zzo().zzj(context, strZzb, (Map) map.get("_ac"));
            return zzd(string, context).replace(str, strZzb);
        }
        if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return string;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzau)).booleanValue()) {
            return string;
        }
        String string2 = zza(zzd(string, context), "fbs_aeid", strZzb).toString();
        com.google.android.gms.ads.internal.zzv.zzo().zzj(context, strZzb, (Map) map.get("_ac"));
        return string2;
    }

    public static String zzc(String str, Context context, boolean z, Map map) {
        String strZzb;
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaD)).booleanValue() && !z) || !com.google.android.gms.ads.internal.zzv.zzo().zzp(context) || TextUtils.isEmpty(str) || (strZzb = com.google.android.gms.ads.internal.zzv.zzo().zzb(context)) == null) {
            return str;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaw);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzav)).booleanValue() && str.contains(str2)) {
            if (com.google.android.gms.ads.internal.zzv.zzq().zzj(str)) {
                com.google.android.gms.ads.internal.zzv.zzo().zzj(context, strZzb, (Map) map.get("_ac"));
                return zzd(str, context).replace(str2, strZzb);
            }
            if (!com.google.android.gms.ads.internal.zzv.zzq().zzk(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzv.zzo().zzk(context, strZzb, (Map) map.get("_ai"));
            return zzd(str, context).replace(str2, strZzb);
        }
        if (str.contains("fbs_aeid")) {
            return str;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzau)).booleanValue()) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzv.zzq().zzj(str)) {
            com.google.android.gms.ads.internal.zzv.zzo().zzj(context, strZzb, (Map) map.get("_ac"));
            return zza(zzd(str, context), "fbs_aeid", strZzb).toString();
        }
        if (!com.google.android.gms.ads.internal.zzv.zzq().zzk(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzv.zzo().zzk(context, strZzb, (Map) map.get("_ai"));
        return zza(zzd(str, context), "fbs_aeid", strZzb).toString();
    }

    private static String zzd(String str, Context context) {
        String strZze = com.google.android.gms.ads.internal.zzv.zzo().zze(context);
        String strZzc = com.google.android.gms.ads.internal.zzv.zzo().zzc(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZze)) {
            str = zza(str, "gmp_app_id", strZze).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzc)) ? str : zza(str, "fbs_aiid", strZzc).toString();
    }
}
