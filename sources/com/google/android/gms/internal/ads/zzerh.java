package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzerh implements zzesv {
    private final zzesv zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzerh(zzesv zzesvVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzesvVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public static /* synthetic */ ListenableFuture zzc(zzerh zzerhVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcw)).booleanValue()) {
            zzesv zzesvVar = zzerhVar.zza;
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "OptionalSignalTimeout:" + zzesvVar.zza());
        }
        return zzgbs.zzh(null);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzb = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcx)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            listenableFutureZzb = zzgbs.zzo(listenableFutureZzb, j, timeUnit, this.zzc);
        }
        return zzgbs.zzf(listenableFutureZzb, Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzerg
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzerh.zzc(this.zza, (Throwable) obj);
            }
        }, zzbzk.zzg);
    }
}
