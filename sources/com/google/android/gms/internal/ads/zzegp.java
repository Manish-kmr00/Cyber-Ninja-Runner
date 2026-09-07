package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzegp implements zzech {
    private final Map zza = new HashMap();
    private final zzdou zzb;

    public zzegp(zzdou zzdouVar) {
        this.zzb = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzech
    public final zzeci zza(String str, JSONObject jSONObject) throws zzfbw {
        zzeci zzeciVar;
        synchronized (this) {
            Map map = this.zza;
            zzeciVar = (zzeci) map.get(str);
            if (zzeciVar == null) {
                zzeciVar = new zzeci(this.zzb.zzc(str, jSONObject), new zzedx(), str);
                map.put(str, zzeciVar);
            }
        }
        return zzeciVar;
    }
}
