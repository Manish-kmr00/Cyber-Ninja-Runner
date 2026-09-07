package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcvp extends zzdat implements zzcvg {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd;

    public zzcvp(zzcvo zzcvoVar, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzd = false;
        this.zzb = scheduledExecutorService;
        super.zzo(zzcvoVar, executor);
    }

    public static /* synthetic */ void zzd(zzcvp zzcvpVar) {
        synchronized (zzcvpVar) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Timeout waiting for show call succeed to be called.");
            zzcvpVar.zzc(new zzdfl("Timeout for show call succeed."));
            zzcvpVar.zzd = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvh
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvg) obj).zza(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzb() {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvi
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvg) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzc(final zzdfl zzdflVar) {
        if (this.zzd) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcvk
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzcvg) obj).zzc(zzdflVar);
            }
        });
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        this.zzc = this.zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcvj
            @Override // java.lang.Runnable
            public final void run() {
                zzcvp.zzd(this.zza);
            }
        }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkN)).intValue(), TimeUnit.MILLISECONDS);
    }
}
