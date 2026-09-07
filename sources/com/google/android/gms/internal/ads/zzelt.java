package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzelt {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzels zzb;

    final zzels zza() {
        return this.zzb;
    }

    final void zzb(zzels zzelsVar) {
        this.zzb = zzelsVar;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
