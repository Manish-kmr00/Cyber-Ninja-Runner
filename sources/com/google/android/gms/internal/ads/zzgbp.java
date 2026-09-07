package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgbp implements Runnable {
    final Future zza;
    final zzgbo zzb;

    zzgbp(Future future, zzgbo zzgboVar) {
        this.zza = future;
        this.zzb = zzgboVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Future future = this.zza;
        if ((future instanceof zzgcw) && (thZza = zzgcx.zza((zzgcw) future)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgbs.zzp(future));
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzftq zzftqVarZza = zzfts.zza(this);
        zzftqVarZza.zza(this.zzb);
        return zzftqVarZza.toString();
    }
}
