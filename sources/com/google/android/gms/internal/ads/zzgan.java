package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgan extends zzgap {
    zzgan(ListenableFuture listenableFuture, zzgaz zzgazVar) {
        super(listenableFuture, zzgazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgap
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgaz zzgazVar = (zzgaz) obj;
        ListenableFuture listenableFutureZza = zzgazVar.zza(obj2);
        zzftw.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgazVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgap
    final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
