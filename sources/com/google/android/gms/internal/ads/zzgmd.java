package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgmd {
    private static final zzgmd zza = new zzgmd();
    private static final zzgmb zzb = new zzgmb(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgmd zzb() {
        return zza;
    }

    public final zzgls zza() {
        zzgls zzglsVar = (zzgls) this.zzc.get();
        return zzglsVar == null ? zzb : zzglsVar;
    }
}
