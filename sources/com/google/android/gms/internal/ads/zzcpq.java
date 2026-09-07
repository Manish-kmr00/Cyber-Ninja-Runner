package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpq implements zzayh {
    private final zzcel zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzcpq(zzcel zzcelVar, Executor executor) {
        this.zza = zzcelVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final synchronized void zzdn(zzayg zzaygVar) {
        final zzcel zzcelVar = this.zza;
        if (zzcelVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmG)).booleanValue()) {
                if (zzaygVar.zzj) {
                    if (!Boolean.TRUE.equals(this.zzc.getAndSet(true))) {
                        Executor executor = this.zzb;
                        Objects.requireNonNull(zzcelVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpo
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzcelVar.onResume();
                            }
                        });
                    }
                } else {
                    if (!Boolean.FALSE.equals(this.zzc.getAndSet(false))) {
                        Executor executor2 = this.zzb;
                        Objects.requireNonNull(zzcelVar);
                        executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpp
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzcelVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
