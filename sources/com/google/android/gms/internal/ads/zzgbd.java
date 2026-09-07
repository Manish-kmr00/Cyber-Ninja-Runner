package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgbd extends zzgbe {
    final /* synthetic */ zzgbf zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgbd(zzgbf zzgbfVar, Callable callable, Executor executor) {
        super(zzgbfVar, executor);
        this.zza = zzgbfVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgbe
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
