package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcr extends zzgca {
    final /* synthetic */ zzgct zza;
    private final zzgay zzb;

    zzgcr(zzgct zzgctVar, zzgay zzgayVar) {
        this.zza = zzgctVar;
        this.zzb = zzgayVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgay zzgayVar = this.zzb;
        ListenableFuture listenableFutureZza = zzgayVar.zza();
        zzftw.zzd(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgayVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzn((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final boolean zzg() {
        return this.zza.isDone();
    }
}
