package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdlc {
    private final Executor zza;
    private final zzdkx zzb;

    public zzdlc(Executor executor, zzdkx zzdkxVar) {
        this.zza = executor;
        this.zzb = zzdkxVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgbs.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZzh = zzgbs.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZzh = zzgbs.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZzh = "string".equals(strOptString2) ? zzgbs.zzh(new zzdlb(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgbs.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value"), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdkz
                        @Override // com.google.android.gms.internal.ads.zzftl
                        public final Object apply(Object obj) {
                            return new zzdlb(strOptString, (zzbfg) obj);
                        }
                    }, this.zza) : zzgbs.zzh(null);
                }
            }
            arrayList.add(listenableFutureZzh);
        }
        return zzgbs.zzm(zzgbs.zzd(arrayList), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdla
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdlb zzdlbVar : (List) obj) {
                    if (zzdlbVar != null) {
                        arrayList2.add(zzdlbVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
