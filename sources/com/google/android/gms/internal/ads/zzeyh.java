package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeyh {
    private final zzfdc zza;
    private final zzcui zzb;
    private final Executor zzc;
    private zzeyf zzd;

    public zzeyh(zzfdc zzfdcVar, zzcui zzcuiVar, Executor executor) {
        this.zza = zzfdcVar;
        this.zzb = zzcuiVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfdm zze() {
        zzfbp zzfbpVarZzf = this.zzb.zzf();
        return this.zza.zzc(zzfbpVarZzf.zzd, zzfbpVarZzf.zzf, zzfbpVarZzf.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFutureZzh;
        zzeyf zzeyfVar = this.zzd;
        if (zzeyfVar != null) {
            return zzgbs.zzh(zzeyfVar);
        }
        if (((Boolean) zzbep.zza.zze()).booleanValue()) {
            zzgbj zzgbjVarZzE = zzgbj.zzE(this.zzb.zzb().zzf(this.zza.zza()));
            zzeye zzeyeVar = new zzeye(this);
            Executor executor = this.zzc;
            listenableFutureZzh = (zzgbj) zzgbs.zze((zzgbj) zzgbs.zzm(zzgbjVarZzE, zzeyeVar, executor), zzdxq.class, new zzeyd(this), executor);
        } else {
            zzeyf zzeyfVar2 = new zzeyf(null, zze(), null);
            this.zzd = zzeyfVar2;
            listenableFutureZzh = zzgbs.zzh(zzeyfVar2);
        }
        return zzgbs.zzm(listenableFutureZzh, new zzftl() { // from class: com.google.android.gms.internal.ads.zzeyc
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return (zzeyf) obj;
            }
        }, this.zzc);
    }
}
