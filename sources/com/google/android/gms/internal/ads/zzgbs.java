package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgbs extends zzgbu {
    public static zzgbq zza(Iterable iterable) {
        return new zzgbq(false, zzfww.zzk(iterable), null);
    }

    public static zzgbq zzb(Iterable iterable) {
        return new zzgbq(true, zzfww.zzk(iterable), null);
    }

    @SafeVarargs
    public static zzgbq zzc(ListenableFuture... listenableFutureArr) {
        return new zzgbq(true, zzfww.zzm(listenableFutureArr), null);
    }

    public static ListenableFuture zzd(Iterable iterable) {
        return new zzgba(zzfww.zzk(iterable), true);
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzftl zzftlVar, Executor executor) {
        int i = zzgaf.zzd;
        zzgae zzgaeVar = new zzgae(listenableFuture, cls, zzftlVar);
        listenableFuture.addListener(zzgaeVar, zzgck.zzd(executor, zzgaeVar));
        return zzgaeVar;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzgaz zzgazVar, Executor executor) {
        int i = zzgaf.zzd;
        zzgad zzgadVar = new zzgad(listenableFuture, cls, zzgazVar);
        listenableFuture.addListener(zzgadVar, zzgck.zzd(executor, zzgadVar));
        return zzgadVar;
    }

    public static ListenableFuture zzh(Object obj) {
        return obj == null ? zzgbw.zza : new zzgbw(obj);
    }

    public static ListenableFuture zzi() {
        return zzgbw.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgct zzgctVar = new zzgct(callable);
        executor.execute(zzgctVar);
        return zzgctVar;
    }

    public static ListenableFuture zzk(zzgay zzgayVar, Executor executor) {
        zzgct zzgctVar = new zzgct(zzgayVar);
        executor.execute(zzgctVar);
        return zzgctVar;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgba(zzfww.zzm(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzftl zzftlVar, Executor executor) {
        int i = zzgap.zzc;
        zzgao zzgaoVar = new zzgao(listenableFuture, zzftlVar);
        listenableFuture.addListener(zzgaoVar, zzgck.zzd(executor, zzgaoVar));
        return zzgaoVar;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzgaz zzgazVar, Executor executor) {
        int i = zzgap.zzc;
        zzgan zzganVar = new zzgan(listenableFuture, zzgazVar);
        listenableFuture.addListener(zzganVar, zzgck.zzd(executor, zzganVar));
        return zzganVar;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : zzgcq.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgcv.zza(future);
        }
        throw new IllegalStateException(zzfun.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgcv.zza(future);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Error) {
                throw new zzgbh((Error) e.getCause());
            }
            throw new zzgcu(e.getCause());
        }
    }

    public static ListenableFuture zzg(Throwable th) {
        th.getClass();
        return new zzgbv(th);
    }

    public static void zzr(ListenableFuture listenableFuture, zzgbo zzgboVar, Executor executor) {
        zzgboVar.getClass();
        listenableFuture.addListener(new zzgbp(listenableFuture, zzgboVar), executor);
    }
}
