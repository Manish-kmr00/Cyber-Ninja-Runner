package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcj extends zzgcg implements zzgce {
    final ScheduledExecutorService zza;

    zzgcj(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgct zzgctVarZze = zzgct.zze(runnable, null);
        return new zzgch(zzgctVarZze, scheduledExecutorService.schedule(zzgctVarZze, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgci zzgciVar = new zzgci(runnable);
        return new zzgch(zzgciVar, this.zza.scheduleAtFixedRate(zzgciVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgci zzgciVar = new zzgci(runnable);
        return new zzgch(zzgciVar, this.zza.scheduleWithFixedDelay(zzgciVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzgcc schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgct zzgctVar = new zzgct(callable);
        return new zzgch(zzgctVar, this.zza.schedule(zzgctVar, j, timeUnit));
    }
}
