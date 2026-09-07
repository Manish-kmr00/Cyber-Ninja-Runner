package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexg implements zzekh {
    private final Context zza;
    private final Executor zzb;
    private final zzcgl zzc;
    private final zzejr zzd;
    private final zzejv zze;
    private final ViewGroup zzf;
    private zzbdd zzg;
    private final zzcxv zzh;
    private final zzfgq zzi;
    private final zzdab zzj;
    private final zzfbn zzk;
    private ListenableFuture zzl;
    private boolean zzm;
    private com.google.android.gms.ads.internal.client.zze zzn;
    private zzekg zzo;

    public zzexg(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzr zzrVar, zzcgl zzcglVar, zzejr zzejrVar, zzejv zzejvVar, zzfbn zzfbnVar, zzdab zzdabVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcglVar;
        this.zzd = zzejrVar;
        this.zze = zzejvVar;
        this.zzk = zzfbnVar;
        this.zzh = zzcglVar.zze();
        this.zzi = zzcglVar.zzy();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdabVar;
        zzfbnVar.zzs(zzrVar);
        this.zzm = true;
        this.zzn = null;
        this.zzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzt() {
        this.zzl = null;
        final com.google.android.gms.ads.internal.client.zze zzeVar = this.zzn;
        this.zzn = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzik)).booleanValue() && zzeVar != null) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdz(zzeVar);
                }
            });
        }
        zzekg zzekgVar = this.zzo;
        if (zzekgVar != null) {
            zzekgVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzekf zzekfVar, zzekg zzekgVar) throws RemoteException {
        zzcpd zzcpdVarZzk;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexe
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdz(zzfcq.zzd(6, null, null));
                }
            });
            return false;
        }
        if (!zza()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziY)).booleanValue() && zzmVar.zzf) {
                this.zzc.zzk().zzo(true);
            }
            Bundle bundleZza = zzdqo.zza(new Pair(zzdqm.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdqm.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis())));
            zzfbn zzfbnVar = this.zzk;
            zzfbnVar.zzt(str);
            zzfbnVar.zzH(zzmVar);
            zzfbnVar.zzA(bundleZza);
            Context context = this.zza;
            zzfbp zzfbpVarZzJ = zzfbnVar.zzJ();
            zzfgc zzfgcVarZzb = zzfgb.zzb(context, zzfgm.zzf(zzfbpVarZzJ), 3, zzmVar);
            zzfgn zzfgnVarZzh = null;
            if (!((Boolean) zzbeo.zzd.zze()).booleanValue() || !zzfbnVar.zzh().zzk) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzik)).booleanValue()) {
                    zzcpc zzcpcVarZzd = this.zzc.zzd();
                    zzcuj zzcujVar = new zzcuj();
                    zzcujVar.zzf(context);
                    zzcujVar.zzk(zzfbpVarZzJ);
                    zzcpcVarZzd.zzi(zzcujVar.zzl());
                    zzdau zzdauVar = new zzdau();
                    zzejr zzejrVar = this.zzd;
                    Executor executor = this.zzb;
                    zzdauVar.zzj(zzejrVar, executor);
                    zzdauVar.zzk(zzejrVar, executor);
                    zzcpcVarZzd.zzf(zzdauVar.zzn());
                    zzcpcVarZzd.zze(new zzeia(this.zzg));
                    zzcpcVarZzd.zzd(new zzdfv(zzdib.zza, null));
                    zzcpcVarZzd.zzg(new zzcpy(this.zzh, this.zzj));
                    zzcpcVarZzd.zzc(new zzcnw(this.zzf));
                    zzcpdVarZzk = zzcpcVarZzd.zzh();
                } else {
                    zzcpc zzcpcVarZzd2 = this.zzc.zzd();
                    zzcuj zzcujVar2 = new zzcuj();
                    zzcujVar2.zzf(context);
                    zzcujVar2.zzk(zzfbpVarZzJ);
                    zzcpcVarZzd2.zzi(zzcujVar2.zzl());
                    zzdau zzdauVar2 = new zzdau();
                    zzejr zzejrVar2 = this.zzd;
                    Executor executor2 = this.zzb;
                    zzdauVar2.zzj(zzejrVar2, executor2);
                    zzdauVar2.zza(zzejrVar2, executor2);
                    zzdauVar2.zza(this.zze, executor2);
                    zzdauVar2.zzl(zzejrVar2, executor2);
                    zzdauVar2.zzd(zzejrVar2, executor2);
                    zzdauVar2.zze(zzejrVar2, executor2);
                    zzdauVar2.zzf(zzejrVar2, executor2);
                    zzdauVar2.zzb(zzejrVar2, executor2);
                    zzdauVar2.zzk(zzejrVar2, executor2);
                    zzdauVar2.zzi(zzejrVar2, executor2);
                    zzcpcVarZzd2.zzf(zzdauVar2.zzn());
                    zzcpcVarZzd2.zze(new zzeia(this.zzg));
                    zzcpcVarZzd2.zzd(new zzdfv(zzdib.zza, null));
                    zzcpcVarZzd2.zzg(new zzcpy(this.zzh, this.zzj));
                    zzcpcVarZzd2.zzc(new zzcnw(this.zzf));
                    zzcpdVarZzk = zzcpcVarZzd2.zzh();
                }
                if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
                    zzfgnVarZzh = zzcpdVarZzk.zzh();
                    zzfgnVarZzh.zzi(3);
                    zzfgnVarZzh.zzb(zzmVar.zzp);
                    zzfgnVarZzh.zzf(zzmVar.zzm);
                }
                this.zzo = zzekgVar;
                zzcrk zzcrkVarZzc = zzcpdVarZzk.zzc();
                ListenableFuture listenableFutureZzh = zzcrkVarZzc.zzh(zzcrkVarZzc.zzi());
                this.zzl = listenableFutureZzh;
                zzgbs.zzr(listenableFutureZzh, new zzexf(this, zzfgnVarZzh, zzfgcVarZzb, zzcpdVarZzk), this.zzb);
                return true;
            }
            zzejr zzejrVar3 = this.zzd;
            if (zzejrVar3 != null) {
                zzejrVar3.zzdz(zzfcq.zzd(7, null, null));
            }
        } else if (!this.zzk.zzS()) {
            this.zzm = true;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzfbn zzf() {
        return this.zzk;
    }

    public final void zzl() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzm() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zze.zza(zzbhVar);
    }

    public final void zzo(zzcxp zzcxpVar) {
        this.zzh.zzo(zzcxpVar, this.zzb);
    }

    public final void zzp(zzbdd zzbddVar) {
        this.zzg = zzbddVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq() {
        synchronized (this) {
            ListenableFuture listenableFuture = this.zzl;
            if (listenableFuture != null && listenableFuture.isDone()) {
                try {
                    zzcnz zzcnzVar = (zzcnz) this.zzl.get();
                    this.zzl = null;
                    ViewGroup viewGroup = this.zzf;
                    viewGroup.removeAllViews();
                    zzcnzVar.zzd();
                    ViewParent parent = zzcnzVar.zzd().getParent();
                    if (parent instanceof ViewGroup) {
                        String str = "Banner view provided from " + (zzcnzVar.zzl() != null ? zzcnzVar.zzl().zzg() : "") + " already has a parent view. Removing its old parent.";
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
                        ((ViewGroup) parent).removeView(zzcnzVar.zzd());
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzik)).booleanValue()) {
                        zzczj zzczjVarZzn = zzcnzVar.zzn();
                        zzczjVarZzn.zza(this.zzd);
                        zzczjVarZzn.zzc(this.zze);
                    }
                    viewGroup.addView(zzcnzVar.zzd());
                    zzekg zzekgVar = this.zzo;
                    if (zzekgVar != null) {
                        zzekgVar.zzb(zzcnzVar);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzik)).booleanValue()) {
                        Executor executor = this.zzb;
                        final zzejr zzejrVar = this.zzd;
                        Objects.requireNonNull(zzejrVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexd
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzejrVar.zzt();
                            }
                        });
                    }
                    if (zzcnzVar.zza() >= 0) {
                        this.zzm = false;
                        zzcxv zzcxvVar = this.zzh;
                        zzcxvVar.zzd(zzcnzVar.zza());
                        zzcxvVar.zze(zzcnzVar.zzc());
                    } else {
                        this.zzm = true;
                        this.zzh.zzd(zzcnzVar.zzc());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzt();
                    com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                    this.zzm = true;
                    this.zzh.zza();
                }
            } else if (this.zzl != null) {
                com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                this.zzm = true;
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                this.zzm = true;
                this.zzh.zza();
            }
        }
    }

    public final boolean zzs() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzv.zzq();
        return com.google.android.gms.ads.internal.util.zzs.zzX(view, view.getContext());
    }
}
