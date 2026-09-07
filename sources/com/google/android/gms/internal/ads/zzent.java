package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzent implements zzesv {
    private final zzgcd zza;
    private final zzdoz zzb;
    private final String zzc;
    private final zzfbp zzd;

    public zzent(zzgcd zzgcdVar, zzdoz zzdozVar, zzfbp zzfbpVar, String str) {
        this.zza = zzgcdVar;
        this.zzb = zzdozVar;
        this.zzd = zzfbpVar;
        this.zzc = str;
    }

    public static /* synthetic */ zzenu zzc(zzent zzentVar) {
        zzfbp zzfbpVar = zzentVar.zzd;
        zzdoz zzdozVar = zzentVar.zzb;
        return new zzenu(zzdozVar.zzb(zzfbpVar.zzf, zzentVar.zzc), zzdozVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 17;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzens
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzent.zzc(this.zza);
            }
        });
    }
}
