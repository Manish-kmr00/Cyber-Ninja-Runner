package com.google.android.gms.internal.ads;

import com.json.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdsi {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdsi(String str, zzdsj zzdsjVar) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdsi zzdsiVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdsiVar.zza);
            jSONObject.put("eventCategory", zzdsiVar.zzb);
            jSONObject.putOpt("event", zzdsiVar.zzc);
            jSONObject.putOpt("errorCode", zzdsiVar.zzd);
            jSONObject.putOpt("rewardType", zzdsiVar.zze);
            jSONObject.putOpt(IronSourceConstants.EVENTS_REWARD_AMOUNT, zzdsiVar.zzf);
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
