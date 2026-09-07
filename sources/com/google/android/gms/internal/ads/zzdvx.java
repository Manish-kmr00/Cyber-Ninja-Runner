package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdvx implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;

    public zzdvx(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0058  */
    /* JADX WARN: Code duplicated, block: B:8:0x0076  */
    /* JADX WARN: Code duplicated, block: B:9:0x0080  */
    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        ListenableFuture listenableFutureZzb;
        final zzauy zzauyVar = (zzauy) this.zza.zzb();
        final Context contextZza = ((zzcgs) this.zzb).zza();
        zzfbp zzfbpVarZza = ((zzcut) this.zzc).zza();
        long jLongValue = ((Long) this.zzd.zzb()).longValue();
        zzgcd zzgcdVarZzc = zzfen.zzc();
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcU)).intValue();
        if (iIntValue != -1) {
            if (Integer.toString(iIntValue).equals(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfbpVarZza.zzd)))) {
                if (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - jLongValue < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcW)).intValue()) {
                    listenableFutureZzb = zzgcdVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdvq
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzauyVar.zzc().zzg(contextZza);
                        }
                    });
                } else {
                    listenableFutureZzb = zzgcdVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdvr
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzauyVar.zzc().zzf(contextZza);
                        }
                    });
                }
            } else {
                listenableFutureZzb = zzgcdVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdvr
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzauyVar.zzc().zzf(contextZza);
                    }
                });
            }
        } else {
            if (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - jLongValue < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcW)).intValue()) {
                listenableFutureZzb = zzgcdVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdvq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzauyVar.zzc().zzg(contextZza);
                    }
                });
            } else {
                listenableFutureZzb = zzgcdVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdvr
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzauyVar.zzc().zzf(contextZza);
                    }
                });
            }
        }
        zzhfg.zzb(listenableFutureZzb);
        return listenableFutureZzb;
    }
}
