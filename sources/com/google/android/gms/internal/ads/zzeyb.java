package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyb implements zzeyl {
    private final zzeyl zza;
    private zzcui zzb;

    public zzeyb(zzeyl zzeylVar) {
        this.zza = zzeylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcui zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzeym zzeymVar, zzeyk zzeykVar, Object obj) {
        return zzb(zzeymVar, zzeykVar, null);
    }

    public final synchronized ListenableFuture zzb(zzeym zzeymVar, zzeyk zzeykVar, zzcui zzcuiVar) {
        zzbuy zzbuyVar;
        this.zzb = zzcuiVar;
        if (zzcuiVar == null || (zzbuyVar = zzeymVar.zza) == null) {
            return ((zzeya) this.zza).zzb(zzeymVar, zzeykVar, zzcuiVar);
        }
        zzcrk zzcrkVarZzb = zzcuiVar.zzb();
        return zzcrkVarZzb.zzh(zzcrkVarZzb.zzj(zzgbs.zzh(zzbuyVar)));
    }
}
