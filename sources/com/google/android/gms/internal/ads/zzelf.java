package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzelf implements zzesv {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    zzelf(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzeld
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(new zzelg((String) obj));
            }
        };
        ListenableFuture listenableFuture = this.zza;
        Executor executor = this.zzb;
        ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFuture, zzgazVar, executor);
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmA)).intValue() > 0) {
            listenableFutureZzn = zzgbs.zzo(listenableFutureZzn, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmA)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgbs.zzf(listenableFutureZzn, Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzele
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return ((Throwable) obj) instanceof TimeoutException ? zzgbs.zzh(new zzelg(Integer.toString(17))) : zzgbs.zzh(new zzelg(null));
            }
        }, executor);
    }
}
