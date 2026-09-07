package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgck {
    public static zzgcd zza(ExecutorService executorService) {
        if (executorService instanceof zzgcd) {
            return (zzgcd) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzgcj((ScheduledExecutorService) executorService) : new zzgcg(executorService);
    }

    public static zzgce zzb(ScheduledExecutorService scheduledExecutorService) {
        return new zzgcj(scheduledExecutorService);
    }

    public static Executor zzc() {
        return zzgbg.INSTANCE;
    }

    static Executor zzd(final Executor executor, final zzgag zzgagVar) {
        executor.getClass();
        return executor == zzgbg.INSTANCE ? executor : new Executor() { // from class: com.google.android.gms.internal.ads.zzgcf
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                zzgck.zze(executor, zzgagVar, runnable);
            }
        };
    }

    static /* synthetic */ void zze(Executor executor, zzgag zzgagVar, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            zzgagVar.zzd(e);
        }
    }
}
