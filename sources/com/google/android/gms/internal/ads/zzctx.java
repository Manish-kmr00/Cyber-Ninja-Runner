package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzctx implements zzcvc, zzdch, zzczx, zzcvs, zzayh {
    private final zzcvu zza;
    private final zzfau zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private ScheduledFuture zzf;
    private final String zzh;
    private final zzgcm zze = zzgcm.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();

    zzctx(zzcvu zzcvuVar, zzfau zzfauVar, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzcvuVar;
        this.zzb = zzfauVar;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    public static /* synthetic */ void zzh(zzctx zzctxVar) {
        synchronized (zzctxVar) {
            zzgcm zzgcmVar = zzctxVar.zze;
            if (zzgcmVar.isDone()) {
                return;
            }
            zzgcmVar.zzc(true);
        }
    }

    private final boolean zzk() {
        return this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        zzfau zzfauVar = this.zzb;
        if (zzfauVar.zze == 3) {
            return;
        }
        int i = zzfauVar.zzY;
        if (i == 0 || i == 1) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlB)).booleanValue() && zzk()) {
                return;
            }
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final void zzdn(zzayg zzaygVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlB)).booleanValue() && zzk() && zzaygVar.zzj && this.zzg.compareAndSet(false, true) && this.zzb.zze != 3) {
            com.google.android.gms.ads.internal.util.zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final synchronized void zzj() {
        if (this.zzb.zze == 4) {
            this.zza.zza();
            return;
        }
        zzgcm zzgcmVar = this.zze;
        if (zzgcmVar.isDone()) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzf;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzgcmVar.zzc(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final synchronized void zzr(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzgcm zzgcmVar = this.zze;
        if (zzgcmVar.isDone()) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzf;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzgcmVar.zzd(new Exception());
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzu() {
        zzfau zzfauVar = this.zzb;
        int i = zzfauVar.zze;
        if (i == 3 || i == 4) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbI)).booleanValue() && zzfauVar.zzY == 2) {
            int i2 = zzfauVar.zzq;
            if (i2 == 0) {
                this.zza.zza();
            } else {
                zzgbs.zzr(this.zze, new zzctw(this), this.zzd);
                this.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzctx.zzh(this.zza);
                    }
                }, i2, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzv() {
    }
}
