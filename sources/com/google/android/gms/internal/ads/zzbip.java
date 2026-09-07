package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbip implements zzbjj {
    zzbip() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcel zzcelVar = (zzcel) obj;
        zzbfh zzbfhVarZzK = zzcelVar.zzK();
        if (zzbfhVarZzK == null || (jSONObjectZzb = zzbfhVarZzK.zzb()) == null) {
            zzcelVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcelVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
