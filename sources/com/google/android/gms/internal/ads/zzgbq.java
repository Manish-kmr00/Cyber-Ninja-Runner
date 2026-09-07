package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgbq {
    private final boolean zza;
    private final zzfww zzb;

    /* synthetic */ zzgbq(boolean z, zzfww zzfwwVar, zzgbr zzgbrVar) {
        this.zza = z;
        this.zzb = zzfwwVar;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzgbf(this.zzb, this.zza, executor, callable);
    }
}
