package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcmj implements zzcvc, zzcwq, zzcvw, com.google.android.gms.ads.internal.client.zza, zzcvs, zzdct, zzdch {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfbg zze;
    private final zzfau zzf;
    private final zzfik zzg;
    private final zzfcb zzh;
    private final zzauy zzi;
    private final zzbdp zzj;
    private final WeakReference zzk;
    private final WeakReference zzl;
    private final zzcuc zzm;
    private final zzcxm zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();

    zzcmj(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfbg zzfbgVar, zzfau zzfauVar, zzfik zzfikVar, zzfcb zzfcbVar, View view, zzcel zzcelVar, zzauy zzauyVar, zzbdp zzbdpVar, zzbdr zzbdrVar, zzfgn zzfgnVar, zzcuc zzcucVar, zzcxm zzcxmVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfbgVar;
        this.zzf = zzfauVar;
        this.zzg = zzfikVar;
        this.zzh = zzfcbVar;
        this.zzi = zzauyVar;
        this.zzk = new WeakReference(view);
        this.zzl = new WeakReference(zzcelVar);
        this.zzj = zzbdpVar;
        this.zzm = zzcucVar;
        this.zzn = zzcxmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List zzx() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlx)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzq();
            Context context = this.zza;
            if (com.google.android.gms.ads.internal.util.zzs.zzC(context)) {
                com.google.android.gms.ads.internal.zzv.zzq();
                Integer numZzt = com.google.android.gms.ads.internal.util.zzs.zzt(context);
                if (numZzt != null) {
                    Integer numValueOf = Integer.valueOf(Math.min(numZzt.intValue(), 20));
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.zzf.zzd.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse((String) it.next()).buildUpon().appendQueryParameter("dspct", Integer.toString(numValueOf.intValue())).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzy() {
        String strZzh;
        int i;
        zzfau zzfauVar = this.zzf;
        List list = zzfauVar.zzd;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdL)).booleanValue()) {
            strZzh = this.zzi.zzc().zzh(this.zza, (View) this.zzk.get(), null);
        } else {
            strZzh = null;
        }
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaF)).booleanValue() && this.zze.zzb.zzb.zzh) || !((Boolean) zzbeh.zzh.zze()).booleanValue()) {
            this.zzh.zza(this.zzg.zze(this.zze, zzfauVar, false, strZzh, null, zzx()), this.zzn);
            return;
        }
        if (((Boolean) zzbeh.zzg.zze()).booleanValue() && ((i = zzfauVar.zzb) == 1 || i == 2 || i == 5)) {
        }
        zzgbs.zzr((zzgbj) zzgbs.zzo(zzgbj.zzE(zzgbs.zzh(null)), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcmi(this, strZzh), this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(final int i, final int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzy();
        } else {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmf
                @Override // java.lang.Runnable
                public final void run() {
                    zzcmj zzcmjVar = this.zza;
                    zzcmjVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmg
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcmjVar.zzz(i - 1, i);
                        }
                    });
                }
            }, i2, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (!(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaF)).booleanValue() && this.zze.zzb.zzb.zzh) && ((Boolean) zzbeh.zzd.zze()).booleanValue()) {
            zzgbs.zzr((zzgbj) zzgbs.zze(zzgbj.zzE(this.zzj.zza()), Throwable.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzcmd
                @Override // com.google.android.gms.internal.ads.zzftl
                public final Object apply(Object obj) {
                    return "failure_click_attok";
                }
            }, zzbzk.zzg), new zzcmh(this), this.zzb);
            return;
        }
        zzfcb zzfcbVar = this.zzh;
        zzfik zzfikVar = this.zzg;
        zzfbg zzfbgVar = this.zze;
        zzfau zzfauVar = this.zzf;
        zzfcbVar.zzc(zzfikVar.zzd(zzfbgVar, zzfauVar, zzfauVar.zzc), true == com.google.android.gms.ads.internal.zzv.zzp().zzA(this.zza) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
        zzfik zzfikVar = this.zzg;
        zzfcb zzfcbVar = this.zzh;
        zzfau zzfauVar = this.zzf;
        zzfcbVar.zza(zzfikVar.zzf(zzfauVar, zzfauVar.zzh, zzbvkVar), null);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
        zzfik zzfikVar = this.zzg;
        zzfbg zzfbgVar = this.zze;
        zzfcb zzfcbVar = this.zzh;
        zzfau zzfauVar = this.zzf;
        zzfcbVar.zza(zzfikVar.zzd(zzfbgVar, zzfauVar, zzfauVar.zzi), null);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
        zzfik zzfikVar = this.zzg;
        zzfbg zzfbgVar = this.zze;
        zzfcb zzfcbVar = this.zzh;
        zzfau zzfauVar = this.zzf;
        zzfcbVar.zza(zzfikVar.zzd(zzfbgVar, zzfauVar, zzfauVar.zzg), null);
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final void zzr(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbH)).booleanValue()) {
            int i = zzeVar.zza;
            zzfau zzfauVar = this.zzf;
            ArrayList arrayList = new ArrayList();
            Iterator it = zzfauVar.zzo.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfik.zzc((String) it.next(), "@gw_mpe@", "2." + i));
            }
            this.zzh.zza(this.zzg.zzd(this.zze, zzfauVar, arrayList), null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        if (this.zzp.compareAndSet(false, true)) {
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdU)).intValue();
            if (iIntValue > 0) {
                zzz(iIntValue, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdV)).intValue());
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdT)).booleanValue()) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmc
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcmj zzcmjVar = this.zza;
                        zzcmjVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcme
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzcmjVar.zzy();
                            }
                        });
                    }
                });
            } else {
                zzy();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final synchronized void zzt() {
        zzcuc zzcucVar;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(zzx());
            zzfau zzfauVar = this.zzf;
            arrayList.addAll(zzfauVar.zzf);
            this.zzh.zza(this.zzg.zze(this.zze, zzfauVar, true, null, null, arrayList), null);
        } else {
            zzfcb zzfcbVar = this.zzh;
            zzfik zzfikVar = this.zzg;
            zzfbg zzfbgVar = this.zze;
            zzfau zzfauVar2 = this.zzf;
            zzfcbVar.zza(zzfikVar.zzd(zzfbgVar, zzfauVar2, zzfauVar2.zzm), null);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdQ)).booleanValue() && (zzcucVar = this.zzm) != null) {
                List list = zzcucVar.zzb().zzm;
                String strZzg = zzcucVar.zza().zzg();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(zzfik.zzc((String) it.next(), "@gw_adnetstatus@", strZzg));
                }
                long jZza = zzcucVar.zza().zza();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(zzfik.zzc((String) it2.next(), "@gw_ttr@", Long.toString(jZza, 10)));
                }
                zzfcbVar.zza(zzfikVar.zzd(zzcucVar.zzc(), zzcucVar.zzb(), arrayList3), null);
            }
            zzfcbVar.zza(zzfikVar.zzd(zzfbgVar, zzfauVar2, zzfauVar2.zzf), null);
        }
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzu() {
        zzfau zzfauVar = this.zzf;
        if (zzfauVar.zze == 4) {
            this.zzh.zza(this.zzg.zzd(this.zze, zzfauVar, zzfauVar.zzaA), null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzv() {
    }

    @Override // com.google.android.gms.internal.ads.zzdct
    public final void zzw() {
        zzfik zzfikVar = this.zzg;
        zzfbg zzfbgVar = this.zze;
        zzfcb zzfcbVar = this.zzh;
        zzfau zzfauVar = this.zzf;
        zzfcbVar.zza(zzfikVar.zzd(zzfbgVar, zzfauVar, zzfauVar.zzau), null);
    }
}
