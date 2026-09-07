package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbds;
import com.google.android.gms.internal.ads.zzben;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzbu extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbu(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        this.zzb = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        String strConcat = ((Boolean) zzben.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.zzb.zzk.zza().toString()) : "";
        String str2 = this.zza;
        Locale locale = Locale.getDefault();
        zzbds zzbdsVar = zzben.zze;
        final String str3 = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", str2, str, Long.valueOf(((Boolean) zzbdsVar.zze()).booleanValue() ? ((Long) zzben.zzh.zze()).longValue() : 0L), strConcat);
        if (((Boolean) zzbdsVar.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb.zzb.evaluateJavascript(str3, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(str3, null);
        }
        if (((Boolean) zzben.zzc.zze()).booleanValue() && ((Boolean) zzben.zzd.zze()).booleanValue()) {
            this.zzb.zzl.zzb();
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        final String str;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzben.zze.zze()).booleanValue() ? ((Long) zzben.zzh.zze()).longValue() : 0L);
            if (((Boolean) zzben.zzc.zze()).booleanValue()) {
                jSONObject.put("as", this.zzb.zzk.zza());
            }
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String strConcat = ((Boolean) zzben.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.zzb.zzk.zza().toString()) : "";
            str = String.format(Locale.getDefault(), "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", this.zza, queryInfo.getQuery(), Long.valueOf(((Boolean) zzben.zze.zze()).booleanValue() ? ((Long) zzben.zzh.zze()).longValue() : 0L), strConcat);
        }
        if (((Boolean) zzben.zze.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb.zzb.evaluateJavascript(str, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(str, null);
        }
        if (((Boolean) zzben.zzc.zze()).booleanValue() && ((Boolean) zzben.zzd.zze()).booleanValue()) {
            this.zzb.zzl.zzb();
        }
    }
}
