package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzenn implements zzesv {
    private final AtomicReference zza = new AtomicReference();
    private final AtomicReference zzb = new AtomicReference(false);
    private final Clock zzc;
    private final Executor zzd;
    private final zzesv zze;
    private final long zzf;
    private final zzdre zzg;

    public zzenn(zzesv zzesvVar, long j, Clock clock, Executor executor, zzdre zzdreVar) {
        this.zzc = clock;
        this.zze = zzesvVar;
        this.zzf = j;
        this.zzd = executor;
        this.zzg = zzdreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return this.zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        zzenm zzenmVar;
        zzenm zzenmVar2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlR)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlQ)).booleanValue() && !((Boolean) this.zzb.getAndSet(true)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzbzk.zzd;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzenk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzenn zzennVar = this.zza;
                        zzennVar.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenl
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzenn zzennVar2 = zzennVar;
                                zzennVar2.zza.set(new zzenm(zzennVar2.zze.zzb(), zzennVar2.zzf, zzennVar2.zzc));
                            }
                        });
                    }
                };
                long j = this.zzf;
                scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
            }
            synchronized (this) {
                AtomicReference atomicReference = this.zza;
                zzenmVar = (zzenm) atomicReference.get();
                if (zzenmVar == null) {
                    zzenm zzenmVar3 = new zzenm(this.zze.zzb(), this.zzf, this.zzc);
                    atomicReference.set(zzenmVar3);
                    return zzenmVar3.zza;
                }
                if (!((Boolean) this.zzb.get()).booleanValue() && zzenmVar.zza()) {
                    ListenableFuture listenableFuture = zzenmVar.zza;
                    zzesv zzesvVar = this.zze;
                    zzenmVar2 = new zzenm(zzesvVar.zzb(), this.zzf, this.zzc);
                    this.zza.set(zzenmVar2);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlS)).booleanValue()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlT)).booleanValue()) {
                            zzdrd zzdrdVarZza = this.zzg.zza();
                            zzdrdVarZza.zzb("action", "scs");
                            zzdrdVarZza.zzb("sid", String.valueOf(zzesvVar.zza()));
                            zzdrdVarZza.zzj();
                        }
                        return listenableFuture;
                    }
                    zzenmVar = zzenmVar2;
                }
            }
        } else {
            AtomicReference atomicReference2 = this.zza;
            zzenmVar = (zzenm) atomicReference2.get();
            if (zzenmVar == null || zzenmVar.zza()) {
                zzesv zzesvVar2 = this.zze;
                zzenmVar2 = new zzenm(zzesvVar2.zzb(), this.zzf, this.zzc);
                atomicReference2.set(zzenmVar2);
                zzenmVar = zzenmVar2;
            }
        }
        return zzenmVar.zza;
    }
}
