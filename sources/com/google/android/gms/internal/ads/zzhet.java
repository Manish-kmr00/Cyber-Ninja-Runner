package com.google.android.gms.internal.ads;

import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public class zzhet {
    final LinkedHashMap zza;

    zzhet(int i) {
        this.zza = zzhev.zzb(i);
    }

    final zzhet zza(Object obj, zzhfh zzhfhVar) {
        zzhfg.zza(obj, "key");
        zzhfg.zza(zzhfhVar, IronSourceConstants.EVENTS_PROVIDER);
        this.zza.put(obj, zzhfhVar);
        return this;
    }
}
