package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzekw implements zzesv {
    private final Clock zza;
    private final zzfbp zzb;

    zzekw(Clock clock, zzfbp zzfbpVar) {
        this.zza = clock;
        this.zzb = zzfbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzh(new zzekx(this.zzb, this.zza.currentTimeMillis()));
    }
}
