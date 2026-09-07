package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbio implements zzbjj {
    zzbio() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZza;
        zzcel zzcelVar = (zzcel) obj;
        zzbfh zzbfhVarZzK = zzcelVar.zzK();
        if (zzbfhVarZzK == null || (jSONObjectZza = zzbfhVarZzK.zza()) == null) {
            zzcelVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcelVar.zze("nativeAdViewSignalsReady", jSONObjectZza);
        }
    }
}
