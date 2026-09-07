package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcn implements Runnable {
    zzgcq zza;

    zzgcn(zzgcq zzgcqVar) {
        this.zza = zzgcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture;
        zzgcq zzgcqVar = this.zza;
        if (zzgcqVar == null || (listenableFuture = zzgcqVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isDone()) {
            zzgcqVar.zzn(listenableFuture);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgcqVar.zzb;
            zzgcqVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgcqVar.zzd(new zzgco(str, null));
                    throw th;
                }
            }
            zzgcqVar.zzd(new zzgco(str + ": " + listenableFuture.toString(), null));
            listenableFuture.cancel(true);
        } catch (Throwable th2) {
            listenableFuture.cancel(true);
            throw th2;
        }
    }
}
