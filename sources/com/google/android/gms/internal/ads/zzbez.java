package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbez {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzbex zza() {
        return (zzbex) zza.get();
    }

    static zzbey zzb() {
        return (zzbey) zzb.get();
    }

    public static void zzc(zzbex zzbexVar) {
        zza.set(zzbexVar);
    }
}
