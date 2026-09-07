package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeur implements zzesv {
    public zzeur(zzbyo zzbyoVar, zzgcd zzgcdVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        final ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfQ)).booleanValue()) {
            listenableFutureZzh = zzgbs.zzh(null);
        }
        final ListenableFuture listenableFutureZzh2 = zzgbs.zzh(null);
        return zzgbs.zzc(listenableFutureZzh, listenableFutureZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuq
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeus((String) listenableFutureZzh.get(), (String) listenableFutureZzh2.get());
            }
        }, zzbzk.zza);
    }
}
