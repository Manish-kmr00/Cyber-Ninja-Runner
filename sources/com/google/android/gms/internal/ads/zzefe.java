package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefe {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcqj zzc;
    private final zzefu zzd;
    private final zzfik zze;
    private final zzgcm zzf = zzgcm.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzeff zzh;
    private zzfbg zzi;

    zzefe(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcqj zzcqjVar, zzefu zzefuVar, zzfik zzfikVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcqjVar;
        this.zzd = zzefuVar;
        this.zze = zzfikVar;
    }

    private final synchronized ListenableFuture zzd(zzfau zzfauVar) {
        Iterator it = zzfauVar.zza.iterator();
        while (it.hasNext()) {
            zzecf zzecfVarZza = this.zzc.zza(zzfauVar.zzb, (String) it.next());
            if (zzecfVarZza != null && zzecfVarZza.zzb(this.zzi, zzfauVar)) {
                return zzgbs.zzo(zzecfVarZza.zza(this.zzi, zzfauVar), zzfauVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgbs.zzg(new zzdvg(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzfau zzfauVar) {
        ListenableFuture listenableFutureZzd = zzd(zzfauVar);
        this.zzd.zzf(this.zzi, zzfauVar, listenableFutureZzd, this.zze);
        zzgbs.zzr(listenableFutureZzd, new zzefd(this, zzfauVar), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfbg zzfbgVar) {
        if (!this.zzg.getAndSet(true)) {
            List list = zzfbgVar.zzb.zza;
            if (list.isEmpty()) {
                this.zzf.zzd(new zzefy(3, zzegb.zzc(zzfbgVar)));
            } else {
                this.zzi = zzfbgVar;
                zzefu zzefuVar = this.zzd;
                this.zzh = new zzeff(zzfbgVar, zzefuVar, this.zzf);
                zzefuVar.zzk(list);
                zzfau zzfauVarZza = this.zzh.zza();
                while (zzfauVarZza != null) {
                    zze(zzfauVarZza);
                    zzfauVarZza = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
