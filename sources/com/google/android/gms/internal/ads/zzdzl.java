package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdzl {
    private final zzdzh zza;
    private final zzgcd zzb;

    public zzdzl(zzdzh zzdzhVar, zzgcd zzgcdVar) {
        this.zza = zzdzhVar;
        this.zzb = zzgcdVar;
    }

    public final void zza(zzfex zzfexVar) {
        final zzdzh zzdzhVar = this.zza;
        Objects.requireNonNull(zzdzhVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzdzj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdzhVar.getWritableDatabase();
            }
        };
        zzgcd zzgcdVar = this.zzb;
        zzgbs.zzr(zzgcdVar.zzb(callable), new zzdzk(this, zzfexVar), zzgcdVar);
    }
}
