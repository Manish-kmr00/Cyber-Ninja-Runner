package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzecg implements zzecf {
    public final zzecf zza;
    private final zzftl zzb;

    public zzecg(zzecf zzecfVar, zzftl zzftlVar) {
        this.zza = zzecfVar;
        this.zzb = zzftlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(zzfbg zzfbgVar, zzfau zzfauVar) {
        return zzgbs.zzm(this.zza.zza(zzfbgVar, zzfauVar), this.zzb, zzbzk.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        return this.zza.zzb(zzfbgVar, zzfauVar);
    }
}
