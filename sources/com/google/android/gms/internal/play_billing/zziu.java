package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zziu {
    public static final /* synthetic */ int zza = 0;
    private static final zziu zzb = new zziu();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zziy zzc = new zzie();

    private zziu() {
    }

    public static zziu zza() {
        return zzb;
    }

    public final zzix zzb(Class cls) {
        zzhp.zzc(cls, "messageType");
        zzix zzixVarZza = (zzix) this.zzd.get(cls);
        if (zzixVarZza == null) {
            zzixVarZza = this.zzc.zza(cls);
            zzhp.zzc(cls, "messageType");
            zzix zzixVar = (zzix) this.zzd.putIfAbsent(cls, zzixVarZza);
            if (zzixVar != null) {
                return zzixVar;
            }
        }
        return zzixVarZza;
    }
}
