package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfus {
    public static zzfuo zza(zzfuo zzfuoVar) {
        if ((zzfuoVar instanceof zzfur) || (zzfuoVar instanceof zzfup)) {
            return zzfuoVar;
        }
        return zzfuoVar instanceof Serializable ? new zzfup(zzfuoVar) : new zzfur(zzfuoVar);
    }
}
