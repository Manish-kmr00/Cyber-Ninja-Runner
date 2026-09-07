package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzemc implements zzesv {
    private final zzgcd zza;
    private final zzfbp zzb;
    private final zzbze zzc;

    public zzemc(zzgcd zzgcdVar, zzfbp zzfbpVar, zzbze zzbzeVar) {
        this.zza = zzgcdVar;
        this.zzb = zzfbpVar;
        this.zzc = zzbzeVar;
    }

    public static /* synthetic */ zzemd zzc(zzemc zzemcVar) {
        return new zzemd(zzemcVar.zzb.zzj, zzemcVar.zzc.zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemc.zzc(this.zza);
            }
        });
    }
}
