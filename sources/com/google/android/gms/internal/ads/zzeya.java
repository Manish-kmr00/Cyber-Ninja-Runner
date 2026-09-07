package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeya implements zzeyl {
    private zzcui zza;

    @Override // com.google.android.gms.internal.ads.zzeyl
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcui zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzeym zzeymVar, zzeyk zzeykVar, Object obj) {
        return zzb(zzeymVar, zzeykVar, null);
    }

    public final synchronized ListenableFuture zzb(zzeym zzeymVar, zzeyk zzeykVar, zzcui zzcuiVar) {
        zzcrk zzcrkVarZzb;
        try {
            if (zzcuiVar != null) {
                this.zza = zzcuiVar;
            } else {
                this.zza = (zzcui) zzeykVar.zza(zzeymVar.zzb).zzh();
            }
            zzcrkVarZzb = this.zza.zzb();
        } catch (Throwable th) {
            throw th;
        }
        return zzcrkVarZzb.zzh(zzcrkVarZzb.zzi());
    }
}
