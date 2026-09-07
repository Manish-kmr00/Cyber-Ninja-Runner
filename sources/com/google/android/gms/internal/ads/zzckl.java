package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzckl {
    private final Map zza;
    private final Map zzb;

    zzckl(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfbg zzfbgVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        for (zzfbe zzfbeVar : zzfbgVar.zzb.zzc) {
            Map map = this.zza;
            String str = zzfbeVar.zza;
            if (!map.containsKey(str) || (jSONObject2 = zzfbeVar.zzb) == null) {
                Map map2 = this.zzb;
                if (map2.containsKey(str) && (jSONObject = zzfbeVar.zzb) != null) {
                    zzckn zzcknVar = (zzckn) map2.get(str);
                    HashMap map3 = new HashMap();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObject.optString(next);
                        if (strOptString != null) {
                            map3.put(next, strOptString);
                        }
                    }
                    zzcknVar.zza(map3);
                }
            } else {
                ((zzcko) map.get(str)).zza(jSONObject2);
            }
        }
    }
}
