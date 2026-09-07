package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgad extends zzgaf {
    zzgad(ListenableFuture listenableFuture, Class cls, zzgaz zzgazVar) {
        super(listenableFuture, cls, zzgazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgaf
    final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgaz zzgazVar = (zzgaz) obj;
        ListenableFuture listenableFutureZza = zzgazVar.zza(th);
        zzftw.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgazVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgaf
    final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
