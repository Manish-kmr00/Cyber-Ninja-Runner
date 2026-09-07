package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeuv implements zzesv {
    final zzgcd zza;
    final List zzb;

    public zzeuv(zzbbr zzbbrVar, zzgcd zzgcdVar, List list) {
        this.zza = zzgcdVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeuw(this.zza.zzb);
            }
        });
    }
}
