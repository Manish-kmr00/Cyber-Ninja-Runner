package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyx implements zzekh {
    private final Context zza;
    private final Executor zzb;
    private final zzcgl zzc;
    private final zzejr zzd;
    private final zzezx zze;
    private zzbdd zzf;
    private final zzfgq zzg;
    private final zzfbn zzh;
    private ListenableFuture zzi;

    public zzeyx(Context context, Executor executor, zzcgl zzcglVar, zzejr zzejrVar, zzezx zzezxVar, zzfbn zzfbnVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcglVar;
        this.zzd = zzejrVar;
        this.zzh = zzfbnVar;
        this.zze = zzezxVar;
        this.zzg = zzcglVar.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzekf zzekfVar, zzekg zzekgVar) {
        zzdfe zzdfeVarZzf;
        zzfgn zzfgnVar;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdz(zzfcq.zzd(6, null, null));
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziY)).booleanValue() && zzmVar.zzf) {
            this.zzc.zzk().zzo(true);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar = ((zzeyq) zzekfVar).zza;
        Bundle bundleZza = zzdqo.zza(new Pair(zzdqm.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdqm.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis())));
        zzfbn zzfbnVar = this.zzh;
        zzfbnVar.zzt(str);
        zzfbnVar.zzs(zzrVar);
        zzfbnVar.zzH(zzmVar);
        zzfbnVar.zzA(bundleZza);
        Context context = this.zza;
        zzfbp zzfbpVarZzJ = zzfbnVar.zzJ();
        zzfgc zzfgcVarZzb = zzfgb.zzb(context, zzfgm.zzf(zzfbpVarZzJ), 4, zzmVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzim)).booleanValue()) {
            zzdfd zzdfdVarZzf = this.zzc.zzf();
            zzcuj zzcujVar = new zzcuj();
            zzcujVar.zzf(context);
            zzcujVar.zzk(zzfbpVarZzJ);
            zzdfdVarZzf.zze(zzcujVar.zzl());
            zzdau zzdauVar = new zzdau();
            zzejr zzejrVar = this.zzd;
            Executor executor = this.zzb;
            zzdauVar.zzj(zzejrVar, executor);
            zzdauVar.zzk(zzejrVar, executor);
            zzdfdVarZzf.zzd(zzdauVar.zzn());
            zzdfdVarZzf.zzc(new zzeia(this.zzf));
            zzdfeVarZzf = zzdfdVarZzf.zzf();
        } else {
            zzdau zzdauVar2 = new zzdau();
            zzezx zzezxVar = this.zze;
            if (zzezxVar != null) {
                Executor executor2 = this.zzb;
                zzdauVar2.zze(zzezxVar, executor2);
                zzdauVar2.zzf(zzezxVar, executor2);
                zzdauVar2.zzb(zzezxVar, executor2);
            }
            zzdfd zzdfdVarZzf2 = this.zzc.zzf();
            zzcuj zzcujVar2 = new zzcuj();
            zzcujVar2.zzf(context);
            zzcujVar2.zzk(zzfbpVarZzJ);
            zzdfdVarZzf2.zze(zzcujVar2.zzl());
            zzejr zzejrVar2 = this.zzd;
            Executor executor3 = this.zzb;
            zzdauVar2.zzj(zzejrVar2, executor3);
            zzdauVar2.zze(zzejrVar2, executor3);
            zzdauVar2.zzf(zzejrVar2, executor3);
            zzdauVar2.zzb(zzejrVar2, executor3);
            zzdauVar2.zza(zzejrVar2, executor3);
            zzdauVar2.zzl(zzejrVar2, executor3);
            zzdauVar2.zzk(zzejrVar2, executor3);
            zzdauVar2.zzi(zzejrVar2, executor3);
            zzdauVar2.zzc(zzejrVar2, executor3);
            zzdfdVarZzf2.zzd(zzdauVar2.zzn());
            zzdfdVarZzf2.zzc(new zzeia(this.zzf));
            zzdfeVarZzf = zzdfdVarZzf2.zzf();
        }
        zzdfe zzdfeVar = zzdfeVarZzf;
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            zzfgn zzfgnVarZze = zzdfeVar.zze();
            zzfgnVarZze.zzi(4);
            zzfgnVarZze.zzb(zzmVar.zzp);
            zzfgnVarZze.zzf(zzmVar.zzm);
            zzfgnVar = zzfgnVarZze;
        } else {
            zzfgnVar = null;
        }
        zzcrk zzcrkVarZza = zzdfeVar.zza();
        ListenableFuture listenableFutureZzh = zzcrkVarZza.zzh(zzcrkVarZza.zzi());
        this.zzi = listenableFutureZzh;
        zzgbs.zzr(listenableFutureZzh, new zzeyw(this, zzekgVar, zzfgnVar, zzfgcVarZzb, zzdfeVar), this.zzb);
        return true;
    }

    public final void zzi(zzbdd zzbddVar) {
        this.zzf = zzbddVar;
    }
}
