package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class zzbmf {
    public static void zza(zzbmg zzbmgVar, String str, Map map) {
        try {
            zzbmgVar.zze(str, com.google.android.gms.ads.internal.client.zzbb.zzb().zzk(map));
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbmg zzbmgVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        String string2 = sb.toString();
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Dispatching AFMA event: ".concat(string2));
        zzbmgVar.zza(sb.toString());
    }

    public static void zzc(zzbmg zzbmgVar, String str, String str2) {
        zzbmgVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbmg zzbmgVar, String str, JSONObject jSONObject) {
        zzbmgVar.zzb(str, jSONObject.toString());
    }
}
