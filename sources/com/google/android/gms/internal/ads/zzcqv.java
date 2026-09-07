package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcqv {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcqv(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    public static /* synthetic */ ListenableFuture zza(zzcqv zzcqvVar, zzgbo zzgboVar, ListenableFuture listenableFuture, zzcqg zzcqgVar) {
        if (zzcqgVar != null) {
            zzgboVar.zzb(zzcqgVar);
        }
        return zzgbs.zzo(listenableFuture, ((Long) zzbev.zza.zze()).longValue(), TimeUnit.MILLISECONDS, zzcqvVar.zzb);
    }

    static /* bridge */ /* synthetic */ void zzc(final zzcqv zzcqvVar, List list, final zzgbo zzgboVar) {
        if (list == null || list.isEmpty()) {
            zzcqvVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqq
                @Override // java.lang.Runnable
                public final void run() {
                    zzgboVar.zza(new zzdvg(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzcqr
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    zzgboVar.zza((Throwable) obj);
                    return zzgbs.zzh(null);
                }
            };
            Executor executor = zzcqvVar.zza;
            listenableFutureZzh = zzgbs.zzn(zzgbs.zzf(listenableFutureZzh, Throwable.class, zzgazVar, executor), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzcqs
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    return zzcqv.zza(this.zza, zzgboVar, listenableFuture, (zzcqg) obj);
                }
            }, executor);
        }
        zzgbs.zzr(listenableFutureZzh, new zzcqu(zzcqvVar, zzgboVar), zzcqvVar.zza);
    }

    public final void zze(zzgbo zzgboVar) {
        zzgbs.zzr(this.zzc, new zzcqt(this, zzgboVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
