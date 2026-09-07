package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzq {
    public static final /* synthetic */ int zza = 0;
    private static final zzgzq zzb = new zzgzq();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzhaa zzc = new zzgyy();

    private zzgzq() {
    }

    public static zzgzq zza() {
        return zzb;
    }

    public final zzgzz zzb(Class cls) {
        zzgyi.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzgzz zzgzzVarZza = (zzgzz) concurrentMap.get(cls);
        if (zzgzzVarZza == null) {
            zzgzzVarZza = this.zzc.zza(cls);
            zzgyi.zzc(cls, "messageType");
            zzgzz zzgzzVar = (zzgzz) concurrentMap.putIfAbsent(cls, zzgzzVarZza);
            if (zzgzzVar != null) {
                return zzgzzVar;
            }
        }
        return zzgzzVarZza;
    }
}
