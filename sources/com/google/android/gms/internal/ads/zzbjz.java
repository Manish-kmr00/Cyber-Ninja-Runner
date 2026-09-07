package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
@ParametersAreNonnullByDefault
public final class zzbjz implements zzbjj {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get(b9.f.e);
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            zzbjy zzbjyVar = (zzbjy) this.zzb.remove(str);
            if (zzbjyVar == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Received result for unexpected method invocation: " + str);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                zzbjyVar.zza(str3 + strConcat);
                return;
            }
            if (str5 == null) {
                zzbjyVar.zzb(null);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Result GMSG: " + jSONObject.toString(2));
                }
                zzbjyVar.zzb(jSONObject);
            } catch (JSONException e) {
                zzbjyVar.zza(e.getMessage());
            }
        }
    }

    public final ListenableFuture zzb(zzbmq zzbmqVar, String str, JSONObject jSONObject) {
        zzbzp zzbzpVar = new zzbzp();
        com.google.android.gms.ads.internal.zzv.zzq();
        String string = UUID.randomUUID().toString();
        zzc(string, new zzbjx(this, zzbzpVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbmqVar.zzp(str, jSONObject2);
        } catch (Exception e) {
            zzbzpVar.zzd(e);
        }
        return zzbzpVar;
    }

    public final void zzc(String str, zzbjy zzbjyVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbjyVar);
        }
    }
}
