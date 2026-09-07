package com.google.android.gms.internal.ads;

import com.json.b9;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgct extends zzgbi implements RunnableFuture {
    private volatile zzgca zza;

    zzgct(zzgay zzgayVar) {
        this.zza = new zzgcr(this, zzgayVar);
    }

    static zzgct zze(Runnable runnable, Object obj) {
        return new zzgct(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgca zzgcaVar = this.zza;
        if (zzgcaVar != null) {
            zzgcaVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgag
    protected final String zza() {
        zzgca zzgcaVar = this.zza;
        if (zzgcaVar == null) {
            return super.zza();
        }
        return "task=[" + zzgcaVar.toString() + b9.i.e;
    }

    @Override // com.google.android.gms.internal.ads.zzgag
    protected final void zzb() {
        zzgca zzgcaVar;
        if (zzo() && (zzgcaVar = this.zza) != null) {
            zzgcaVar.zzh();
        }
        this.zza = null;
    }

    zzgct(Callable callable) {
        this.zza = new zzgcs(this, callable);
    }
}
