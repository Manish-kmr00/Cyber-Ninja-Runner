package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbcv {
    private final Map zza = new HashMap();
    private final zzbcx zzb;

    public zzbcv(zzbcx zzbcxVar) {
        this.zzb = zzbcxVar;
    }

    public final zzbcx zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbcu zzbcuVar) {
        this.zza.put(str, zzbcuVar);
    }

    public final void zzc(String str, String str2, long j) {
        Map map = this.zza;
        zzbcu zzbcuVar = (zzbcu) map.get(str2);
        String[] strArr = {str};
        if (zzbcuVar != null) {
            this.zzb.zze(zzbcuVar, j, strArr);
        }
        map.put(str, new zzbcu(j, null, null));
    }
}
