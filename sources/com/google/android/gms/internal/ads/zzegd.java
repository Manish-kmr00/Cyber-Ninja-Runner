package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzegd {
    private zzefu zza;

    zzegd() {
    }

    private zzegd(zzefu zzefuVar) {
        this.zza = zzefuVar;
    }

    public static zzegd zzb(zzefu zzefuVar) {
        return new zzegd(zzefuVar);
    }

    public final zzefu zza(Clock clock, zzefw zzefwVar, zzeck zzeckVar, zzfio zzfioVar) {
        zzefu zzefuVar = this.zza;
        return zzefuVar != null ? zzefuVar : new zzefu(clock, zzefwVar, zzeckVar, zzfioVar);
    }
}
