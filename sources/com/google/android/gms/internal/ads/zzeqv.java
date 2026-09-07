package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqv implements zzesv {
    private final zzfat zza;

    zzeqv(zzfat zzfatVar) {
        this.zza = zzfatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzh(new zzeqw(this.zza));
    }
}
