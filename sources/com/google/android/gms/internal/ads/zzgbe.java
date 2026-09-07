package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgbe extends zzgca {
    private final Executor zza;
    final /* synthetic */ zzgbf zzb;

    zzgbe(zzgbf zzgbfVar, Executor executor) {
        this.zzb = zzgbfVar;
        executor.getClass();
        this.zza = executor;
    }

    abstract void zzc(Object obj);

    @Override // com.google.android.gms.internal.ads.zzgca
    final void zzd(Throwable th) {
        zzgbf zzgbfVar = this.zzb;
        zzgbfVar.zzb = null;
        if (th instanceof ExecutionException) {
            zzgbfVar.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzgbfVar.cancel(false);
        } else {
            zzgbfVar.zzd(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final void zze(Object obj) {
        this.zzb.zzb = null;
        zzc(obj);
    }

    final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final boolean zzg() {
        return this.zzb.isDone();
    }
}
