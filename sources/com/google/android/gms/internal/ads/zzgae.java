package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgae extends zzgaf {
    zzgae(ListenableFuture listenableFuture, Class cls, zzftl zzftlVar) {
        super(listenableFuture, cls, zzftlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgaf
    final /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        return ((zzftl) obj).apply(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgaf
    final void zzf(Object obj) {
        zzc(obj);
    }
}
