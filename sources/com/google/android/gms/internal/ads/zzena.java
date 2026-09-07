package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzena implements zzesv {
    private final zzfbp zza;

    zzena(zzfbp zzfbpVar) {
        this.zza = zzfbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 58;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzh(new zzenb(this.zza.zzp));
    }
}
