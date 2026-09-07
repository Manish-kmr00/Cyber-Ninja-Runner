package com.google.android.gms.internal.play_billing;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes11.dex */
final class zzu implements zzeu {
    final WeakReference zza;
    private final zzq zzb = new zzt(this);

    zzu(zzr zzrVar) {
        this.zza = new WeakReference(zzrVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzr zzrVar = (zzr) this.zza.get();
        boolean zCancel = this.zzb.cancel(z);
        if (!zCancel || zzrVar == null) {
            return zCancel;
        }
        zzrVar.zza();
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.zzb.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzb.zzc instanceof zzg;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzb.isDone();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    final boolean zza(Object obj) {
        return this.zzb.zzd(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        this.zzb.zzb(runnable, executor);
    }

    final boolean zzc(Throwable th) {
        zzi zziVar = new zzi(th);
        zzf zzfVar = zzq.zzb;
        zzq zzqVar = this.zzb;
        if (!zzfVar.zzd(zzqVar, null, zziVar)) {
            return false;
        }
        zzq.zzc(zzqVar);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzb.get(j, timeUnit);
    }
}
