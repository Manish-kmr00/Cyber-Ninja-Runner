package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfah implements zzekh {
    private final Context zza;
    private final Executor zzb;
    private final zzcgl zzc;
    private final zzezx zzd;
    private final zzeyl zze;
    private final zzfbh zzf;
    private final zzfgq zzg;
    private final zzfbn zzh;
    private ListenableFuture zzi;

    public zzfah(Context context, Executor executor, zzcgl zzcglVar, zzeyl zzeylVar, zzezx zzezxVar, zzfbn zzfbnVar, zzfbh zzfbhVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcglVar;
        this.zze = zzeylVar;
        this.zzd = zzezxVar;
        this.zzh = zzfbnVar;
        this.zzf = zzfbhVar;
        this.zzg = zzcglVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdnm zzk(zzeyj zzeyjVar) {
        zzdnm zzdnmVarZzh = this.zzc.zzh();
        zzcuj zzcujVar = new zzcuj();
        zzcujVar.zzf(this.zza);
        zzcujVar.zzk(((zzfaf) zzeyjVar).zza);
        zzcujVar.zzj(this.zzf);
        zzdnmVarZzh.zzd(zzcujVar.zzl());
        zzdnmVarZzh.zzc(new zzdau().zzn());
        return zzdnmVarZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005e  */
    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzekf zzekfVar, zzekg zzekgVar) throws RemoteException {
        zzfgn zzfgnVar;
        zzbvr zzbvrVar = new zzbvr(zzmVar, str);
        String str2 = zzbvrVar.zzb;
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaa
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdz(zzfcq.zzd(6, null, null));
                }
            });
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            zzeyl zzeylVar = this.zze;
            if (zzeylVar.zzd() != null) {
                zzfgn zzfgnVarZzg = ((zzdnn) zzeylVar.zzd()).zzg();
                zzfgnVarZzg.zzi(5);
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzbvrVar.zza;
                zzfgnVarZzg.zzb(zzmVar2.zzp);
                zzfgnVarZzg.zzf(zzmVar2.zzm);
                zzfgnVar = zzfgnVarZzg;
            } else {
                zzfgnVar = null;
            }
        } else {
            zzfgnVar = null;
        }
        Context context = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar3 = zzbvrVar.zza;
        boolean z = zzmVar3.zzf;
        zzfcm.zza(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziY)).booleanValue() && z) {
            this.zzc.zzk().zzo(true);
        }
        Bundle bundleZza = zzdqo.zza(new Pair(zzdqm.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar3.zzz)), new Pair(zzdqm.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis())));
        zzfbn zzfbnVar = this.zzh;
        zzfbnVar.zzt(str2);
        zzfbnVar.zzs(com.google.android.gms.ads.internal.client.zzr.zzd());
        zzfbnVar.zzH(zzmVar3);
        zzfbnVar.zzA(bundleZza);
        zzfbp zzfbpVarZzJ = zzfbnVar.zzJ();
        zzfgc zzfgcVarZzb = zzfgb.zzb(context, zzfgm.zzf(zzfbpVarZzJ), 5, zzmVar3);
        zzfaf zzfafVar = new zzfaf(null);
        zzfafVar.zza = zzfbpVarZzJ;
        ListenableFuture listenableFutureZzc = this.zze.zzc(new zzeym(zzfafVar, null), new zzeyk() { // from class: com.google.android.gms.internal.ads.zzfab
            @Override // com.google.android.gms.internal.ads.zzeyk
            public final zzcuh zza(zzeyj zzeyjVar) {
                return this.zza.zzk(zzeyjVar);
            }
        }, null);
        this.zzi = listenableFutureZzc;
        zzgbs.zzr(listenableFutureZzc, new zzfae(this, zzekgVar, zzfgnVar, zzfgcVarZzb, zzfafVar), this.zzb);
        return true;
    }

    final void zzj(int i) {
        this.zzh.zzp().zza(i);
    }
}
