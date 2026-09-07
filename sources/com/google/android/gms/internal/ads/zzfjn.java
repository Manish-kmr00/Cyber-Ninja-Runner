package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzfjn {
    protected final ClientApi zza;
    protected final Context zzb;
    protected final int zzc;
    protected final zzboy zzd;
    protected com.google.android.gms.ads.internal.client.zzfp zze;
    private final com.google.android.gms.ads.internal.client.zzce zzg;
    private final Queue zzh;
    private final zzfiu zzi;
    private final ScheduledExecutorService zzk;
    private zzfiz zzn;
    private final Clock zzo;
    protected final AtomicBoolean zzf = new AtomicBoolean(true);
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    private final AtomicBoolean zzl = new AtomicBoolean(true);
    private final AtomicBoolean zzm = new AtomicBoolean(false);

    public zzfjn(ClientApi clientApi, Context context, int i, zzboy zzboyVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfiu zzfiuVar, Clock clock) {
        this.zza = clientApi;
        this.zzb = context;
        this.zzc = i;
        this.zzd = zzboyVar;
        this.zze = zzfpVar;
        this.zzg = zzceVar;
        this.zzh = new PriorityQueue(Math.max(1, zzfpVar.zzd), new zzfjh(this));
        this.zzk = scheduledExecutorService;
        this.zzi = zzfiuVar;
        this.zzo = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzA(Object obj) {
        this.zzj.set(false);
        if (obj != null) {
            this.zzi.zzc();
            this.zzm.set(true);
            zzy(obj);
        }
        zzG(obj == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzB() {
        if (this.zzl.get()) {
            try {
                this.zzg.zze(this.zze);
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdsAvailable");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzC() {
        if (this.zzl.get()) {
            try {
                this.zzg.zzf(this.zze);
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdsExhausted");
            }
        }
    }

    private final synchronized void zzD() {
        AtomicBoolean atomicBoolean = this.zzm;
        if (atomicBoolean.get() && this.zzh.isEmpty()) {
            atomicBoolean.set(false);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfjl(this));
            this.zzk.execute(new zzfjm(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzE(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzj.set(false);
        int i = zzeVar.zza;
        if (i != 1 && i != 8 && i != 10 && i != 11) {
            zzG(true);
            return;
        }
        com.google.android.gms.ads.internal.client.zzfp zzfpVar = this.zze;
        String str = "Preloading " + zzfpVar.zzb + ", for adUnitId:" + zzfpVar.zza + ", Ad load failed. Stop preloading due to non-retriable error:";
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(str);
        this.zzf.set(false);
    }

    private final synchronized void zzF() {
        Iterator it = this.zzh.iterator();
        while (it.hasNext()) {
            if (((zzfjf) it.next()).zzd()) {
                it.remove();
            }
        }
    }

    private final synchronized void zzG(boolean z) {
        zzfiu zzfiuVar = this.zzi;
        if (zzfiuVar.zze()) {
            return;
        }
        if (z) {
            zzfiuVar.zzb();
        }
        this.zzk.schedule(new zzfji(this), zzfiuVar.zza(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzH(com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        if (zzdxVar instanceof zzcuv) {
            return ((zzcuv) zzdxVar).zzl();
        }
        return null;
    }

    static /* bridge */ /* synthetic */ double zzc(zzfjn zzfjnVar, com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        if (zzdxVar instanceof zzcuv) {
            return ((zzcuv) zzdxVar).zzc();
        }
        return 0.0d;
    }

    private final synchronized void zzy(Object obj) {
        Clock clock = this.zzo;
        zzfjf zzfjfVar = new zzfjf(obj, clock);
        this.zzh.add(zzfjfVar);
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZza = zza(obj);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfjj(this));
        zzfjk zzfjkVar = new zzfjk(this, jCurrentTimeMillis, zzdxVarZza);
        ScheduledExecutorService scheduledExecutorService = this.zzk;
        scheduledExecutorService.execute(zzfjkVar);
        scheduledExecutorService.schedule(new zzfji(this), zzfjfVar.zza(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzz(Throwable th) {
        this.zzj.set(false);
        if ((th instanceof zzfiq) && ((zzfiq) th).zza() == 0) {
            throw null;
        }
        zzG(true);
    }

    protected abstract com.google.android.gms.ads.internal.client.zzdx zza(Object obj);

    protected abstract ListenableFuture zzb(Context context);

    protected final synchronized int zzd() {
        return this.zzh.size();
    }

    public final synchronized zzfjn zzf() {
        this.zzk.submit(new zzfji(this));
        return this;
    }

    protected final synchronized Object zzh() {
        zzfjf zzfjfVar = (zzfjf) this.zzh.peek();
        if (zzfjfVar == null) {
            return null;
        }
        return zzfjfVar.zzc();
    }

    public final synchronized Object zzi() {
        this.zzi.zzc();
        Queue queue = this.zzh;
        zzfjf zzfjfVar = (zzfjf) queue.poll();
        this.zzm.set(zzfjfVar != null);
        if (zzfjfVar == null) {
            zzfjfVar = null;
        } else if (!queue.isEmpty()) {
            zzfjf zzfjfVar2 = (zzfjf) queue.peek();
            AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
            String strZzH = zzH(zza(zzfjfVar.zzc()));
            if (zzfjfVar2 != null && adFormat != null && strZzH != null && zzfjfVar2.zzb() < zzfjfVar.zzb()) {
                this.zzn.zzg(adFormat, this.zzo.currentTimeMillis(), this.zze.zzd, zzd(), strZzH);
            }
        }
        zzr();
        if (zzfjfVar == null) {
            return null;
        }
        return zzfjfVar.zzc();
    }

    public final synchronized String zzk() {
        Object objZzh;
        objZzh = zzh();
        return zzH(objZzh == null ? null : zza(objZzh));
    }

    protected final void zzq() {
        this.zzh.clear();
    }

    protected final synchronized void zzr() {
        ListenableFuture listenableFutureZzb;
        zzF();
        zzD();
        AtomicBoolean atomicBoolean = this.zzj;
        if (!atomicBoolean.get() && this.zzf.get() && this.zzh.size() < this.zze.zzd) {
            atomicBoolean.set(true);
            Activity activityZza = com.google.android.gms.ads.internal.zzv.zzb().zza();
            if (activityZza == null) {
                String strValueOf = String.valueOf(this.zze.zza);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Empty activity context at preloading: ".concat(strValueOf));
                listenableFutureZzb = zzb(this.zzb);
            } else {
                listenableFutureZzb = zzb(activityZza);
            }
            zzgbs.zzr(listenableFutureZzb, new zzfjg(this), this.zzk);
        }
    }

    public final synchronized void zzs(int i) {
        Preconditions.checkArgument(i >= 5);
        this.zzi.zzd(i);
    }

    public final synchronized void zzt() {
        this.zzf.set(true);
        this.zzl.set(true);
        this.zzk.submit(new zzfji(this));
    }

    public final void zzu(zzfiz zzfizVar) {
        this.zzn = zzfizVar;
    }

    public final void zzv() {
        this.zzf.set(false);
        this.zzl.set(false);
    }

    protected final void zzw(int i) {
        Preconditions.checkArgument(i > 0);
        AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
        int i2 = this.zze.zzd;
        synchronized (this) {
            com.google.android.gms.ads.internal.client.zzfp zzfpVar = this.zze;
            this.zze = new com.google.android.gms.ads.internal.client.zzfp(zzfpVar.zza, zzfpVar.zzb, zzfpVar.zzc, i > 0 ? i : zzfpVar.zzd);
            Queue queue = this.zzh;
            if (queue.size() > i) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzu)).booleanValue()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i; i3++) {
                        zzfjf zzfjfVar = (zzfjf) queue.poll();
                        if (zzfjfVar != null) {
                            arrayList.add(zzfjfVar);
                        }
                    }
                    queue.clear();
                    queue.addAll(arrayList);
                }
            }
        }
        zzfiz zzfizVar = this.zzn;
        if (zzfizVar == null || adFormat == null) {
            return;
        }
        zzfizVar.zza(adFormat, i2, i, this.zzo.currentTimeMillis());
    }

    public final synchronized boolean zzx() {
        zzF();
        return !this.zzh.isEmpty();
    }
}
