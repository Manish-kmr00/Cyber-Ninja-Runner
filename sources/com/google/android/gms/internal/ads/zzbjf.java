package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbjf implements zzbjj {
    zzbjf() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcelVar.zzde();
        } else if ("resume".equals(str)) {
            zzcelVar.zzdf();
        }
    }
}
