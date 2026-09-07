package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzexx implements zzeyl {
    private final zzfdc zza;
    private final Executor zzb;
    private final zzgbo zzc = new zzexv(this);

    public zzexx(zzfdc zzfdcVar, Executor executor) {
        this.zza = zzfdcVar;
        this.zzb = executor;
    }

    public static /* synthetic */ ListenableFuture zza(zzexx zzexxVar, zzcui zzcuiVar, zzeyf zzeyfVar) {
        zzfdc zzfdcVar = zzexxVar.zza;
        zzfdm zzfdmVar = zzeyfVar.zzb;
        zzbuy zzbuyVar = zzeyfVar.zza;
        zzfdl zzfdlVarZzb = zzfdcVar.zzb(zzfdmVar);
        if (zzfdlVarZzb != null && zzbuyVar != null) {
            zzgbs.zzr(zzcuiVar.zzb().zzg(zzbuyVar), zzexxVar.zzc, zzexxVar.zzb);
        }
        return zzgbs.zzh(new zzexw(zzfdmVar, zzbuyVar, zzfdlVarZzb));
    }

    public final ListenableFuture zzb(zzeym zzeymVar, zzeyk zzeykVar, final zzcui zzcuiVar) {
        zzfdc zzfdcVar = this.zza;
        Executor executor = this.zzb;
        return (zzgbj) zzgbs.zze((zzgbj) zzgbs.zzn(zzgbj.zzE(new zzeyh(zzfdcVar, zzcuiVar, executor).zzc()), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzext
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzexx.zza(this.zza, zzcuiVar, (zzeyf) obj);
            }
        }, executor), Exception.class, new zzexu(this), executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzeym zzeymVar, zzeyk zzeykVar, Object obj) {
        return zzb(zzeymVar, zzeykVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
